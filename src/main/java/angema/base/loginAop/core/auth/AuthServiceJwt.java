package angema.base.loginAop.core.auth;

import angema.base.loginAop.core.utils.GsonUtil;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@Service
public class AuthServiceJwt {

    @Value("${configs.auth.token.secret:secretPassDefault}")
    private String SECRET;
    @Value("${configs.auth.timezone:America/Argentina/Buenos_Aires}")
    private String TIMEZONE;
    @Value("${configs.auth.token.expiration:3600}")
    private int EXPIRATION_TIME;
    @Value("${configs.auth.issuer:none}")
    private String ISSUER;

    public String generateToken(Object obj) {
        String subject = GsonUtil.serialize(obj);
        Signer signer = HMACSigner.newSHA256Signer(SECRET);

        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);
        ZonedDateTime now = ZonedDateTime.now(tz.toZoneId());
        ZonedDateTime exp = now.plusSeconds(EXPIRATION_TIME);

        JWT jwt = new JWT()
                .setIssuer(ISSUER)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(exp);
        return JWT.getEncoder().encode(jwt, signer);
    }

    public boolean validateToken(String token) {
        JWT jwt = jwt(token);
        if(jwt == null ) {
            return false;
        }
        return !jwt.isExpired();
    }

    public String getPayLoad(String token) {
        JWT jwt = jwt(token);
        return jwt.subject;
    }


    public AuthDtoUserLoggedIn getPayLoadObject(String token) {
        String payload = getPayLoad(token);
        return GsonUtil.toObject(payload, AuthDtoUserLoggedIn.class);
    }

    private JWT jwt(String token) {
        try {
            Verifier verifier = HMACVerifier.newVerifier(SECRET);
            return JWT.getDecoder().decode(token, verifier);
        } catch (Exception e) {
            return null;
        }
    }
}
