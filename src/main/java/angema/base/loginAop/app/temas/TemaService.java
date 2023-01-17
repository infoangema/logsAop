package angema.base.loginAop.app.temas;

import angema.base.loginAop.app.temas.dtos.ImagenCarruselDto;
import angema.base.loginAop.app.temas.dtos.TemaDto;
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


    public Tema findTemas(String cuitSocio) {
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

    public boolean saveOrUpdateTema(String cuit, TemaDto nuevoTema, boolean modificar) {
        Tema tema = new Tema();
        try {
            if(modificar) {
                tema.id = temaRepository.findByCuitSocio(cuit).id;
                tema.navbar.id = navbarTemaRepository.findByCuitSocio(cuit).id;
                tema.color.id = colorRepository.findByCuitSocio(cuit).id;
                tema.boton.id = botonRepository.findByCuitSocio(cuit).id;
            }

            tema.cuitSocio = cuit;
            tema.nombre = nuevoTema.nombre;
            tema.urlLogo = nuevoTema.urlLogo;
            tema.urlImagenFondo = nuevoTema.urlImagenFondo;
            tema.urlTipografia = nuevoTema.urlTipografia;

            tema.color.cuitSocio = cuit;
            tema.color.primarioRgba = nuevoTema.color.primarioRgba;
            tema.color.primarioRgbaLight = nuevoTema.color.primarioRgbaLight;
            tema.color.secundarioRgba = nuevoTema.color.secundarioRgba;
            tema.color.secundarioRgbaLight = nuevoTema.color.secundarioRgbaLight;
            tema.color.terciarioRgba = nuevoTema.color.terciarioRgba;
            tema.color.terciarioRgbaLight = nuevoTema.color.terciarioRgbaLight;

            tema.boton.cuitSocio = cuit;
            tema.boton.primarioRgba = nuevoTema.boton.primarioRgba;
            tema.boton.primarioRgbaLight = nuevoTema.boton.primarioRgbaLight;
            tema.boton.secundarioRgba = nuevoTema.boton.secundarioRgba;
            tema.boton.secundarioRgbaLight = nuevoTema.boton.secundarioRgbaLight;
            tema.boton.fondoRgba = nuevoTema.boton.fondoRgba;
            tema.boton.fondoRgbaLight = nuevoTema.boton.fondoRgbaLight;

            tema.navbar.cuitSocio = cuit;
            tema.navbar.colorPrimarioRgba = nuevoTema.navbar.colorPrimarioRgba;
            tema.navbar.colorPrimarioRgbaLight = nuevoTema.navbar.colorPrimarioRgbaLight;
            tema.navbar.colorSecundarioRgba = nuevoTema.navbar.colorSecundarioRgba;
            tema.navbar.colorSecundarioRgbaLight = nuevoTema.navbar.colorSecundarioRgbaLight;
            tema.navbar.urlLogo = nuevoTema.navbar.urlLogo;

            for (ImagenCarruselDto img : nuevoTema.imagenesCarrusel) {
                Carrusel carrusel = new Carrusel();
                carrusel.cuitSocio = cuit;
                carrusel.nombre = nuevoTema.nombre;
                carrusel.url = img.url;
                carrusel.estado = img.estado;
                tema.imagenesCarrusel.add(carrusel);
            }

            temaRepository.save(tema);
            colorRepository.save(tema.color);
            botonRepository.save(tema.boton);
            navbarTemaRepository.save(tema.navbar);
            carruselRepository.saveAll(tema.imagenesCarrusel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
