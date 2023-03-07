package angema.base.loginAop.app.productos.producto;

public class ProductoMsg {
    // CREATE ##########################################################################################################
    public static final String PRODUCTO_CREATE_SUMMARY= "@RequestBody List<Producto>, @Return String:  - Producto agregado correctamente. -";
    public static final String PRODUCTO_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo accede administrador, para crear un nuevo producto.";

    // GET ALL PRODUCTOS ############################################################################################################
    public static final String PRODUCTO_GET_ALL_SUMMARY = "@PathVariable String cuitSocio, @Return  List<Producto>";
    public static final String PRODUCTO_GET_ALL_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener todos los productos y asistencias, según el cuit del socio.";

    // GET PRODUCTO ############################################################################################################
    public static final String PRODUCTO_GET_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String productoId, @Return  List<Producto>";
    public static final String PRODUCTO_GET_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener un producto, según el cuit del socio y el id del producto.";

    // READ PRODUCTOS ############################################################################################################
    public static final String PRODUCTO_READ_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String productoId, @Return  List<Producto>";
    public static final String PRODUCTO_READ_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la lista de productos, según el cuit del socio ";


    // UPDATE ##########################################################################################################
    public static final String PRODUCTO_UPDATE_SUMMARY = "@RequestBody List<Producto>, @Return String: - producto modificado correctamente -";
    public static final String PRODUCTO_UPDATE_DESCRIPTION = "CRUD-UPDATE del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar un producto  .";


    // UPDATE BY PARAMS ################################################################################################
    public static final String PRODUCTO_UPDATE_BY_PARAMS_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - item modificado correctamente. -";
    public static final String PRODUCTO_UPDATE_BY_PARAMS_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar algun dato en cuestion de un registro del modelo del producto.";


    // DELETE ##########################################################################################################
    public static final String PRODUCTO_DELETE_SUMMARY = "@PathVariable Integer idProducto, @Return String: - producto eliminado correctamente. -";
    public static final String PRODUCTO_DELETE_DESCRIPTION = "CRUD-DELETE del Backoffice. Solo acceden perfiles administrativos, se utiliza para eliminar un item de un producto  especifica según su id .";


    // GET IMAGEN ##########################################################################################################
    public static final String PRODUCTO_GET_IMAGEN_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String productoId, @PathVariable String numeroImagen, @Return Byte[] -";
    public static final String PRODUCTO_GET_IMAGEN_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la imagen del producto según su id producto.";


    // GET DEFAULT IMAGEN ##########################################################################################################
    public static final String PRODUCTO_GET_DEFAULT_IMAGEN_SUMMARY = "@PathVariable String cuitSocio, @Return Byte[].";
    public static final String PRODUCTO_GET_DEFAULT_IMAGEN_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para Obtener una imagen por dafault para un producto según el cuit de socio .";



    public static final String PRODUCTO_CREATE_CODE_200 = "Producto agregado correctamente.";
    public static final String PRODUCTO_MSG_ERROR_CREATE = "Error al intentar guardar los productos.";

    public static final String PRODUCTO_MSG_ERROR_READ = "Error al intentar obtener los productos para el cuit -> %s, idProducto -> %s: %s";

    public static final String PRODUCTO_MSG_OK_UPDATE = "Producto modificado correctamente.";
    public static final String PRODUCTO_MSG_ERROR_UPDATE = "Error al intentar modificar las coberturas: %s";
    public static final String PRODUCTO_MSG_ERROR_UPDATE_PARAMS = "Uno o mas parametros de los enviados no son validos.";

    public static final String PRODUCTO_MSG_OK_DELETE = "Producto eliminado correctamente.";
    public static final String PRODUCTO_MSG_ERROR_DELETE = "Error al intentar eliminar los productos: %s";
}


