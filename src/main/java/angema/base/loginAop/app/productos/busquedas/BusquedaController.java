package angema.base.loginAop.app.productos.busquedas;


import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.productos.busquedas.BusquedaMsg.*;
import static angema.base.loginAop.core.utils.ErrorUtils.getErrorMessage;

@RestController
@RequestMapping("${BUSQUEDA_PATH}")
public class BusquedaController {
    @Autowired
    private BusquedaService busquedaService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @Operation(
            summary = BUSCAR_PARAMETROS_SUMMARY,
            description = BUSCAR_PARAMETROS_DESCRIPTION
    )
    @GetMapping("/${BUSQUEDA_URI_FIND_LIST_ID}")
    public GlobalResponse findIdsProductosByParams(@RequestParam String params, WebRequest request) {
        List<String> parametros = Arrays.asList(params.trim().split(","));
        parametros = busquedaService.findParams(parametros);
        return globalResponseService.responseOk(parametros, request);
    }

    @Operation(
            summary = BUSQUEDA_CREATE_SUMMARY,
            description = BUSQUEDA_CREATE_DESCRIPTION
    )
    @PostMapping("/${BUSQUEDA_URI_CREATE}")
    public GlobalResponse create(@RequestBody List<Busqueda> busquedas, WebRequest request) throws BarraNavegacionException {
        busquedaService.addBusquedas(busquedas);
        return globalResponseService.responseOk(BUSQUEDA_CREATE_CODE_200, request);
    }

    @Operation(
            summary = BUSQUEDA_READ_SUMMARY,
            description = BUSQUEDA_READ_DESCRIPTION
    )
    @GetMapping("/${BUSQUEDA_URI_READ}/cuit-socio/{cuitSocio}/id-producto/{idProducto}")
    public GlobalResponse read(@PathVariable String cuitSocio, @PathVariable String idProducto, WebRequest request) {
        try {
            List<Busqueda> busquedas = busquedaService.getBusquedas(cuitSocio, idProducto);
            return globalResponseService.responseOk(busquedas, request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_READ, cuitSocio, idProducto, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    @Operation(
            summary = BUSQUEDA_UPDATE_SUMMARY,
            description = BUSQUEDA_UPDATE_DESCRIPTION
    )
    @PutMapping("/${BUSQUEDA_URI_UPDATE}")
    public GlobalResponse update(@RequestBody List<Busqueda> busquedas, WebRequest request) {
        try {
            busquedaService.updateBusquedas(busquedas);
            return globalResponseService.responseOk(BUSQUEDA_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_UPDATE, e.getMessage());
            throw new BarraNavegacionException(errMsg);
        }
    }

    @Operation(
            summary = BUSQUEDA_UPDATE_BY_PARAMS_SUMMARY,
            description = BUSQUEDA_UPDATE_BY_PARAMS_DESCRIPTION
    )
    @PatchMapping("/${BUSQUEDA_URI_UPDATE_BY_PARAMS}")
    public GlobalResponse updateByParams(@RequestParam Map<String, Object> params, WebRequest request) {
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

    @Operation(
            summary = BUSQUEDA_DELETE_SUMMARY,
            description = BUSQUEDA_DELETE_DESCRIPTION
    )
    @DeleteMapping("/${BUSQUEDA_URI_DELETE}/{idBusqueda}")
    public GlobalResponse delete(@PathVariable Integer idBusqueda, WebRequest request) {
        try {
            busquedaService.deleteBusqueda(idBusqueda);
            return globalResponseService.responseOk(BUSQUEDA_MSG_OK_DELETE, request);
        } catch (BusquedaException e) {
            String errMsg = getErrorMessage(BUSQUEDA_MSG_ERROR_DELETE, e.getMessage());
            throw new BusquedaException(errMsg);
        }
    }

}
