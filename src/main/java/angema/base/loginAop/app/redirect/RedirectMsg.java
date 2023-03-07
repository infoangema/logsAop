package angema.base.loginAop.app.redirect;

public class RedirectMsg {
    // GET ############################################################################################################
    public static final String REDIRECT_GET_SUMMARY = "@PathVariable String nombre, @Return  GlobalResponse";
    public static final String REDIRECT_GET_DESCRIPTION = "CRUD READ del Backoffice. Solo acceden perfiles administrativos, se utiliza para Redireccionar la url a partir de un nombre ingresado.";



    public static final String REDIRECT_MSG_ERROR_READ_SOCIO = "No existe sitio para el socio solicitado";
    public static final String REDIRECT_MSG_ERROR_READ_INVALID_SOCIO = "Cuit del socio no encontrado ó inválido.";
}
