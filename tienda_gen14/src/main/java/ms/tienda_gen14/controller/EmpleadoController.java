package ms.tienda_gen14.controller;

import jakarta.websocket.server.PathParam;
import ms.tienda_gen14.entity.EmpleadoEntity;
import ms.tienda_gen14.response.EmpleadoResponse;
import ms.tienda_gen14.service.impl.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tiendaGen14/v1")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;


    @GetMapping("/empleados")
    public List<EmpleadoEntity> readAll(){
            return empleadoService.readAll();
    }



    @GetMapping("/empleados/all")
    public List<EmpleadoResponse> all(){
        return empleadoService.All();
    }

    @GetMapping("/empleados/{id}")
    public Optional<EmpleadoEntity> readById(@PathVariable Integer id){
        return empleadoService.readById(id);
    }


    @GetMapping("/empleadoActivo")
    public List<EmpleadoEntity> activo(){
        return empleadoService.activo();
    }


    @PostMapping("/crearEmpleado")
    public EmpleadoEntity create(@RequestBody EmpleadoEntity empleadoEntity){
        return empleadoService.createEmpleado(empleadoEntity);
    }

    @PutMapping("/empleados")
    public EmpleadoEntity update(@RequestBody EmpleadoEntity empleadoEntity){
        return empleadoService.update(empleadoEntity);
    }

    @DeleteMapping("/empleado/{id}")
    public String deleteById(@PathVariable Integer id){
        return empleadoService.deleteById(id);
    }

    @GetMapping("/empleadosfechas")
    public List<EmpleadoEntity> fechas(@PathParam("fecha_contratacion")String fecha_contratacion, @PathParam("salario") Double salario){
        return empleadoService.fechas(fecha_contratacion, salario);
    }

}
