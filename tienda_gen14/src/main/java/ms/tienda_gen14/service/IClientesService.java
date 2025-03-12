package ms.tienda_gen14.service;

import ms.tienda_gen14.entity.ClientesEntity;
import ms.tienda_gen14.response.ClientesResponse;

import java.util.List;
import java.util.Optional;

public interface IClientesService {

    public List<ClientesResponse> readAll();  // Cambiar para manejar Clientes
    // public List<Clientes> readAll(); // Alternativa si no utilizas la clase de respuesta
    public Optional<ClientesEntity> readById(Integer id);  // Cambiar para manejar Clientes
    public ClientesEntity create(ClientesEntity clientesEntity);  // Cambiar para manejar Clientes
    public ClientesEntity update(ClientesEntity clientesEntity);  // Cambiar para manejar Clientes
    public String deleteById(Integer id);  // Cambiar nombre de delateById a deleteById




    //METODOS DTO
    // Método para obtener todos los clientes en formato ClientesResponse
    List<ClientesResponse> readAllResponse();

    // Método para obtener un cliente por su ID en formato ClientesResponse
    Optional<ClientesResponse> readByIdResponse(Integer id);
}