package angema.base.loginAop.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthValidator authValidator;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public AuthResponse login(@RequestBody MultiValueMap<String, String> formParams, @RequestParam("grant_type") String grantType) throws AuthException {
        AuthUserLoggedIn user = authValidator.validate(formParams, grantType);
        return authService.login(formParams.getFirst("client_id"), user);
    }

    @PostMapping(path = "")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public AuthResponse login(@RequestBody AuthRequest authRequest, @RequestParam("grant_type") String grantType) throws AuthException {
        AuthUserLoggedIn user = authValidator.validate(authRequest, grantType);
        return authService.login(authRequest.user, user);
    }
}
