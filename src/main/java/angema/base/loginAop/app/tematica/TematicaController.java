package angema.base.loginAop.app.tematica;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TematicaController {
    public static final String cuitCarre = "30687310434";
    public static final String cuitMusimundo = "30697265895";

    @Autowired
    private TematicaService tematicaService;

    @GetMapping("/tematica/{cuit}")
    public String getTematica(@PathVariable(value = "cuit") String cuit) {
        JsonObject json = new JsonObject();
        // put some value pairs into the JSON object .
        if(cuit.equals(cuitCarre)){
            json.addProperty("colorPrimary", "#0093d3");
            json.addProperty("colorSecondary", "#e30512");
            json.addProperty("fontPrimary", "http://localhost:8080/socio/30717119238/theme/font/eemplo.tiff");
            json.addProperty("logo", " https://www.servicioscarrefour1.com.ar/image/layout_set_logo?img_id=23766&t=1661563261880");
        }
        else{
            json.addProperty("colorPrimary", "#e30613");
            json.addProperty("colorSecondary", "#e30613");
            json.addProperty("fontPrimary", "http://localhost:8080/socio/30717119238/theme/font/eemplo.tiff");
            json.addProperty("logo", "https://mimundoprotegido.com.ar/assets/images/logo.png");
        }
        String resultado=json.toString();
        return resultado;


    }
}


