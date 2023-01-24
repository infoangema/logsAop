package angema.base.loginAop.app.descargas;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DescargaException extends RuntimeException {
    public DescargaException(String s) {
        super(s);
    }
}
