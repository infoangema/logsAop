package angema.base.logsAop.core.auth;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

@Component
public class AuthValidator {

    public static final String CLIENT_CREDENTIALS = "client_credentials";

    public void validate(MultiValueMap<String, String> formParams, String grantType) throws AuthException {

        if(grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)) {
            message("Invalid grant_type");
        }

        if(Objects.isNull(formParams) || formParams.getFirst("client_id").equals("") || formParams.getFirst("client_secret").equals("")) {
            message("Invalid client_id or client_secret");
        }
    }

    public void message(String message) throws AuthException {
        throw new AuthException(message);
    }
}
