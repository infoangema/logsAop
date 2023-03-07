package angema.base.loginAop.app.productos.coberturas;

public class CoberturaMsg {


    // CREATE ##########################################################################################################
    public static final String COBERTURA_CREATE_SUMMARY= "@RequestBody List<Cobertura>, @Return String:  - Coberturas agregadas correctamente. -";
    public static final String COBERTURA_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo accede administrador, para crear las coberturas para los productos.";


    // READ ############################################################################################################
    public static final String COBERTURA_READ_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return  List<Cobertura>";
    public static final String COBERTURA_READ_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utilza para obtener la lista de  coberturas cargadas por productos, segun el cuit del socio y el id del producto.";


    // UPDATE ##########################################################################################################
    public static final String COBERTURA_UPDATE_SUMMARY = "@RequestBody List<Cobertura> coberturas, @Return String: - Coberturas modificadas correctamente -";
    public static final String COBERTURA_UPDATE_DESCRIPTION = "CRUD-UPDATE del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar las coberturas de un producto en cuestion .";


    // UPDATE BY PARAMS ################################################################################################
    public static final String COBERTURA_UPDATE_BY_PARAMS_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - Cobertura modificada correctamente. -";
    public static final String COBERTURA_UPDATE_BY_PARAMS_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar algun dato en cuestion de un registro del modelo.";


    // DELETE ##########################################################################################################
    public static final String COBERTURA_DELETE_SUMMARY = "@PathVariable Integer idCobertura, @Return String: - Cobertura eliminada correctamente. -";
    public static final String COBERTURA_DELETE_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utilza para eliminar una cobertura especifica según su id .";





    public static final String COBERTURA_CREATE_CODE_200 = "Coberturas agregadas correctamente.";
    public static final String COBERTURA_MSG_ERROR_CREATE = "Error al intentar guardar las coberturas.";

    public static final String COBERTURA_MSG_ERROR_READ = "Error al intentar obtener las coberturas para el cuit -> %s, idProducto -> %s: %s";

    public static final String COBERTURA_MSG_OK_UPDATE = "Coberturas modificadas correctamente.";
    public static final String COBERTURA_MSG_ERROR_UPDATE = "Error al intentar modificar las coberturas: %s";
    public static final String COBERTURA_MSG_ERROR_UPDATE_PARAMS = "Uno o mas parametros de los enviados no son validos.";

    public static final String COBERTURA_MSG_OK_DELETE = "Cobertura eliminada correctamente.";
    public static final String COBERTURA_MSG_ERROR_DELETE = "Error al intentar eliminar las cobertura: %s";
}


