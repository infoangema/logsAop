package angema.base.loginAop.app.productos.coberturas;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos/coberturas")
public class CoberturaController {
    @Autowired
    private CoberturaService coberturaService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @Autowired
    CoberturaRepository coberturaRepository;

    @PostMapping("/guardar-coberturas")
    public GlobalResponse createCoberturas(@RequestBody List<Cobertura> coberturas, WebRequest request) {
        try {
            coberturaService.addCoberturas(coberturas);
            return globalResponseService.responseOk("Coberturas agregadas correctamente", request);
        } catch (CoberturaException e) {
            throw new CoberturaException("Error al intentar guardar las coberturas: " + e.getMessage());
        }
    }

    @GetMapping("/obtener-coberturas/cuit-socio/{cuitSocio}/id-producto/{idProducto}")
    public GlobalResponse readCoberturas(@PathVariable String cuitSocio, @PathVariable String idProducto, WebRequest request) {
        try {
            List<Cobertura> coberturas = coberturaService.getCoberturas(cuitSocio, idProducto);
            return globalResponseService.responseOk(coberturas, request);
        } catch (CoberturaException e) {
            throw new CoberturaException("Error al intentar obtener las coberturas -> " + idProducto + ": " + e.getMessage());
        }
    }


    @PutMapping("/modificar-coberturas")
    public GlobalResponse updateCoberturas(@RequestBody List<Cobertura> coberturas, WebRequest request) {
        try {
            coberturaService.updateCoberturas(coberturas);
            return globalResponseService.responseOk("Coberturas modificadas correctamente", request);
        } catch (CoberturaException e) {
            throw new CoberturaException("Error al intentar modificar las coberturas: " + e.getMessage());
        }
    }
// todo prueba
    @PatchMapping("/modificar-coberturas")
    public GlobalResponse updateCoberturaByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Cobertura cobertura = coberturaService.getCoberturaFromUpdateParams(params);
            if (cobertura == null) {
                throw new CoberturaException("Uno o mas parametros de los enviados no son validos.");
            }
            List<Cobertura> coberturas = new ArrayList<>();
            coberturas.add(cobertura);
            coberturaService.updateCoberturas(coberturas);
            return globalResponseService.responseOk("Cobertura modificada correctamente", request);
        } catch (Exception e) {
            throw new CoberturaException("Error al intentar modificar las coberturas: " + e.getMessage());
        }
    }
    @DeleteMapping("/eliminar-cobertura/id-cobertura/{idCobertura}")
    public GlobalResponse deleteCobertura(@PathVariable Integer idCobertura, WebRequest request) {
        try {
            coberturaService.deleteCobertura(idCobertura);
            return globalResponseService.responseOk("Cobertura eliminada correctamente", request);
        } catch (Exception e) {
            throw new CoberturaException("Error al intentar eliminar las cobertura: " + e.getMessage());
        }
    }

}
