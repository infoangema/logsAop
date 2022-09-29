package angema.base.loginAop.app.estatico;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RequestMapping("/socio")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EstaticoController {

    // todo getLogoByCuitSocio

 //   @GetMapping("/logo")
//    public static String getLogo() {
//       String logoUrl="/src/main/resources/static/images/layout_set_logo.png";
//        return logoUrl;
//
//
//    }
    @GetMapping(value = "/logo")
    public @ResponseBody byte[] getLogo() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/src/main/resources/static/images/layout_set_logo.png");
        return org.apache.commons.io.IOUtils.toByteArray(in);
    }



    // todo getCorrouselByCiutSocio

    // todo getFontByCuitSocio
}
