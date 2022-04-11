package angema.base.loginAop.app.verificar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verificar")
public class VerificarController {

    @Autowired
    private VerificarService verificarService;

    @PostMapping(path = "")
    @ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @ResponseBody
    public String verificar(@RequestBody VerificarRequest body) {

        String response = verificarService.verificar(body);

        return response;
    }
}
