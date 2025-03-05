package ms.tienda_gen14.service;

import ms.tienda_gen14.model.Empleados;

import java.util.List;

public interface IEmpleadosService {
    public List<Empleados> getAllData();

    public Empleados getById(Integer id);

    public Empleados crearEmpleados(Empleados empleado);

    public Empleados modificarEmpleados(Integer id, Empleados cancion);

    public String eliminarEmpleados(Integer id);
}

