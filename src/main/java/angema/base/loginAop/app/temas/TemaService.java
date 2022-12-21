package angema.base.loginAop.app.temas;

import angema.base.loginAop.app.temas.entities.Color;
import angema.base.loginAop.app.temas.entities.Carrusel;
import angema.base.loginAop.app.temas.entities.NavbarTema;
import angema.base.loginAop.app.temas.repository.CarruselRepository;
import angema.base.loginAop.app.temas.repository.ColorRepository;
import angema.base.loginAop.app.temas.repository.NavbarTemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {
    @Autowired
    private TemaRepository temaRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private CarruselRepository carruselRepository;

    @Autowired
    private NavbarTemaRepository navbarTemaRepository;

    public Tema obtenerTemas(String cuitSocio) {
        Tema temaSocio;
        Color color = colorRepository.findByCuitSocio(cuitSocio);
        NavbarTema navbarTema = navbarTemaRepository.findByCuitSocio(cuitSocio);
        temaSocio = temaRepository.findByCuitSocio(cuitSocio);
        List<Carrusel> imagenes = carruselRepository.findByCuitSocio(cuitSocio);
        temaSocio.color = color;
        temaSocio.navbarTema = navbarTema;
        temaSocio.imagenesCarrusel = imagenes;
        return temaSocio;
    }
}
