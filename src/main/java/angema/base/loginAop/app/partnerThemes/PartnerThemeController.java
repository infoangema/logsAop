package angema.base.loginAop.app.partnerThemes;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/partners")
public class PartnerThemeController {
    public static final String cuitCarre = "30687310434";
    public static final String cuitMusimundo = "30697265895";

    @Autowired
    private PartnerThemeService partnerThemeService;

    @GetMapping("/themes/{cuit}")
    public String getTematica(@PathVariable String cuit) {
        JsonObject json = new JsonObject();
        // put some value pairs into the JSON object .
        if(cuit.equals(cuitCarre)){
            json.addProperty("color_primary", "#0093d3");
            json.addProperty("color_secondary", "#e30512");
            json.addProperty("font_primary", "http://localhost:8080/socio/30717119238/theme/font/eemplo.tiff");
            json.addProperty("logo_url", "https://www.servicioscarrefour1.com.ar/image/layout_set_logo?img_id=23766&t=1661563261880");
        }
        else{
            json.addProperty("color_primary", "#e30613");
            json.addProperty("color_secondary", "#e30613");
            json.addProperty("font_primary", "http://localhost:8080/socio/30717119238/theme/font/eemplo.tiff");
            json.addProperty("logo_url", "https://mimundoprotegido.com.ar/assets/images/logo.png");
        }
        String resultado=json.toString();
        return resultado;


    }
}


