package ms.tienda_gen14.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

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
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    @Column(name = "stock_producto")
    private Integer stockProducto;
    @Column(name = "active")
    private Boolean active;

    public Producto() {
    }

    public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, Double precioProducto, String categoriaProducto, Integer idProveedor, Integer stockProducto, Boolean active) {
        IdProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.categoriaProducto = categoriaProducto;
        this.idProveedor = idProveedor;
        this.stockProducto = stockProducto;
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer idProducto) {
        IdProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(Integer stockProducto) {
        this.stockProducto = stockProducto;
    }
}
