package angema.base.loginAop.core.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * * @author Hugo Gerard Palet 13/9/2021
 **/
@Service
public class LogService {
    private static Log LOG = LogFactory.getLog(LogService.class);
    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        System.setProperty("uuid", String.valueOf(uuid));
        return uuid.toString();
    }

    public void clearUUID() {
        System.clearProperty("uuid");
    }

    public boolean isDebugEnabled() {
        return LOG.isDebugEnabled();
    }

    public String getUUID() {
        return System.getProperty("uuid");
    }

    private void setClazz(String clazz) {
        System.setProperty("clazz", clazz);
    }

    private String getClazz() {
        return System.getProperty("clazz");
    }

    public void setMethod(String method) {
        System.setProperty("method", method);
    }

    public void setEndpoint(String endpoint) {
        System.setProperty("endpoint", endpoint);
    }

    public String getMethod() {
        return System.getProperty("method");
    }

    public String getEndpoint() {
        return System.getProperty("endpoint");
    }

    public String getInitLog() {
        return "START RequestId: ";
    }

    public String getProcessLog() {
        return "PROCESS RequestId: ";
    }

    public String getEndLog() {
        return "END RequestId: ";
    }

    public String getErrorLog() {
        return "ERROR RequestId: ";
    }

    public void initLog(String clazz, String method, String data) {
        setClazz(clazz);
        setMethod(method);
        LOG.info(getInitLog() + generateUUID() + " CLASS: " + clazz + " - METHOD: " + method + "() - DATA:" + data);
    }

    public void initLog(String method,String data) {
        setMethod(method);
        LOG.info(getInitLog() + generateUUID() + " CLASS - METHOD: " + method  +"() - DATA: " + data);
    }

    public void processLog(String clazz, String method, String info) {
        setClazz(clazz);
        setMethod(method);
        LOG.info(getProcessLog() + getUUID() + " CLASS: "+clazz+" - METHOD: "+method+"() - DATA "+info );
    }

    public void endLog() {
        LOG.info(getEndLog() + getUUID() + " CLASS: "+getClazz()+" - METHOD: " + getMethod() );
        clearUUID();
    }

    public void errorLog(String info) {
        LOG.error(getErrorLog() + getUUID() + " CLASS: "+getClazz()+ " - METHOD: "+getMethod()+" - DATA "+info);
        endLog();
    }

}
