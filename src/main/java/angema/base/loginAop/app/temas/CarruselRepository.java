package angema.base.loginAop.app.temas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarruselRepository extends JpaRepository<Carrusel, Integer> {
    List<Carrusel> findByCuitSocioAndActiveIsTrueOrderByPrioridad(String cuitSocio);
}
