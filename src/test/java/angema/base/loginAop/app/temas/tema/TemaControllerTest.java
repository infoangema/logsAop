package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.boton.BotonDto;
import angema.base.loginAop.app.temas.color.ColorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-unitest.properties")
class TemaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void obtenerTemasPorCuit() throws Exception {
        String cuitSocio = "30687310434";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/temas/obtener-temas/cuit-socio/" + cuitSocio + "/tema-socio"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String response = result.getResponse().getContentAsString();
    }

    @Test
    public void agregarTema() throws Exception {
        String cuitSocio = "30687310434";

        TemaDto tema = new TemaDto();
        tema.setNombre("BSF");
        tema.setUrlLogo("http://200.114.219.199/service/landing/themes/getLogoByCuit/30687310434");
        tema.setUrlImagenFondo("http://200.114.219.199/service/landing/themes/getImagenFondoByCuit/30687310434");
        tema.setUrlTipografia("http://200.114.219.199/service/landing/themes/getTipografia/primary");

        ColorDto color = new ColorDto();
        color.setPrimarioRgba("rgba(2, 80, 158, 1)");
        color.setPrimarioRgbaLight("rgba(2, 80, 158, 0.8)");
        color.setSecundarioRgba("rgba(0, 204, 153, 1)");
        color.setSecundarioRgbaLight("rgba(0, 204, 153, 0.8)");
        color.setTerciarioRgba("rgba(0, 152, 204, 1)");
        tema.setColor(color);

        BotonDto boton = new BotonDto();
        boton.setPrimarioRgba("rgba(2, 80, 158, 1)");
        boton.setPrimarioRgbaLight("rgba(2, 80, 158, 0.8)");
        boton.setSecundarioRgba("rgba(0, 204, 153, 1)");
        boton.setSecundarioRgbaLight("rgba(0, 204, 153, 0.8)");
        boton.setFondoRgba("rgba(247, 247, 247, 1)");
        boton.setFondoRgbaLight("rgba(247, 247, 247, 0.8)");
        tema.setBoton(boton);

        String temaJson = objectMapper.writeValueAsString(tema);

        mockMvc.perform(MockMvcRequestBuilders.post("/temas/agregar-tema/cuit-socio/" + cuitSocio)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(temaJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void modificarTema() throws Exception {
        String cuitSocio = "30687310434";

        TemaDto tema = new TemaDto();
        tema.setId(1);
        tema.setNombre("BSF");
        tema.setUrlLogo("http://200.114.219.199/service/landing/themes/getLogoByCuit/30687310434");
        tema.setUrlImagenFondo("http://200.114.219.199/service/landing/themes/getImagenFondoByCuit/30687310434");
        tema.setUrlTipografia("http://200.114.219.199/service/landing/themes/getTipografia/primary");

        ColorDto color = new ColorDto();
        color.setPrimarioRgba("rgba(2, 80, 158, 1)");
        color.setPrimarioRgbaLight("rgba(2, 80, 158, 0.8)");
        color.setSecundarioRgba("rgba(0, 204, 153, 1)");
        color.setSecundarioRgbaLight("rgba(0, 204, 153, 0.8)");
        color.setTerciarioRgba("rgba(0, 152, 204, 1)");
        tema.setColor(color);

        BotonDto boton = new BotonDto();
        boton.setPrimarioRgba("rgba(2, 80, 158, 1)");
        boton.setPrimarioRgbaLight("rgba(2, 80, 158, 0.8)");
        boton.setSecundarioRgba("rgba(0, 204, 153, 1)");
        boton.setSecundarioRgbaLight("rgba(0, 204, 153, 0.8)");
        boton.setFondoRgba("rgba(247, 247, 247, 1)");
        boton.setFondoRgbaLight("rgba(247, 247, 247, 0.8)");
        tema.setBoton(boton);

        String temaJson = objectMapper.writeValueAsString(tema);

        mockMvc.perform(MockMvcRequestBuilders.put("/temas/modificar-tema")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(temaJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
