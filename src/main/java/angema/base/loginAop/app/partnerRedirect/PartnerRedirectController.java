package angema.base.loginAop.app.partnerRedirect;

import angema.base.loginAop.app.partnerThemes.PartnerThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/landing")
public class PartnerRedirectController {

    @Autowired
    private final  Map<String,String> PartnersNames =null;

    @Value("${partners.redirect}")
    private String  PARTNER_REDIRECT;

    @Autowired
    private PartnerThemeService partnerThemeService;

    @GetMapping("/{partnerName}")
    public void getRedirectByPartnerName(@PathVariable String partnerName, HttpServletResponse response) throws IOException {
        String cuit_socio="";
        if (PartnersNames.containsKey(partnerName)){
            // todo crear campo nombre en base themes, buscar cuit y setaer en cookie.
            try {
                cuit_socio=partnerThemeService.getCuitSocioByPartnerName(partnerName);
                Cookie cookie = new Cookie("cuit_socio", cuit_socio);
                cookie.setMaxAge(60 * 60);
//              cookie.setSecure(true);
//              cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
                response.sendRedirect(PARTNER_REDIRECT);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


    }
}
