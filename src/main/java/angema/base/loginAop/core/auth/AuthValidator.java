package angema.base.loginAop.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AuthValidator {

    @Autowired
    private AuthRepository authRepository;

    @Value("${configs.auth.timezone}")
    private String TIMEZONE;

    public static final String CLIENT_CREDENTIALS = "client_credentials";
    private String USERNAME_KEY = "angema_devs";
    private String PASSWORD_KEY = "Secret..";

    public boolean validate(MultiValueMap<String, String> params) {
        return Objects.nonNull(params.getFirst(USERNAME_KEY)) && Objects.nonNull(params.getFirst(PASSWORD_KEY));
    }


    public AuthUserLoggedIn validate(MultiValueMap<String, String> formParams, String grantType) throws AuthException {

        if (grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)) {
            message("Invalid grant_type");
        }

        if (Objects.isNull(formParams) || formParams.getFirst("client_id").equals("") || formParams.getFirst("client_secret").equals("")) {
            message("Invalid client_id or client_secret");
        }

        return AuthUserLoggedIn.builder()
                .userName(formParams.getFirst("client_id"))
                .name("Gerard")
                .lastName("Palet")
                .email("paletgerardo@gmail.com")
                .build();
    }

    public AuthUserLoggedIn validate(AuthRequest authRequest, String grantType) throws AuthException {

        if (grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)) {
            message("Invalid grant_type");
        }

        if (isNull(authRequest)) {
            message("Invalid user or password");
        }

        Optional<Auth> userOpt = authRepository.findByEmailAndPassword(authRequest.email, authRequest.password);
        if (!userOpt.isPresent()) {
            message("Invalid user or password");
        }

        Auth user = userOpt.get();

        // get day of Date now
//        Date date = new Date(); // your date
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(TIMEZONE));
//        cal.setTime(date);
//        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
//        // get hour of Date now
//        String hour = String.valueOf(new Date().getHours());
//        String userName = authRequest.user;
//        String password = authRequest.password;

//        if (!userName.equals(USERNAME_KEY + day) || !password.equals(PASSWORD_KEY + hour)) {
//            message("Invalid user or password");
//        }
        List<String> roles = new ArrayList<>();
        user.roles.forEach(role -> roles.add(role.name));
        user.roles.forEach( r -> {
            roles.add(r.name);
        });
        return AuthUserLoggedIn.builder()
                .userName(user.userName)
                .name(user.name)
                .lastName(user.lastName)
                .email(user.email)
                .roles(roles)
                .build();
    }

    private boolean isNull(AuthRequest authRequest) {
        return Objects.isNull(authRequest)
                || authRequest.email == null
                || authRequest.email.equals("")
                || authRequest.password == null
                || authRequest.password.equals("");
    }

    public void message(String message) throws AuthException {
        throw new AuthException(message);
    }
}
