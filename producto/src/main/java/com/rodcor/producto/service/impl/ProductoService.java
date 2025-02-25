package com.rodcor.producto.service.impl;

import com.rodcor.producto.entity.Producto;
import com.rodcor.producto.repository.ProductoRepository;
import com.rodcor.producto.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<Producto> readAll() {

        return productoRepository.findAll().stream()
                .filter(producto -> producto.getActive() == true)
                .toList();
    }

    @Override
    public Optional<Producto> readById(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setActive(false);
            productoRepository.save(producto);
            return "Borrado exitoso";
        }
        return "No se encontró el registro";
    }
}
