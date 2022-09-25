package angema.base.loginAop.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${configs.auth.token.auth.path}")
    private String AUTH_PATH;

    @Value("#{'${configs.auth.exclude.paths}'.split(',')}")
    private List<String> EXCLUDED_PATHS;

    @Autowired
    private AuthJwt authJwt;

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean validate = false;
        String uri = request.getRequestURI();
        String authToken = request.getHeader("Authorization");

        if (uri.equals(AUTH_PATH) || excluded(uri)) {
            return true;
        }

        if (authToken == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

        if (!authToken.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

        String token = authToken.replace("Bearer ", "");
        validate = authJwt.validateToken(token);
        if (!validate) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        return validate;


    }

    private boolean excluded(String uri) {
        boolean result = false;
        for (String exc : EXCLUDED_PATHS) {
            if (exc.equals(uri)) {
                result = true;
            }
        }
        return result;
    }


}
