package angema.base.loginAop.app.productos.repository;

import angema.base.loginAop.app.productos.entities.ItemDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDetalleRepository extends JpaRepository<ItemDetalle, Integer> {
    List<ItemDetalle> findByCuitSocioAndIdProductoOrderByPrioridad(String cuitSocio, String idProducto);
}
