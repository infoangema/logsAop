package angema.base.loginAop.app.temas.tipografia;

import angema.base.loginAop.app.temas.tema.TemaService;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/temas/tipografias")
public class TipografiaController {

    @Autowired
    private TemaService temaService;

    @Autowired
    private GlobalResponseService globalResponseService;


    @GetMapping(value = "/obtener-tipografia/cuit/{cuitSocio}/primary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontPrimaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TipografiaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/obtener-tipografia/cuit/{cuitSocio}/secondary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontSecondaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TipografiaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_secondary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/obtener-tipografia/cuit/{cuitSocio}/primary/font_primary.css", produces = "test/css")
    @ResponseBody
    public byte[] getFontCssByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TipografiaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".css");
        return IOUtils.toByteArray(in);
    }
}
