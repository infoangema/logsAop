package angema.base.loginAop.core.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByEmailAndPassword(String user, String password);

    Optional<Auth> findByUserName(String nombreUsuario);
}
