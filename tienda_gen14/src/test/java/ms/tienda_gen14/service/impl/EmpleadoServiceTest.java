package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.Empleado;
import ms.tienda_gen14.repository.EmpleadoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class EmpleadoServiceTest {
    @InjectMocks
    EmpleadoService empleadoService;

    @Mock
    EmpleadoRepository empleadoRepository;

    private List<Empleado> lista = new ArrayList<>();
    private Empleado empleado;
    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;

    @BeforeEach
    void setUp() {
        empleado = new Empleado(8,"Adrian","Buendia","FrontEndDeveloper",15000.0,"2021-06-12",true);
        empleado1 = new Empleado(7,"Jorge","Sanchez","Supervisor TI",20000.0,"2022-03-21",true);
        empleado2 = new Empleado(2,"isai","hernandez","administrador",15000.0,"2025-03-20",true);
        empleado3 = new Empleado(2,"cesar","ocampo","administrador",15000.0,"2024-01-26",true);

        lista.add(empleado);
        lista.add(empleado1);
        lista.add(empleado2);
        lista.add(empleado3);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void readAll() {
        Mockito.when(empleadoRepository.findAll()).thenReturn(lista);
        List<Empleado> res = empleadoService.readAll();
        List<Empleado> listaEsperada = new ArrayList<>();
        listaEsperada.add(empleado);
        listaEsperada.add(empleado1);
        listaEsperada.add(empleado2);
        listaEsperada.add(empleado3);

        Assertions.assertEquals(listaEsperada,res);


    }


    @Test
    void readById() {
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleado));
        Optional<Empleado> res = empleadoService.readById(1);
        Assertions.assertEquals(empleado,res.get());
    }

    @Test
    void deleteById_True() {
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleado));
        Mockito.when(empleadoRepository.save(empleado)).thenReturn(empleado);

        assertEquals("borrado exitosamente" ,  empleadoService.deleteById(1));
    }

    @Test
    void deleteById_False(){
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.empty());
        assertEquals("No esta" ,  empleadoService.deleteById(1));
    }

    @Test
    void createEmpleado() {
        Mockito.when(empleadoRepository.save(empleado)).thenReturn(empleado);
        Empleado resp = empleadoService.createEmpleado(empleado);
        Assertions.assertEquals(empleado,resp);
    }

    @Test
    void update() {
        Empleado emple = new Empleado(9,"Adrian","Buendia","FrontEndDeveloper",15000.0,"2021-06-12",true);
        Mockito.when(empleadoRepository.save(emple)).thenReturn(empleado1);

        Empleado resp = empleadoService.createEmpleado(emple);
        System.out.println(resp);
        Assertions.assertEquals(empleado1,resp);
    }

    @Test
    void activoIgual() {
        Mockito.when(empleadoRepository.findByActivoEquals(true)).thenReturn(lista);
        List<Empleado> res = empleadoService.activoIgual(true);
        Assertions.assertEquals(lista,res);

    }

    @Test
    void fechas() {
        Mockito.when(empleadoRepository.fechas("2021-06-11",15000.0)).thenReturn(lista);
        List<Empleado> res = empleadoService.fechas("2021-06-11",15000.0);
        List<Empleado> listaEsperada = new ArrayList<>();
        listaEsperada.add(empleado);
        listaEsperada.add(empleado1);
        listaEsperada.add(empleado2);
        listaEsperada.add(empleado3);
        Assertions.assertEquals(listaEsperada,res);

    }
}