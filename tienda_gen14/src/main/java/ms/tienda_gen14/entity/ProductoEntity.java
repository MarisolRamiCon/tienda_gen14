package ms.tienda_gen14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer IdProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @Column(name = "precio")
    private Double precioProducto;

    @Column(name = "categoria")
    private String categoriaProducto;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_provedores")
//    private Proveedores proveedoresEntity;
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "stock_producto")
    private Integer stockProducto;

    @Column(name = "active")
    private Boolean active;


//    @OneToOne(mappedBy = "producto")
//    private InventarioEntity inventario;
}
