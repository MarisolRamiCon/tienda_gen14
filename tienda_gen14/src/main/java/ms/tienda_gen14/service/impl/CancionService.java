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

        try {
            return cancionesClient.getAllData();
        } catch (Exception e) {
            System.out.println("No se obtuvo información" );
            e.printStackTrace();
            throw new RuntimeException("Error al consultar la base de datos");
        }

    }

    @Override
    public Cancion getById(Long id) {
        try {
            return cancionesClient.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la canción con ID: " + id);
        }
    }

    @Override
    public Cancion saveCancion(Cancion cancion) {
        try {
            return cancionesClient.saveCancion(cancion);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la canción: " + cancion.getNombre(), e);
        }
    }

    @Override
    public Cancion updateCancion(Long id, Cancion cancion) {
        try {
            return cancionesClient.updateCancion(id, cancion);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la canción con ID: " + id, e);
        }
    }

    @DeleteMapping("/cancion/{id}")
    public String deleteCancion(@PathVariable Long id) {
        try {
            cancionesClient.deleteCancion(id);
            return "Canción eliminada";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la canción con ID: " + id, e);
        }
    }
}
