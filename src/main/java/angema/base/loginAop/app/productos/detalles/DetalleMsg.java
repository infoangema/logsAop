package angema.base.loginAop.app.productos.detalles;

public class DetalleMsg {

    // CREATE ##########################################################################################################
    public static final String DETALLE_CREATE_SUMMARY= "@RequestBody List<Detalle>, @Return String:  - Detalles agregados correctamente. -";
    public static final String DETALLE_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo accede administrador, para crear los detalles  para los productos.";


    // READ ############################################################################################################
    public static final String DETALLE_READ_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return  List<Detalle>";
    public static final String DETALLE_READ_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utilza para obtener la lista de  detalles de un producto, según el cuit del socio y el id del producto.";


    // UPDATE ##########################################################################################################
    public static final String DETALLE_UPDATE_SUMMARY = "@RequestBody List<Detalle>, @Return String: - Detalles modificados correctamente -";
    public static final String DETALLE_UPDATE_DESCRIPTION = "CRUD-UPDATE del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar las detalles de un producto en cuestion .";


    // UPDATE BY PARAMS ################################################################################################
    public static final String DETALLE_UPDATE_BY_PARAMS_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - detalle modificado correctamente. -";
    public static final String DETALLE_UPDATE_BY_PARAMS_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar algun dato en cuestion de un registro del modelo del detalle.";


    // DELETE ##########################################################################################################
    public static final String DETALLE_DELETE_SUMMARY = "@PathVariable Integer idCobertura, @Return String: - Cobertura eliminada correctamente. -";
    public static final String DETALLE_DELETE_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utiliza para eliminar un detalle de un producto  especifica según su id .";





    public static final String DETALLE_CREATE_CODE_200 = "Detalles agregados correctamente.";
    public static final String DETALLE_MSG_ERROR_CREATE = "Error al intentar guardar los detalles.";

    public static final String DETALLE_MSG_ERROR_READ = "Error al intentar obtener los detalles para el cuit -> %s, idProducto -> %s: %s";

    public static final String DETALLE_MSG_OK_UPDATE = "Coberturas modificadas correctamente.";
    public static final String DETALLE_MSG_ERROR_UPDATE = "Error al intentar modificar las coberturas: %s";
    public static final String DETALLE_MSG_ERROR_UPDATE_PARAMS = "Uno o mas parametros de los enviados no son validos.";

    public static final String DETALLE_MSG_OK_DELETE = "Cobertura eliminada correctamente.";
    public static final String DETALLE_MSG_ERROR_DELETE = "Error al intentar eliminar las cobertura: %s";
}

