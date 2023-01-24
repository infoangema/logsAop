package angema.base.loginAop.app.temas.carrusel;

import angema.base.loginAop.app.temas.carrusel.Carrusel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarruselRepository extends JpaRepository<Carrusel, Integer> {
    List<Carrusel> findByCuitSocio(String cuitSocio);
}
