package angema.base.loginAop.app.productos.detalles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
    Optional<Detalle> findByCuitSocioAndIdProducto(String cuitSocio, String idProducto);
}
