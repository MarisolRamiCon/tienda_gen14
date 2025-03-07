package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ProductoEntity;
import ms.tienda_gen14.repository.ProductoRepository;
import ms.tienda_gen14.response.ProductoResponse;
import ms.tienda_gen14.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> readAll() {

        return productoRepository.findAll().stream()
                .filter(producto -> producto.getActive() == true)
                .toList();
    }

    @Override
    public Optional<ProductoEntity> readById(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public ProductoEntity create(ProductoEntity productoEntity) {
        return productoRepository.save(productoEntity);
    }

    @Override
    public ProductoEntity update(ProductoEntity productoEntity) {
        Optional<ProductoEntity> existingProducto = productoRepository.findById(productoEntity.getIdProducto());

        if (existingProducto.isPresent()) {
            ProductoEntity updatedProductoEntity = existingProducto.get();
            updatedProductoEntity.setNombreProducto(productoEntity.getNombreProducto());
            updatedProductoEntity.setDescripcionProducto(productoEntity.getDescripcionProducto());
            updatedProductoEntity.setPrecioProducto(productoEntity.getPrecioProducto());
            updatedProductoEntity.setCategoriaProducto(productoEntity.getCategoriaProducto());
            updatedProductoEntity.setIdProveedor(productoEntity.getIdProveedor());
            updatedProductoEntity.setStockProducto(productoEntity.getStockProducto());
            updatedProductoEntity.setActive(productoEntity.getActive());
            return productoRepository.save(updatedProductoEntity);
        } else {
            return null;
        }
    }

    @Override
    public String deleteById(Integer id) {
        Optional<ProductoEntity> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            ProductoEntity productoEntity = productoOptional.get();
            productoEntity.setActive(false);
            productoRepository.save(productoEntity);
            return "Borrado exitoso";
        }
        return "No se encontró el registro";
    }

    //Métodos personalizados
    @Override
    public List<ProductoEntity> findByStockProductoLessThan(Integer stock) {
        return productoRepository.findByStockProductoLessThan(stock);
    }

    @Override
    public List<ProductoEntity> findProductosWithPriceGreaterThanAverage() {
        return productoRepository.findProductosWithPriceGreaterThanAverage();
    }

    //Métodos Response
    @Override
    public List<ProductoResponse> readAllResponse() {
        List<ProductoEntity> productoEntityList = productoRepository.findAll();
        List<ProductoResponse> productoResponseList=  productoEntityList.stream()
                                        .map(this::convertToResponse)
                                        .collect(Collectors.toList());
        return productoResponseList;
    }

    @Override
    public Optional<ProductoResponse> readByIdResponse(Integer id) {
        Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
        Optional<ProductoResponse> productoResponseOptional = productoEntity.map(this::convertToResponse);
        return productoResponseOptional;
    }

    // Método usado para readAllResponse y readByIdResponse
    private ProductoResponse convertToResponse(ProductoEntity producto) {
        ProductoResponse response = new ProductoResponse();
        response.setIdProductoResponse(producto.getIdProducto());
        response.setNombreProductoResponse(producto.getNombreProducto());
        response.setDescripcionProductoResponse(producto.getDescripcionProducto());
        response.setPrecioProductoResponse(producto.getPrecioProducto());
        response.setCategoriaProductoResponse(producto.getCategoriaProducto());
        response.setStockProductoResponse(producto.getStockProducto());
        return response;
    }


}
