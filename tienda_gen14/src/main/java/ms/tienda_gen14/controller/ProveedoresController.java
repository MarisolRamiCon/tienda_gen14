package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.service.impl.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v5") // La ruta base para todos los endpoints

public class ProveedoresController { //  ProveedorController

    @Autowired
    ProveedoresService proveedoresService; // Inyecté ProveedorService

    @GetMapping("/proveedores") //  "proveedores"
    public List<ProveedoresEntity> readAll() {
        return proveedoresService.readAll(); // Obtener todos los proveedores
    }


    @GetMapping("/proveedores/{id}") //  "proveedores/{id}"
    public Optional<ProveedoresEntity> readById(@PathVariable Integer id) {
        return proveedoresService.readById(id); // Obtener un proveedor por su ID
    }

    @PostMapping("/proveedores") //  "proveedores"
    public ProveedoresEntity create(@RequestBody ProveedoresEntity proveedoresEntity) {
        return proveedoresService.create(proveedoresEntity); // Crear un nuevo proveedor
    }

    @PutMapping("/proveedores") // Actualizar un proveedor
    public ProveedoresEntity update(@RequestBody ProveedoresEntity proveedoresEntity) {
        return proveedoresService.update(proveedoresEntity); // Actualizar un proveedor
    }

    @DeleteMapping("/proveedores/{id}") //  "proveedores/{id}"
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


    //Metodos Try-Cach

    //

    // Obtener todos los proveedores activos
    @GetMapping("/proveedores/activoscach")
    public ResponseEntity<List<ProveedoresEntity>> obtenerProveedoresActivos() {
        try {
            List<ProveedoresEntity> proveedoresActivos = proveedoresService.obtenerProveedoresActivos();
            if (proveedoresActivos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Si no hay proveedores activos
            }
            return new ResponseEntity<>(proveedoresActivos, HttpStatus.OK);  // Si hay proveedores activos
        } catch (Exception e) {
            System.err.println("Error al obtener proveedores activos: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Manejo de error
        }
    }

    // Obtener todos los proveedores inactivos
    @GetMapping("/proveedores/inactivoscach")
    public ResponseEntity<List<ProveedoresEntity>> obtenerProveedoresInactivos() {
        try {
            List<ProveedoresEntity> proveedoresInactivos = proveedoresService.obtenerProveedoresInactivos();
            if (proveedoresInactivos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Si no hay proveedores inactivos
            }
            return new ResponseEntity<>(proveedoresInactivos, HttpStatus.OK);  // Si hay proveedores inactivos
        } catch (Exception e) {
            System.err.println("Error al obtener proveedores inactivos: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Manejo de error
        }
    }

    // Agregar un nuevo proveedor
    @PostMapping("/proveedorescach")
    public ResponseEntity<String> agregarProveedor(@RequestBody ProveedoresEntity proveedor) {
        try {
            String respuesta = proveedoresService.agregarProveedor(proveedor);
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);  // Retorna el mensaje con código 201
        } catch (Exception e) {
            System.err.println("Error al agregar proveedor: " + e.getMessage());
            return new ResponseEntity<>("Error al agregar proveedor", HttpStatus.INTERNAL_SERVER_ERROR);  // Manejo de error
        }
    }

    @DeleteMapping("/proveedor/logico/{id}")
    public ResponseEntity<String> borrarProveedorLogico(@PathVariable Integer id) {
        String resultado = proveedoresService.deleteLogicalById(id);  // Llamar al servicio para borrar lógicamente el proveedor
        if (resultado.equals("Proveedor no encontrado")) {
            return ResponseEntity.notFound().build();  // Si no se encuentra el proveedor, devolver un 404
        }
        return ResponseEntity.ok(resultado);  // Devolver respuesta exitosa
    }

    // Endpoint para buscar proveedores activos por nombre de empresa @Querry

    @GetMapping("/activos/empresa")
    public List<ProveedoresEntity> getActiveProveedoresByNombreEmpresa(@RequestParam String nombreEmpresa) {
        return proveedoresService.getActiveProveedoresByNombreEmpresa(nombreEmpresa);
    }

}





