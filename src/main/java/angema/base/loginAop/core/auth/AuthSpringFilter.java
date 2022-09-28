package angema.base.loginAop.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthSpringFilter extends OncePerRequestFilter {

    @Value("${configs.auth.security.IS_SECURITY_ENABLED}")
    private boolean IS_SECURITY_ENABLED;

    @Autowired
    AuthServiceJwt authServiceJwt;

    @Autowired
    AuthSpringUserDetailsService authSpringUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            logger.info("ENTRO EN  doFilterInternal");
            String token = getToken(req);
            if (IS_SECURITY_ENABLED && token != null && authServiceJwt.validateToken(token)) {
                String nombreUsuario = authServiceJwt.getPayLoadObject(token).getUserName();
                UserDetails userDetails = authSpringUserDetailsService.loadUserByUsername(nombreUsuario);

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error("Error en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }
}
