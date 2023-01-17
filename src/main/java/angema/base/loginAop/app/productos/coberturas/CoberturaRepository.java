package angema.base.loginAop.app.productos.coberturas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Integer> {
    List<Cobertura> findByCuitSocioAndIdProductoOrderByPrioridad(String cuitSocio, String idProducto);
}