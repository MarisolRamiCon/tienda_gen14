package ms.tienda_gen14.controller;

import jakarta.websocket.server.PathParam;
import ms.tienda_gen14.entity.Empleado;
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
    public List<Empleado> readAll(){
            return empleadoService.readAll();
    }



    @GetMapping("/empleados/all")
    public List<EmpleadoResponse> all(){
        return empleadoService.All();
    }

    @GetMapping("/empleados/{id}")
    public Optional<Empleado> readById(@PathVariable Integer id){
        return empleadoService.readById(id);
    }


    @GetMapping("/empleadoActivo")
    public List<Empleado> activoIgual(@PathParam("Activo") Boolean bool){
        return empleadoService.activoIgual(bool);
    }


    @PostMapping("/crearEmpleado")
    public Empleado create(@RequestBody Empleado empleado){
        return empleadoService.createEmpleado(empleado);
    }

    @PostMapping("/empleados")
    public Empleado update(@RequestBody Empleado empleado){
        return empleadoService.update(empleado);
    }

    @DeleteMapping("/empleado/{id}")
    public String deleteById(@PathVariable Integer id){
        return empleadoService.deleteById(id);
    }

    @GetMapping("/empleadosfechas")
    public List<Empleado> fechas(@PathParam("fecha_contratacion")String fecha_contratacion, @PathParam("salario") Double salario){
        return empleadoService.fechas(fecha_contratacion, salario);
    }

}
