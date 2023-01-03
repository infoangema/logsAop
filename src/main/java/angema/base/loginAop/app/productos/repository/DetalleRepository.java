package angema.base.loginAop.app.productos.repository;

import angema.base.loginAop.app.productos.entities.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
    Detalle findByCuitSocioAndIdProducto(String cuitSocio, String idProducto);
}