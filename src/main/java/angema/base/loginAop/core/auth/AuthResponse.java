package angema.base.loginAop.core.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse {

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
    public AuthUserLoggedIn clientData;

}
