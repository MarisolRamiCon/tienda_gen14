package ms.tienda_gen14.repository;

import ms.tienda_gen14.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    public List<Empleado> findByActivoEquals(Boolean bool);
}
