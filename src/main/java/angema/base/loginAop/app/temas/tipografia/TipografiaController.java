package angema.base.loginAop.app.temas.tipografia;

import angema.base.loginAop.app.temas.tema.TemaService;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static angema.base.loginAop.app.redirect.RedirectMsg.REDIRECT_GET_DESCRIPTION;
import static angema.base.loginAop.app.redirect.RedirectMsg.REDIRECT_GET_SUMMARY;
import static angema.base.loginAop.app.temas.tipografia.TipografiaMsg.*;

@RestController
@RequestMapping("/${TIPOGRAFIA_PATH}")
public class TipografiaController {

    @Autowired
    private TemaService temaService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @Operation(
            summary = TIPOGRAFIA_FONT_PRIMARY_SUMMARY,
            description = TIPOGRAFIA_FONT_PRIMARY_DESCRIPTION
    )
    @GetMapping(value = "/${TIPOGRAFIA_URI_FIND_FONT_PRIMARY_BY_CUIT}/cuit/{cuitSocio}/primary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontPrimaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TipografiaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = TIPOGRAFIA_FONT_SECONDARY_SUMMARY,
            description = TIPOGRAFIA_FONT_SECONDARY_DESCRIPTION
    )
    @GetMapping(value = "/${TIPOGRAFIA_URI_FIND_FONT_SECONDARY_BY_CUIT}/cuit/{cuitSocio}/secondary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontSecondaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TipografiaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_secondary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = TIPOGRAFIA_FONT_CSS_SUMMARY,
            description = TIPOGRAFIA_FONT_CSS_SUMMARY
    )
    @GetMapping(value = "/${TIPOGRAFIA_URI_FIND_FONT_CSS_BY_CUIT}/cuit/{cuitSocio}/primary/font_primary.css", produces = "test/css")
    @ResponseBody
    public byte[] getFontCssByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TipografiaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".css");
        return IOUtils.toByteArray(in);
    }
}
