package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.repository.ProveedorRepository;
import ms.tienda_gen14.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService implements IProveedoresService { // Cambié el nombre de la clase a ProveedorService

    @Autowired
    private ProveedorRepository proveedorRepository; // Cambié la inyección del repositorio a ProveedorRepository

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




}