package angema.base.loginAop.app.temas.carrusel;

public class CarruselMsg {
    // findImageByCuit #################################################################################################
    public static final String CARRUSEL_FIND_IMG_BY_CUIT_SUMMARY= "@PathVariable String cuitSocio, @PathVariable String numero, @RequestParam(required = false) String size, @Return byte[]:";
    public static final String CARRUSEL_FIND_IMG_BY_CUIT_DESCRIPTION = "Endpoint público para solicitar imagen de carrusel segun el cuit del socio, el numero de imagen, y el tamaño de la pantalla.";


    // CREATE ##########################################################################################################
    public static final String CARRUSEL_CREATE_SUMMARY= "@RequestBody List<Carrusel>, @Return String: - Carrusel agregado correctamente -";
    public static final String CARRUSEL_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo accede administrador. Se utiliza para cargar la informacion del modelo.";


    // READ ############################################################################################################
    public static final String CARRUSEL_READ_SUMMARY = "@PathVariable String cuitSocio, @Return List<Carrusel>";
    public static final String CARRUSEL_READ_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos. Retorna lista de las configuraciones del carrusel segu el cuit del socio.";


    // UPDATE ##########################################################################################################
    public static final String CARRUSEL_UPDATE_SUMMARY = "@RequestBody List<Busqueda> busquedas, @Return String: - Error al intentar modificar las busquedas: %s -";
    public static final String CARRUSEL_UPDATE_DESCRIPTION = "CRUD-UPDATE del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar los datos completos de un registro del modelo.";


    // UPDATE BY PARAMS ################################################################################################
    public static final String CARRUSEL_UPDATE_BY_PARAMS_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - Busquedas modificadas correctamente. -";
    public static final String CARRUSEL_UPDATE_BY_PARAMS_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar los datos completos de un registro del modelo.";


    // DELETE ##########################################################################################################
    public static final String CARRUSEL_DELETE_SUMMARY = "@RequestParam Map<String, Object> params, @Return String: - Busquedas modificadas correctamente. -";
    public static final String CARRUSEL_DELETE_DESCRIPTION = "CRUD-UPDATE-BY-PARAMS del Backoffice. Solo acceden perfiles administrativos, se utilza para modificar los datos completos de un registro del modelo.";


    public static final String CODE_200_CREATE = "Carrusel agregado correctamente";
    public static final String CODE_200_DELETE = "Carrusel eliminado correctamente";
    public static final String CODE_400_DELETE = "Error al intentar eliminar carrusel: ";

    public static final String CODE_200_UPDATE = "Carrusel modificado correctamente";
    public static final String CODE_400_CREATE = "Error al intentar guardar carrusel";

    public static final String CODE_400_UPDATE = "Error al intentar modificar carrusel: ";
    public static final String CODE_200_UPDATE_BY_PARAMS = "BarraNavegacion modificada correctamente";
    public static final String BARRA_NAVEGACION_MSG_ERROR_CREATE = "Error al intentar guardar el tema de la barra de navegacion: %s";

    public static final String BARRA_NAVEGACION_MSG_OK_UPDATE = "Barra de navegacion modificada correctamente";
    public static final String BARRA_NAVEGACION_MSG_ERROR_UPDATE = "Error al intentar modificar la barra de navegacion: %s";

    public static final String BARRA_NAVEGACION_MSG_ERROR_DELETE = "Error al intentar borrar el tema de la barra de navegacion id %s: %s";

}
