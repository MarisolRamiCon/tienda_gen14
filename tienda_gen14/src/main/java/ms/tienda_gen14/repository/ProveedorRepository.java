package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.ProveedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedoresEntity, Integer> {
    // Método para buscar proveedores activos por nombre de empresa
    List<ProveedoresEntity> findActiveProveedoresByNombreEmpresa(String nombreEmpresa);

    // Método para buscar proveedores activos
    List<ProveedoresEntity> findByIsActiveTrue();

    // Método para buscar proveedores inactivos
    List<ProveedoresEntity> findByIsActiveFalse();

    // Método personalizado para buscar proveedores activos por nombre de empresa (con consulta JPA)
    @Query("SELECT p FROM ProveedoresEntity p WHERE p.isActive = true AND p.nombreEmpresa LIKE %?1%")
    List<ProveedoresEntity> findByNombreEmpresa(String nombreEmpresa);
}
