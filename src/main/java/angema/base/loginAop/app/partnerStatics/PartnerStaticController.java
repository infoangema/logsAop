package angema.base.loginAop.app.partnerStatics;

import org.apache.commons.io.IOUtils;

import org.springframework.http.MediaType;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RequestMapping("/socio")
@RestController
public class PartnerStaticController {
    public static final String cuitCarre = "30687310434";
    // todo getLogoByCuitSocio



    @GetMapping(value="/logo/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getLogo(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/images/logo-"+cuit_socio+".png");
        return IOUtils.toByteArray(in);
    }


    // todo getCorrouselByCiutSocio

    // todo getFontByCuitSocio




    @GetMapping(value="/font/cuit/{cuit_socio}/primary/type/font_primary.ttf",produces = "application/x-font-ttf")
    @ResponseBody
    public  byte[] getFontByCuit(@PathVariable String cuit_socio) throws IOException {
        InputStream in=null;
        if (cuit_socio.equals(cuitCarre))
             in = PartnerStaticController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/font_primary_"+cuit_socio+".ttf");
        else
             in = PartnerStaticController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/static/RobotoSlab-Regular.ttf");

        return IOUtils.toByteArray(in);


    }

//    @GetMapping(value="/font/cuit/{cuit_socio}/primary/type/{tipo}/font_primary.ttf",produces = "application/x-font-ttf")
//    @ResponseBody
//    public  byte[] getFontByCuitAndType(@PathVariable String cuit_socio,@PathVariable String tipo) throws IOException {
//        InputStream in=null;
//        if (cuit_socio.equals(cuitCarre))
//            in = EstaticoController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/font_primary_"+cuit_socio+".ttf");
//        else
//            in = EstaticoController.class.getResourceAsStream("/static/fonts/font-"+cuit_socio+"/static/RobotoSlab-Regular.ttf");
//
//        //  return IOUtils.toByteArray(in);
//
//        final HttpHeaders httpHeaders= new HttpHeaders();
//        httpHeaders.setContentType("application/x-font-"+tipo);
//        return new ResponseEntity<String>("{\"test\": \"Hello with ResponseEntity\"}", httpHeaders, HttpStatus.OK);
//    }

}
