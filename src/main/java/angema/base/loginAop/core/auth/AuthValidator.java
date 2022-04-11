package angema.base.loginAop.core.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@Component
public class AuthValidator {

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
                .name("Gerard")
                .lastName("Palet")
                .email("paletgerardo@gmail.com")
                .phone("11-3643-3247")
                .build();
    }

    public AuthUserLoggedIn validate(AuthRequest authRequest, String grantType) throws AuthException {

        if (grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)) {
            message("Invalid grant_type");
        }

        if (Objects.isNull(authRequest) || authRequest.user.equals("") || authRequest.password.equals("")) {
            message("Invalid user or password");
        }
        // get day of Date now
        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(TIMEZONE));
        cal.setTime(date);
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        // get hour of Date now
        String hour = String.valueOf(new Date().getHours());
        String user = authRequest.user;
        String password = authRequest.password;
        if (!user.equals(USERNAME_KEY + day) || !password.equals(PASSWORD_KEY + hour)) {
            message("Invalid user or password");
        }

        return AuthUserLoggedIn.builder()
                .name("Gerard")
                .lastName("Palet")
                .email("paletgerardo@gmail.com")
                .phone("11-3643-3247")
                .build();
    }

    public void message(String message) throws AuthException {
        throw new AuthException(message);
    }
}
