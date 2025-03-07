package ms.tienda_gen14.service;

import ms.tienda_gen14.entity.ProductoEntity;
import ms.tienda_gen14.response.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    //Obtener todos los registros
    public List<ProductoEntity> readAll();

    //Buscar producto por Id
    public Optional<ProductoEntity> readById(Integer idProducto);

    //Crear un registro
    public ProductoEntity create(ProductoEntity productoEntity);

    //Actualizar un registro
    public ProductoEntity update(ProductoEntity productoEntity);

    //Eliminar un registro de forma logica
    public String deleteById(Integer id);

    //Métodos personalizados
    public List<ProductoEntity> findByStockProductoLessThan(Integer stock);
    public List<ProductoEntity> findProductosWithPriceGreaterThanAverage();

    //Métodos Response DTO
    public List<ProductoResponse> readAllResponse();
    public Optional<ProductoResponse>  readByIdResponse(Integer id);

}
