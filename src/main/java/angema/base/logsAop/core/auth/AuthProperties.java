package angema.base.logsAop.core.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "configs.auth")
public class AuthProperties {
    private Security security;
    private String timeZone;
    private String issuer;
    private Token token;
    private Exclude exclude;

    @Data
    public static class Security {
        private boolean enabled;
    }

    @Data
    public static class Token {
        private Auth auth;
        private String secret;
        private Expiration expiration;
    }

    @Data
    public static class Auth {
        private String path;
    }

    @Data
    public static class Expiration {
        private int seconds;
    }

    @Data
    public static class Exclude {
        private String paths;
//        private String[] paths;
    }
}
