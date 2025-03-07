package ms.tienda_gen14.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import ms.tienda_gen14.entity.Inventario;
import ms.tienda_gen14.entity.Producto;
import ms.tienda_gen14.repository.InventarioRepository;
import ms.tienda_gen14.repository.ProductoRepository;
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
class InventarioServiceTest {

    @InjectMocks
    InventarioService inventarioService;

    @Mock
    InventarioRepository inventarioRepository;

    //Inicio de objetos
    List<Inventario> inventarioList;
    private Inventario inventario;
    private Inventario inventario2;
    private Inventario inventario3;


    @BeforeEach
    void setUp(){
        // Código de inicialización antes de cada prueba
        System.out.println("Método setUp");

        // Crear datos de prueba
        inventario = new Inventario(1, 101, 50, true);
        inventario2 = new Inventario(2, 102, 30, false);
        inventario3 = new Inventario(3, 103, 75, true);

        // Inicializar la lista y agregar los inventarios
        inventarioList = new ArrayList<>();
        inventarioList.add(inventario);
        inventarioList.add(inventario2);
        inventarioList.add(inventario3);

    }

    @AfterEach
    void tearDown() {
        // Código de limpieza después de cada prueba
        System.out.println("Método tearDown");
    }


    @Test
    void readAll() {
        // Simular el comportamiento del repositorio para devolver la lista de inventarios completa
        when(inventarioRepository.findAll()).thenReturn(inventarioList);

        // Llamar al método a probar
        List<Inventario> resultado = inventarioService.readAll();

        // Crear la lista esperada de inventarios activos
        List<Inventario> listaEsperada = new ArrayList<>();
        listaEsperada.add(inventario);
//      listaEsperada.add(inventario2);
        listaEsperada.add(inventario3);

        // Comparar la lista esperada con el resultado obtenido
        assertEquals(listaEsperada,resultado);
    }


    @Test
    void readById() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.findById(1)).thenReturn(Optional.of(inventario));

        // Llamar al método a probar
        Optional<Inventario> resultado = inventarioService.readById(1);

        // Verificar el resultado
        assertEquals(Optional.of(inventario), resultado);
    }

    @Test
    void create() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.save(inventario)).thenReturn(inventario);

        // Llamar al método a probar
        Inventario resultado = inventarioService.create(inventario);

        // Verificar el resultado
        assertEquals(inventario,resultado);
    }

    @Test
    void update() {

        when(inventarioRepository.save(inventario)).thenReturn(inventario);

        Inventario resultado = inventarioService.update(inventario);

        assertEquals(inventario,resultado);
    }

    @Test
    void deleteById_True() {
        // Simular el comportamiento del repositorio
        when(inventarioRepository.findById(1)).thenReturn(Optional.of(inventario));
        when(inventarioRepository.save(inventario)).thenReturn(inventario);

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