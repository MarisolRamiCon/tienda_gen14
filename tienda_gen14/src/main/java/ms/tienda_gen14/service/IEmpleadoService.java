package ms.tienda_gen14.service;

import ms.tienda_gen14.entity.Empleado;
import ms.tienda_gen14.response.EmpleadoResponse;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    public List<Empleado> readAll();
    public List<EmpleadoResponse> All();
    public Optional<Empleado> readById(Integer id);
    public Empleado createEmpleado(Empleado empleado);
    public Empleado update(Empleado empleado);
    public String deleteById(Integer id);
    public List<Empleado> activo();
    public List<Empleado> fechas(String fecha_contratacion, Double salario);
}
