package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ClientesEntity;
import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.repository.ClientesRepository;
import ms.tienda_gen14.response.ClientesResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ClientesServiceTest {

    @InjectMocks
    private ClientesService clientesService;
    private ClientesEntity clienteEntity;
    private ClientesResponse clienteResponse;

    @Mock
    private ClientesRepository clientesRepository;

    private ClientesEntity cliente;
    private ClientesEntity cliente1;
    private ClientesEntity cliente2;
    private ClientesEntity cliente3;

    private List<ClientesEntity> listaClientesEntity;

    @BeforeEach
    void setUp() {
        ProveedoresEntity proveedor = new ProveedoresEntity(1, "Proveedor Uno", "Contacto Uno", "proveedor@email.com", "123456789", true);

        cliente = new ClientesEntity(1, "Juan", "Perez", "Calle Ficticia 123", "juan@email.com", "1234567890", true, proveedor);
        cliente1 = new ClientesEntity(1, "Juan", "Perez", "Calle Ficticia 123", "juan@email.com", "1234567890", true, proveedor);
        cliente2 = new ClientesEntity(2, "Maria", "Lopez", "Avenida Real 456", "maria@email.com", "0987654321", true, proveedor);
        cliente3 = new ClientesEntity(3, "Pedro", "Gomez", "Calle Secundaria 789", "pedro@email.com", "1122334455", true, proveedor);

        listaClientesEntity = new ArrayList<>();
        listaClientesEntity.add(cliente1);
        listaClientesEntity.add(cliente2);
        listaClientesEntity.add(cliente3);
    }

    // Test para el método readAll()
    @Test
    void testReadAll() {
        when(clientesRepository.findAll()).thenReturn(listaClientesEntity);

        List<ClientesResponse> result = clientesService.readAll();

        assertNotNull(result);
        assertEquals(3, result.size());
        verify(clientesRepository, times(1)).findAll();
    }

    // Test para el método readById()
    @Test
    void testReadById() {
        when(clientesRepository.findById(1)).thenReturn(Optional.of(cliente));

        Optional<ClientesEntity> result = clientesService.readById(1);

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
        verify(clientesRepository, times(1)).findById(1);
    }

    // Test para el método create()
    @Test
    void testCreate() {
        when(clientesRepository.save(cliente)).thenReturn(cliente);

        ClientesEntity result = clientesService.create(cliente);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(clientesRepository, times(1)).save(cliente);
    }

    // Test para el método update()
    @Test
    void testUpdate() {
        when(clientesRepository.save(cliente)).thenReturn(cliente);

        ClientesEntity result = clientesService.update(cliente);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(clientesRepository, times(1)).save(cliente);
    }

    // Test para el método deleteById()
    @Test
    void testDeleteById_ClienteExistente() {
        when(clientesRepository.findById(1)).thenReturn(Optional.of(cliente));

        String result = clientesService.deleteById(1);

        assertEquals("Borrado exitosamente", result);
        verify(clientesRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteById_ClienteNoExistente() {
        when(clientesRepository.findById(1)).thenReturn(Optional.empty());

        String result = clientesService.deleteById(1);

        assertEquals("No está", result);
        verify(clientesRepository, times(1)).findById(1);
    }

    // Test para el método readAllResponse()
    @Test
    void testReadAllResponse() {
        when(clientesRepository.findAll()).thenReturn(listaClientesEntity);

        List<ClientesResponse> result = clientesService.readAllResponse();

        assertNotNull(result);
        assertEquals(3, result.size());
        verify(clientesRepository, times(1)).findAll();
    }

    // Test para el método readByIdResponse()
    @Test
    void testReadByIdResponse() {
        when(clientesRepository.findById(1)).thenReturn(Optional.of(cliente));

        Optional<ClientesResponse> result = clientesService.readByIdResponse(1);

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
        verify(clientesRepository, times(1)).findById(1);
    }

    // Test para el método getClientesActivos()
    @Test
    void testGetClientesActivos() {
        when(clientesRepository.findByIsActiveTrue()).thenReturn(listaClientesEntity);

        List<ClientesEntity> result = clientesService.getClientesActivos();

        assertNotNull(result);
        assertEquals(3, result.size());
        verify(clientesRepository, times(1)).findByIsActiveTrue();
    }

    // Test para el método getClientesPorNombre()
    @Test
    void testGetClientesPorNombre() {
        when(clientesRepository.findByNombre("Juan")).thenReturn(List.of(cliente1, cliente2));

        List<ClientesEntity> result = clientesService.getClientesPorNombre("Juan");

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clientesRepository, times(1)).findByNombre("Juan");
    }

    @Test
    void testDeleteLogicalById_ClienteExistente() {
        // Simulamos que el cliente existe en la base de datos
        when(clientesRepository.findById(1)).thenReturn(Optional.of(cliente));

        // Llamamos al método deleteLogicalById
        String result = clientesService.deleteLogicalById(1);

        // Verificamos que el cliente ha sido marcado como inactivo
        assertEquals("Cliente borrado lógicamente", result);
        assertFalse(cliente.isActive());  // El cliente debe estar inactivo

        // Verificamos que se haya llamado al método save de los repositorios
        verify(clientesRepository, times(1)).save(cliente);  // Se debe llamar al save solo una vez
    }

    @Test
    void testDeleteLogicalById_ClienteNoExistente() {
        // Simulamos que no se encuentra un cliente con ID 1
        when(clientesRepository.findById(1)).thenReturn(Optional.empty());

        // Llamamos al método deleteLogicalById
        String result = clientesService.deleteLogicalById(1);

        // Verificamos que el mensaje devuelto sea el esperado
        assertEquals("Cliente no encontrado", result);

        // Verificamos que el método save no sea llamado porque no hubo actualización
        verify(clientesRepository, times(0)).save(any(ClientesEntity.class));  // El save no debe ser llamado
    }


    @Test
    void testGetClientesActivosTry() {
        // Caso exitoso: Recupera los clientes activos
        when(clientesRepository.findByIsActiveTrue()).thenReturn(listaClientesEntity);

        List<ClientesEntity> result = clientesService.getClientesActivosTry();

        assertNotNull(result);
        assertEquals(3, result.size());
        verify(clientesRepository, times(1)).findByIsActiveTrue();

        // Caso de error: Manejo de excepción y retorno de lista vacía
        when(clientesRepository.findByIsActiveTrue()).thenThrow(new RuntimeException("Error al obtener clientes activos"));

        List<ClientesEntity> resultWithError = clientesService.getClientesActivosTry();

        assertNotNull(resultWithError);
        assertTrue(resultWithError.isEmpty());  // Debe retornar lista vacía en caso de error
        verify(clientesRepository, times(2)).findByIsActiveTrue();  // Verificamos que el método se haya ejecutado dos veces
    }

    @Test
    void testGetClientesPorNombreTry_Success() {
        // Arrange: Simulamos que el repositorio devuelve la lista de clientes con el nombre "Juan"
        when(clientesRepository.findByNombre("Juan")).thenReturn(List.of(cliente, cliente1));

        // Act: Llamamos al método con el nombre "Juan"
        List<ClientesEntity> result = clientesService.getClientesPorNombreTry("Juan");

        // Assert: Verificamos que el resultado no sea nulo y contenga los clientes con ese nombre
        assertNotNull(result);
        assertEquals(2, result.size());  // Esperamos 2 clientes con el nombre "Juan"
        assertEquals("Juan", result.get(0).getNombre());
    }

    @Test
    void testGetClientesPorNombreTry_Exception() {
        // Arrange: Simulamos una excepción al llamar al repositorio
        when(clientesRepository.findByNombre("Juan")).thenThrow(new RuntimeException("Error"));

        // Act: Llamamos al método con el nombre "Juan"
        List<ClientesEntity> result = clientesService.getClientesPorNombreTry("Juan");

        // Assert: Verificamos que el resultado sea una lista vacía
        assertTrue(result.isEmpty());
    }



    //exepcion assertThrows de @Query

    @Test
    void testGetClientesPorNombreContiene_Exception() {
        // Arrange: Simulamos que el repositorio lanza una excepción
        when(clientesRepository.findByNombreContiene("Juan")).thenThrow(new RuntimeException("Error al obtener clientes"));

        // Act y Assert: Verificamos que la excepción sea lanzada
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clientesService.getClientesPorNombreContiene("Juan");
        });

        // Asegúrate de que el mensaje de la excepción sea el esperado
        assertEquals("Error al obtener clientes", exception.getMessage());
    }



}