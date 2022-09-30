package angema.base.loginAop.app.partnerStatics;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/statics")
@RestController
public class PartnerStaticController {

    @GetMapping(value="/logo/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getLogo(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/images/logo-"+cuit_socio+".png");
        return IOUtils.toByteArray(in);
    }

    // todo getCorrouselByCiutSocio

    // todo getFontByCuitSocio
}
