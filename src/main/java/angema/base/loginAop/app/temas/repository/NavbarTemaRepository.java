package angema.base.loginAop.app.temas.repository;

import angema.base.loginAop.app.temas.entities.Navbar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavbarTemaRepository extends JpaRepository<Navbar, Integer> {
    Navbar findByCuitSocio(String cuitSocio);
}
