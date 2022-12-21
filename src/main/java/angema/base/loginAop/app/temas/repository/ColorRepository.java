package angema.base.loginAop.app.temas.repository;

import angema.base.loginAop.app.temas.entities.Color;

import angema.base.loginAop.app.temas.entities.NavbarTema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    Color findByCuitSocio(String cuitSocio);
}
