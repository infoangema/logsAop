package angema.base.logsAop.app.verificar;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VerificarService {

    @Value("${url}")
    private String url;

    public String verificar(VerificarRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        // crear headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", token);

        // buscar: how to send json object to rest template
        JsonObject body = new JsonObject();
        body.add("DNI", request.dni);
        body.add("nroTramite", request.nroTramite);

        HttpEntity entity = new HttpEntity(body, headers);

        return restTemplate.postForObject(url, entity, String.class);
    }
}
