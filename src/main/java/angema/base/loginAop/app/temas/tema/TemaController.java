package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.enums.ViewportSize;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InputStream;

import static angema.base.loginAop.app.redirect.RedirectMsg.REDIRECT_GET_DESCRIPTION;
import static angema.base.loginAop.app.redirect.RedirectMsg.REDIRECT_GET_SUMMARY;
import static angema.base.loginAop.app.temas.tema.TemaMsg.*;

@RestController
@RequestMapping("/${TEMA_PATH}")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @Autowired
    private GlobalResponseService globalResponseService;
    @Operation(
            summary = TEMA_READ_TEMAS_SUMMARY,
            description = TEMA_READ_TEMAS_DESCRIPTION
    )
    @GetMapping("/${TEMA_URI_FIND_BY_CUIT}/cuit-socio/{cuitSocio}/tema-socio")
    @ResponseBody
    public GlobalResponse obtenerTemasPorCuit(@PathVariable String cuitSocio, WebRequest request) {
        Tema temasSocio = temaService.findTemas(cuitSocio);
        if (temasSocio == null) {
            return globalResponseService.responseWithHttpStatus(temasSocio, HttpStatus.NO_CONTENT, request);
        }
        return globalResponseService.responseOk(temasSocio, request);
    }
    @Operation(
            summary = TEMA_CREATE_SUMMARY,
            description = TEMA_CREATE_DESCRIPTION
    )
    @PostMapping("/${TEMA_URI_CREATE}/cuit-socio/{cuitSocio}")
    @ResponseBody
    public GlobalResponse agregarTema(@PathVariable String cuitSocio, @RequestBody TemaDto nuevoTema, WebRequest request) {
        try {
            boolean seGuardoOk = temaService.saveOrUpdateTema(cuitSocio, nuevoTema, false);
            if (seGuardoOk) {
                return globalResponseService.responseWithHttpStatus(TEMA_CREATE_CODE_200, HttpStatus.NO_CONTENT, request);
            }
            return globalResponseService.badRequestResponse(TEMA_MSG_ERROR_CREATE, request);
        } catch (Exception e) {
            throw new TemaException(TEMA_MSG_ERROR_READ + cuitSocio);
        }
    }
    @Operation(
            summary = TEMA_UPDATE_SUMMARY,
            description = TEMA_UPDATE_DESCRIPTION
    )
    @PutMapping("/${TEMA_URI_UPDATE}")
    @ResponseBody
    public GlobalResponse modificarTema(@PathVariable String cuitSocio, @RequestBody TemaDto tema, WebRequest request) {
        try {
            boolean seGuardoOk = temaService.saveOrUpdateTema(cuitSocio, tema, true);
            if (seGuardoOk) {
                return globalResponseService.responseWithHttpStatus(TEMA_CREATE_CODE_200, HttpStatus.NO_CONTENT, request);
            }
            return globalResponseService.badRequestResponse(TEMA_MSG_ERROR_CREATE, request);
        } catch (Exception e) {
            throw new TemaException(TEMA_MSG_ERROR_READ + cuitSocio);
        }
    }

    @Operation(
            summary = TEMA_READ_LOGO_SUMMARY,
            description = TEMA_READ_LOGO_DESCRIPTION
    )
    @GetMapping(value = "/${TEMA_URI_FIND_LOGO_BY_CUIT}/cuit-socio/{cuitSocio}/logo", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getLogo(@PathVariable String cuitSocio) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/images/logo-" + cuitSocio + ".png");
        return IOUtils.toByteArray(in);
    }

    @Operation(
            summary = TEMA_READ_BACKGROUND_SUMMARY,
            description = TEMA_READ_BACKGROUND_DESCRIPTION
    )
    // TODO: 13/10/2022 :definir imagen background y implementar funcionalidad en front.
    @GetMapping(value = "/${TEMA_URI_FIND_BACKGROUND_BY_CUIT}/cuit/{cuitSocio}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getBackGroundImageByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/images/bg-image-" + cuitSocio + ".jpg");
        return IOUtils.toByteArray(in);
    }

    @Operation(
            summary = TEMA_READ_COBERTURA_SUMMARY,
            description = TEMA_READ_COBERTURA_DESCRIPTION
    )
    @GetMapping(value = "/${TEMA_URI_FIND_COBERTURA_BY_CUIT_AND_IDPROD}/cuit/{cuitSocio}/id-producto/{idProducto}", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getCoberturaByCuitAndProductId(@PathVariable String cuitSocio, @PathVariable String idProducto) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/coberturaProduct/" + idProducto + ".pdf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = TEMA_READ_CONDICIONES_SUMMARY,
            description = TEMA_READ_CONDICIONES_DESCRIPTION
    )
    @GetMapping(value = "/${TEMA_URI_FIND_CONDICIONES_BY_CUIT_AND_IDPROD}/cuit/{cuitSocio}/id-producto/{idProducto}", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getCondicionesByCuitAndProductId(@PathVariable String cuitSocio, @PathVariable String idProducto) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/basesYCondicionesProduct/" + idProducto + ".pdf");
        return IOUtils.toByteArray(in);
    }

    @Operation(
            summary = TEMA_FONT_PRIMARY_SUMMARY,
            description = TEMA_FONT_PRIMARY_DESCRIPTION
    )
    @GetMapping(value = "/${TEMA_URI_FIND_FONT_PRIMARY_BY_CUIT}/cuit/{cuitSocio}/primary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontPrimaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = TEMA_FONT_SECONDARY_SUMMARY,
            description = TEMA_FONT_SECONDARY_DESCRIPTION
    )
    @GetMapping(value = "/${TEMA_URI_FIND_FONT_SECONDARY_BY_CUIT}/cuit/{cuitSocio}/secondary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontSecondaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_secondary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }
    @Operation(
            summary = TEMA_FONT_CSS_SUMMARY,
            description = TEMA_FONT_CSS_SUMMARY
    )
    @GetMapping(value = "/${TEMA_URI_FIND_FONT_CSS_BY_CUIT}/cuit/{cuitSocio}/primary/font_primary.css", produces = "test/css")
    @ResponseBody
    public byte[] getFontCssByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".css");
        return IOUtils.toByteArray(in);
    }
}
