package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.Inventario;
import ms.tienda_gen14.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Integer> {


    // Métodos personalizados
    // Buscar inventarios cuyo stock es menor a un valor dado por el usuario
    List<Inventario> findByStockInventarioLessThan(Integer stock);

    // Buscar inventarios cuyo stock está entre dos valores específicos (inclusive)
    @Query(value = "SELECT * FROM inventario WHERE stock_inventario BETWEEN :stockInicio AND :stockFin", nativeQuery = true)
    List<Inventario> findInventariosWithStockBetween( Integer stockInicio, Integer stockFin);
}
