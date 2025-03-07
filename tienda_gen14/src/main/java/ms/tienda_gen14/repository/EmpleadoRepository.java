package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    public List<Empleado> findByactivoTrue();

    @Query(value = "select * from u630341118_gen14tienda.empleado where fecha_contratacion>=:fecha_contratacion and salario>=:salario;",nativeQuery = true)
    public List<Empleado> fechas(String fecha_contratacion, Double salario);
}
