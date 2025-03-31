package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.feign.TiendaClient;
import ms.tienda_gen14.model.Tienda;
import ms.tienda_gen14.service.ITiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService implements ITiendaService {
    @Autowired
    TiendaClient tiendaClient;

    @Override
    public List<Tienda> getData() {
        try {
            return tiendaClient.getData().stream()
                    .filter(Tienda::isActivo)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los datos de la tienda", e);
        }
    }

    @Override
    public Tienda getById(Long id) {
        try {
            return tiendaClient.getDataById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tienda con ID: " + id, e);
        }
    }

    @Override
    public Tienda createTienda(Tienda tienda) {
        try {
            return tiendaClient.createTienda(tienda);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la tienda", e);
        }
    }

    @Override
    public Tienda updateTienda(Long id, Tienda tienda) {
        try {
            return tiendaClient.updateTienda(id, tienda);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la tienda con ID: " + id, e);
        }
    }

    @Override
    public void deleteTienda(Long id) {
        try {
            Tienda tienda = tiendaClient.getDataById(id);
            if (tienda != null) {
                tienda.setActivo(false);
                tiendaClient.updateTienda(id, tienda);
            } else {
                throw new RuntimeException("La tienda con ID " + id + " no existe.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar el borrado lógico de la tienda con ID: " + id, e);
        }
    }
}