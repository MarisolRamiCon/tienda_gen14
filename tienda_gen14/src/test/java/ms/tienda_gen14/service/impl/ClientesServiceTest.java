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
}