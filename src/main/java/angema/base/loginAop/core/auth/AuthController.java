package angema.base.loginAop.core.auth;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthValidator authValidator;

    @Autowired
    private GlobalResponseService globalResponseService;

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public GlobalResponse login(@RequestBody MultiValueMap<String, String> formParams, @RequestParam("grant_type") String grantType) throws AuthException {
        AuthUserLoggedIn user = authValidator.validate(formParams, grantType);
        AuthResponse token = authService.login(user);
        return globalResponseService.response(token, "/auth/login");
    }

    @PostMapping(path = "/login")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public GlobalResponse login(@RequestBody AuthRequest authRequest, @RequestParam("grant_type") String grantType) throws AuthException {
        AuthUserLoggedIn user = authValidator.validate(authRequest, grantType);
        AuthResponse authResponse = authService.login(user);
        return globalResponseService.response(authResponse, "/auth/login");
    }

    @GetMapping(path = "/users")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public GlobalResponse getUserRoles() {
        List<Auth> users = authService.getUsers();
        return globalResponseService.response(users, "/user/users");
    }
}
