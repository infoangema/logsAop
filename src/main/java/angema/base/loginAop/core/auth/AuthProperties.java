package angema.base.loginAop.core.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "configs.auth")
public class AuthProperties {
    public Security security;
    public String timeZone;
    public String issuer;
    public Token token;
    public Exclude exclude;

    @Data
    public static class Security {
        public boolean enabled;
    }

    @Data
    public static class Token {
        public Auth auth;
        public String secret;
        public Expiration expiration;
    }

    @Data
    public static class Auth {
        public String path;
    }

    @Data
    public static class Expiration {
        public int seconds;
    }

    @Data
    public static class Exclude {
        public String paths;
//        public String[] paths;
    }
}
