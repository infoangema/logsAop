package angema.base.loginAop.app.verificar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificarService {

    @Value("${url}")
    private String url;

    public String verificar(VerificarRequest request) {
        return request.toString();
//        RestTemplate restTemplate = new RestTemplate();
//        // crear headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        headers.add("Accept", "application/json");
//        headers.add("Authorization", "token");
//
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("DNI", request.dni);
//        params.put("nroTramite", request.nroTramite);
//
//        HttpEntity entity = new HttpEntity(params, headers);
//
//        return restTemplate.postForObject(url, entity, String.class);
    }
}
