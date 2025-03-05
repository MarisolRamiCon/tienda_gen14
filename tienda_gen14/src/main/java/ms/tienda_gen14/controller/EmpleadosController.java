package ms.tienda_gen14.controller;

import ms.tienda_gen14.model.Cancion;
import ms.tienda_gen14.model.Empleados;
import ms.tienda_gen14.service.impl.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados/v1")
public class EmpleadosController {
    @Autowired
    EmpleadosService empleadosService;
    @GetMapping("/empleados")
    public List<Empleados> getData() {
        return empleadosService.getAllData();
    }

    @GetMapping("/empleados/{id}")
    public Empleados getById(@PathVariable("id") Integer id) {
        return empleadosService.getById(id);
    }

    @PostMapping("/empleados")
    public Empleados crearEmpleados(@RequestBody Empleados empleados) {
        return empleadosService.crearEmpleados(empleados);
    }

    @PutMapping("/empleados/{id}")
    public Empleados modificarEmpleados(@PathVariable Integer id, @RequestBody Empleados empleados) {
        return empleadosService.modificarEmpleados(id, empleados);

    }

    @DeleteMapping("/empleados/{id}")
    public String eliminarEmpleados(@PathVariable Integer id) {
        return empleadosService.eliminarEmpleados(id);
    }

}
