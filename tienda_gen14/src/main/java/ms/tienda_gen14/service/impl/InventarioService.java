package ms.tienda_gen14.service.impl;


import ms.tienda_gen14.entity.InventarioEntity;
import ms.tienda_gen14.repository.InventarioRepository;
import ms.tienda_gen14.response.InventarioResponse;
import ms.tienda_gen14.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements IInventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public List<InventarioEntity> readAll() {
        return inventarioRepository.findAll().stream()
                .filter(inventario -> inventario.getActive())
                .toList();
    }

    @Override
    public Optional<InventarioEntity> readById(Integer idInventario) {
        return inventarioRepository.findById(idInventario);
    }

    @Override
    public InventarioEntity create(InventarioEntity inventarioEntity) {
        return inventarioRepository.save(inventarioEntity);
    }

    @Override
    public InventarioEntity update(InventarioEntity inventarioEntity) {
        return inventarioRepository.save(inventarioEntity);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<InventarioEntity> inventarioOptional = inventarioRepository.findById(id);
        if (inventarioOptional.isPresent()) {
            InventarioEntity inventarioEntity = inventarioOptional.get();
            inventarioEntity.setActive(false);
            inventarioRepository.save(inventarioEntity);
            return "Borrado exitoso";
        }
        return "No se encontró el registro";
    }

    //Métodos personalizados
    @Override
    public List<InventarioEntity> findByStockInventarioLessThan(Integer stock) {
        return inventarioRepository.findByStockInventarioLessThan(stock);
    }

    //Métodos personalizados
    @Override
    public List<InventarioEntity> findInventariosWithStockBetween(Integer stockInicio, Integer stockFin) {
        return inventarioRepository.findInventariosWithStockBetween(stockInicio,stockFin);
    }

    @Override
    public List<InventarioResponse> readAllResponse() {
        return inventarioRepository.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public Optional<InventarioResponse> readByIdResponse(Integer id) {
        return inventarioRepository.findById(id)
                .map(this::convertToResponse);
    }

    private InventarioResponse convertToResponse(InventarioEntity inventario) {
        InventarioResponse response = new InventarioResponse();
        response.setIdInventarioResponse(inventario.getIdInventario());
        response.setIdProductoResponse(inventario.getIdProducto());
        response.setStockInventarioResponse(inventario.getStockInventario());
        return response;
    }

}
