package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.enums.ViewportSize;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @GetMapping("/obtener-temas/cuit-socio/{cuitSocio}/tema-socio")
    @ResponseBody
    public GlobalResponse obtenerTemasPorCuit(@PathVariable String cuitSocio, WebRequest request) {
        Tema temasSocio = temaService.findTemas(cuitSocio);
        if (temasSocio == null) {
            return globalResponseService.responseWithHttpStatus(temasSocio, HttpStatus.NO_CONTENT, request);
        }
        return globalResponseService.responseOk(temasSocio, request);
    }

    @PostMapping("/agregar-tema/cuit-socio/{cuitSocio}")
    @ResponseBody
    public GlobalResponse agregarTema(@PathVariable String cuitSocio, @RequestBody TemaDto nuevoTema, WebRequest request) {
        try {
            boolean seGuardoOk = temaService.saveOrUpdateTema(cuitSocio, nuevoTema, false);
            if (seGuardoOk) {
                return globalResponseService.responseWithHttpStatus("Nuevo tema agregado correctamente.", HttpStatus.NO_CONTENT, request);
            }
            return globalResponseService.badRequestResponse("Error al intentar guardar el nuevo tema.", request);
        } catch (Exception e) {
            throw new TemaException("Error al intentar obtener tema para el cuit " + cuitSocio);
        }
    }

    @PutMapping("/modificar-tema")
    @ResponseBody
    public GlobalResponse modificarTema(@PathVariable String cuitSocio, @RequestBody TemaDto tema, WebRequest request) {
        try {
            boolean seGuardoOk = temaService.saveOrUpdateTema(cuitSocio, tema, true);
            if (seGuardoOk) {
                return globalResponseService.responseWithHttpStatus("Nuevo tema agregado correctamente.", HttpStatus.NO_CONTENT, request);
            }
            return globalResponseService.badRequestResponse("Error al intentar guardar el nuevo tema.", request);
        } catch (Exception e) {
            throw new TemaException("Error al intentar obtener tema para el cuit " + cuitSocio);
        }
    }


    @GetMapping(value = "/obtener-logo/cuit-socio/{cuitSocio}/logo", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getLogo(@PathVariable String cuitSocio) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/images/logo-" + cuitSocio + ".png");
        return IOUtils.toByteArray(in);
    }


    // TODO: 13/10/2022 :definir imagen background y implementar funcionalidad en front.
    @GetMapping(value = "/obtener-imagen-fondo/cuit/{cuitSocio}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getBackGroundImageByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/images/bg-image-" + cuitSocio + ".jpg");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value = "/obtener-cobertura/cuit/{cuitSocio}/id-producto/{idProducto}", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getCoberturaByCuitAndProductId(@PathVariable String cuitSocio, @PathVariable String idProducto) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/coberturaProduct/" + idProducto + ".pdf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/obtener-condiciones/cuit/{cuitSocio}/id-producto/{idProducto}", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getCondicionesByCuitAndProductId(@PathVariable String cuitSocio, @PathVariable String idProducto) throws IOException {
        InputStream in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/basesYCondicionesProduct/" + idProducto + ".pdf");
        return IOUtils.toByteArray(in);
    }


    @GetMapping(value = "/obtener-tipografia/cuit/{cuitSocio}/primary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontPrimaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/obtener-tipografia/cuit/{cuitSocio}/secondary/font_primary.ttf", produces = "application/x-font-ttf")
    @ResponseBody
    public byte[] getFontSecondaryByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_secondary_" + cuitSocio + ".ttf");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/obtener-tipografia/cuit/{cuitSocio}/primary/font_primary.css", produces = "test/css")
    @ResponseBody
    public byte[] getFontCssByCuit(@PathVariable String cuitSocio) throws IOException {
        InputStream in = null;
        in = TemaController.class.getResourceAsStream("/static/" + cuitSocio + "/fonts/font_primary_" + cuitSocio + ".css");
        return IOUtils.toByteArray(in);
    }
}
