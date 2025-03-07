package ms.tienda_gen14.service;

import ms.tienda_gen14.entity.EmpleadoEntity;
import ms.tienda_gen14.response.EmpleadoResponse;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    public List<EmpleadoEntity> readAll();
    public List<EmpleadoResponse> All();
    public Optional<EmpleadoEntity> readById(Integer id);
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleadoEntity);
    public EmpleadoEntity update(EmpleadoEntity empleadoEntity);
    public String deleteById(Integer id);
    public List<EmpleadoEntity> activo();
    public List<EmpleadoEntity> fechas(String fecha_contratacion, Double salario);
}
