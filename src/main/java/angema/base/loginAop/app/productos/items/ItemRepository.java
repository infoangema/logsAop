package angema.base.loginAop.app.productos.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByCuitSocioAndIdProductoOrderByPrioridad(String cuitSocio, String idProducto);
}
