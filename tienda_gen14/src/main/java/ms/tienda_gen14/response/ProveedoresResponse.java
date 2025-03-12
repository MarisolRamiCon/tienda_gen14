package ms.tienda_gen14.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProveedoresResponse {


    private Integer idProvedor;
    private String nombreEmpresa;
    private String contacto;
    private String correoElectronico;
    private String telefono;
    private Boolean isActive;
}
