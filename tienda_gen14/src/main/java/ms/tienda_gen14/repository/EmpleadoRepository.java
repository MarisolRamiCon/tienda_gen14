package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity,Integer> {

    public List<EmpleadoEntity> findByactivoTrue();

    @Query(value = "select * from u630341118_gen14tienda.empleado where fecha_contratacion>=:fecha_contratacion and salario>=:salario;",nativeQuery = true)
    public List<EmpleadoEntity> fechas(String fecha_contratacion, Double salario);
}
