package angema.base.loginAop.app.temas.boton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotonRepository extends JpaRepository<Boton, Integer> {
    Boton findByCuitSocio(String cuitSocio);
}
