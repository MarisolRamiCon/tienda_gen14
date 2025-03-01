package ms.tienda_gen14.controller;

import ms.tienda_gen14.model.Cancion;
import ms.tienda_gen14.service.impl.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class CancionController {

    @Autowired
    CancionService cancionService;

    @GetMapping("/cancion")
    public List<Cancion> getData() {
        return cancionService.getAllData();
    }

    @GetMapping("/cancion/{id}")
    public Cancion getCancionPorId(@PathVariable("id") Long id) {
        return cancionService.getById(id);
    }

    @PostMapping("/cancion")
    public Cancion saveCancion(@RequestBody Cancion cancion) {
        return cancionService.saveCancion(cancion);
    }

    @PutMapping("/cancion/{id}")
    public Cancion updateCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        return cancionService.updateCancion(id, cancion);

    }

    @DeleteMapping("/cancion/{id}")
    public String deleteCancion(@PathVariable Long id) {
        return cancionService.deleteCancion(id);
    }
}
