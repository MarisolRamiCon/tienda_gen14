package ms.tienda_gen14.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import ms.tienda_gen14.entity.Inventario;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {

    //Obtener todos los registros
    public List<Inventario> readAll();

    //Buscar inventario por Id
    public Optional<Inventario> readById(Integer idInventario);

    //Crear un registro
    public Inventario create(Inventario inventario);

    //Actualizar un registro
    public Inventario update(Inventario inventario);

    //Eliminar un registro de forma logica
    public String deleteById(Integer id);

    //Métodos personalizados
    public List<Inventario> findByStockInventarioLessThan(Integer stock);

    public List<Inventario> findInventariosWithStockBetween(Integer stockInicio, Integer stockFin);
}
