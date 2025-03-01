package ms.tienda_gen14.service.impl;


import ms.tienda_gen14.entity.Inventario;
import ms.tienda_gen14.repository.InventarioRepository;
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
    public List<Inventario> readAll() {


        return inventarioRepository.findAll().stream()
                .filter(inventario -> inventario.getActive() == true)
                .toList();
    }

    @Override
    public Optional<Inventario> readById(Integer idInventario) {
        return inventarioRepository.findById(idInventario);
    }

    @Override
    public Inventario create(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario update(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Inventario> inventarioOptional = inventarioRepository.findById(id);
        if (inventarioOptional.isPresent()) {
            Inventario inventario = inventarioOptional.get();
            inventario.setActive(false);
            inventarioRepository.save(inventario);
            return "Borrado exitoso";
        }
        return "No se encontró el registro";
    }

    //Métodos personalizados
    @Override
    public List<Inventario> findByStockInventarioLessThan(Integer stock) {
        return inventarioRepository.findByStockInventarioLessThan(stock);
    }

    //Métodos personalizados
    @Override
    public List<Inventario> findInventariosWithStockBetween(Integer stockInicio, Integer stockFin) {
        return inventarioRepository.findInventariosWithStockBetween(stockInicio,stockFin);
    }
}
