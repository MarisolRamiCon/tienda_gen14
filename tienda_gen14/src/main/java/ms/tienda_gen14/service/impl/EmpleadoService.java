package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.Empleado;
import ms.tienda_gen14.repository.EmpleadoRepository;
import ms.tienda_gen14.response.EmpleadoResponse;
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
        try{
            var empleado = empleadoRepository.findAll();
            if(empleado == null){
                throw new RuntimeException("Algo salio mal");

            }
            return empleado;

        }catch (Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public List<EmpleadoResponse> All() {
        try{
            return empleadoRepository.findAll().stream().map(per ->{
                EmpleadoResponse response = new EmpleadoResponse(per.getId(),per.getNombre(),per.getApellido(),per.getPuesto());
                return response;
            }).toList();
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public Optional<Empleado> readById(Integer id) {
        try{
            Optional<Empleado> empleado= empleadoRepository.findById(id);
            if(!empleado.isPresent()){
                throw new RuntimeException("Algo salio mal");
            }
            return empleado;
        }catch (Exception e){
            throw new RuntimeException("Algo salio mal");
        }


    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        try{
            return empleadoRepository.save(empleado);
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public Empleado update(Empleado empleado) {
        try{
            return empleadoRepository.save(empleado);
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

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
    public List<Empleado> activo() {
        try{
            return empleadoRepository.findByactivoTrue();
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public List<Empleado> fechas(String fecha_contratacion, Double salario) {
        try{
            return empleadoRepository.fechas(fecha_contratacion,salario);
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }
}
