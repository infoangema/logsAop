package angema.base.loginAop.app.temas.barraNavegacion;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionErrorMsj.*;
import static angema.base.loginAop.core.utils.ErrorUtils.*;

@RestController
@RequestMapping("/temas/barra-navegacion")
public class BarraNavegacionController {

    @Autowired
    private BarraNavegacionService barraNavegacionService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @PostMapping("/guardar-barra-navegacion")
    public GlobalResponse<?> createBarraNavegacion(@RequestBody BarraNavegacion barraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.addBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk(BARRA_NAVEGACION_MSG_OK_CREATE, request);
    }

    @GetMapping("/obtener-barra-navegacion/cuit-socio/{cuitSocio}/barra-navegacion")
    public GlobalResponse<?> readBarraNavegacion(@PathVariable String cuitSocio, WebRequest request) throws BarraNavegacionException {
        BarraNavegacion barraNavegacion = barraNavegacionService.getBarraNavegacion(cuitSocio);
        return globalResponseService.responseOk(barraNavegacion, request);
    }


    @PutMapping("/modificar-barra-navegacion")
    public GlobalResponse<?> updateBarraNavegacions(@RequestBody BarraNavegacion barraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.updateBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk(BARRA_NAVEGACION_MSG_OK_UPDATE, request);
    }

    @PatchMapping("/modificar-barra-navegacion")
    public GlobalResponse<?> updateBarraNavegacionByParams(@RequestParam Map<String, Object> params, WebRequest request) throws BarraNavegacionException {
        BarraNavegacion barraNavegacion = barraNavegacionService.updateBarraNAvegacionByParams(params);
        if (barraNavegacion == null) {
            throw new BarraNavegacionException("Uno o mas parametros de los enviados no son validos.");
        }
        barraNavegacionService.updateBarraNavegacions(barraNavegacion);
        return globalResponseService.responseOk("BarraNavegacion modificada correctamente", request);
    }

    @DeleteMapping("/eliminar-barra-navegacion/id-barra-navegacion/{idBarraNavegacion}")
    public GlobalResponse<?> deleteBarraNavegacion(@PathVariable Integer idBarraNavegacion, WebRequest request) throws BarraNavegacionException {
        barraNavegacionService.deleteBarraNavegacion(idBarraNavegacion);
        return globalResponseService.responseOk("BarraNavegacion eliminada correctamente", request);
    }


}
