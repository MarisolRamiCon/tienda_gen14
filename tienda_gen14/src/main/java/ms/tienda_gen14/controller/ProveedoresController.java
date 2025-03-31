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
@RequestMapping("/api/v5") // Ruta base para todos los endpoints
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    // Obtener todos los proveedores
    @GetMapping("/proveedores")
    public List<ProveedoresEntity> readAll() {
        return proveedoresService.readAll();
    }

    // Obtener proveedor por ID
    @GetMapping("/proveedores/{id}")
    public ResponseEntity<ProveedoresEntity> readById(@PathVariable Integer id) {
        Optional<ProveedoresEntity> proveedor = proveedoresService.readById(id);
        return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo proveedor
    @PostMapping("/proveedores")
    public ResponseEntity<ProveedoresEntity> create(@RequestBody ProveedoresEntity proveedoresEntity) {
        ProveedoresEntity newProveedor = proveedoresService.create(proveedoresEntity);
        return new ResponseEntity<>(newProveedor, HttpStatus.CREATED);
    }

    // Actualizar un proveedor existente
    @PutMapping("/proveedores")
    public ResponseEntity<ProveedoresEntity> update(@RequestBody ProveedoresEntity proveedoresEntity) {
        ProveedoresEntity updatedProveedor = proveedoresService.update(proveedoresEntity);
        return new ResponseEntity<>(updatedProveedor, HttpStatus.OK);
    }

    // Eliminar un proveedor por ID
    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        String response = proveedoresService.deleteById(id);
        if (response.equals("Proveedor borrado exitosamente")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Obtener todos los proveedores activos
    @GetMapping("/proveedores/activos")
    public List<ProveedoresEntity> findActiveProveedores() {
        return proveedoresService.findActiveProveedores();
    }

    // Obtener todos los proveedores inactivos
    @GetMapping("/proveedores/inactivos")
    public List<ProveedoresEntity> findInactiveProveedores() {
        return proveedoresService.findInactiveProveedores();
    }

    // Obtener proveedores activos por nombre de empresa
    @GetMapping("/proveedores/activos/empresa")
    public List<ProveedoresEntity> getActiveProveedoresByNombreEmpresa(@RequestParam String nombreEmpresa) {
        return proveedoresService.getActiveProveedoresByNombreEmpresa(nombreEmpresa);
    }

    // Método para agregar un nuevo proveedor
    @PostMapping("/proveedores/agregar")
    public ResponseEntity<String> agregarProveedor(@RequestBody ProveedoresEntity proveedor) {
        String respuesta = proveedoresService.agregarProveedor(proveedor);
        if (respuesta.equals("Proveedor agregado correctamente")) {
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrado lógico (marcar como inactivo)
    @DeleteMapping("/proveedores/logico/{id}")
    public ResponseEntity<String> deleteLogicalById(@PathVariable Integer id) {
        String resultado = proveedoresService.deleteLogicalById(id);
        if (resultado.equals("Proveedor marcado como inactivo exitosamente")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
    }
}
