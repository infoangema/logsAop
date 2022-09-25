package angema.base.loginAop.core.globalResponse;

import org.springframework.http.HttpStatus;

public class GlobalResponse {
    public HttpStatus status;
    public String path;
    public String timestamp;
    public Object body;
    public String error;
}
