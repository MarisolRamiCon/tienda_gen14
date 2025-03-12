package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.feign.TiendaClient;
import ms.tienda_gen14.model.Tienda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TiendaServiceTest {

    @Mock
    private TiendaClient tiendaClient; // Mock del cliente Feign

    @InjectMocks
    private TiendaService tiendaService; // Servicio bajo prueba

    private Tienda tienda1;
    private Tienda tienda2;

    @BeforeEach
    public void setUp() {
        // Preparar datos de ejemplo para las pruebas
        tienda1 = new Tienda(1L, "Tienda 1", "Ubicación 1");
        tienda2 = new Tienda(2L, "Tienda 2", "Ubicación 2");
    }

    @Test
    public void testGetData() {
        // Configurar el mock para que devuelva una lista de tiendas
        when(tiendaClient.getData()).thenReturn(Arrays.asList(tienda1, tienda2));

        // Llamar al método del servicio
        List<Tienda> tiendas = tiendaService.getData();

        // Verificar que la lista devuelta contiene las tiendas esperadas
        assertNotNull(tiendas);
        assertEquals(2, tiendas.size());
        assertTrue(tiendas.contains(tienda1));
        assertTrue(tiendas.contains(tienda2));
    }

    @Test
    public void testGetById() {
        // Configurar el mock para que devuelva una tienda por ID
        when(tiendaClient.getDataById(anyLong())).thenReturn(tienda1);

        // Llamar al método del servicio
        Tienda tienda = tiendaService.getById(1L);

        // Verificar que la tienda devuelta sea la esperada
        assertNotNull(tienda);
        assertEquals(1L, tienda.getId());
        assertEquals("Tienda 1", tienda.getEstablecimiento());
        assertEquals("Ubicación 1", tienda.getLugar());
    }

    @Test
    public void testCreateTienda() {
        // Configurar el mock para que devuelva la tienda creada
        when(tiendaClient.createTienda(any(Tienda.class))).thenReturn(tienda1);

        // Llamar al método del servicio
        Tienda nuevaTienda = tiendaService.createTienda(tienda1);

        // Verificar que la tienda devuelta es la misma que la creada
        assertNotNull(nuevaTienda);
        assertEquals(tienda1.getId(), nuevaTienda.getId());
        assertEquals(tienda1.getEstablecimiento(), nuevaTienda.getEstablecimiento());
    }

    @Test
    public void testUpdateTienda() {
        // Configurar el mock para que devuelva la tienda actualizada
        when(tiendaClient.updateTienda(anyLong(), any(Tienda.class))).thenReturn(tienda1);

        // Llamar al método del servicio
        Tienda tiendaActualizada = tiendaService.updateTienda(1L, tienda1);

        // Verificar que la tienda devuelta es la misma que la actualizada
        assertNotNull(tiendaActualizada);
        assertEquals(tienda1.getId(), tiendaActualizada.getId());
        assertEquals(tienda1.getEstablecimiento(), tiendaActualizada.getEstablecimiento());
    }

    @Test
    public void testDeleteTienda() {
        // Configurar el mock para que la llamada no haga nada
        Mockito.doNothing().when(tiendaClient).deleteTienda(anyLong());

        // Llamar al método del servicio
        tiendaService.deleteTienda(1L);

        // Verificar que la llamada se haya hecho correctamente
        Mockito.verify(tiendaClient, Mockito.times(1)).deleteTienda(1L);
    }
}