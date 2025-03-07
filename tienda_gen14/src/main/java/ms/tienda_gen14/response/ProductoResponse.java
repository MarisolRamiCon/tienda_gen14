package ms.tienda_gen14.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoResponse {
    private Integer idProductoResponse;
    private String nombreProductoResponse;
    private String descripcionProductoResponse;
    private Double precioProductoResponse;
    private String categoriaProductoResponse;
    private Integer stockProductoResponse;

}
