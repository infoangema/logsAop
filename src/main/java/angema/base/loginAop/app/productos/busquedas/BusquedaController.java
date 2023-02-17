package angema.base.loginAop.app.productos.busquedas;


import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.productos.busquedas.BusquedaErrorMsj.*;
import static angema.base.loginAop.core.utils.ErrorUtils.getErrorMessage;

@RestController
@RequestMapping("/productos/busquedas")
public class BusquedaController {
    @Autowired
    private BusquedaService busquedaService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @GetMapping("/buscar-parametros")
    public List<String> buscarParametros(@RequestParam String params) {
        List<String> parametros = Arrays.asList(params.trim().split(","));
        return busquedaService.findParams(parametros);
    }

    @PostMapping("/guardar-busquedas-producto")
    public GlobalResponse<?> createBusquedas(@RequestBody List<Busqueda> busquedas, WebRequest request) {
        busquedaService.addBusquedas(busquedas);
        return globalResponseService.responseOk(BUSQUEDA_MSG_OK_CREATE, request);
    }

    @GetMapping("/obtener-busquedas-producto/cuit-socio/{cuitSocio}/id-producto/{idProducto}")
    public GlobalResponse<?> readBusquedas(@PathVariable String cuitSocio, @PathVariable String idProducto, WebRequest request) {
        try {
            List<Busqueda> busquedas = busquedaService.getBusquedas(cuitSocio, idProducto);
            return globalResponseService.responseOk(busquedas, request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_READ, cuitSocio, idProducto, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }


    @PutMapping("/modificar-busquedas")
    public GlobalResponse<?> updateBusquedas(@RequestBody List<Busqueda> busquedas, WebRequest request) {
        try {
            busquedaService.updateBusquedas(busquedas);
            return globalResponseService.responseOk(BUSQUEDA_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_UPDATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    @PatchMapping("/modificar-busqueda")
    public GlobalResponse<?> updateCoberturaByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Busqueda busqueda = busquedaService.getBusquedaFromUpdateParams(params);
            if (busqueda == null) {
                throw new BusquedaException(BUSQUEDA_MSG_ERROR_UPDATE_PARAMS);
            }
            List<Busqueda> busquedas = new ArrayList<>();
            busquedas.add(busqueda);
            busquedaService.updateBusquedas(busquedas);
            return globalResponseService.responseOk(BUSQUEDA_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_UPDATE, e.getMessage());
            throw new BusquedaException(errMsg);
        }
    }

    @DeleteMapping("/eliminar-busqueda/id-busqueda/{idBusqueda}")
    public GlobalResponse<?> deleteBusqueda(@PathVariable Integer idBusqueda, WebRequest request) {
        try {
            busquedaService.deleteBusqueda(idBusqueda);
            return globalResponseService.responseOk(BUSQUEDA_MSG_OK_DELETE, request);
        } catch (BusquedaException e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_DELETE, e.getMessage());
            throw new BusquedaException(errMsg);
        }
    }

}
