package angema.base.loginAop.app.descargas;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static angema.base.loginAop.app.descargas.DescargaErrorMsj.*;
import static angema.base.loginAop.core.utils.ErrorUtils.*;

@RestController
@RequestMapping("/descargas")
public class DescargasController {


    @GetMapping(value = "/cobertura/cuit/{cuitSocio}/id-producto/{idProducto}/descarga-cobertura", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] downloadCoberturaByCuitAndProductoId(@PathVariable String cuitSocio, @PathVariable String idProducto) throws IOException {
        try {
            InputStream in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/coberturaProduct/" + idProducto + ".pdf");
            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            String errMsg = getErrorMessage(DOWNLOAD_COBERTURA, cuitSocio, idProducto);
            throw new DescargaException(errMsg);
        }
    }

    @GetMapping(value = "/condiciones/cuit/{cuitSocio}/id-producto/{idProducto}/descarga-condiciones", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getCondicionesByCuitAndProductoId(@PathVariable String cuitSocio, @PathVariable String idProducto) throws IOException {
        try {
            InputStream in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/basesYCondicionesProduct/" + idProducto + ".pdf");
            return IOUtils.toByteArray(in);
        } catch (Exception e) {
            String errMsg = getErrorMessage(DOWNLOAD_CONDIONES, cuitSocio, idProducto);
            throw new DescargaException(errMsg);
        }
    }


    @GetMapping(value = "/getFontByCuit/{cuitSocio}/primary/type/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontPrimaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/getFontByCuit/{cuitSocio}/secondary/type/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontSecondaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_secondary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/getFontByCuit/{cuitSocio}/primary/type/font_primary.css", produces = "test/css")
    @ResponseBody
    public byte[] getFontCssByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".css");
        return IOUtils.toByteArray(in);


    }
}
