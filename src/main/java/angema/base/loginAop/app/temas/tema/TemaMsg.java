package angema.base.loginAop.app.temas.tema;

public class TemaMsg {



    // CREATE     ############################################################################################################
    public static final String TEMA_CREATE_SUMMARY = "@PathVariable String cuitSocio, @RequestBody TemaDto, @Return GlobalResponse:  - Tema agregado correctamente. -";
    public static final String TEMA_CREATE_DESCRIPTION = "CRUD CREATE del Backoffice. Solo acceden perfiles administrativos, se utiliza para agregar un nuevo tema";
    // UPDATE     ############################################################################################################
    public static final String TEMA_UPDATE_SUMMARY = "@PathVariable String cuitSocio, @RequestBody TemaDto, @Return GlobalResponse: - Tema modificado correctamente -";
    public static final String TEMA_UPDATE_DESCRIPTION = "CRUD UPDATE del Backoffice. Solo acceden perfiles administrativos, se utiliza para modificar un tema";
    // READ COBERTURA  ############################################################################################################
    public static final String TEMA_READ_COBERTURA_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return Byte[]";
    public static final String TEMA_READ_COBERTURA_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la cobertura de un producto, según el cuit y el id producto.";
    // READ CONDICIONES  ############################################################################################################
    public static final String TEMA_READ_CONDICIONES_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return byte[]";
    public static final String TEMA_READ_CONDICIONES_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos,se utiliza para obtener la lista de condiciones de un producto, según el cuit del socio y el id del producto.";
    // READ BACKGROUND  ############################################################################################################
    public static final String TEMA_READ_BACKGROUND_SUMMARY = "@PathVariable String cuitSocio, @Return byte[]";
    public static final String TEMA_READ_BACKGROUND_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos,se utiliza para obtener  la imagen de fondo del socio, según el cuit de socio";
    // READ LOGO  ############################################################################################################
    public static final String TEMA_READ_LOGO_SUMMARY = "@PathVariable String cuitSocio, @Return byte[]";
    public static final String TEMA_READ_LOGO_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos,se utiliza para obtener el logo del socio ,según el cuit del socio .";

    // READ TEMAS  ############################################################################################################
    public static final String TEMA_READ_TEMAS_SUMMARY = "@PathVariable String cuitSocio, @Return GlobalResponse";
    public static final String TEMA_READ_TEMAS_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos,se utiliza para obtener los temas de un socio, según el cuit de socio";


    // FONT CSS     ############################################################################################################
    public static final String TEMA_FONT_CSS_SUMMARY = "@PathVariable String cuitSocio, @Return byte[]";
    public static final String TEMA_FONT_CSS_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la lista de  parametros cargados por productos, segun el cuit del socio y el id del producto.";

    // FONT PRIMARY ############################################################################################################
    public static final String TEMA_FONT_PRIMARY_SUMMARY = "@PathVariable String cuitSocio, @Return byte[]";
    public static final String TEMA_FONT_PRIMARY_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la font primaria a utilizar en la Landing de ventas , segun el cuit del socio.";

    // FONT SECONDARY  ############################################################################################################
    public static final String TEMA_FONT_SECONDARY_SUMMARY = "@PathVariable String cuitSocio, @Return byte[]";
    public static final String TEMA_FONT_SECONDARY_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la font secundaria a utilizar en la Landing de ventas , según el cuit del socio.";




    public static final String TEMA_CREATE_CODE_200 = "Nuevo tema agregado correctamente.";
    public static final String TEMA_MSG_ERROR_CREATE = "Error al intentar guardar el nuevo tema.";

    public static final String TEMA_MSG_ERROR_READ = "Error al intentar obtener tema para el cuit -> %s, idProducto -> %s: %s";



}
