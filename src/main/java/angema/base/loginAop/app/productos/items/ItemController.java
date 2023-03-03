package angema.base.loginAop.app.productos.items;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private GlobalResponseService globalResponseService;

    @GetMapping("/obtener-items/cuit-socio/{cuitSocio}/id-producto/{productoId}")
    public GlobalResponse getItemsByCuitSocioAndIdProducto(@PathVariable String cuitSocio, @PathVariable String productoId, WebRequest request) {
        try {
            List<Item> items = itemService.getItemsByCuitSocioAndIdProducto(cuitSocio, productoId);
            return globalResponseService.responseOk(items, request);
        } catch (Exception e) {
            throw new ItemException("Error al intentar obtner items del producto -> " + productoId + ": " + e.getMessage());
        }
    }

    @PostMapping("/guardar-items")
    public GlobalResponse addItems(@RequestBody List<Item> items, WebRequest request) {
        try {
            itemService.addItems(items);
            return globalResponseService.responseOk("Items agregados correctamente", request);
        } catch (Exception e) {
            throw new ItemException("Error al intentar guardar los items: " + e.getMessage());
        }
    }

    @PutMapping("/modificar-items")
    public GlobalResponse updateItems(@RequestBody List<Item> items, WebRequest request) {
        try {
            itemService.updateItems(items);
            return globalResponseService.responseOk("Items modificados correctamente", request);
        } catch (Exception e) {
            throw new ItemException("Error al intentar modificar los items: " + e.getMessage());
        }
    }

    @PatchMapping("/modificar-item")
    public GlobalResponse updateItemByParams(@RequestParam Map<String, Object> params, WebRequest request) {
        try {
            Item item = itemService.getItemFromUpdateParams(params);
            if (item == null) {
                throw new ItemException("Uno o mas parametros de los enviados no son validos.");
            }
            List<Item> items = new ArrayList<>();
            items.add(item);
            itemService.updateItems(items);
            return globalResponseService.responseOk("Item modificada correctamente", request);
        } catch (Exception e) {
            throw new ItemException("Error al intentar modificar las coberturas: " + e.getMessage());
        }
    }
    @DeleteMapping("/eliminar-item/id-item/{idItem}")
    public GlobalResponse deleteItem(@PathVariable Integer idItem, WebRequest request) {
        try {
            itemService.deleteItem(idItem);
            return globalResponseService.responseOk("Item eliminada correctamente", request);
        } catch (Exception e) {
            throw new ItemException("Error al intentar eliminar las cobertura: " + e.getMessage());
        }
    }

}
