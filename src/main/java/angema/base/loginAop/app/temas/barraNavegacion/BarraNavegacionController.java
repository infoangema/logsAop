package angema.base.loginAop.app.temas.barraNavegacion;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionErrorMsj.*;

@RestController
@RequestMapping("/temas/barra-navegacion")
public class BarraNavegacionController {

    @Autowired
    private BarraNavegacionService barraNavegacionService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @Operation(
            summary = "@RequestBody List<BarraNavegacion>, @Return String: \"" + CODE_200_CREATE + "\"",
            description = "CRUD CREATE. Retorna mensaje ok. Errores conocidos. El atributo cuit_socio no puede estar repetido."
    )
    @PostMapping("/guardar-barra-navegacion")
    public GlobalResponse create(@RequestBody List<BarraNavegacion> barrasNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.addBarraNavegacions(barrasNavegacion);
        return globalResponseService.responseOk(CODE_200_CREATE, request);
    }

    @Operation(
            summary = "@PathVariable: String cuitSocio, @Return model: BarraNavegacion",
            description = "CRUD READ. Retorna BarraNavegacion."
    )
    @GetMapping("/obtener-barra-navegacion/cuit-socio/{cuitSocio}/barra-navegacion")
    public GlobalResponse read(@PathVariable String cuitSocio, WebRequest request) throws BarraNavegacionException {
        BarraNavegacion barraNavegacion = barraNavegacionService.getBarraNavegacion(cuitSocio);
        return globalResponseService.responseOk(barraNavegacion, request);
    }

    @Operation(
            summary = "@Return List<BarraNavegacion>",
            description = "CRUD READ-ALL. Retorna List<BarraNavegacion>."
    )
    @GetMapping("/obtener-barra-navegacion/lista-barra-navegacion")
    public GlobalResponse readAll(WebRequest request) throws BarraNavegacionException {
        List<BarraNavegacion> barrasNavegacion = barraNavegacionService.getAllBarraNavegacion();
        return globalResponseService.responseOk(barrasNavegacion, request, barrasNavegacion.size());
    }


    @Operation(
            summary = "@RequestBody BarraNavegacion, @Return String: " + BARRA_NAVEGACION_MSG_OK_UPDATE,
            description = "CRUD UPDATE BarraNavegacion. Recibe modelo BarraNavegacion con id para la actualizar."
    )
    @PutMapping("/modificar-barra-navegacion")
    public GlobalResponse update(@RequestBody BarraNavegacion barraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.updateBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk(BARRA_NAVEGACION_MSG_OK_UPDATE, request);
    }

    @Operation(
            summary = "@RequestParam Map<String, Object> params, @Return String: \"" + CODE_200_UPDATE_BY_PARAMS + "\"",
            description = "CRUD UPDATE BarraNavegacion by query params. ej: ?url_logo=http://example.com"
    )
    @PatchMapping("/modificar-barra-navegacion")
    public GlobalResponse updateByParams(@RequestParam Map<String, Object> params, WebRequest request) throws BarraNavegacionException {
        BarraNavegacion barraNavegacion = barraNavegacionService.updateBarraNAvegacionByParams(params);
        barraNavegacionService.updateBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk(CODE_200_UPDATE_BY_PARAMS, request);
    }

    @Operation(
            summary = "@PathVariable idBarraNavegacion, @Return String: \"" + CODE_200_DELETE + "\"",
            description = "CRUD DELETE BarraNavegacion."
    )
    @DeleteMapping("/eliminar-barra-navegacion/id-barra-navegacion/{idBarraNavegacion}")
    public GlobalResponse delete(@PathVariable Integer idBarraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.deleteBarraNavegacion(idBarraNavegacion);
        return globalResponseService.responseOk(CODE_200_DELETE, request);
    }


}
