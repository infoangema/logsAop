package angema.base.loginAop.app.temas.barraNavegacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarraNavegacionRepository extends JpaRepository<BarraNavegacion, Integer> {
    BarraNavegacion findByCuitSocio(String cuitSocio);
}
