package angema.base.loginAop.app.partnerThemes;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/themes")
public class PartnerThemeController {
    public static final String cuitCarre = "30687310434";
    public static final String cuitMusimundo = "30697265895";

    @Autowired
    private PartnerThemeService partnerThemeService;

    @GetMapping("/themes/{cuit_socio}")
    public String getTematica(@PathVariable String cuit_socio) {
        JsonObject json = new JsonObject();
        // put some value pairs into the JSON object .
        if(cuit_socio.equals(cuitCarre)){
            json.addProperty("color_primary", "#0093d3");
            json.addProperty("color_secondary", "#e30512");
            json.addProperty("font_primary_url", "Helvetica Neue,Helvetica,Arial,sans-serif");
            json.addProperty("logo_url", "http://localhost:8080/api/v.0/socio/logo/"+cuit_socio);
        }
        else{
            json.addProperty("color_primary", "#e30613");
            json.addProperty("color_secondary", "#e30613");
            json.addProperty("font_primary_url", "Custom,Roboto,Helvetica Neue,sans-serif");
            json.addProperty("logo_url", "http://localhost:8080/api/v.0/socio/logo/"+cuit_socio);
        }
        String resultado=json.toString();
        return resultado;


    }
}


