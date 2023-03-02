package angema.base.loginAop.app.temas.tema;

import angema.base.loginAop.app.productos.producto.ProductoException;
import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacion;
import angema.base.loginAop.app.temas.barraNavegacion.BarraNavegacionRepository;
import angema.base.loginAop.app.temas.boton.Boton;
import angema.base.loginAop.app.temas.boton.BotonRepository;
import angema.base.loginAop.app.temas.carrusel.Carrusel;
import angema.base.loginAop.app.temas.carrusel.CarruselRepository;
import angema.base.loginAop.app.temas.color.Color;
import angema.base.loginAop.app.temas.color.ColorRepository;
import angema.base.loginAop.app.temas.enums.ViewportSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static angema.base.loginAop.core.exceptions.ExceptionService.getErrorMessage;

@Service
public class TemaService {
    @Autowired
    private TemaRepository temaRepository;
    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private BotonRepository botonRepository;


    public Tema findTemas(String cuitSocio) {
        try {
            Tema temaSocio;
            Color color = colorRepository.findByCuitSocio(cuitSocio);
            Boton boton = botonRepository.findByCuitSocio(cuitSocio);

            temaSocio = temaRepository.findByCuitSocio(cuitSocio);
            temaSocio.color = color;
            temaSocio.boton = boton;
            return temaSocio;
        } catch (ConstraintViolationException e) {
            throw new TemaException("Error al intentar guardar producto: " + getErrorMessage(e));
        } catch (DataIntegrityViolationException e) {
            throw new TemaException("Error al intentar guardar producto: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            throw new TemaException("Error al intentar guardar producto: " + e.getCause().getMessage());
        }
    }

    public boolean saveOrUpdateTema(String cuit, TemaDto nuevoTema, boolean modificar) {
        Tema tema = new Tema();
        try {
            if(modificar) {
                tema.id = temaRepository.findByCuitSocio(cuit).id;
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

            temaRepository.save(tema);
            colorRepository.save(tema.color);
            botonRepository.save(tema.boton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
