package ms.tienda_gen14.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empleados {
    private Integer id;
    private String creado;
    private String nombre;
    private String ciudad;
    private String fechanacimiento;
    private String numerotelefonico;

}
