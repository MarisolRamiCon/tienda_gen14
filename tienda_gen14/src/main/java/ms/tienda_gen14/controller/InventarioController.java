package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.Inventario;
import ms.tienda_gen14.service.impl.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @GetMapping("/readAll")
    public List<Inventario> readAll() {

        return inventarioService.readAll();
    }

    @GetMapping("/readId/{id}")
    public Optional<Inventario> readById(@PathVariable Integer id) {

        return inventarioService.readById(id);
    }

    @PostMapping("/save")
    public Inventario create(@RequestBody Inventario inventario) {
        return inventarioService.create(inventario);
    }

    //Método update
    @PutMapping("/update")
    public Inventario update(@RequestBody Inventario inventario) {
        return inventarioService.update(inventario);
    }

    //Método delete
    @DeleteMapping("/delete/{id}")
    public String delteById(@PathVariable Integer id) {
        return inventarioService.deleteById(id);
    }

    //Método personalizado
    @GetMapping("/findByStockProductoLessThan")
    public List<Inventario> findByStockProductoLessThan(@RequestParam("stock") Integer stock) {
        return inventarioService.findByStockInventarioLessThan(stock);
    }

    //Método personalizado
    @GetMapping("/findInventariosWithStockBetween")
    public List<Inventario> findInventariosWithStockBetween(@RequestParam("stockInicio") Integer stockInicio,
                                                            @RequestParam("stockFin") Integer stockFin) {

        return inventarioService.findInventariosWithStockBetween(stockInicio, stockFin);
    }


}
