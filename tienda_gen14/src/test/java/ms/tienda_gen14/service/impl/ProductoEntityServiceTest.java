package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.Producto;
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
class ProductoServiceTest {

    @InjectMocks
    ProductoService productoService;

    @Mock
    ProductoRepository productoRepository;

    //Inicio de objetos
    List<Producto> productoList;
    private Producto producto;
    private Producto producto2;
    private Producto producto3;

    @BeforeEach
    void setUp() {
        // Código de inicialización antes de cada prueba
        System.out.println("Método setUp");

        // Crear datos de prueba
        producto = new Producto(1, "Jabón Líquido Antibacterial", "Jabón líquido con propiedades antibacteriales", 50.0, "Higiene Personal", 101, 120, true);
        producto2 = new Producto(2, "Shampoo para Cabello Seco", "Shampoo hidratante para cabello seco", 150.0, "Cuidado del Cabello", 102, 80, true);
        producto3 = new Producto(3, "Pasta de Dientes Blanqueadora", "Pasta dental con efecto blanqueador", 60.0, "Cuidado Bucal", 103, 150, false);

        // Inicializar la lista y agregar los productos
        productoList = new ArrayList<>();
        productoList.add(producto);
        productoList.add(producto2);
        productoList.add(producto3);

    }

    @AfterEach
    void tearDown() {
        // Código de limpieza después de cada prueba
        System.out.println("Método tearDown");
    }

    @Test
    void readAll() {

        // Simular el comportamiento del repositorio para devolver la lista de productos de prueba
        when(productoRepository.findAll()).thenReturn(productoList);

        // Llamar al método a probar
        List<Producto> resultado = productoService.readAll();

        // Crear la lista esperada de productos activos, haciendo la lógica aquí.
        List<Producto> listaEsperada = productoList.stream()
                .filter(Producto::getActive)
                .toList();

        // Comparar la lista esperada con el resultado obtenido
        assertEquals(listaEsperada,resultado);
    }

    @Test
    void readById() {

        // Simular el comportamiento del repositorio
        when(productoRepository.findById(1)).thenReturn(Optional.of(producto));

        // Llamar al método a probar
        Optional<Producto> resultado = productoService.readById(1);

        // Verificar el resultado
        assertEquals(Optional.of(producto), resultado);

    }

    @Test
    void create() {
        // Simular el comportamiento del repositorio
        when(productoRepository.save(producto)).thenReturn(producto);

        // Llamar al método a probar
        Producto resultado = productoService.create(producto);

        // Verificar el resultado
        assertEquals(producto, resultado);
    }

    @Test
    void updateWhenTrue() {
        // Simular el comportamiento del repositorio
        when(productoRepository.findById(producto.getIdProducto())).thenReturn(Optional.of(producto));

        // Simular el comportamiento del repositorio para save
        when(productoRepository.save(producto)).thenReturn(producto);

        // Llamar al método a probar
        Producto resultado = productoService.update(producto);

        // Verificar el resultado
        assertEquals(producto, resultado);
    }

    @Test
    void updateWhenFalse() {
        // Simular el comportamiento del repositorio
        when(productoRepository.findById(producto.getIdProducto())).thenReturn(Optional.empty());

        // Llamar al método a probar
        Producto resultado = productoService.update(producto);

        // Verificar el resultado
        assertEquals(null,resultado);
    }

    @Test
    void deleteById() {
        // Simular el comportamiento del repositorio
        when(productoRepository.findById(1)).thenReturn(Optional.of(producto));

        // Simular el comportamiento del repositorio para save
        when(productoRepository.save(producto)).thenReturn(producto);

        // Llamar al método a probar
        String resultado = productoService.deleteById(1);

        // Verificar el resultado
        assertEquals("Borrado exitoso", resultado);

    }

    @Test
    void testDeleteById_False() {
        when(productoRepository.findById(1)).thenReturn(Optional.empty());

        String resultado = productoService.deleteById(1);

        assertEquals("No se encontró el registro",resultado);
    }
}