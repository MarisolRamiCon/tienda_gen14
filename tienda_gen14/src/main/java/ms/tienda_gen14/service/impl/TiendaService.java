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
        return tiendaClient.getData();
    }

    @Override
    public Tienda getById(Long id) {
        return tiendaClient.getDataById(id);

    }

    @Override
    public Tienda createTienda(Tienda tienda) {
        // Llamada al cliente Feign para crear una nueva tienda
        return tiendaClient.createTienda(tienda);
    }

    @Override
    public Tienda updateTienda(Long id, Tienda tienda) {
        // Llamada al cliente Feign para actualizar una tienda existente
        return tiendaClient.updateTienda(id, tienda);
    }

    @Override
    public void deleteTienda(Long id) {
        // Llamada al cliente Feign para eliminar una tienda por su ID
        tiendaClient.deleteTienda(id);
    }


}