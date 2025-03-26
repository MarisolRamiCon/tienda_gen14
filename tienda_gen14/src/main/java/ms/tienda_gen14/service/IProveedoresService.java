package ms.tienda_gen14.service;

import ms.tienda_gen14.entity.ProveedoresEntity;

import java.util.List;
import java.util.Optional;

public interface IProveedoresService {

    // Obtener todos los proveedores
    public List<ProveedoresEntity> readAll();

    // Obtener un proveedor por su ID
    public Optional<ProveedoresEntity> readById(Integer id);

    // Crear un nuevo proveedor
    public ProveedoresEntity create(ProveedoresEntity proveedoresEntity);

    // Actualizar un proveedor existente
    public ProveedoresEntity update(ProveedoresEntity proveedoresEntity);

    // Eliminar un proveedor por su ID
    public String deleteById(Integer id);

    // Borrado logico
    public String deleteLogicalById(Integer id);

    //Métodos personalizados

}
