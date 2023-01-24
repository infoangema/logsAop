package angema.base.loginAop.app.temas.color;

import angema.base.loginAop.app.temas.color.Color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    Color findByCuitSocio(String cuitSocio);
}
