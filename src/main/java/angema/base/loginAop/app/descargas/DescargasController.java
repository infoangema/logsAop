package angema.base.loginAop.app.descargas;

import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

import static angema.base.loginAop.app.descargas.DescargaMsg.*;
import static angema.base.loginAop.core.utils.ErrorUtils.*;

@RestController
@RequestMapping("/${DESCARGA_PATH}")
public class DescargasController {

    @Operation(
            summary = DOWNLOAD_COBERTURA_SUMMARY,
            description = DOWNLOAD_COBERTURA_DESCRIPTION
    )
    @GetMapping(value = "/${DESCARGA_URI_COBERTURA_BY_CUIT_AND_IDPRODUC}/cuit/{cuitSocio}/id-producto/{idProducto}/descarga-cobertura", produces = MediaType.APPLICATION_PDF_VALUE)
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
    @Operation(
            summary = DOWNLOAD_CONDICIONES_SUMMARY,
            description = DOWNLOAD_CONDICIONES_DESCRIPTION
    )
    @GetMapping(value = "/${DESCARGA_URI_CONDICIONES_BY_CUIT_AND_IDPRODUC}/cuit/{cuitSocio}/id-producto/{idProducto}/descarga-condiciones", produces = MediaType.APPLICATION_PDF_VALUE)
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

    @Operation(
            summary = FONT_PRIMARY_SUMMARY,
            description = FONT_PRIMARY_DESCRIPTION
    )
    @GetMapping(value = "/${DESCARGA_URI_FONT_PRIMARY_BY_CUIT}/{cuitSocio}/primary/type/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontPrimaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = FONT_SECONDARY_SUMMARY,
            description = FONT_SECONDARY_DESCRIPTION
    )
    @GetMapping(value = "/${DESCARGA_URI_FONT_SECONDARY_BY_CUIT}/{cuitSocio}/secondary/type/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontSecondaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_secondary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = FONT_CSS_SUMMARY,
            description = FONT_CSS_DESCRIPTION
    )
    @GetMapping(value = "/${DESCARGA_URI_FONT_CSS_BY_CUIT}/{cuitSocio}/primary/type/font_primary.css", produces = "test/css")
    @ResponseBody
    public byte[] getFontCssByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = DescargasController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".css");
        return IOUtils.toByteArray(in);
    }
}
