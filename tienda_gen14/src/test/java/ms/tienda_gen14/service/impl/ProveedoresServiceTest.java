package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.ProveedoresEntity;
import ms.tienda_gen14.repository.ProveedorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProveedoresServiceTest {

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private ProveedoresService proveedoresService;

    private ProveedoresEntity proveedor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicia los mocks
        proveedor = new ProveedoresEntity(1, "Proveedor Test", "Juan Pérez", "juan@test.com", "123456789", true);
    }

    // Prueba para el método readAll
    @Test
    void testReadAll() {
        // Simulamos que el repositorio devuelve una lista de proveedores
        when(proveedorRepository.findAll()).thenReturn(List.of(proveedor));

        List<ProveedoresEntity> result = proveedoresService.readAll();

        // Verificamos que el resultado no es nulo ni vacío
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());  // Comprobamos que se devolvió 1 proveedor

        // Verificamos que se llamó al repositorio
        verify(proveedorRepository).findAll();
    }

    // Prueba para el método readById
    @Test
    void testReadById_ProveedorExistente() {
        // Configurar mock para que devuelva un proveedor cuando se busque por ID
        when(proveedorRepository.findById(1)).thenReturn(Optional.of(proveedor));

        Optional<ProveedoresEntity> result = proveedoresService.readById(1);

        // Verificar que el proveedor existe
        assertTrue(result.isPresent());
        assertEquals(proveedor.getIdProvedor(), result.get().getIdProvedor());

        // Verificar que se llama al repositorio correctamente
        verify(proveedorRepository).findById(1);
    }

    // Prueba para el método create
    @Test
    void testCreate_ProveedorCreado() {
        when(proveedorRepository.save(proveedor)).thenReturn(proveedor);

        ProveedoresEntity result = proveedoresService.create(proveedor);

        assertNotNull(result);
        assertEquals(proveedor.getNombreEmpresa(), result.getNombreEmpresa());

        verify(proveedorRepository).save(proveedor);
    }

    // Prueba para el método update
    @Test
    void testUpdate_ProveedorActualizado() {
        when(proveedorRepository.save(proveedor)).thenReturn(proveedor);

        ProveedoresEntity result = proveedoresService.update(proveedor);

        assertNotNull(result);
        assertEquals(proveedor.getIdProvedor(), result.getIdProvedor());

        verify(proveedorRepository).save(proveedor);
    }

    // Prueba para el método deleteById con proveedor existente
    @Test
    void testDeleteById_ProveedorExistente() {
        when(proveedorRepository.findById(1)).thenReturn(Optional.of(proveedor));

        String result = proveedoresService.deleteById(1);

        assertEquals("Borrado exitosamente", result);

        verify(proveedorRepository).deleteById(1);
    }

    // Prueba para el método deleteById con proveedor no existente
    @Test
    void testDeleteById_ProveedorNoExistente() {
        when(proveedorRepository.findById(1)).thenReturn(Optional.empty());

        String result = proveedoresService.deleteById(1);

        assertEquals("Proveedor no encontrado", result);

        verify(proveedorRepository, never()).deleteById(1);
    }

    // Prueba para obtener proveedores activos
    @Test
    void testFindActiveProveedores() {
        when(proveedorRepository.findByIsActiveTrue()).thenReturn(List.of(proveedor));

        var result = proveedoresService.findActiveProveedores();

        assertNotNull(result);
        assertFalse(result.isEmpty());

        verify(proveedorRepository).findByIsActiveTrue();
    }

    // Prueba para el método findInactiveProveedores
    @Test
    void testFindInactiveProveedores() {
        // Simulamos que el repositorio devuelve una lista de proveedores inactivos
        when(proveedorRepository.findByIsActiveFalse()).thenReturn(List.of(proveedor));

        List<ProveedoresEntity> result = proveedoresService.findInactiveProveedores();

        // Verificamos que el resultado no es nulo ni vacío
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());  // Comprobamos que se devolvió 1 proveedor

        // Verificamos que se llamó al repositorio
        verify(proveedorRepository).findByIsActiveFalse();
    }
}