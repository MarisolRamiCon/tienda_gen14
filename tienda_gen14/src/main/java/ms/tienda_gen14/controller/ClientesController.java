package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.ClientesEntity;
import ms.tienda_gen14.response.ClientesResponse;
import ms.tienda_gen14.service.impl.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v5")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public List<ClientesResponse> readAll() {
        return clientesService.readAll();
    }


    // Obtener un cliente por su ID
    @GetMapping("/clientes/{id}")  // Cambiado de /personas/{id} a /clientes/{id}
    public Optional<ClientesEntity> readById(@PathVariable Integer id) {  // Cambiado a Clientes
        return clientesService.readById(id);  // Cambiado a clientesService
    }

    // Crear un nuevo cliente
    @PostMapping("/clientes")  // Cambiado de /personas a /clientes
    public ClientesEntity create(@RequestBody ClientesEntity clientesEntity) {  // Cambiado a Clientes
        return clientesService.create(clientesEntity);  // Cambiado a clientesService
    }

    // Actualizar un cliente existente
    @PutMapping("/clientes")  // Cambiado de /personas a /clientes
    public ClientesEntity update(@RequestBody ClientesEntity clientesEntity) {  // Cambiado a Clientes
        return clientesService.update(clientesEntity);  // Cambiado a clientesService
    }

    // Eliminar un cliente por su ID
    @DeleteMapping("/clientes/{id}")  // Cambiado de /personas/{id} a /clientes/{id}
    public String deleteById(@PathVariable Integer id) {  // Cambiado a clientesService
        return clientesService.deleteById(id);  // Cambiado a clientesService
    }
    // Obtener clientes activos
    @GetMapping("/clientes/activos")
    public List<ClientesEntity> getClientesActivos() {
        return clientesService.getClientesActivos();
    }

    // Buscar clientes por nombre
    @GetMapping("/clientes/nombre/{nombre}")
    public List<ClientesEntity> getClientesPorNombre(@PathVariable String nombre) {
        return clientesService.getClientesPorNombre(nombre);
    }

    //METODOS DTO

    // Obtener todos los clientes
    @GetMapping("/clientesDTO")
    public List<ClientesResponse> readAllResponse() {
        return clientesService.readAllResponse();  // Llama al servicio para obtener todos los clientes y los devuelve como ClientesResponse
    }

    // Obtener un cliente por su ID
    @GetMapping("/clientesDTO/{id}")
    public Optional<ClientesResponse> readByIdResponse(@PathVariable Integer id) {
        return clientesService.readByIdResponse(id);  // Llama al servicio para obtener un cliente por su ID y devolverlo como ClientesResponse
    }

}