package angema.base.loginAop.app.partnerRedirect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/landing")
public class PartnerRedirectController {

    @GetMapping("/{socio}")
    public void getTematica(@PathVariable String socio, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("cuit_socio", "30697265895");
        cookie.setMaxAge(60 * 60);
//        cookie.setSecure(true);
//        cookie.setHttpOnly(true);
        cookie.setPath("/");

        response.addCookie(cookie);
        response.sendRedirect("https://angular-base-login-s6gd-b8m3etfn7-infoangema.vercel.app/dashboard/home");
    }
}
