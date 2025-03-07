package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.ProductoEntity;
import ms.tienda_gen14.response.ProductoResponse;
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
    public List<ProductoEntity> readAll() {
        return productoService.readAll();
    }

    @GetMapping("/readId/{id}")
    public Optional<ProductoEntity> readById(@PathVariable Integer id) {
        return productoService.readById(id);
    }

    //Crear
    @PostMapping("/save")
    public ProductoEntity create(@RequestBody ProductoEntity productoEntity) {
        return productoService.create(productoEntity);
    }

    //Método update
    @PutMapping("/update")
    public ProductoEntity update(@RequestBody ProductoEntity productoEntity) {
        return productoService.update(productoEntity);
    }

    //Método delete
    @DeleteMapping("/delete/{id}")
    public String delteById(@PathVariable Integer id) {
        return productoService.deleteById(id);
    }

    //Métodos personalizados
    @GetMapping("/findByStockProductoLessThan")
    public List<ProductoEntity> findByStockProductoLessThan(@RequestParam("stock") Integer stock) {
        return productoService.findByStockProductoLessThan(stock);
    }

    @GetMapping("/findProductosWithPriceGreaterThanAverage")
    public List<ProductoEntity> findProductosWithPriceGreaterThanAverage() {
        return productoService.findProductosWithPriceGreaterThanAverage();
    }

    //Métodos response DTO
    @GetMapping("/readAllResponse")
    public List<ProductoResponse> readAllResponse() {
        return productoService.readAllResponse();
    }

    //Métodos response DTO
    @GetMapping("/readByIdResponse/{id}")
    public Optional<ProductoResponse> readByIdResponse(@PathVariable Integer id) {
        return productoService.readByIdResponse(id);
    }
}
