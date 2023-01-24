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
    public GlobalResponse<?> createBarraNavegacion(@RequestBody BarraNavegacion barraNavegacion, WebRequest request) {
        try {
            barraNavegacionService.addBarraNavegacions(barraNavegacion);
            return globalResponseService.responseOk(BARRA_NAVEGACION_MSG_OK_CREATE, request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_CREATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    @GetMapping("/obtener-barra-navegacion/cuit-socio/{cuitSocio}/barra-navegacion")
    public GlobalResponse<?> readBarraNavegacion(@PathVariable String cuitSocio, WebRequest request) {
        try {
            BarraNavegacion barraNavegacion = barraNavegacionService.getBarraNavegacion(cuitSocio);
            return globalResponseService.responseOk(barraNavegacion, request);
        } catch (BarraNavegacionException e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_CREATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }


    @PutMapping("/modificar-barra-navegacion")
    public GlobalResponse<?> updateBarraNavegacions(@RequestBody BarraNavegacion barraNavegacion, WebRequest request) {
        try {
            barraNavegacionService.updateBarraNavegacions(barraNavegacion);
            return globalResponseService.responseOk(BARRA_NAVEGACION_MSG_OK_UPDATE, request);
        } catch (BarraNavegacionException e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_UPDATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    @PatchMapping("/modificar-barra-navegacion")
    public GlobalResponse<?> updateBarraNavegacionByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            BarraNavegacion barraNavegacion = barraNavegacionService.updateBarraNAvegacionByParams(params);
            if (barraNavegacion == null) {
                throw new BarraNavegacionException("Uno o mas parametros de los enviados no son validos.");
            }
            barraNavegacionService.updateBarraNavegacions(barraNavegacion);
            return globalResponseService.responseOk("BarraNavegacion modificada correctamente", request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_UPDATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }
    @DeleteMapping("/eliminar-barra-navegacion/id-barra-navegacion/{idBarraNavegacion}")
    public GlobalResponse<?> deleteBarraNavegacion(@PathVariable Integer idBarraNavegacion, WebRequest request) {
        try {
            barraNavegacionService.deleteBarraNavegacion(idBarraNavegacion);
            return globalResponseService.responseOk("BarraNavegacion eliminada correctamente", request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BARRA_NAVEGACION_MSG_ERROR_DELETE, idBarraNavegacion.toString(), e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }



}
