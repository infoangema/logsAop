package angema.base.loginAop.app.productos.producto;

import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import angema.base.loginAop.core.utils.FileSystemUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static angema.base.loginAop.app.productos.items.ItemMsg.ITEM_READ_DESCRIPTION;
import static angema.base.loginAop.app.productos.items.ItemMsg.ITEM_READ_SUMMARY;
import static angema.base.loginAop.app.productos.producto.ProductoMsg.*;

@RestController
@RequestMapping("/productos/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private FileSystemUtil fileSystemUtil;

    @Autowired
    private GlobalResponseService globalResponseService;
    @Operation(
            summary = PRODUCTO_GET_ALL_SUMMARY,
            description = PRODUCTO_GET_ALL_DESCRIPTION
    )
    @GetMapping(value = "/obtener-productos-por-cuit/{cuitSocio}/productos")
    @ResponseBody
    public String getAllProductsByCuit(@PathVariable String cuitSocio, WebRequest request) {
        String res = fileSystemUtil.getFile("/static/" + cuitSocio + "/productos/productos.json");
        return res;
    }

    /**
     * @param cuitSocio
     * @param productoId
     * @param request
     * @return GlobalResponse<Producto>
     * @Detail Obtiene datos del producto para poder completar cards en front.
     */
    @Operation(
            summary = PRODUCTO_GET_SUMMARY,
            description = PRODUCTO_GET_DESCRIPTION
    )
    @GetMapping("/obtener-producto/id/{productoId}/cuit-socio/{cuitSocio}/producto-{id}")
    public GlobalResponse getProductoByIdAndCuitSocio(@PathVariable String cuitSocio, @PathVariable String productoId, WebRequest request) throws ProductoException {
        Producto prd = productoService.buscarProductoPorId_y_CuitSocio(cuitSocio, productoId);
        return globalResponseService.responseOk(prd, request);
    }
    @Operation(
            summary = PRODUCTO_CREATE_SUMMARY,
            description = PRODUCTO_CREATE_DESCRIPTION
    )
    @PostMapping("/guardar-productos")
    public GlobalResponse createProducto(@Valid @RequestBody List<Producto> productoList, WebRequest request) throws ProductoException {
        productoService.addProducto(productoList);
        return  globalResponseService.responseOk(PRODUCTO_CREATE_CODE_200, request);
    }

    // todo: Pasar imagenes de producto a bdd.
    @Operation(
            summary = PRODUCTO_READ_SUMMARY,
            description = PRODUCTO_READ_DESCRIPTION
    )
    @GetMapping("/obtener-productos/cuit-socio/{cuitSocio}/productos")
    public GlobalResponse readProducto(@PathVariable String cuitSocio, WebRequest request) throws ProductoException {
        List<Producto> producto = productoService.getProducto(cuitSocio);
        if (producto == null || producto.size() == 0) {
            return  globalResponseService.responseWithHttpStatus(producto, HttpStatus.NO_CONTENT, request);
        }
        return  globalResponseService.responseOk(producto, request);
    }
    @Operation(
            summary = PRODUCTO_UPDATE_SUMMARY,
            description = PRODUCTO_UPDATE_DESCRIPTION
    )
    @PutMapping("/modificar-productos")
    public GlobalResponse updateCoberturas(@RequestBody List<Producto> productoList, WebRequest request) throws ProductoException {
        productoService.updateProducto(productoList);
        return globalResponseService.responseOk(PRODUCTO_MSG_OK_UPDATE, request);
    }

    // todo prueba
    @Operation(
            summary = PRODUCTO_UPDATE_BY_PARAMS_SUMMARY,
            description = PRODUCTO_UPDATE_BY_PARAMS_DESCRIPTION
    )
    @PatchMapping("/modificar-producto")
    public GlobalResponse updateProductoByParams(@RequestParam Map<String, Object> params, WebRequest request) throws ProductoException {
        Producto producto = productoService.getProductoFromUpdateParams(params);
        if (producto == null) {
            throw new ProductoException(PRODUCTO_MSG_ERROR_UPDATE_PARAMS);
        }
        List<Producto> productoList = new ArrayList<>();
        productoList.add(producto);
        productoService.updateProducto(productoList);
        return globalResponseService.responseOk(PRODUCTO_MSG_OK_UPDATE, request);
    }
    @Operation(
            summary = PRODUCTO_DELETE_SUMMARY,
            description = PRODUCTO_DELETE_DESCRIPTION
    )
    @DeleteMapping("/eliminar-producto/id-producto/{idProducto}")
    public GlobalResponse deleteProducto(@PathVariable Integer idProducto, WebRequest request) throws ProductoException {
        productoService.deleteProducto(idProducto);
        return globalResponseService.responseOk(PRODUCTO_MSG_OK_DELETE, request);
    }
    @Operation(
            summary = PRODUCTO_GET_IMAGEN_SUMMARY,
            description = PRODUCTO_GET_IMAGEN_DESCRIPTION
    )
    @GetMapping(value = "/obtener-imagen/id-producto/{productoId}/cuit/{cuitSocio}/numero-imagen/{numeroImagen}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] obtenerImagenPorIdProducto(@PathVariable String cuitSocio, @PathVariable String productoId, @PathVariable String numeroImagen, @RequestParam(defaultValue = "jpg", required = false) String tipo) throws IOException {
        try {
            InputStream in = ProductoController.class.getResourceAsStream("/static/" + cuitSocio + "/images/productos/" + productoId + "/img_" + numeroImagen + "." + tipo);
            if (in == null) {
                in = ProductoController.class.getResourceAsStream("/static/imagen_no_disponible.jpg");
            }
            assert in != null;
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new ProtocolException(e.getMessage());
        }
    }
    @Operation(
            summary = PRODUCTO_GET_DEFAULT_IMAGEN_SUMMARY,
            description = PRODUCTO_GET_DEFAULT_IMAGEN_DESCRIPTION
    )
    @GetMapping(value = "/getImagedefaultBycuitSocio/{cuitSocio}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] obtenerImagenDefaultPorCuitSocio(@PathVariable String cuitSocio) throws IOException {
        try {
            InputStream in = ProductoController.class.getResourceAsStream("/static/" + cuitSocio + "/productos/" + "default.jpg");
            assert in != null;
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new ProductoException(e.getMessage());
        }
    }
}
