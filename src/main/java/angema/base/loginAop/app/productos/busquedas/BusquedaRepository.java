package angema.base.loginAop.app.productos.busquedas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaRepository extends JpaRepository<Busqueda, Integer> {
    List<Busqueda> findByCuitSocioAndIdProducto(String cuitSocio, String productoId);

    List<Busqueda> findAllByDescripcionIn(List<String> parametros);

    @Query(value = "SELECT DISTINCT * FROM BUSQUEDAS WHERE CONCAT('%', descripcion, '%') LIKE CONCAT('%', :parametro, '%')", nativeQuery = true)
    List<Busqueda> findAllDistinctByDescripcionIn(@Param("parametro") String parametro);
}
