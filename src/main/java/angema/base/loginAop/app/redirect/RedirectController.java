package angema.base.loginAop.app.redirect;

import angema.base.loginAop.app.temas.tema.TemaRepository;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static angema.base.loginAop.app.productos.detalles.DetalleMsg.DETALLE_READ_DESCRIPTION;
import static angema.base.loginAop.app.productos.detalles.DetalleMsg.DETALLE_READ_SUMMARY;
import static angema.base.loginAop.app.redirect.RedirectMsg.*;

@RestController
@RequestMapping("/site/redirect")
public class RedirectController {

    @Autowired
    private final  Map<String,String> PartnersNames;

    @Value("${partners.redirect}")
    private String  PARTNER_REDIRECT;

    @Autowired
    private TemaRepository temaRepository;

    public RedirectController(Map<String, String> partnersNames) {
        PartnersNames = partnersNames;
    }

    /**
     * Este controlador se encarga de redireccionar al sitio de la landing segun el socio ingresado como parametro de la
     * request.
     * El @param nombre, que es el nombre del socio, cuenta con una validacion previa, la cual consiste en buscar si
     * este, se encuentra seteado en el archivo applications.properties. Si no existe, lanza la exception
     * correspondiente.
     * Si el parametro se encuentra en esta lista, continua el flujo, para buscar en la base de datos.
     * @param nombre
     * @param response
     * @param webRequest
     * @return
     */
    @Operation(
            summary = REDIRECT_GET_SUMMARY,
            description = REDIRECT_GET_DESCRIPTION
    )
    @GetMapping("/{nombre}")
    public GlobalResponse getRedirectByPartnerName(@PathVariable String nombre, HttpServletResponse response, WebRequest webRequest) {
        if (!PartnersNames.containsKey(nombre)){
            throw new RedirectException(REDIRECT_MSG_ERROR_READ_SOCIO);
        }
        try {
            String cuitSocio=temaRepository.findByNombreLikeIgnoreCase(nombre).cuitSocio;
            if (cuitSocio == null || cuitSocio.length() != 11){
                throw new RedirectException(REDIRECT_MSG_ERROR_READ_INVALID_SOCIO);
            }
            Cookie cookie = new Cookie("cuit_socio", cuitSocio);
            cookie.setMaxAge(60 * 60000);
//              cookie.setSecure(true);
//              cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect(PARTNER_REDIRECT);
        } catch (Exception e) {
            throw new RedirectException(e.getMessage());
        }
        return null;
    }
}
