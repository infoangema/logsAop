package angema.base.loginAop.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class DateUtil {

    @Value("${configs.auth.timezone}")
    private String TIMEZONE;

    private SimpleDateFormat simpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return sdf;
    }

    public String getDateString() {
        return simpleDateFormat().format(new Date());
    }

    public long getDateMillis() {
        String strDate = simpleDateFormat().format(new java.util.Date());
        Date strNow = new Date();
        try {
            strNow = simpleDateFormat().parse(strDate);
        } catch (ParseException ignored) {}
        return strNow.getTime();
    }
}
