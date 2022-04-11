package angema.base.loginAop.core.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserLoggedIn {
    public String userName;
    public String name;
    public String lastName;
    public String email;
    public String phone;
    public String role;
}
