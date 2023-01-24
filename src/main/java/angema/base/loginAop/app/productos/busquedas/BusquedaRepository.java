package angema.base.loginAop.app.productos.busquedas;

import angema.base.loginAop.app.productos.coberturas.Cobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaRepository extends JpaRepository<Busqueda, Integer> {
    List<Busqueda> findByCuitSocioAndIdProducto(String cuitSocio, String productoId);
}
