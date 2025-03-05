package ms.tienda_gen14.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private String puesto;
}
