package angema.base.loginAop.core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Service
public class FileSystemUtil {
    Gson gson = new Gson();

    public String getFile(String path) {
        InputStream in = FileSystemUtil.class.getResourceAsStream(path);
        JsonElement json = gson.fromJson(new InputStreamReader(in, Charset.forName("UTF-8").newDecoder()), JsonElement.class);
        String jsonStr = ((JsonObject) json).get("body").toString();
        return jsonStr;
    }
}
