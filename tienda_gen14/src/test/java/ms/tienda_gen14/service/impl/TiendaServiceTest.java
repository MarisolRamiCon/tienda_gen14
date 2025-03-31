import ms.tienda_gen14.feign.TiendaClient;
import ms.tienda_gen14.model.Tienda;
import ms.tienda_gen14.service.impl.TiendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TiendaServiceTest {

    @Mock
    private TiendaClient tiendaClient;

    @InjectMocks
    private TiendaService tiendaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetData() {
        // Configura el comportamiento del mock
        Tienda tienda1 = new Tienda();
        tienda1.setActivo(true);

        Tienda tienda2 = new Tienda();
        tienda2.setActivo(false);

        when(tiendaClient.getData()).thenReturn(Arrays.asList(tienda1, tienda2));

        // Llama al método que estás probando
        List<Tienda> result = tiendaService.getData();

        // Verifica que el resultado es el esperado
        assertNotNull(result);
        assertEquals(1, result.size()); // Solo debe devolver la tienda activa

        // Verifica que el mock fue llamado
        verify(tiendaClient, times(1)).getData();
    }

    @Test
    void testGetById() {
        Long tiendaId = 1L;
        Tienda tienda = new Tienda();
        tienda.setId(tiendaId);
        tienda.setActivo(true);

        // Configurar el comportamiento esperado del mock
        when(tiendaClient.getDataById(tiendaId)).thenReturn(tienda);

        // Ejecutar el método a probar
        Tienda result = tiendaService.getById(tiendaId);

        // Verificar que el resultado no es nulo y que la tienda es la correcta
        assertNotNull(result, "La tienda obtenida no debe ser nula.");
        assertEquals(tienda, result, "La tienda obtenida debe ser igual a la tienda con el ID dado.");

        // Verificar que el método del cliente fue llamado
        verify(tiendaClient).getDataById(tiendaId);
    }
    @Test
    void testGetByIdNotFound() {
        Long tiendaId = 1L;

        // Configurar el comportamiento esperado del mock para devolver null
        when(tiendaClient.getDataById(tiendaId)).thenReturn(null);

        // Ejecutar el método a probar
        Tienda result = tiendaService.getById(tiendaId);

        // Verificar que el resultado es nulo
        assertNull(result, "La tienda obtenida debería ser nula cuando no se encuentra en la base de datos.");

        // Verificar que el método del cliente fue llamado
        verify(tiendaClient).getDataById(tiendaId);
    }
    @Test
    void testGetByIdThrowsException() {
        Long tiendaId = 1L;

        // Configurar el comportamiento del mock para lanzar una excepción
        when(tiendaClient.getDataById(tiendaId)).thenThrow(new RuntimeException("Error al obtener la tienda"));

        // Ejecutar el método a probar y verificar que lanza la excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> tiendaService.getById(tiendaId));
        assertEquals("Error al obtener la tienda con ID: " + tiendaId, exception.getMessage());
    }

    @Test
    void testCreateTienda() {
        Tienda tienda = new Tienda();
        tienda.setId(1L);
        tienda.setActivo(true);

        // Configurar el comportamiento esperado del mock para crear una tienda
        when(tiendaClient.createTienda(tienda)).thenReturn(tienda);

        // Ejecutar el método a probar
        Tienda result = tiendaService.createTienda(tienda);

        // Verificar que el resultado no es nulo y que la tienda es la correcta
        assertNotNull(result, "La tienda creada no debe ser nula.");
        assertEquals(tienda, result, "La tienda creada debe ser igual a la tienda que se pasa como parámetro.");

        // Verificar que el método del cliente fue llamado
        verify(tiendaClient).createTienda(tienda);
    }

    @Test
    void testCreateTiendaThrowsException() {
        Tienda tienda = new Tienda();
        tienda.setActivo(true);

        // Configurar el comportamiento del mock para lanzar una excepción
        when(tiendaClient.createTienda(tienda)).thenThrow(new RuntimeException("Error al crear la tienda"));

        // Ejecutar el método a probar y verificar que lanza la excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> tiendaService.createTienda(tienda));
        assertEquals("Error al crear la tienda", exception.getMessage());
    }
    @Test
    void testCreateTiendaNullResponse() {
        Tienda tienda = new Tienda();
        tienda.setActivo(true);

        // Configurar el comportamiento esperado del mock para devolver null
        when(tiendaClient.createTienda(tienda)).thenReturn(null);

        // Ejecutar el método a probar
        Tienda result = tiendaService.createTienda(tienda);

        // Verificar que el resultado es nulo, o realizar otra validación si es necesario
        assertNull(result, "La tienda creada debería ser nula cuando el cliente devuelve null.");
    }

    @Test
    void testUpdateTienda() {
        Long id = 1L;
        Tienda tienda = new Tienda();
        tienda.setId(id);
        tienda.setActivo(true);

        // Configurar el comportamiento esperado del mock para actualizar la tienda
        when(tiendaClient.updateTienda(id, tienda)).thenReturn(tienda);

        // Ejecutar el método a probar
        Tienda result = tiendaService.updateTienda(id, tienda);

        // Verificar que el resultado no es nulo y que la tienda es la correcta
        assertNotNull(result, "La tienda actualizada no debe ser nula.");
        assertEquals(tienda, result, "La tienda actualizada debe ser igual a la tienda que se pasa como parámetro.");

        // Verificar que el método del cliente fue llamado con los parámetros correctos
        verify(tiendaClient).updateTienda(id, tienda);
    }

    @Test
    void testUpdateTiendaThrowsException() {
        Long id = 1L;
        Tienda tienda = new Tienda();
        tienda.setId(id);
        tienda.setActivo(true);

        // Configurar el comportamiento del mock para lanzar una excepción
        when(tiendaClient.updateTienda(id, tienda)).thenThrow(new RuntimeException("Error al actualizar la tienda"));

        // Ejecutar el método a probar y verificar que lanza la excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> tiendaService.updateTienda(id, tienda));
        assertEquals("Error al actualizar la tienda con ID: " + id, exception.getMessage());
    }


    @Test
    void testUpdateTiendaNullResponse() {
        Long id = 1L;
        Tienda tienda = new Tienda();
        tienda.setId(id);
        tienda.setActivo(true);

        // Configurar el comportamiento del mock para devolver null
        when(tiendaClient.updateTienda(id, tienda)).thenReturn(null);

        // Ejecutar el método a probar
        Tienda result = tiendaService.updateTienda(id, tienda);

        // Verificar que el resultado es nulo
        assertNull(result, "La tienda actualizada debería ser nula cuando el cliente devuelve null.");
    }


    @Test
    void testDeleteTiendaNoUpdateIfNotFound() {
        Long id = 1L;

        // Configurar el mock para simular que la tienda no existe (devuelve null)
        when(tiendaClient.getDataById(id)).thenReturn(null);

        // Ejecutar el método
        tiendaService.deleteTienda(id);

        // Verificar que el método updateTienda NO fue llamado
        verify(tiendaClient, never()).updateTienda(any(), any());
    }

    @Test
    void testDeleteTiendaUpdateIfFound() {
        Long id = 1L;
        Tienda tienda = new Tienda();
        tienda.setId(id);
        tienda.setActivo(true);  // La tienda está activa inicialmente

        // Configurar el mock para devolver una tienda existente
        when(tiendaClient.getDataById(id)).thenReturn(tienda);

        // Ejecutar el método
        tiendaService.deleteTienda(id);

        // Verificar que el método updateTienda fue llamado con la tienda actualizada
        verify(tiendaClient).updateTienda(eq(id), eq(tienda));

        // Verificar que el estado de la tienda haya cambiado a 'no activo'
        assertFalse(tienda.isActivo());
    }




}

