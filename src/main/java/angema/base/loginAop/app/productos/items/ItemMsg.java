package angema.base.loginAop.app.productos.items;

public class ItemMsg {
    // CREATE ##########################################################################################################
    public static final String ITEM_CREATE_SUMMARY= "@RequestBody List<Item>, @Return String:  - Items agregados correctamente. -";
    public static final String ITEM_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo accede administrador, para crear los items  de los productos.";


    // READ ############################################################################################################
    public static final String ITEM_READ_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return  List<Item>";
    public static final String ITEM_READ_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la lista de  items de un producto, según el cuit del socio y el id del producto.";


    // UPDATE ##########################################################################################################
    public static final String ITEM_UPDATE_SUMMARY = "@RequestBody List<item>, @Return String: - items modificados correctamente -";
    public static final String ITEM_UPDATE_DESCRIPTION = "CRUD-UPDATE del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar las items de un producto en cuestion .";


    // UPDATE BY PARAMS ################################################################################################
    public static final String ITEM_UPDATE_BY_PARAMS_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - item modificado correctamente. -";
    public static final String ITEM_UPDATE_BY_PARAMS_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar algun dato en cuestion de un registro del modelo del item.";


    // DELETE ##########################################################################################################
    public static final String ITEM_DELETE_SUMMARY = "@PathVariable Integer idItem, @Return String: - item eliminado correctamente. -";
    public static final String ITEM_DELETE_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utiliza para eliminar un item de un producto  especifica según su id .";





    public static final String ITEM_CREATE_CODE_200 = "Items agregados correctamente.";
    public static final String ITEM_MSG_ERROR_CREATE = "Error al intentar guardar las Items.";

    public static final String ITEM_MSG_ERROR_READ = "Error al intentar obtener las Items para el cuit -> %s, idProducto -> %s: %s";

    public static final String ITEM_MSG_OK_UPDATE = "Items modificados correctamente.";
    public static final String ITEM_MSG_ERROR_UPDATE = "Error al intentar modificar los Items: %s";
    public static final String ITEM_MSG_ERROR_UPDATE_PARAMS = "Uno o mas parametros de los enviados no son validos.";

    public static final String ITEM_MSG_OK_DELETE = "Item eliminado correctamente.";
    public static final String ITEM_MSG_ERROR_DELETE = "Error al intentar eliminar los Items: %s";
}

