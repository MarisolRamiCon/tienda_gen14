package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.ProveedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedoresEntity, Integer> {
    // Aquí puedes agregar consultas personalizadas si las necesitas


    List<ProveedoresEntity> findActiveProveedoresByNombreEmpresa(String nombreEmpresa);

    //Métodos personalizados

    // Método personalizado para buscar proveedores activos
    List<ProveedoresEntity> findByIsActiveTrue();

    // Método personalizado para buscar proveedores inactivos
    List<ProveedoresEntity> findByIsActiveFalse();

    // Buscar proveedores activos por nombre de empresa (consulta personalizada)
    @Query("SELECT p FROM ProveedoresEntity p WHERE p.isActive = true AND p.nombreEmpresa LIKE %?1%")
    List<ProveedoresEntity> findByNombreEmpresa(String nombreEmpresa);



}