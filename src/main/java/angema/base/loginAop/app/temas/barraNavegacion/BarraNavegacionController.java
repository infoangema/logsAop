package angema.base.loginAop.app.temas.barraNavegacion;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionMsg.*;

@RestController
@RequestMapping("${BARRA_NAVEGACION_PATH}")
public class BarraNavegacionController {

    @Autowired
    private BarraNavegacionService barraNavegacionService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @Operation(
            summary = "@RequestBody List<BarraNavegacion>, @Return String: \"" + CODE_200_CREATE + "\"",
            description = "CRUD CREATE. Retorna mensaje ok. Errores conocidos. El atributo cuit_socio no puede estar repetido."
    )
    @PostMapping("/${BARRA_NAVEGACION_URI_CREATE}")
    public GlobalResponse create(@RequestBody List<BarraNavegacion> barrasNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.addBarraNavegacions(barrasNavegacion);
        return globalResponseService.responseOk(CODE_200_CREATE, request);
    }

    @Operation(
            summary = "@PathVariable: String cuitSocio, @Return model: BarraNavegacion",
            description = "CRUD READ. Retorna BarraNavegacion."
    )
    @GetMapping("/${BARRA_NAVEGACION_URI_READ}/cuit-socio/{cuitSocio}/barra-navegacion")
    public GlobalResponse read(@PathVariable String cuitSocio, WebRequest request) throws BarraNavegacionException {
        BarraNavegacion barraNavegacion = barraNavegacionService.getBarraNavegacion(cuitSocio);
        return globalResponseService.responseOk(barraNavegacion, request);
    }

    @Operation(
            summary = "@Return List<BarraNavegacion>",
            description = "CRUD READ-ALL. Retorna List<BarraNavegacion>."
    )
    @GetMapping("/${BARRA_NAVEGACION_URI_READ_ALL}")
    public GlobalResponse readAll(WebRequest request) throws BarraNavegacionException {
        List<BarraNavegacion> barrasNavegacion = barraNavegacionService.getAllBarraNavegacion();
        return globalResponseService.responseOk(barrasNavegacion, request, barrasNavegacion.size());
    }


    @Operation(
            summary = "@RequestBody BarraNavegacion, @Return String: " + BARRA_NAVEGACION_MSG_OK_UPDATE,
            description = "CRUD UPDATE BarraNavegacion. Recibe modelo BarraNavegacion con id para la actualizar."
    )
    @PutMapping("/${BARRA_NAVEGACION_URI_UPDATE}")
    public GlobalResponse update(@RequestBody BarraNavegacion barraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.updateBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk(BARRA_NAVEGACION_MSG_OK_UPDATE, request);
    }

    @Operation(
            summary = "@RequestParam Map<String, Object> params, @Return String: \"" + CODE_200_UPDATE_BY_PARAMS + "\"",
            description = "CRUD UPDATE BarraNavegacion by query params. ej: ?url_logo=http://example.com"
    )
    @PatchMapping("/${BARRA_NAVEGACION_URI_UPDATE_BY_PARAMS}")
    public GlobalResponse updateByParams(@RequestParam Map<String, Object> params, WebRequest request) throws BarraNavegacionException {
        BarraNavegacion barraNavegacion = barraNavegacionService.updateBarraNAvegacionByParams(params);
        barraNavegacionService.updateBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk(CODE_200_UPDATE_BY_PARAMS, request);
    }

    @Operation(
            summary = "@PathVariable idBarraNavegacion, @Return String: \"" + CODE_200_DELETE + "\"",
            description = "CRUD DELETE BarraNavegacion."
    )
    @DeleteMapping("/${BARRA_NAVEGACION_URI_DELETE}/id-barra-navegacion/{idBarraNavegacion}")
    public GlobalResponse delete(@PathVariable Integer idBarraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.deleteBarraNavegacion(idBarraNavegacion);
        return globalResponseService.responseOk(CODE_200_DELETE, request);
    }


}
