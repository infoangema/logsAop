package angema.base.loginAop.app.productos;
import angema.base.loginAop.core.utils.FileSystemUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value="/obtener-productos-por-cuit/{cuitSocio}")
    @ResponseBody
    public String getAllProductsByCuit(@PathVariable String cuitSocio) {
        try {
            return fileSystemUtil.getFile("/static/"+cuitSocio+"/productos/productos.json");
        } catch (Exception e) {
            throw new ProductoException(e.getMessage());
        }
    }

    @GetMapping("/obtener-detalle-producto-por-id/{productoId}/{cuitSocio}")
    public ProductoEntity obtenerDetalleProductoPorId(@PathVariable String cuitSocio, @PathVariable String productoId) {
        try{
            return productoService.obtenerDetalleProductoPorCuit(cuitSocio,productoId);
        }catch(Exception e){
            throw new ProductoException("Error al intentar obtner detalles del producto -> " + productoId + ": " + e.getMessage());
        }
    }

    @GetMapping(value="/obtener-imagen-producto-por-id/{productoId}/{cuitSocio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getImageByProductId(@PathVariable String cuitSocio,@PathVariable String productoId) throws IOException {
        try {
            InputStream in = ProductoController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/img_"+productoId+".jfif");
            assert in != null;
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new ProtocolException(e.getMessage());
        }
    }

    @GetMapping(value="/getImagedefaultBycuitSocio/{cuitSocio}",produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public  byte[] getImagedefaultBycuitSocio(@PathVariable String cuitSocio) throws IOException {
        try {
            InputStream in = ProductoController.class.getResourceAsStream("/static/"+cuitSocio+"/productos/"+"default.jpg");
            assert in != null;
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new ProductoException(e.getMessage());
        }
    }
}
