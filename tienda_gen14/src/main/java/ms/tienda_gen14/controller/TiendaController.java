package ms.tienda_gen14.controller;

import ms.tienda_gen14.model.Tienda;
import ms.tienda_gen14.service.impl.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class TiendaController {
    @Autowired
    TiendaService tiendaService;

    @GetMapping("/Tienda")
    public List<Tienda> getData(){
        return tiendaService.getData();
    }

    @GetMapping("/Tienda/{id}")
    public Tienda getById(@PathVariable Long id){
        return tiendaService.getById(id);
    }

    // Crear una nueva tienda
    @PostMapping("/Tienda")
    public Tienda createTienda(@RequestBody Tienda tienda) {
        return tiendaService.createTienda(tienda); // Llama al servicio para crear una tienda
    }

    // Actualizar una tienda existente
    @PutMapping("/Tienda/{id}")
    public Tienda updateTienda(@PathVariable Long id, @RequestBody Tienda tienda) {
        return tiendaService.updateTienda(id, tienda); // Llama al servicio para actualizar una tienda
    }

    // Eliminar una tienda por su ID
    @DeleteMapping("/Tienda/{id}")
    public void deleteTienda(@PathVariable Long id) {
        tiendaService.deleteTienda(id); // Llama al servicio para eliminar una tienda
    }

}
