package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.Producto;
import ms.tienda_gen14.repository.ProductoRepository;
import ms.tienda_gen14.service.IProductoService;
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
        Optional<Producto> existingProducto = productoRepository.findById(producto.getIdProducto());

        if (existingProducto.isPresent()) {
            Producto updatedProducto = existingProducto.get();
            updatedProducto.setNombreProducto(producto.getNombreProducto());
            updatedProducto.setDescripcionProducto(producto.getDescripcionProducto());
            updatedProducto.setPrecioProducto(producto.getPrecioProducto());
            updatedProducto.setCategoriaProducto(producto.getCategoriaProducto());
            updatedProducto.setIdProveedor(producto.getIdProveedor());
            updatedProducto.setStockProducto(producto.getStockProducto());
            updatedProducto.setActive(producto.getActive());
            return productoRepository.save(updatedProducto);
        } else {
            return null;
        }
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

    @Override
    public List<Producto> findByStockProductoLessThan(Integer stock) {
        return productoRepository.findByStockProductoLessThan(stock);
    }

    @Override
    public List<Producto> findProductosWithPriceGreaterThanAverage() {
        return productoRepository.findProductosWithPriceGreaterThanAverage();
    }

    //Métodos personalizados

}
