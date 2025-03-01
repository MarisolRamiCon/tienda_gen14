package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.Producto;
import ms.tienda_gen14.service.impl.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/readAll")
    public List<Producto> readAll() {
        return productoService.readAll();
    }

    @GetMapping("/readId/{id}")
    public Optional<Producto> readById(@PathVariable Integer id) {
        return productoService.readById(id);
    }

    //Crear
    @PostMapping("/save")
    public Producto create(@RequestBody Producto producto) {
        return productoService.create(producto);
    }

    //Método update
    @PutMapping("/update")
    public Producto update(@RequestBody Producto producto) {
        return productoService.update(producto);
    }

    //Método delete
    @DeleteMapping("/delete/{id}")
    public String delteById(@PathVariable Integer id) {
        return productoService.deleteById(id);
    }

    //Métodos personalizados
    @GetMapping("/findByStockProductoLessThan")
    public List<Producto> findByStockProductoLessThan(@RequestParam("stock") Integer stock) {
        return productoService.findByStockProductoLessThan(stock);
    }

    @GetMapping("/findProductosWithPriceGreaterThanAverage")
    public List<Producto> findProductosWithPriceGreaterThanAverage() {
        return productoService.findProductosWithPriceGreaterThanAverage();
    }

}
