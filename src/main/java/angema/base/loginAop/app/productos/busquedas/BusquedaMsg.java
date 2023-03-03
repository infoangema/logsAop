package angema.base.loginAop.app.productos.busquedas;

public class BusquedaMsg {

    // buscarParametros ################################################################################################
    public static final String BUSCAR_PARAMETROS_SUMMARY = "@RequestParam String params, @Return List<String> ids";
    public static final String BUSCAR_PARAMETROS_DESCRIPTION = "Endpoint público para solicitar los ids de productos según los parámetros recibidos. Se utiliza para la barra de búsqueda de la Landing.";


    // CREATE ##########################################################################################################
    public static final String BUSQUEDA_CREATE_SUMMARY= "@RequestBody List<Busqueda>, @Return String:  - Busqueda nueva agregada correctamente. -";
    public static final String BUSQUEDA_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo accede administrador, para crear nuevos parametros de busquedas para los productos.";


    // READ ############################################################################################################
    public static final String BUSQUEDA_READ_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return List<Busqueda>";
    public static final String BUSQUEDA_READ_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utilza para obtener la lista de de parametros cargados por productos, segun el cuit del socio y el id del producto.";


    // UPDATE ##########################################################################################################
    public static final String BUSQUEDA_UPDATE_SUMMARY = "@RequestBody List<Busqueda> busquedas, @Return String: - Error al intentar modificar las busquedas: %s -";
    public static final String BUSQUEDA_UPDATE_DESCRIPTION = "CRUD-UPDATE del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar los datos completos de un registro del modelo.";


    // UPDATE BY PARAMS ################################################################################################
    public static final String BUSQUEDA_UPDATE_BY_PARAMS_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - Busquedas modificadas correctamente. -";
    public static final String BUSQUEDA_UPDATE_BY_PARAMS_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar los datos completos de un registro del modelo.";


    // DELETE ##########################################################################################################
    public static final String BUSQUEDA_DELETE_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - Busquedas modificadas correctamente. -";
    public static final String BUSQUEDA_DELETE_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar los datos completos de un registro del modelo.";





    public static final String BUSQUEDA_CREATE_CODE_200 = "Busqueda nueva agregada correctamente.";
    public static final String BUSQUEDA_MSG_ERROR_CREATE = "Error al intentar guardar las busquedas.";

    public static final String BUSQUEDA_MSG_ERROR_READ = "Error al intentar guardar las busquedas para el cuit -> %s, idProducto -> %s: %s";

    public static final String BUSQUEDA_MSG_OK_UPDATE = "Busquedas modificadas correctamente.";
    public static final String BUSQUEDA_MSG_ERROR_UPDATE = "Error al intentar modificar las busquedas: %s";
    public static final String BUSQUEDA_MSG_ERROR_UPDATE_PARAMS = "Uno o mas parametros de los enviados no son validos.";

    public static final String BUSQUEDA_MSG_OK_DELETE = "Busqueda eliminada correctamente.";
    public static final String BUSQUEDA_MSG_ERROR_DELETE = "Error al intentar eliminar la busqueda: %s";
}
