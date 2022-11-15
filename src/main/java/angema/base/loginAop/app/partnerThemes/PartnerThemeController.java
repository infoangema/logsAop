package angema.base.loginAop.app.partnerThemes;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/themes")
public class PartnerThemeController {
    public static final String cuitCarre = "30687310434";
    public static final String cuitMusimundo = "30697265895";
    private static Logger logger = Logger.getLogger(PartnerThemeController.class.getName());

    @Autowired
    private PartnerThemeService partnerThemeService;

//    @GetMapping("/getThemeBycuit/{cuitSocio}")
//    public PartnerTheme getThemeBycuit(@PathVariable String cuitSocio) {
//    List<PartnerTheme>tematica=null;
//            try{
//                tematica=partnerThemeService.getThemesByPartner(cuitSocio);
//            }catch(Exception e){
//                logger.info("Exception PartnerThemeController getTematicaBySocio: " + e.getMessage());
//            }
//     return tematica.get(0);
//    }

    @GetMapping("/getThemeBycuit/{cuitSocio}")
    public PartnerTheme getThemeAndColorAndCarouselBycuit(@PathVariable String cuitSocio) {
        PartnerTheme tematica=null;
        try{
            tematica=partnerThemeService.getThemeAndColorAndCarouselBycuit(cuitSocio);
        }catch(Exception e){
            logger.info("Exception PartnerThemeController getTematicaBySocio: " + e.getMessage());
        }
        return tematica;
    }


    @GetMapping(value="/getLogoByCuit/{cuitSocio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getLogo(@PathVariable String cuitSocio) throws IOException {
        InputStream in = PartnerThemeController.class.getResourceAsStream("/static/"+cuitSocio+"/images/logo-"+cuitSocio+".png");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value="/getCarouselImageByCuit/{cuitSocio}/{numero}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getCarouselImageByCuit(@PathVariable String cuitSocio,@PathVariable String numero) throws IOException {
        InputStream in = PartnerThemeController.class.getResourceAsStream("/static/"+cuitSocio+"/images/carousel_image_"+numero+".jpg");
        return IOUtils.toByteArray(in);
    }

    // TODO: 13/10/2022 :definir imagen background y implementar funcionalidad en front.
    @GetMapping(value="/getBackGroundImageByCuit/{cuitSocio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getBackGroundImageByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = PartnerThemeController.class.getResourceAsStream("/static/images/bg-image-"+cuitSocio+".jpg");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value="/getCoberturaByCuitAndProductId/{cuitSocio}/{id_producto}",produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public  byte[] getCoberturaByCuitAndProductId(@PathVariable String cuitSocio,@PathVariable String id_producto) throws IOException {
        InputStream in = PartnerThemeController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/coberturaProduct/"+id_producto+".pdf");
        return IOUtils.toByteArray(in);
    }
    @GetMapping(value="/getCondicionesByCuitAndProductId/{cuitSocio}/{id_producto}",produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public  byte[] getCondicionesByCuitAndProductId(@PathVariable String cuitSocio,@PathVariable String id_producto) throws IOException {
        InputStream in = PartnerThemeController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/basesYCondicionesProduct/"+id_producto+".pdf");
        return IOUtils.toByteArray(in);
    }




    @GetMapping(value="/getFontByCuit/{cuitSocio}/primary/type/font_primary.ttf",produces = "application/x-font-ttf")
    @ResponseBody
    public  byte[] getFontByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in=null;
        if (cuitSocio.equals(cuitCarre))
            in = PartnerThemeController.class.getResourceAsStream("/static/fonts/font-"+cuitSocio+"/font_primary_"+cuitSocio+".ttf");
        else
            in = PartnerThemeController.class.getResourceAsStream("/static/fonts/font-"+cuitSocio+"/static/RobotoSlab-Regular.ttf");

        return IOUtils.toByteArray(in);


    }

    //    @GetMapping(value="/font/cuit/{cuitSocio}/primary/type/{tipo}/font_primary.ttf",produces = "application/x-font-ttf")
//    @ResponseBody
//    public  byte[] getFontByCuitAndType(@PathVariable String cuitSocio,@PathVariable String tipo) throws IOException {
//        InputStream in=null;
//        if (cuitSocio.equals(cuitCarre))
//            in = EstaticoController.class.getResourceAsStream("/static/fonts/font-"+cuitSocio+"/font_primary_"+cuitSocio+".ttf");
//        else
//            in = EstaticoController.class.getResourceAsStream("/static/fonts/font-"+cuitSocio+"/static/RobotoSlab-Regular.ttf");
//
//        //  return IOUtils.toByteArray(in);
//
//        final HttpHeaders httpHeaders= new HttpHeaders();
//        httpHeaders.setContentType("application/x-font-"+tipo);
//        return new ResponseEntity<String>("{\"test\": \"Hello with ResponseEntity\"}", httpHeaders, HttpStatus.OK);
//    }
}


