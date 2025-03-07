package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.InventarioEntity;
import ms.tienda_gen14.repository.InventarioRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventarioEntityServiceTest {

    @InjectMocks
    InventarioService inventarioService;

    @Mock
    InventarioRepository inventarioRepository;

    //Inicio de objetos
    List<InventarioEntity> inventarioEntityList;
    private InventarioEntity inventarioEntity;
    private InventarioEntity inventarioEntity2;
    private InventarioEntity inventarioEntity3;


    @BeforeEach
    void setUp(){
        // Código de inicialización antes de cada prueba
        System.out.println("Método setUp");

        // Crear datos de prueba
        inventarioEntity = new InventarioEntity(1, 101, 50, true);
        inventarioEntity2 = new InventarioEntity(2, 102, 30, false);
        inventarioEntity3 = new InventarioEntity(3, 103, 75, true);

        // Inicializar la lista y agregar los inventarios
        inventarioEntityList = new ArrayList<>();
        inventarioEntityList.add(inventarioEntity);
        inventarioEntityList.add(inventarioEntity2);
        inventarioEntityList.add(inventarioEntity3);

    }

    @AfterEach
    void tearDown() {
        // Código de limpieza después de cada prueba
        System.out.println("Método tearDown");
    }


    @Test
    void readAll() {
        // Simular el comportamiento del repositorio para devolver la lista de inventarios completa
        when(inventarioRepository.findAll()).thenReturn(inventarioEntityList);

        // Llamar al método a probar
        List<InventarioEntity> resultado = inventarioService.readAll();

        // Crear la lista esperada de inventarios activos
        List<InventarioEntity> listaEsperada = new ArrayList<>();
        listaEsperada.add(inventarioEntity);
//      listaEsperada.add(inventario2);
        listaEsperada.add(inventarioEntity3);

        // Comparar la lista esperada con el resultado obtenido
        assertEquals(listaEsperada,resultado);
    }


    @Test
    void readById() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.findById(1)).thenReturn(Optional.of(inventarioEntity));

        // Llamar al método a probar
        Optional<InventarioEntity> resultado = inventarioService.readById(1);

        // Verificar el resultado
        assertEquals(Optional.of(inventarioEntity), resultado);
    }

    @Test
    void create() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.save(inventarioEntity)).thenReturn(inventarioEntity);

        // Llamar al método a probar
        InventarioEntity resultado = inventarioService.create(inventarioEntity);

        // Verificar el resultado
        assertEquals(inventarioEntity,resultado);
    }

    @Test
    void update() {

        when(inventarioRepository.save(inventarioEntity)).thenReturn(inventarioEntity);

        InventarioEntity resultado = inventarioService.update(inventarioEntity);

        assertEquals(inventarioEntity,resultado);
    }

    @Test
    void deleteById_True() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.findById(1)).thenReturn(Optional.of(inventarioEntity));
        when(inventarioRepository.save(inventarioEntity)).thenReturn(inventarioEntity);

        // Llamar al método a probar
        String resultado = inventarioService.deleteById(1);

        // Verificar el resultado
        assertEquals("Borrado exitoso" , resultado);
    }

    @Test
    void deleteById_False() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.findById(1)).thenReturn(Optional.empty());

        // Llamar al método a probar
        String resultado = inventarioService.deleteById(1);

        // Verificar el resultado
        assertEquals("No se encontró el registro", resultado);
    }
}