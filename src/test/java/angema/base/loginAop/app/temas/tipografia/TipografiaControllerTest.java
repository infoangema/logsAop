package angema.base.loginAop.app.temas.tipografia;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-local.properties")
public class TipografiaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getFontPrimaryByCuit() throws Exception{
        String cuitSocio = "30687310434";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/tipografias/obtener-tipografia/cuit/"+cuitSocio+"/primary/font_primary.ttf"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String response = result.getResponse().getContentAsString();

    }


}
