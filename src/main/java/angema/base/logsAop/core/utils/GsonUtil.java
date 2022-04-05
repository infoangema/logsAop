package angema.base.logsAop.core.utils;

import com.google.gson.Gson;

public class GsonUtil {

    public static String serialize(Object object) {
        Gson gsonUtil = new Gson();
        return gsonUtil.toJson(object);
    }

    public static <T> T toObject(String json, Class<T> tClass) {
        Gson gson = new Gson();
        return gson.fromJson(json, tClass);
    }

    public static <T> T toObject(Object obj, Class<T> tClass) {
        Gson gson = new Gson();
        String strJson = gson.toJson(obj);
        return gson.fromJson(strJson, tClass);
    }

}
