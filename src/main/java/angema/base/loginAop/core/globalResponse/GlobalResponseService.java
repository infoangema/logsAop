package angema.base.loginAop.core.globalResponse;

import angema.base.loginAop.core.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

@Service
public class GlobalResponseService {

    @Autowired
    private DateUtil dateUtil;

    public GlobalResponse<?> responseOk(Object obj, WebRequest request) {
        GlobalResponse<String> response = new GlobalResponse<>();
        response.body = obj;
        response.status = HttpStatus.OK;
        response.path = request.getDescription(false);
        response.error = null;
        response.timestamp = dateUtil.getDateString();
        return response;
    }

    public GlobalResponse<?> responseWithHttpStatus(Object obj, HttpStatus httpStatus, WebRequest request) {
        GlobalResponse<Object> response = new GlobalResponse<>();
        response.body = obj;
        response.status = httpStatus;
        response.path = request.getDescription(false);
        response.error = null;
        response.timestamp = dateUtil.getDateString();
        return response;
    }

    public GlobalResponse<?> badRequestResponse(String errorStr, WebRequest request) {
        GlobalResponse<Object> response = new GlobalResponse<>();
        response.body = null;
        response.status = HttpStatus.BAD_REQUEST;
        response.path = request.getDescription(false);
        response.error = errorStr;
        if(errorStr == null || errorStr.equals("")) {
            response.error = "Error desconocido.";
        }
        response.timestamp = dateUtil.getDateString();
        return response;
    }
}
