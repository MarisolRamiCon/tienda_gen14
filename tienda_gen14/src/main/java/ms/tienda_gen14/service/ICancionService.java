package ms.tienda_gen14.service;

import ms.tienda_gen14.model.Cancion;

import java.util.List;

public interface ICancionService {

    public List<Cancion> getAllData();

    public Cancion getById(Long id);

    public Cancion saveCancion(Cancion cancion);

    public Cancion updateCancion(Long id, Cancion cancion);

    public String deleteCancion(Long id);
}
