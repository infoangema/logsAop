package angema.base.loginAop.app.temas.tema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Integer> {
    Tema findByCuitSocio(String cuitSocio);

    Tema findByNombreLikeIgnoreCase(String partnerName);
}