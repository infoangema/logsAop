package angema.base.loginAop.app.partnerStatics;

import angema.base.loginAop.core.utils.FileSystemUtil;
import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RequestMapping("/partners/statics")
@RestController
public class PartnerStaticController {
    public static final String cuitCarre = "30687310434";
    // todo getLogoByCuitSocio

    @Autowired
    private FileSystemUtil fileSystemUtil;


    @GetMapping(value="/logo/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getLogo(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/"+cuit_socio+"/images/logo-"+cuit_socio+".png");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value="/carousel/{numero}/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getCarouselImage(@PathVariable String cuit_socio,@PathVariable String numero) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/"+cuit_socio+"/images/carousel_image_"+numero+".jpg");
        return IOUtils.toByteArray(in);
    }

    // TODO: 13/10/2022 :definir imagen background y implementar funcionalidad en front.
    @GetMapping(value="/bg-image/{cuit_socio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getBackGroundImage(@PathVariable String cuit_socio) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/images/bg-image-30687310434.jpg");
        return IOUtils.toByteArray(in);
    }


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

    @GetMapping(value="/products/{cuit_socio}/{id_producto}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getProductImage(@PathVariable String cuit_socio,@PathVariable String id_producto) throws IOException {
        InputStream in = PartnerStaticController.class.getResourceAsStream("/static/"+cuit_socio+"/productos/img_"+id_producto+".jfif");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value="/catalogos/productos/{cuit_socio}")
    @ResponseBody
    public String getProductos(@PathVariable String cuit_socio) throws IOException {
        String res = fileSystemUtil.getFile("/static/"+cuit_socio+"/productos/productos.json");
        return res;
    }
    // todo getCorrouselByCiutSocio

    // todo getFontByCuitSocio

}
