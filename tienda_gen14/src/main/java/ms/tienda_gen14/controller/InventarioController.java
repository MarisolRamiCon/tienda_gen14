package ms.tienda_gen14.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import ms.tienda_gen14.entity.InventarioEntity;
import ms.tienda_gen14.response.InventarioResponse;
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
    public List<InventarioEntity> readAll() {

        return inventarioService.readAll();
    }

    @GetMapping("/readId/{id}")
    public Optional<InventarioEntity> readById(@PathVariable Integer id) {

        return inventarioService.readById(id);
    }

    @PostMapping("/save")
    public InventarioEntity create(@RequestBody InventarioEntity inventarioEntity) {
        return inventarioService.create(inventarioEntity);
    }

    //Método update
    @PutMapping("/update")
    public InventarioEntity update(@RequestBody InventarioEntity inventarioEntity) {
        return inventarioService.update(inventarioEntity);
    }

    //Método delete
    @DeleteMapping("/delete/{id}")
    public String delteById(@PathVariable Integer id) {
        return inventarioService.deleteById(id);
    }

    //Método personalizado
    @GetMapping("/findByStockProductoLessThan")
    public List<InventarioEntity> findByStockProductoLessThan(@RequestParam("stock") Integer stock) {
        return inventarioService.findByStockInventarioLessThan(stock);
    }

    //Método personalizado
    @GetMapping("/findInventariosWithStockBetween")
    public List<InventarioEntity> findInventariosWithStockBetween(@RequestParam("stockInicio") Integer stockInicio,
                                                                  @RequestParam("stockFin") Integer stockFin) {

        return inventarioService.findInventariosWithStockBetween(stockInicio, stockFin);
    }

    //Métodos response DTO
    @GetMapping("/readAllResponse")
    public List<InventarioResponse> readAllResponse() {
        return inventarioService.readAllResponse();
    }

    //Métodos response DTO
    @GetMapping("/readByIdResponse/{id}")
    public Optional<InventarioResponse> readByIdResponse(@PathVariable Integer id) {
        return inventarioService.readByIdResponse(id);
    }

}
