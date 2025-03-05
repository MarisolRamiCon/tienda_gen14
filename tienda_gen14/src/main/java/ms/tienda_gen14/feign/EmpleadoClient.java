package ms.tienda_gen14.feign;

import ms.tienda_gen14.model.Cancion;
import ms.tienda_gen14.model.Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TiendaEmpleados", url = "https://67c7f2e4c19eb8753e7b7321.mockapi.io/TiendaEmpleados/")
public interface EmpleadoClient {

    @GetMapping("/empleados")
    public List<Empleados> getAllData();

    @GetMapping("/empleados/{id}")
    public Empleados getById(@PathVariable("id") Integer id);

    @PostMapping("/empleados")
    public Empleados crearEmpleados(@RequestBody Empleados empleados);

    @PutMapping("/empleados/{id}")
    public Empleados modificarEmpleados(@PathVariable Integer id,
                                 @RequestBody Empleados empleados);

    @DeleteMapping("/empleados/{id}")
    public String eliminarEmpleados(@PathVariable("id") Integer id);

}
