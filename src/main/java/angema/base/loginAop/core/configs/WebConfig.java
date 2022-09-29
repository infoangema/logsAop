package angema.base.loginAop.core.configs;

import angema.base.loginAop.core.auth.AuthSpringInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${configs.auth.security.IS_SECURITY_ENABLED}")
    private boolean IS_SECURITY_ENABLED;

    @Autowired
    private AuthSpringInterceptor authInterceptor;

    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        if(IS_SECURITY_ENABLED) {
            registry.addInterceptor(authInterceptor);
        }
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}

