package angema.base.loginAop.app.productos.detalles;

import angema.base.loginAop.app.productos.coberturas.CoberturaException;
import angema.base.loginAop.app.productos.producto.ProductoException;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/detalles/detalle")
public class DetalleController {
    @Autowired
    private DetalleService detalleService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @GetMapping("/obtener-detalle/cuit-socio/{cuitSocio}/id-producto/{productoId}")
    public GlobalResponse getDetallesByCuitSocioAndIdProducto(@PathVariable String cuitSocio, @PathVariable String productoId, WebRequest request) {
        try {
            Detalle detalle = detalleService.getDetalleByCuitSocioAndIdProducto(cuitSocio, productoId);
            return globalResponseService.responseOk(detalle, request);
        } catch (Exception e) {
            throw new ProductoException("Error al intentar obtner detalles del producto -> " + productoId + ": " + e.getMessage());
        }
    }

    @PostMapping("/guardar-detalles")
    public GlobalResponse addDetalles(@RequestBody List<Detalle> detalles, WebRequest request) {
        try {
            detalleService.addDetalles(detalles);
            return globalResponseService.responseOk("Detalles agregados correctamente", request);
        } catch (Exception e) {
            throw new CoberturaException("Error al intentar guardar los detalles: " + e.getMessage());
        }
    }

    @PutMapping("/modificar-detalles")
    public GlobalResponse updateDetalles(@RequestBody List<Detalle> detalles, WebRequest request) {
        try {
            detalleService.updateDetalles(detalles);
            return globalResponseService.responseOk("Detalles modificados correctamente", request);
        } catch (Exception e) {
            throw new CoberturaException("Error al intentar modificar los detalles: " + e.getMessage());
        }
    }

    @PatchMapping("/modificar-detalle")
    public GlobalResponse updateCoberturaByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Detalle detalle = detalleService.getDetalleFromUpdateParams(params);
            if (detalle == null) {
                throw new CoberturaException("Uno o mas parametros de los enviados no son validos.");
            }
            List<Detalle> detalles = new ArrayList<>();
            detalles.add(detalle);
            detalleService.updateDetalles(detalles);
            return globalResponseService.responseOk("Cobertura modificada correctamente", request);
        } catch (Exception e) {
            throw new CoberturaException("Error al intentar modificar las coberturas: " + e.getMessage());
        }
    }
    @DeleteMapping("/eliminar-detalle/id-detalle/{idCobertura}")
    public GlobalResponse deleteCobertura(@PathVariable Integer idCobertura, WebRequest request) {
        try {
            detalleService.deleteDetalle(idCobertura);
            return globalResponseService.responseOk("Cobertura eliminada correctamente", request);
        } catch (Exception e) {
            throw new CoberturaException("Error al intentar eliminar las cobertura: " + e.getMessage());
        }
    }

}
