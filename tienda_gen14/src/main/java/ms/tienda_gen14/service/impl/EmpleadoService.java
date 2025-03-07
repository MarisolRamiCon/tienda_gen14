package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.EmpleadoEntity;
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
    public List<EmpleadoEntity> readAll() {
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
    public Optional<EmpleadoEntity> readById(Integer id) {
        try{
            Optional<EmpleadoEntity> empleado= empleadoRepository.findById(id);
            if(!empleado.isPresent()){
                throw new RuntimeException("Algo salio mal");
            }
            return empleado;
        }catch (Exception e){
            throw new RuntimeException("Algo salio mal");
        }


    }

    @Override
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleadoEntity) {
        try{
            return empleadoRepository.save(empleadoEntity);
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity empleadoEntity) {
        try{
            return empleadoRepository.save(empleadoEntity);
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public String deleteById(Integer id) {
        Optional<EmpleadoEntity> empleado= empleadoRepository.findById(id);
        if (empleado.isPresent()){
            EmpleadoEntity empleadoEntityObj = empleado.get();
            empleadoEntityObj.setActivo(false);
            empleadoRepository.save(empleadoEntityObj);
            return "borrado exitosamente";
        }else{
            return "No esta";
        }
    }

    @Override
    public List<EmpleadoEntity> activo() {
        try{
            return empleadoRepository.findByactivoTrue();
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }

    @Override
    public List<EmpleadoEntity> fechas(String fecha_contratacion, Double salario) {
        try{
            return empleadoRepository.fechas(fecha_contratacion,salario);
        }catch(Exception e){
            throw new RuntimeException("Algo salio mal");
        }

    }
}
