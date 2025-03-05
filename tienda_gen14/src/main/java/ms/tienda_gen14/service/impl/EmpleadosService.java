package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.feign.EmpleadoClient;
import ms.tienda_gen14.model.Empleados;
import ms.tienda_gen14.service.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadosService implements IEmpleadosService {
    @Autowired
    EmpleadoClient empleadoClient;

    @Override
    public List<Empleados> getAllData() {
        return empleadoClient.getAllData();
    }

    @Override
    public Empleados getById(Integer id) {
        return empleadoClient.getById(id);
    }

    @Override
    public Empleados crearEmpleados(Empleados empleado) {
        return empleadoClient.crearEmpleados(empleado);
    }

    @Override
    public Empleados modificarEmpleados(Integer id, Empleados empleado) {
        return empleadoClient.modificarEmpleados(id,empleado);
    }

    @Override
    public String eliminarEmpleados(Integer id) {
        return empleadoClient.eliminarEmpleados(id);
    }
}
