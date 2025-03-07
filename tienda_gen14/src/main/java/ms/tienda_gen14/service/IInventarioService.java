package ms.tienda_gen14.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import ms.tienda_gen14.entity.InventarioEntity;
import ms.tienda_gen14.response.InventarioResponse;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {

    //Obtener todos los registros
    public List<InventarioEntity> readAll();

    //Buscar inventario por Id
    public Optional<InventarioEntity> readById(Integer idInventario);

    //Crear un registro
    public InventarioEntity create(InventarioEntity inventarioEntity);

    //Actualizar un registro
    public InventarioEntity update(InventarioEntity inventarioEntity);

    //Eliminar un registro de forma logica
    public String deleteById(Integer id);

    //Métodos personalizados
    public List<InventarioEntity> findByStockInventarioLessThan(Integer stock);

    public List<InventarioEntity> findInventariosWithStockBetween(Integer stockInicio, Integer stockFin);

    //Métodos Response DTO
    public List<InventarioResponse> readAllResponse();
    public Optional<InventarioResponse> readByIdResponse(Integer id);

}
