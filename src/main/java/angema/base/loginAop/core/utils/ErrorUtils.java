package angema.base.loginAop.core.utils;

public class ErrorUtils {
//    private static final Map<String, String> errorMessages = new HashMap<>();

//    static {
//        errorMessages.put("ARCHIVO_CONDICIONES", "Error al intentar obtener el archivo de condiciones para el socio %s id-producto %s");
//    }

    public static String getErrorMessage(String errorCode, Object... args) {
//        String errorMessage = errorMessages.get(errorCode);
        return String.format(errorCode, args);
    }
}
