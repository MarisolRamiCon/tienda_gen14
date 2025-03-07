package ms.tienda_gen14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventario")
public class InventarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer idInventario;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
//    private ProductoEntity producto;
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "stock_inventario")
    private Integer stockInventario;

    @Column(name = "active")
    private Boolean active;


}
