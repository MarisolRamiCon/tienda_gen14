package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Integer> {
    // Aquí puedes agregar métodos personalizados si lo necesitas

    // Método para obtener todos los clientes activos
    List<ClientesEntity> findByIsActiveTrue();

    // Método para buscar clientes por nombre
    List<ClientesEntity> findByNombre(String nombre);

    // Método utilizando @Query para buscar clientes por nombre

    @Query("SELECT c FROM ClientesEntity c WHERE c.nombre LIKE %:nombre%")
    List<ClientesEntity> findByNombreContiene(String nombre);

}