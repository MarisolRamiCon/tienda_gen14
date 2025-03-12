package ms.tienda_gen14.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientesResponse{

    private String nombre;
    private String apellido;
    private Integer idProvedor;
}
