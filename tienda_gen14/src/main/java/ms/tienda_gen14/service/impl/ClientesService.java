package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ClientesEntity;
import ms.tienda_gen14.repository.ClientesRepository;
import ms.tienda_gen14.response.ClientesResponse;
import ms.tienda_gen14.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesService implements IClientesService {// Cambiado a ClientesService

    @Autowired
    ClientesRepository clientesRepository; // Cambiado a clientesRepository

    //@Override

    // public List<ClientesResponse> readAll() {
    //   return ClientesRepository.findAll(); // Obtener todos los clientes
    //}
    @Override
    public List<ClientesResponse> readAll(){
        List<ClientesResponse> List=new ArrayList<>();

        List=clientesRepository.findAll().stream().map(clientesEntity ->
        {
            ClientesResponse clientesResponse =
                    new ClientesResponse(clientesEntity.getNombre(), clientesEntity.getApellido(),
                            clientesEntity.getIdProvedor().getIdProvedor()); //Agregas los atributos que quieres mostrar en pantalla
            return clientesResponse;
        }).toList();
        return List;

    }

    @Override
    public Optional<ClientesEntity> readById(Integer id) {
        Optional<ClientesEntity> clientes = clientesRepository.findById(id); // Cambiado a persona
        return clientes;
    }



    @Override
    public ClientesEntity create(ClientesEntity clientesEntity) { // Cambiado a Clientes
        return clientesRepository.save(clientesEntity);  // Guardar cliente en la base de datos
    }

    @Override
    public ClientesEntity update(ClientesEntity clientesEntity) { // Cambiado a Clientes
        return clientesRepository.save(clientesEntity);  // Actualizar cliente en la base de datos
    }

    @Override
    public String deleteById(Integer id) { // Cambiado de delateById a deleteById
        Optional<ClientesEntity> cliente = clientesRepository.findById(id); // Cambiado a cliente
        if (cliente.isPresent()) {
            clientesRepository.deleteById(id);  // Eliminar el cliente
            return "Borrado exitosamente";
        } else {
            return "No está";
        }
    }

    // Aquí puedes agregar métodos adicionales para la entidad Clientes

    // Método personalizado para obtener clientes activos
    public List<ClientesEntity> getClientesActivos() {
        return clientesRepository.findByIsActiveTrue();
    }

    // Método personalizado para buscar clientes por nombre
    public List<ClientesEntity> getClientesPorNombre(String nombre) {
        return clientesRepository.findByNombre(nombre);
    }


    //METODOS RESPONSE



    // Método para obtener todos los clientes y devolverlos como ClientesResponse
    @Override
    public List<ClientesResponse> readAllResponse() {
        List<ClientesEntity> clientes = clientesRepository.findAll();
        return clientes.stream().map(cliente -> new ClientesResponse(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getIdProvedor().getIdProvedor() // Asumimos que idProvedor es una relación ManyToOne con la entidad Proveedores
        )).collect(Collectors.toList());
    }


    // Método para obtener un cliente por su ID y devolverlo como ClientesResponse
    @Override
    public Optional<ClientesResponse> readByIdResponse(Integer id) {
        Optional<ClientesEntity> cliente = clientesRepository.findById(id);
        return cliente.map(c -> new ClientesResponse(
                c.getNombre(),
                c.getApellido(),
                c.getIdProvedor().getIdProvedor()
        ));
    }

    //Borrado logico



    // Método para realizar el borrado lógico de un cliente

    public String deleteLogicalById(Integer id) {
        Optional<ClientesEntity> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()) {
            ClientesEntity clienteEntity = cliente.get();
            clienteEntity.setIsActive(false);  // Marcamos el cliente como inactivo
            clientesRepository.save(clienteEntity); // Guardamos los cambios en la base de datos
            return "Cliente borrado lógicamente";
        } else {
            return "Cliente no encontrado";
        }
    }

    //MTODOS TRI-CACH

    // Método personalizado para obtener clientes activos

    public List<ClientesEntity> getClientesActivosTry() {
        try {
            return clientesRepository.findByIsActiveTrue();
        } catch (Exception e) {
            // Capturamos cualquier error al obtener clientes activos
            System.err.println("Error al obtener clientes activos: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();  // Retornamos una lista vacía en caso de error
        }
    }

    // Método personalizado para buscar clientes por nombre

    public List<ClientesEntity> getClientesPorNombreTry(String nombre) {
        try {
            return clientesRepository.findByNombre(nombre);
        } catch (Exception e) {
            // Capturamos cualquier error al buscar clientes por nombre
            System.err.println("Error al obtener clientes por nombre: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();  // Retornamos una lista vacía en caso de error
        }
    }

    // Método @QUERY que utiliza la consulta personalizada para obtener clientes por nombre parcial

    public List<ClientesEntity> getClientesPorNombreContiene(String nombre) {
        return clientesRepository.findByNombreContiene(nombre);
    }



}
