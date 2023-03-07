package angema.base.loginAop.app.productos.detalles;

import angema.base.loginAop.app.productos.coberturas.CoberturaException;
import angema.base.loginAop.app.productos.producto.ProductoException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.productos.coberturas.CoberturaMsg.*;
import static angema.base.loginAop.app.productos.coberturas.CoberturaMsg.COBERTURA_READ_DESCRIPTION;
import static angema.base.loginAop.app.productos.detalles.DetalleMsg.*;

@RestController
@RequestMapping("/${DETALLE_PATH}")
public class DetalleController {
    @Autowired
    private DetalleService detalleService;

    @Autowired
    private GlobalResponseService globalResponseService;
    @Operation(
            summary = DETALLE_READ_SUMMARY,
            description = DETALLE_READ_DESCRIPTION
    )
    @GetMapping("/${DETALLE_URI_FIND_BY_CUIT_AND_IDPROD}/cuit-socio/{cuitSocio}/id-producto/{productoId}")
    public GlobalResponse getDetallesByCuitSocioAndIdProducto(@PathVariable String cuitSocio, @PathVariable String productoId, WebRequest request) {
        try {
            Detalle detalle = detalleService.getDetalleByCuitSocioAndIdProducto(cuitSocio, productoId);
            return globalResponseService.responseOk(detalle, request);
        } catch (Exception e) {
            throw new ProductoException(DETALLE_MSG_ERROR_READ + productoId + ": " + e.getMessage());
        }
    }
    @Operation(
            summary = DETALLE_CREATE_SUMMARY,
            description = DETALLE_CREATE_DESCRIPTION
    )
    @PostMapping("/${DETALLE_URI_CREATE}")
    public GlobalResponse addDetalles(@RequestBody List<Detalle> detalles, WebRequest request) {
        try {
            detalleService.addDetalles(detalles);
            return globalResponseService.responseOk(DETALLE_CREATE_CODE_200, request);
        } catch (Exception e) {
            throw new CoberturaException(DETALLE_MSG_ERROR_CREATE + e.getMessage());
        }
    }
    @Operation(
            summary = DETALLE_UPDATE_SUMMARY,
            description = DETALLE_UPDATE_DESCRIPTION
    )
    @PutMapping("/${DETALLE_URI_UPDATE}")
    public GlobalResponse updateDetalles(@RequestBody List<Detalle> detalles, WebRequest request) {
        try {
            detalleService.updateDetalles(detalles);
            return globalResponseService.responseOk(DETALLE_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            throw new CoberturaException(DETALLE_MSG_ERROR_UPDATE + e.getMessage());
        }
    }
    @Operation(
            summary = DETALLE_UPDATE_BY_PARAMS_SUMMARY,
            description = DETALLE_UPDATE_BY_PARAMS_DESCRIPTION
    )
    @PatchMapping("/${DETALLE_URI_UPDATE_BY_PARAMS}")
    public GlobalResponse updateCoberturaByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Detalle detalle = detalleService.getDetalleFromUpdateParams(params);
            if (detalle == null) {
                throw new CoberturaException(DETALLE_MSG_ERROR_UPDATE_PARAMS);
            }
            List<Detalle> detalles = new ArrayList<>();
            detalles.add(detalle);
            detalleService.updateDetalles(detalles);
            return globalResponseService.responseOk(DETALLE_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            throw new CoberturaException(DETALLE_MSG_ERROR_UPDATE + e.getMessage());
        }
    }


    @Operation(
            summary = DETALLE_DELETE_SUMMARY,
            description = DETALLE_DELETE_DESCRIPTION
    )
    @DeleteMapping("/${DETALLE_URI_DELETE}/id-detalle/{idCobertura}")
    public GlobalResponse deleteCobertura(@PathVariable Integer idCobertura, WebRequest request) {
        try {
            detalleService.deleteDetalle(idCobertura);
            return globalResponseService.responseOk(DETALLE_MSG_OK_DELETE, request);
        } catch (Exception e) {
            throw new CoberturaException(DETALLE_MSG_ERROR_DELETE + e.getMessage());
        }
    }

}
