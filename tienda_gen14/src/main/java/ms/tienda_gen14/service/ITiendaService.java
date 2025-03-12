package ms.tienda_gen14.service;

import ms.tienda_gen14.model.Tienda;

import java.util.List;

public interface ITiendaService {
    public List<Tienda> getData(); // pegarlo aqui en ITiendaService

    public Tienda getById(Long id);

    // Crear una nueva tienda
    public Tienda createTienda(Tienda tienda);

    // Actualizar una tienda existente
    public Tienda updateTienda(Long id, Tienda tienda);

    // Eliminar una tienda por su ID
    public void deleteTienda(Long id);
}