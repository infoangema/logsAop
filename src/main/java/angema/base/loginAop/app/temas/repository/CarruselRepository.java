package angema.base.loginAop.app.temas.repository;

import angema.base.loginAop.app.temas.entities.Carrusel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarruselRepository extends JpaRepository<Carrusel, Integer> {
    List<Carrusel> findByCuitSocio(String cuitSocio);
}
