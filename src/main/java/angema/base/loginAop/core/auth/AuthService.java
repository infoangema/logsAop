package angema.base.loginAop.core.auth;

import angema.base.loginAop.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthJwt authJwt;

    @Autowired
    private DateUtil dateUtil;

    @Value("${configs.auth.token.expiration:3600}")
    private int EXPIRATION_TIME;

    @Autowired
    private AuthRepository authRepository;

    public AuthResponse login(AuthUserLoggedIn user) {

        AuthResponse response = AuthResponse.builder()
                .tokenType("Bearer")
                .accessToken(authJwt.generateToken(user))
                .refreshToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
                .issuedAt(dateUtil.getDateMillis() + "")
                .clientId(user.userName)
                .expiresIn(EXPIRATION_TIME)
                .clientData(user)
                .build();
        return response;
    }

    public AuthUserLoggedIn getPayloadObject(String token) {
        return authJwt.getPayLoadObject(token);
    }

    public List<Auth> getUsers() {
        return authRepository.findAll();
    }
}
