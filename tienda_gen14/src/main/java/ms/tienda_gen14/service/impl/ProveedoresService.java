package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.repository.ProveedorRepository;
import ms.tienda_gen14.service.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService implements IProveedoresService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Método para obtener proveedores activos por nombre de empresa
    @Override
    public List<ProveedoresEntity> getActiveProveedoresByNombreEmpresa(String nombreEmpresa) {
        return proveedorRepository.findActiveProveedoresByNombreEmpresa(nombreEmpresa);
    }

    // Obtener todos los proveedores
    @Override
    public List<ProveedoresEntity> readAll() {
        return proveedorRepository.findAll();
    }

    // Obtener proveedor por ID
    @Override
    public Optional<ProveedoresEntity> readById(Integer id) {
        return proveedorRepository.findById(id);
    }

    // Crear un nuevo proveedor
    @Override
    public ProveedoresEntity create(ProveedoresEntity proveedoresEntity) {
        return proveedorRepository.save(proveedoresEntity);
    }

    // Actualizar un proveedor
    @Override
    public ProveedoresEntity update(ProveedoresEntity proveedoresEntity) {
        return proveedorRepository.save(proveedoresEntity);
    }

    // Eliminar proveedor por ID
    @Override
    public String deleteById(Integer id) {
        Optional<ProveedoresEntity> proveedores = proveedorRepository.findById(id);
        if (proveedores.isPresent()) {
            proveedorRepository.deleteById(id);
            return "Proveedor borrado exitosamente";
        } else {
            return "Proveedor no encontrado";
        }
    }

    // Obtener todos los proveedores activos
    public List<ProveedoresEntity> findActiveProveedores() {
        return proveedorRepository.findByIsActiveTrue();
    }

    // Obtener todos los proveedores inactivos
    public List<ProveedoresEntity> findInactiveProveedores() {
        return proveedorRepository.findByIsActiveFalse();
    }

    // Método para obtener proveedores activos por nombre de empresa (consulta personalizada JPA)
    public List<ProveedoresEntity> getActiveProveedoresByNombreEmpresaQuery(String nombreEmpresa) {
        return proveedorRepository.findByNombreEmpresa(nombreEmpresa);
    }

    // Método para agregar un nuevo proveedor
    public String agregarProveedor(ProveedoresEntity proveedor) {
        try {
            proveedorRepository.save(proveedor);
            return "Proveedor agregado correctamente";
        } catch (Exception e) {
            return "Error al agregar el proveedor: " + e.getMessage();
        }
    }

    // Borrado lógico (marcar como inactivo)
    @Override
    public String deleteLogicalById(Integer id) {
        Optional<ProveedoresEntity> proveedorOptional = proveedorRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            ProveedoresEntity proveedor = proveedorOptional.get();
            proveedor.setIsActive(false);  // Marcar el proveedor como inactivo (borrado lógico)
            proveedorRepository.save(proveedor);  // Guardar el proveedor con el estado actualizado
            return "Proveedor marcado como inactivo exitosamente";
        } else {
            return "Proveedor no encontrado";
        }
    }


}
