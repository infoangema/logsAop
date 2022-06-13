package angema.base.loginAop.core.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class GlobalResponse {
    public HttpStatus status;
    public String path;
    public Date timestamp = new Date();
    public Object body;
    public ErrorDetails error;
}
