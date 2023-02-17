package angema.base.loginAop.app.temas.tema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
@TestPropertySource(locations = "classpath:application-local.properties")
class TemaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void obtenerTemasPorCuit()throws Exception {
        String cuitSocio = "30687310434";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/obtener-temas/cuit-socio/"+cuitSocio+"/tema-socio"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    void getLogo() throws Exception {
        String cuitSocio = "30687310434";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/obtener-logo/cuit-socio/"+cuitSocio+"/logo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    void getBackGroundImageByCuit() throws Exception {
        String cuitSocio = "30687310434";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/obtener-logo/cuit-socio/"+cuitSocio+"/logo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }


}