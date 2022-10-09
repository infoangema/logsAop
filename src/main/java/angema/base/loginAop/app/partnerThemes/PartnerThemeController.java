package angema.base.loginAop.app.partnerThemes;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cuit/{cuit_socio}")
    public String getTematica(@PathVariable String cuit_socio) {
        JsonObject json = new JsonObject();
        // put some value pairs into the JSON object .
        if(cuit_socio.equals(cuitCarre)){
            json.addProperty("color_primary", "#0093d3");
            json.addProperty("color_secondary", "#dad6d6");
            json.addProperty("font_primary_url", "Helvetica Neue,Helvetica,Arial,sans-serif");
            json.addProperty("logo_url", "http://localhost:8080/api/v.0/partners/statics/logo/"+cuit_socio);
            json.addProperty("carousel_image_1", "http://localhost:8080/api/v.0/partners/statics/carousel/1/"+cuit_socio);
            json.addProperty("carousel_image_2", "http://localhost:8080/api/v.0/partners/statics/carousel/2/"+cuit_socio);
            json.addProperty("carousel_image_3", "http://localhost:8080/api/v.0/partners/statics/carousel/3/"+cuit_socio);
            json.addProperty("carousel_image_4", "http://localhost:8080/api/v.0/partners/statics/carousel/4/"+cuit_socio);
        }
        else{
            json.addProperty("color_primary", "#e30613");
            json.addProperty("color_secondary", "#e30613");
            json.addProperty("font_primary_url", "Custom,Roboto,Helvetica Neue,sans-serif");
            json.addProperty("logo_url", "http://localhost:8080/api/v.0/partners/statics/logo/"+cuit_socio);
            json.addProperty("carousel_image_1", "http://localhost:8080/api/v.0/partners/statics/carousel/1/"+cuit_socio);
            json.addProperty("carousel_image_2", "http://localhost:8080/api/v.0/partners/statics/carousel/2/"+cuit_socio);
            json.addProperty("carousel_image_3", "http://localhost:8080/api/v.0/partners/statics/carousel/3/"+cuit_socio);
            json.addProperty("carousel_image_4", "http://localhost:8080/api/v.0/partners/statics/carousel/4/"+cuit_socio);
        }
        String resultado=json.toString();
        return resultado;
    }
    @GetMapping("/cuit_socio/{cuit_socio}")
    public List<PartnerTheme> getThemesByPartner(@PathVariable String cuit_socio) {
    List<PartnerTheme>tematica=null;
            try{
                tematica=partnerThemeService.getThemesByPartner(cuit_socio);
            }catch(Exception e){
                logger.info("Exception PartnerThemeController getTematicaBySocio: " + e.getMessage());
            }
     return tematica;
    }
}


