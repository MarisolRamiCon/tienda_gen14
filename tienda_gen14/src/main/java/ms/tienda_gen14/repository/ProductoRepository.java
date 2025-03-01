package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    // Métodos personalizados
    // Buscar productos cuyo stock es menor a 10
    List<Producto> findByStockProductoLessThan(Integer stock);

    // Buscar productos cuyo precio es mayor que el precio promedio
    @Query(value = "SELECT * FROM producto WHERE precio > (SELECT AVG(precio) FROM producto)", nativeQuery = true)
    List<Producto> findProductosWithPriceGreaterThanAverage();
}
