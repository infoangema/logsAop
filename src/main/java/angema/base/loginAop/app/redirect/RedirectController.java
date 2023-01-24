package angema.base.loginAop.app.redirect;

import angema.base.loginAop.app.temas.tema.TemaRepository;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
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

    @GetMapping("/{nombre}")
    public GlobalResponse<?> getRedirectByPartnerName(@PathVariable String nombre, HttpServletResponse response, WebRequest webRequest) {
        if (!PartnersNames.containsKey(nombre)){
            throw new RedirectException("No existe sitio para el socio solicitado");
        }
        try {
            String cuitSocio=temaRepository.findByNombreLikeIgnoreCase(nombre).cuitSocio;
            if (cuitSocio == null || cuitSocio.length() != 11){
                throw new RedirectException("Cuit del socio no encontrado ó inválido.");
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
