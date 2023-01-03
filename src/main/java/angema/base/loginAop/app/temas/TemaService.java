package angema.base.loginAop.app.temas;

import angema.base.loginAop.app.temas.entities.*;
import angema.base.loginAop.app.temas.enums.ViewportSize;
import angema.base.loginAop.app.temas.repository.*;
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
    @Autowired
    private BotonRepository botonRepository;


    public Tema obtenerTemas(String cuitSocio) {
        Tema temaSocio;
        Color color = colorRepository.findByCuitSocio(cuitSocio);
        Navbar navbar = navbarTemaRepository.findByCuitSocio(cuitSocio);
        Boton boton = botonRepository.findByCuitSocio(cuitSocio);
        List<Carrusel> imagenes = carruselRepository.findByCuitSocio(cuitSocio);

        temaSocio = temaRepository.findByCuitSocio(cuitSocio);
        temaSocio.color = color;
        temaSocio.navbar = navbar;
        temaSocio.boton = boton;
        temaSocio.imagenesCarrusel = imagenes;
        return temaSocio;
    }

    public ViewportSize getMatchingViewportSize(String size) {
        int sizeInPixels = Integer.parseInt(size);

        for (ViewportSize viewportSize : ViewportSize.values()) {
            int viewportSizeInPixels = Integer.parseInt(viewportSize.getSize());
            if (sizeInPixels <= viewportSizeInPixels) {
                return viewportSize;
            }
        }
        return ViewportSize.XXS;
    }
}
