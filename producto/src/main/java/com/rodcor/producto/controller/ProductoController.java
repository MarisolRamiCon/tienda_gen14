package com.rodcor.producto.controller;

import com.rodcor.producto.entity.Producto;
import com.rodcor.producto.service.impl.ProductoService;
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
    @DeleteMapping("delete/{id}")
    public String delteById(@PathVariable Integer id) {
        return productoService.deleteById(id);
    }

}
