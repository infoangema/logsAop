package angema.base.loginAop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@EnableConfigurationProperties
@SpringBootApplication
public class LogsAopApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@ConfigurationProperties(prefix = "partners.names")
	public Map<String,String> PartnersNames(){
		return new HashMap<>();
	}



	public static void main(String[] args) {
		SpringApplication.run(LogsAopApplication.class, args);
	}


}
