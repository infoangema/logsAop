package angema.base.loginAop.app.partnerRedirect;

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

    @GetMapping("/{socio}")
    public void getRedirectByPartnerName(@PathVariable String socio, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("cuit_socio", "30697265895");
        cookie.setMaxAge(60 * 60);
//        cookie.setSecure(true);
//        cookie.setHttpOnly(true);
        cookie.setPath("/");
        if (PartnersNames.containsKey(socio)){
            response.addCookie(cookie);
            response.sendRedirect(PARTNER_REDIRECT);
        }


    }
}
