package angema.base.loginAop.app.descargas;

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

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-local.properties")
class DescargasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getDownloadCoberturas() throws Exception {
        String cuitSocio = "30687310434";
        int idProducto=1077;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/descargas/cobertura/cuit/"+cuitSocio+"/id-producto/"+idProducto+"/descarga-cobertura"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String response = result.getResponse().getContentAsString();
    }

    @Test
    void getCondiciones()throws Exception {
        String cuitSocio = "30687310434";
        int idProducto=1077;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/descargas/condiciones/cuit/"+cuitSocio+"/id-producto/"+idProducto+"/descarga-condiciones"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String response = result.getResponse().getContentAsString();


    }


}