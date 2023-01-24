package angema.base.loginAop.app.temas.tema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TemaException extends RuntimeException {
    public TemaException(String s) {
        super(s);
    }
}
