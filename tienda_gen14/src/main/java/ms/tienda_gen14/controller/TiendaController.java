package ms.tienda_gen14.controller;

import ms.tienda_gen14.model.Tienda;
import ms.tienda_gen14.service.impl.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class TiendaController {
    @Autowired
    TiendaService tiendaService;

    @GetMapping("/Tienda")
    public ResponseEntity<List<Tienda>> getData() {
        try {
            return ResponseEntity.ok(tiendaService.getData());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/Tienda/{id}")
    public ResponseEntity<Tienda> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tiendaService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping("/Tienda")
    public ResponseEntity<Tienda> createTienda(@RequestBody Tienda tienda) {
        try {
            return ResponseEntity.ok(tiendaService.createTienda(tienda));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("/Tienda/{id}")
    public ResponseEntity<Tienda> updateTienda(@PathVariable Long id, @RequestBody Tienda tienda) {
        try {
            return ResponseEntity.ok(tiendaService.updateTienda(id, tienda));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/Tienda/{id}")
    public ResponseEntity<Void> deleteTienda(@PathVariable Long id) {
        try {
            tiendaService.deleteTienda(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

