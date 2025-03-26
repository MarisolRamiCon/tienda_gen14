package ms.tienda_gen14.controller;

import ms.tienda_gen14.entity.ClientesEntity;
import ms.tienda_gen14.response.ClientesResponse;
import ms.tienda_gen14.service.impl.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    // Endpoint para borrar un cliente lógicamente
    @DeleteMapping("/cliente/logico/{id}")
    public ResponseEntity<String> borrarClienteLogico(@PathVariable Integer id) {
        String resultado = clientesService.deleteLogicalById(id);
        if (resultado.equals("Cliente no encontrado")) {
            return ResponseEntity.notFound().build(); // Si el cliente no existe, respondemos con un 404
        }
        return ResponseEntity.ok(resultado); // Si el cliente es borrado lógicamente, devolvemos un 200 con el mensaje
    }

    // Endpoint para obtener clientes activos TRY-CATCH

    @GetMapping("/clientes/activostry")
    public ResponseEntity<List<ClientesEntity>> obtenerClientesActivos() {
        try {
            List<ClientesEntity> clientesActivos = clientesService.getClientesActivosTry();
            if (clientesActivos.isEmpty()) {
                // Si no hay clientes activos, retornamos una respuesta con código 204 (No Content)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // Si encontramos clientes activos, retornamos con código 200 (OK)
            return new ResponseEntity<>(clientesActivos, HttpStatus.OK);
        } catch (Exception e) {
            // En caso de cualquier excepción, retornamos una respuesta de error 500 (Internal Server Error)
            System.err.println("Error al obtener los clientes activos: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para buscar clientes por nombre
    @GetMapping("/clientes/buscarPorNombretry/{nombre}")
    public ResponseEntity<List<ClientesEntity>> obtenerClientesPorNombre(@PathVariable("nombre") String nombre) {
        try {
            List<ClientesEntity> clientes = clientesService.getClientesPorNombreTry(nombre);
            if (clientes.isEmpty()) {
                // Si no hay clientes con el nombre proporcionado, retornamos una respuesta con código 204 (No Content)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // Si encontramos clientes por nombre, retornamos con código 200 (OK)
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            // En caso de cualquier excepción, retornamos una respuesta de error 500 (Internal Server Error)
            System.err.println("Error al buscar clientes por nombre: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint @QUERY para buscar clientes por nombre parcial


    @GetMapping("/clientes/buscarPorNombreContiene/{nombre}")
    public ResponseEntity<List<ClientesEntity>> obtenerClientesPorNombreContiene(@PathVariable("nombre") String nombre) {
        try {
            List<ClientesEntity> clientes = clientesService.getClientesPorNombreContiene(nombre);
            if (clientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // No se encontraron clientes
            }
            return new ResponseEntity<>(clientes, HttpStatus.OK);  // Clientes encontrados
        } catch (Exception e) {
            System.err.println("Error al buscar clientes por nombre: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // Error del servidor
        }

    }
}

