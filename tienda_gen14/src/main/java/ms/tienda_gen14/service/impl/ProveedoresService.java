package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.repository.ProveedorRepository;
import ms.tienda_gen14.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService implements IProveedoresService { // Cambié el nombre de la clase a ProveedorService

    @Autowired
    private ProveedorRepository proveedorRepository; // Cambié la inyección del repositorio a ProveedorRepository

    // Método para buscar proveedores activos por nombre de empresa @Querry

    public List<ProveedoresEntity> getActiveProveedoresByNombreEmpresa(String nombreEmpresa) {
        return proveedorRepository.findActiveProveedoresByNombreEmpresa(nombreEmpresa);
    }


    @Override
    public List<ProveedoresEntity> readAll() {
        return proveedorRepository.findAll(); // Obtener todos los proveedores
    }

    @Override
    public Optional<ProveedoresEntity> readById(Integer id) {
        Optional<ProveedoresEntity> proveedores = proveedorRepository.findById(id); // Obtener un proveedor por su ID
        return proveedores;
    }

    @Override
    public ProveedoresEntity create(ProveedoresEntity proveedoresEntity) {
        return proveedorRepository.save(proveedoresEntity); // Crear un nuevo proveedor
    }

//metodo

    @Override
    public ProveedoresEntity update(ProveedoresEntity proveedoresEntity) {
        return proveedorRepository.save(proveedoresEntity); // Actualizar un proveedor
    }

    @Override
    public String deleteById(Integer id) { // Cambié el nombre del método a deleteById
        Optional<ProveedoresEntity> proveedores = proveedorRepository.findById(id); // Buscar proveedor por ID
        if (proveedores.isPresent()) {
            proveedorRepository.deleteById(id);  // Eliminar el proveedor
            return "Borrado exitosamente";
        } else {
            return "Proveedor no encontrado";
        }
    }


    // Método para obtener todos los proveedores activos
    public List<ProveedoresEntity> findActiveProveedores() {
        return proveedorRepository.findByIsActiveTrue();
    }

    // Método para obtener todos los proveedores inactivos
    public List<ProveedoresEntity> findInactiveProveedores() {
        return proveedorRepository.findByIsActiveFalse();
    }

   // Tri-Cach


    // Método para obtener proveedores activos
    public List<ProveedoresEntity> obtenerProveedoresActivos() {
        try {
            return proveedorRepository.findByIsActiveTrue();
        } catch (DataAccessException e) {
            // Manejar la excepción si ocurre un error de acceso a datos
            System.err.println("Error al obtener proveedores activos: " + e.getMessage());
            e.printStackTrace();
            return null;  // O puedes retornar una lista vacía si prefieres
        }
    }

    // Método para obtener proveedores inactivos
    public List<ProveedoresEntity> obtenerProveedoresInactivos() {
        try {
            return proveedorRepository.findByIsActiveFalse();
        } catch (DataAccessException e) {
            // Manejar la excepción si ocurre un error de acceso a datos
            System.err.println("Error al obtener proveedores inactivos: " + e.getMessage());
            e.printStackTrace();
            return null;  // O puedes retornar una lista vacía si prefieres
        }
    }

    // Método para agregar un nuevo proveedor
    public String agregarProveedor(ProveedoresEntity proveedor) {
        try {
            proveedorRepository.save(proveedor);
            return "Proveedor agregado correctamente";
        } catch (DataAccessException e) {
            // Manejar el error de acceso a datos
            System.err.println("Error al agregar el proveedor: " + e.getMessage());
            e.printStackTrace();
            return "Error al agregar el proveedor";
        }


    }
    // Método de borrado logico

    @Override
    public String deleteLogicalById(Integer id) {
        Optional<ProveedoresEntity> proveedorOptional = proveedorRepository.findById(id); // Buscar proveedor por ID
        if (proveedorOptional.isPresent()) {
            ProveedoresEntity proveedor = proveedorOptional.get();
            proveedor.setIsActive(false);  // Marcar el proveedor como inactivo (borrado lógico)
            proveedorRepository.save(proveedor);  // Guardar el proveedor con el estado actualizado
            return "Proveedor marcado como inactivo exitosamente";  // Mensaje indicando que el proveedor fue "borrado lógicamente"
        } else {
            return "Proveedor no encontrado";  // Mensaje si el proveedor no existe
        }
    }


}