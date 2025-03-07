package ms.tienda_gen14.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventarioResponse {
    private Integer idInventarioResponse;
    private Integer IdProductoResponse;
    private Integer stockInventarioResponse;

}
