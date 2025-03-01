package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.feign.CancionesClient;
import ms.tienda_gen14.model.Cancion;
import ms.tienda_gen14.service.ICancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CancionService implements ICancionService {

    @Autowired
    CancionesClient cancionesClient;

    @Override
    public List<Cancion> getAllData() {
        return cancionesClient.getAllData();
    }

    @Override
    public Cancion getById(Long id) {
        return cancionesClient.getById(id);
    }

    @Override
    public Cancion saveCancion(Cancion cancion) {
        return cancionesClient.saveCancion(cancion);
    }

    @Override
    public Cancion updateCancion(Long id, Cancion cancion) {
        return cancionesClient.updateCancion(id, cancion);
    }

    @DeleteMapping("/cancion/{id}")
    public String deleteCancion(@PathVariable Long id) {
        cancionesClient.deleteCancion(id);
        return  "Canción eliminada" ;
    }
}
