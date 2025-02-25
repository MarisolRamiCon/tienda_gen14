package com.rodcor.inventario.controller;

import com.rodcor.inventario.entity.Inventario;
import com.rodcor.inventario.service.impl.InventarioService;
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
    @DeleteMapping("delete/{id}")
    public String delteById(@PathVariable Integer id) {
        return inventarioService.deleteById(id);
    }

}
