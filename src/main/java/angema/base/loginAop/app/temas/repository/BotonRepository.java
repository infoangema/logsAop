package angema.base.loginAop.app.temas.repository;

import angema.base.loginAop.app.temas.entities.Boton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotonRepository extends JpaRepository<Boton, Integer> {
    Boton findByCuitSocio(String cuitSocio);
}
