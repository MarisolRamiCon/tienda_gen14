package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.Empleado;
import ms.tienda_gen14.repository.EmpleadoRepository;
import ms.tienda_gen14.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> readAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> readById(Integer id) {
          Optional<Empleado> empleado= empleadoRepository.findById(id);
          return empleado;
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Empleado> empleado= empleadoRepository.findById(id);
        if (empleado.isPresent()){
            Empleado empleadoObj = empleado.get();
            empleadoObj.setActivo(false);
            empleadoRepository.save(empleadoObj);
            return "borrado exitosamente";
        }else{
            return "No esta";
        }
    }

    @Override
    public List<Empleado> activoIgual(Boolean bool) {
        return empleadoRepository.findByActivoEquals(true);
    }
}
