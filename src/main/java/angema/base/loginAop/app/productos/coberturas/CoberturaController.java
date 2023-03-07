package angema.base.loginAop.app.productos.coberturas;

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
import static angema.base.loginAop.app.productos.detalles.DetalleMsg.DETALLE_READ_DESCRIPTION;
import static angema.base.loginAop.app.productos.detalles.DetalleMsg.DETALLE_READ_SUMMARY;

@RestController
@RequestMapping("/${COBERTURA_PATH}")
public class CoberturaController {
    @Autowired
    private CoberturaService coberturaService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @Autowired
    CoberturaRepository coberturaRepository;
    @Operation(
            summary = COBERTURA_CREATE_SUMMARY,
            description = COBERTURA_CREATE_DESCRIPTION
    )
    @PostMapping("/${COBERTURA_URI_CREATE}")
    public GlobalResponse createCoberturas(@RequestBody List<Cobertura> coberturas, WebRequest request) {
        try {
            coberturaService.addCoberturas(coberturas);
            return globalResponseService.responseOk(COBERTURA_CREATE_CODE_200, request);
        } catch (CoberturaException e) {
            throw new CoberturaException(COBERTURA_MSG_ERROR_CREATE + e.getMessage());
        }
    }


    @Operation(
            summary = COBERTURA_READ_SUMMARY,
            description = COBERTURA_READ_DESCRIPTION
    )
    @GetMapping("/${COBERTURA_URI_READ}/cuit-socio/{cuitSocio}/id-producto/{idProducto}")
    public GlobalResponse readCoberturas(@PathVariable String cuitSocio, @PathVariable String idProducto, WebRequest request) {
        try {
            List<Cobertura> coberturas = coberturaService.getCoberturas(cuitSocio, idProducto);
            return globalResponseService.responseOk(coberturas, request);
        } catch (CoberturaException e) {
            throw new CoberturaException(COBERTURA_MSG_ERROR_READ + idProducto + ": " + e.getMessage());
        }
    }

    @Operation(
            summary = COBERTURA_UPDATE_SUMMARY ,
            description = COBERTURA_UPDATE_DESCRIPTION
    )
    @PutMapping("/${COBERTURA_URI_UPDATE}")
    public GlobalResponse updateCoberturas(@RequestBody List<Cobertura> coberturas, WebRequest request) {
        try {
            coberturaService.updateCoberturas(coberturas);
            return globalResponseService.responseOk(COBERTURA_MSG_OK_UPDATE, request);
        } catch (CoberturaException e) {
            throw new CoberturaException(COBERTURA_MSG_ERROR_UPDATE + e.getMessage());
        }
    }


    @Operation(
            summary = COBERTURA_UPDATE_BY_PARAMS_SUMMARY ,
            description = COBERTURA_UPDATE_BY_PARAMS_DESCRIPTION
    )
// todo prueba
    @PatchMapping("/${COBERTURA_URI_UPDATE_BY_PARAMS}")
    public GlobalResponse updateCoberturaByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Cobertura cobertura = coberturaService.getCoberturaFromUpdateParams(params);
            if (cobertura == null) {
                throw new CoberturaException(COBERTURA_MSG_ERROR_UPDATE_PARAMS);
            }
            List<Cobertura> coberturas = new ArrayList<>();
            coberturas.add(cobertura);
            coberturaService.updateCoberturas(coberturas);
            return globalResponseService.responseOk(COBERTURA_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            throw new CoberturaException(COBERTURA_MSG_ERROR_UPDATE + e.getMessage());
        }
    }


    @Operation(
            summary = COBERTURA_DELETE_SUMMARY ,
            description = COBERTURA_DELETE_DESCRIPTION
    )
    @DeleteMapping("/${COBERTURA_URI_DELETE}/id-cobertura/{idCobertura}")
    public GlobalResponse deleteCobertura(@PathVariable Integer idCobertura, WebRequest request) {
        try {
            coberturaService.deleteCobertura(idCobertura);
            return globalResponseService.responseOk(COBERTURA_MSG_OK_DELETE, request);
        } catch (Exception e) {
            throw new CoberturaException(COBERTURA_MSG_ERROR_DELETE + e.getMessage());
        }
    }

}
