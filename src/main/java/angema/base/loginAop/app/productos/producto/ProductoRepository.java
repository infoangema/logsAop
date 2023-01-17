package angema.base.loginAop.app.productos.producto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

//    @Query(value = "select * from productos where cuit_socio = ?1 and id_producto = ?2", nativeQuery = true)
    Producto findByCuitSocioAndIdProducto(String cuitSocio, String productoId);
}
