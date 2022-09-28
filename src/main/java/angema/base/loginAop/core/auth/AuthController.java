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
    private AuthServiceValidator authServiceValidator;

    @Autowired
    private GlobalResponseService globalResponseService;

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public GlobalResponse login(@RequestBody MultiValueMap<String, String> formParams, @RequestParam("grant_type") String grantType) throws AuthException {
        AuthDtoUserLoggedIn user = authServiceValidator.validate(formParams, grantType);
        AuthDtoResponse token = authService.login(user);
        return globalResponseService.response(token, "/auth/login");
    }

    @PostMapping(path = "/login")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public GlobalResponse login(@RequestBody AuthDtoRequest authDtoRequest, @RequestParam("grant_type") String grantType) throws AuthException {
        AuthDtoUserLoggedIn user = authServiceValidator.validate(authDtoRequest, grantType);
        AuthDtoResponse authDtoResponse = authService.login(user);
        return globalResponseService.response(authDtoResponse, "/auth/login");
    }

    @GetMapping(path = "/users")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public GlobalResponse getUserRoles() {
        List<AuthEntity> users = authService.getUsers();
        return globalResponseService.response(users, "/user/users");
    }
}
