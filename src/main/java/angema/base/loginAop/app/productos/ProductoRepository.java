package angema.base.loginAop.app.productos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer> {

    ProductoEntity findByCuitSocioAndIdProducto(String cuitSocio, String productoId);
}
