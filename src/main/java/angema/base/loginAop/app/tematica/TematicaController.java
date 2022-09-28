package angema.base.loginAop.app.tematica;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TematicaController {

    @Autowired
    private TematicaService tematicaService;

    @GetMapping("/tematica/{cuit}")
    public String getTematica() {
        JsonObject json = new JsonObject();
        // put some value pairs into the JSON object .
        json.addProperty("colorPrimary", "blue");
        json.addProperty("colorSecondary", "lightcoral");
        json.addProperty("fontPrimary", "http://localhost:8080/socio/30717119238/theme/font/eemplo.tiff");
        json.addProperty("logo", "http://localhost:8080/socio/30717119238/theme/imagen/logo/logo-carre.png");

        String resultado=json.toString();
        return resultado;


    }
}


