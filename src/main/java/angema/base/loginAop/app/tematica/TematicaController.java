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

    @GetMapping("/tematica")
    public String getTematica() {
        JsonObject json = new JsonObject();
        // put some value pairs into the JSON object .
        json.addProperty("colorPrimary", "blue");
        json.addProperty("colorSecondary", "lightcoral");
        json.addProperty("fontPrimary", "Times New Roman");

        String resultado=json.toString();
        return resultado;


    }

}


