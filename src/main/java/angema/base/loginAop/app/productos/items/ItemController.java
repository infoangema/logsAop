package angema.base.loginAop.app.productos.items;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.productos.detalles.DetalleMsg.DETALLE_READ_DESCRIPTION;
import static angema.base.loginAop.app.productos.detalles.DetalleMsg.DETALLE_READ_SUMMARY;
import static angema.base.loginAop.app.productos.items.ItemMsg.*;

@RestController
@RequestMapping("/${ITEMS_PATH}")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private GlobalResponseService globalResponseService;
    @Operation(
            summary = ITEM_READ_SUMMARY,
            description = ITEM_READ_DESCRIPTION
    )
    @GetMapping("/${ITEMS_URI_FIND_BY_CUIT_AND_IDPROD}/cuit-socio/{cuitSocio}/id-producto/{productoId}")
    public GlobalResponse getItemsByCuitSocioAndIdProducto(@PathVariable String cuitSocio, @PathVariable String productoId, WebRequest request) {
        try {
            List<Item> items = itemService.getItemsByCuitSocioAndIdProducto(cuitSocio, productoId);
            return globalResponseService.responseOk(items, request);
        } catch (Exception e) {
            throw new ItemException(ITEM_MSG_ERROR_READ + productoId + ": " + e.getMessage());
        }
    }
    @Operation(
            summary = ITEM_CREATE_SUMMARY,
            description = ITEM_CREATE_DESCRIPTION
    )
    @PostMapping("/${ITEMS_URI_CREATE}")
    public GlobalResponse addItems(@RequestBody List<Item> items, WebRequest request) {
        try {
            itemService.addItems(items);
            return globalResponseService.responseOk(ITEM_CREATE_CODE_200, request);
        } catch (Exception e) {
            throw new ItemException(ITEM_MSG_ERROR_CREATE + e.getMessage());
        }
    }
    @Operation(
            summary = ITEM_UPDATE_SUMMARY,
            description = ITEM_UPDATE_DESCRIPTION
    )
    @PutMapping("/${ITEMS_URI_UPDATE}")
    public GlobalResponse updateItems(@RequestBody List<Item> items, WebRequest request) {
        try {
            itemService.updateItems(items);
            return globalResponseService.responseOk(ITEM_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            throw new ItemException(ITEM_MSG_ERROR_UPDATE + e.getMessage());
        }
    }
    @Operation(
            summary = ITEM_UPDATE_BY_PARAMS_SUMMARY,
            description = ITEM_UPDATE_BY_PARAMS_DESCRIPTION
    )
    @PatchMapping("/${ITEMS_URI_UPDATE_BY_PARAMS}")
    public GlobalResponse updateItemByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Item item = itemService.getItemFromUpdateParams(params);
            if (item == null) {
                throw new ItemException(ITEM_MSG_ERROR_UPDATE_PARAMS);
            }
            List<Item> items = new ArrayList<>();
            items.add(item);
            itemService.updateItems(items);
            return globalResponseService.responseOk(ITEM_MSG_OK_UPDATE, request);
        } catch (Exception e) {
            throw new ItemException(ITEM_MSG_ERROR_UPDATE + e.getMessage());
        }
    }
    @Operation(
            summary = ITEM_DELETE_SUMMARY,
            description = ITEM_DELETE_DESCRIPTION
    )
    @DeleteMapping("/${ITEMS_URI_DELETE}/id-item/{idItem}")
    public GlobalResponse deleteItem(@PathVariable Integer idItem, WebRequest request) {
        try {
            itemService.deleteItem(idItem);
            return globalResponseService.responseOk(ITEM_MSG_OK_DELETE, request);
        } catch (Exception e) {
            throw new ItemException(ITEM_MSG_ERROR_DELETE + e.getMessage());
        }
    }

}
