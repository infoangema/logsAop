package angema.base.loginAop.app.descargas;

public class DescargaMsj {

    public static final String DOWNLOAD_CONDIONES = "Error al intentar obtener el archivo de condiciones para el socio %s id-producto %s, archivo no encontrado.";
    public static final String DOWNLOAD_COBERTURA = "Error al intentar obtener el archivo de oberturas para el socio %s id-producto %s, archivo no encontrado.";


    // DOWNLOAD COBERTURA ############################################################################################################
    public static final String DOWNLOAD_COBERTURA_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return byte[]";
    public static final String DOWNLOAD_COBERTURA_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para descargar un pdf con el detellle de las coberturas del producto según el cuit de socio y el id del producto.";

    // DOWNLOAD CONDICIONES ############################################################################################################
    public static final String DOWNLOAD_CONDICIONES_SUMMARY = "@PathVariable String cuitSocio, @PathVariable String idProducto, @Return byte[]";
    public static final String DOWNLOAD_CONDICIONES_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para descargar la font de css mediante  un cuit de socio solicitado.";

    // FONT CSS     ############################################################################################################
    public static final String FONT_CSS_SUMMARY = "@PathVariable String cuitSocio, @Return byte[]";
    public static final String FONT_CSS_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la lista de de parametros cargados por productos, segun el cuit del socio y el id del producto.";

    // FONT PRIMARY ############################################################################################################
    public static final String FONT_PRIMARY_SUMMARY = "@PathVariable String cuitSocio, @Return List<Busqueda>";
    public static final String FONT_PRIMARY_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la font primaria a utilizar en la Landing de ventas , segun el cuit del socio.";

    // FONT SECONDARY  ############################################################################################################
    public static final String FONT_SECONDARY_SUMMARY = "@PathVariable String cuitSocio";
    public static final String FONT_SECONDARY_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para obtener la font secundaria a utilizar en la Landing de ventas , según el cuit del socio.";

}
