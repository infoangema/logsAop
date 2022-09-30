package angema.base.loginAop.app.partnerStatics;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RequestMapping("/socio")
@RestController
public class EstaticoController {
    public static final String cuitCarre = "30687310434";
    // todo getLogoByCuitSocio



    @GetMapping(value="/logo/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getLogo(@PathVariable String cuit_socio) throws IOException {
        InputStream in = EstaticoController.class.getResourceAsStream("/static/images/logo-"+cuit_socio+".png");

        return IOUtils.toByteArray(in);
    }


    // todo getCorrouselByCiutSocio

    // todo getFontByCuitSocio
}
