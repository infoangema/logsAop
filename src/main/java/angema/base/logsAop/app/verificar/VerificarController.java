package angema.base.logsAop.app.verificar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verificar")
public class VerificarController {

    @Autowired
    private VerificarService verificarService;

    @PostMapping("/")
    public String verificar(@RequestBody VerificarRequest request) {

        String response = verificarService.verificar(request);

        return response;
    }
}
