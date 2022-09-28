package angema.base.loginAop.core.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
    Optional<AuthEntity> findByEmailAndPassword(String user, String password);

    Optional<AuthEntity> findByUserName(String nombreUsuario);
}
