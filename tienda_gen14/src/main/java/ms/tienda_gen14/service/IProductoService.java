package ms.tienda_gen14.service;

import ms.tienda_gen14.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    //Obtener todos los registros
    public List<Producto> readAll();

    //Buscar producto por Id
    public Optional<Producto> readById(Integer idProducto);

    //Crear un registro
    public Producto create(Producto producto);

    //Actualizar un registro
    public Producto update(Producto producto);

    //Eliminar un registro de forma logica
    public String deleteById(Integer id);

    //Métodos personalizados
    public List<Producto> findByStockProductoLessThan(Integer stock);

    public List<Producto> findProductosWithPriceGreaterThanAverage();
}
