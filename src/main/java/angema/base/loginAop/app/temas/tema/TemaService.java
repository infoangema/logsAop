package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacion;
import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionRepository;
import angema.base.loginAop.app.temas.boton.Boton;
import angema.base.loginAop.app.temas.boton.BotonRepository;
import angema.base.loginAop.app.temas.carrusel.Carrusel;
import angema.base.loginAop.app.temas.carrusel.CarruselRepository;
import angema.base.loginAop.app.temas.color.Color;
import angema.base.loginAop.app.temas.color.ColorRepository;
import angema.base.loginAop.app.temas.carrusel.ImagenCarruselDto;
import angema.base.loginAop.app.temas.enums.ViewportSize;
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
    private BarraNavegacionRepository barraNavegacionRepository;
    @Autowired
    private BotonRepository botonRepository;


    public Tema findTemas(String cuitSocio) {
        Tema temaSocio;
        Color color = colorRepository.findByCuitSocio(cuitSocio);
        BarraNavegacion barraNavegacion = barraNavegacionRepository.findByCuitSocio(cuitSocio);
        Boton boton = botonRepository.findByCuitSocio(cuitSocio);
        List<Carrusel> imagenes = carruselRepository.findByCuitSocio(cuitSocio);

        temaSocio = temaRepository.findByCuitSocio(cuitSocio);
        temaSocio.color = color;
        temaSocio.barraNavegacion = barraNavegacion;
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
                tema.barraNavegacion.id = barraNavegacionRepository.findByCuitSocio(cuit).id;
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

            tema.barraNavegacion.cuitSocio = cuit;
            tema.barraNavegacion.colorPrimarioRgba = nuevoTema.navbar.colorPrimarioRgba;
            tema.barraNavegacion.colorPrimarioRgbaLight = nuevoTema.navbar.colorPrimarioRgbaLight;
            tema.barraNavegacion.colorSecundarioRgba = nuevoTema.navbar.colorSecundarioRgba;
            tema.barraNavegacion.colorSecundarioRgbaLight = nuevoTema.navbar.colorSecundarioRgbaLight;
            tema.barraNavegacion.urlLogo = nuevoTema.navbar.urlLogo;

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
            barraNavegacionRepository.save(tema.barraNavegacion);
            carruselRepository.saveAll(tema.imagenesCarrusel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
