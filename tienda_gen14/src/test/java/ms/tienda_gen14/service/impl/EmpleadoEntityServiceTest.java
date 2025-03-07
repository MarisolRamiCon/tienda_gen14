package ms.tienda_gen14.service.impl;

import ms.tienda_gen14.entity.EmpleadoEntity;
import ms.tienda_gen14.repository.EmpleadoRepository;
import ms.tienda_gen14.response.EmpleadoResponse;
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

@ExtendWith(MockitoExtension.class)
class EmpleadoEntityServiceTest {
    @InjectMocks
    EmpleadoService empleadoService;

    @Mock
    EmpleadoRepository empleadoRepository;

    private List<EmpleadoEntity> lista = new ArrayList<>();
    private List<EmpleadoResponse> lista1 = new ArrayList<>();
    private List<EmpleadoResponse> listaEsperada = new ArrayList<>();
    private EmpleadoEntity empleadoEntity;
    private EmpleadoEntity empleadoEntity1;
    private EmpleadoEntity empleadoEntity2;
    private EmpleadoEntity empleadoEntity3;

    private EmpleadoResponse empleados;
    private EmpleadoResponse empleados1;
    private EmpleadoResponse empleados2;
    private EmpleadoResponse empleados3;

    @BeforeEach
    void setUp() {
        empleadoEntity = new EmpleadoEntity(8,"Adrian","Buendia","FrontEndDeveloper",15000.0,"2021-06-12",true);
        empleadoEntity1 = new EmpleadoEntity(7,"Jorge","Sanchez","Supervisor TI",20000.0,"2022-03-21",true);
        empleadoEntity2 = new EmpleadoEntity(2,"isai","hernandez","administrador",15000.0,"2025-03-20",true);
        empleadoEntity3 = new EmpleadoEntity(2,"cesar","ocampo","administrador",15000.0,"2024-01-26",true);

        empleados = new EmpleadoResponse(8,"Adrian","Buendia","FrontEndDeveloper");
        empleados1 = new EmpleadoResponse(7,"Jorge","Sanchez","Supervisor TI");
        empleados2 = new EmpleadoResponse(2,"isai","hernandez","administrador");
        empleados3 = new EmpleadoResponse(2,"cesar","ocampo","administrador");

        lista.add(empleadoEntity);
        lista.add(empleadoEntity1);
        lista.add(empleadoEntity2);
        lista.add(empleadoEntity3);

        listaEsperada.add(empleados);
        listaEsperada.add(empleados1);
        listaEsperada.add(empleados2);
        listaEsperada.add(empleados3);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void readAll() {
        Mockito.when(empleadoRepository.findAll()).thenReturn(lista);
        List<EmpleadoEntity> listaEsperada = new ArrayList<>();
        listaEsperada.add(empleadoEntity);
        listaEsperada.add(empleadoEntity1);
        listaEsperada.add(empleadoEntity2);
        listaEsperada.add(empleadoEntity3);
        Assertions.assertEquals(listaEsperada,empleadoService.readAll());
    }
    @Test
     void readAllFal(){
       Mockito.when(empleadoRepository.findAll()).thenThrow(new RuntimeException("Algo salio mal"));
       RuntimeException exception = assertThrows(RuntimeException.class,()->{
           empleadoService.readAll();
       });
        Assertions.assertEquals("Algo salio mal",exception.getMessage());
    }


    @Test
    void readById() {
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleadoEntity));
        Optional<EmpleadoEntity> res = empleadoService.readById(1);
        Assertions.assertEquals(empleadoEntity,res.get());
    }

    @Test
    void readByIdFalse(){
        Mockito.when(empleadoRepository.findById(10)).thenThrow(new RuntimeException("Algo salio mal"));
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            empleadoService.readById(10);
        });
        Assertions.assertEquals("Algo salio mal", exception.getMessage());
    }

    @Test
    void deleteById_True() {
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.of(empleadoEntity));
        Mockito.when(empleadoRepository.save(empleadoEntity)).thenReturn(empleadoEntity);

        assertEquals("borrado exitosamente" ,  empleadoService.deleteById(1));
    }

    @Test
    void deleteById_False(){
        Mockito.when(empleadoRepository.findById(1)).thenReturn(Optional.empty());
        assertEquals("No esta" ,  empleadoService.deleteById(1));
    }

    @Test
    void createEmpleado() {
        Mockito.when(empleadoRepository.save(empleadoEntity)).thenReturn(empleadoEntity);
        EmpleadoEntity resp = empleadoService.createEmpleado(empleadoEntity);
        Assertions.assertEquals(empleadoEntity,resp);
    }
    @Test
    void createEmpleadoFalse() {
        Mockito.when(empleadoRepository.save(empleadoEntity)).thenThrow(new RuntimeException("Algo salio mal"));
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            empleadoService.createEmpleado(empleadoEntity);
        });
        Assertions.assertEquals("Algo salio mal",exception.getMessage());
    }

    @Test
    void update() {
        EmpleadoEntity emple = new EmpleadoEntity(9,"Adrian","Buendia","FrontEndDeveloper",15000.0,"2021-06-12",true);
        Mockito.when(empleadoRepository.save(emple)).thenReturn(empleadoEntity1);
        EmpleadoEntity resp = empleadoService.update(emple);
        Assertions.assertEquals(empleadoEntity1,resp);
    }

    @Test
    void updateFalse() {
        EmpleadoEntity emple = new EmpleadoEntity(9,"Adrian","Buendia","FrontEndDeveloper",15000.0,"2021-06-12",true);
        Mockito.when(empleadoRepository.save(emple)).thenThrow(new RuntimeException("Algo salio mal"));
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            empleadoService.update(empleadoEntity);
        });
        Assertions.assertEquals("Algo salio mal",exception.getMessage());
    }

    @Test
    void activo() {
        Mockito.when(empleadoRepository.findByactivoTrue()).thenReturn(lista);
        List<EmpleadoEntity> res = empleadoService.activo();
        Assertions.assertEquals(lista,res);

    }
    @Test
    void activoFalse() {
        Mockito.when(empleadoRepository.findByactivoTrue()).thenThrow(new RuntimeException("Algo salio mal"));
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            empleadoService.activo();
        });
        Assertions.assertEquals("Algo salio mal",exception.getMessage());

    }

    @Test
    void fechas() {
        Mockito.when(empleadoRepository.fechas("2021-06-11",15000.0)).thenReturn(lista);
        List<EmpleadoEntity> res = empleadoService.fechas("2021-06-11",15000.0);
        List<EmpleadoEntity> listaEsperada = new ArrayList<>();
        listaEsperada.add(empleadoEntity);
        listaEsperada.add(empleadoEntity1);
        listaEsperada.add(empleadoEntity2);
        listaEsperada.add(empleadoEntity3);
        Assertions.assertEquals(listaEsperada,res);

    }
    @Test
    void fechasFalse() {
        Mockito.when(empleadoRepository.fechas("2021-06-11",15000.0)).thenThrow(new RuntimeException("Algo salio mal"));
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            empleadoService.fechas("2021-06-11",15000.0);
        });
        Assertions.assertEquals("Algo salio mal",exception.getMessage());

    }

    @Test
    void all() {
        Mockito.when(empleadoRepository.findAll()).thenReturn(lista);
        System.out.println(empleadoService.All());
        Assertions.assertEquals(listaEsperada,empleadoService.All());
    }

    @Test
    void allEx(){
        Mockito.when(empleadoRepository.findAll()).thenThrow(new RuntimeException("Algo salio mal"));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            empleadoService.All();
        });
        Assertions.assertEquals("Algo salio mal",exception.getMessage());
    }
}