package angema.base.loginAop.app.temas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Integer> {
    Tema findByCuitSocio(String cuitSocio);
}