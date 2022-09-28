package angema.base.loginAop.core.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AuthDtoResponse {

    @JsonProperty("access_token")
    public String accessToken;
    @JsonProperty("token_type")
    public String tokenType;
    @JsonProperty("expires_in")
    public Integer expiresIn;
    @JsonProperty("refresh_token")
    public String refreshToken;
    @JsonProperty("issued_at")
    public String issuedAt;
    @JsonProperty("client_id")
    public String clientId;
    @JsonProperty("client_data")
    public AuthDtoUserLoggedIn clientData;

}

@Data
@Builder
class AuthDtoUserLoggedIn {
    @JsonProperty("username")
    public String userName;
    public String name;
    @JsonProperty("lastname")
    public String lastName;
    public String email;
    public List<String> roles;
}
