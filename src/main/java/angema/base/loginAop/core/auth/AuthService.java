package angema.base.loginAop.core.auth;

import angema.base.loginAop.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthServiceJwt authServiceJwt;

    @Autowired
    private DateUtil dateUtil;

    @Value("${configs.auth.token.expiration:3600}")
    private int EXPIRATION_TIME;

    @Autowired
    private AuthRepository authRepository;

    public AuthDtoResponse login(AuthDtoUserLoggedIn user) {

        AuthDtoResponse response = AuthDtoResponse.builder()
                .tokenType("Bearer")
                .accessToken(authServiceJwt.generateToken(user))
                .refreshToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
                .issuedAt(dateUtil.getDateMillis() + "")
                .clientId(user.userName)
                .expiresIn(EXPIRATION_TIME)
                .clientData(user)
                .build();
        return response;
    }

    public AuthDtoUserLoggedIn getPayloadObject(String token) {
        return authServiceJwt.getPayLoadObject(token);
    }

    public List<AuthEntity> getUsers() {
        return authRepository.findAll();
    }
}
