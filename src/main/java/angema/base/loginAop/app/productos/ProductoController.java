package angema.base.loginAop.app.productos;
import angema.base.loginAop.core.globalResponse.GlobalResponse;
import angema.base.loginAop.core.globalResponse.GlobalResponseService;
import angema.base.loginAop.core.utils.FileSystemUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private FileSystemUtil fileSystemUtil;

    @Autowired
    private GlobalResponseService globalResponseService;

    @GetMapping(value="/obtener-productos-por-cuit/{cuitSocio}")
    @ResponseBody
    public GlobalResponse<?> getAllProductsByCuit(@PathVariable String cuitSocio, WebRequest request) {
        try {
            if (cuitSocio == null || cuitSocio.equals("")) {
              throw new ProductoException("El cuit no puede estar vacio");
            }
            String res = fileSystemUtil.getFile("/static/"+cuitSocio+"/productos/productos.json");
            return globalResponseService.responseOk(res, request);
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    @GetMapping("/obtener-detalle-producto/id-producto/{productoId}/cuit-socio/{cuitSocio}")
    public GlobalResponse<?> obtenerDetalleProductoPorId(@PathVariable String cuitSocio, @PathVariable String productoId,  WebRequest request) {
        try{
            Producto prd = productoService.obtenerDetalleProductoPorCuit(cuitSocio,productoId);
            return globalResponseService.responseOk(prd, request );
        }catch(Exception e){
            throw new ProductoException("Error al intentar obtner detalles del producto -> " + productoId + ": " + e.getMessage());
        }
    }

    @GetMapping(value="/obtener-imagen/id-producto/{productoId}/cuit/{cuitSocio}/numero-imagen/{numeroImagen}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] obtenerImagenPorIdProducto(@PathVariable String cuitSocio,@PathVariable String productoId, @PathVariable String numeroImagen) throws IOException {
        try {
            InputStream in = ProductoController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/id_producto_"+productoId+"_img_"+ numeroImagen + ".jpg");
            assert in != null;
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new ProtocolException(e.getMessage());
        }
    }

    @GetMapping(value="/getImagedefaultBycuitSocio/{cuitSocio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] obtenerImagenDefaultPorCuitSocio(@PathVariable String cuitSocio) throws IOException {
        try {
            InputStream in = ProductoController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/"+"default.jpg");
            assert in != null;
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new ProductoException(e.getMessage());
        }
    }
}
