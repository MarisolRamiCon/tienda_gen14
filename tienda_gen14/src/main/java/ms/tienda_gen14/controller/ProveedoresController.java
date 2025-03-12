package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.service.impl.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v5") // La ruta base para todos los endpoints

public class ProveedoresController { // Cambié el nombre del controlador a ProveedorController

    @Autowired
    ProveedoresService proveedoresService; // Inyecté ProveedorService en lugar de DepartamentoService

    @GetMapping("/proveedores") // Cambié la ruta de "departamentos" a "proveedores"
    public List<ProveedoresEntity> readAll() {
        return proveedoresService.readAll(); // Obtener todos los proveedores
    }


    @GetMapping("/proveedores/{id}") // Cambié la ruta de "departamentos/{id}" a "proveedores/{id}"
    public Optional<ProveedoresEntity> readById(@PathVariable Integer id) {
        return proveedoresService.readById(id); // Obtener un proveedor por su ID
    }

    @PostMapping("/proveedores") // Cambié la ruta de "departamentos" a "proveedores"
    public ProveedoresEntity create(@RequestBody ProveedoresEntity proveedoresEntity) {
        return proveedoresService.create(proveedoresEntity); // Crear un nuevo proveedor
    }

    @PutMapping("/proveedores") // Actualizar un proveedor
    public ProveedoresEntity update(@RequestBody ProveedoresEntity proveedoresEntity) {
        return proveedoresService.update(proveedoresEntity); // Actualizar un proveedor
    }

    @DeleteMapping("/proveedores/{id}") // Cambié la ruta de "departamentos/{id}" a "proveedores/{id}"
    public String deleteById(@PathVariable Integer id) {
        return proveedoresService.deleteById(id); // Eliminar un proveedor por su ID
    }




    //Método personalizado

    // Endpoint para obtener todos los proveedores activos
    @GetMapping("/proveedores/activos")
    public List<ProveedoresEntity> findActiveProveedores() {
        return proveedoresService.findActiveProveedores();
    }

    // Endpoint para obtener todos los proveedores inactivos
    @GetMapping("/proveedores/inactivos")
    public List<ProveedoresEntity> findInactiveProveedores() {
        return proveedoresService.findInactiveProveedores();
    }







}

