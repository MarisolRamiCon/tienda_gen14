package ms.tienda_gen14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer idInventario;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "stock_inventario")
    private Integer stockInventario;

    @Column(name = "active")
    private Boolean active;

    public Inventario() {
    }

    public Inventario(Integer idInventario, Integer idProducto, Integer stockInventario, Boolean active) {
        this.idInventario = idInventario;
        this.idProducto = idProducto;
        this.stockInventario = stockInventario;
        this.active = active;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getStockInventario() {
        return stockInventario;
    }

    public void setStockInventario(Integer stockInventario) {
        this.stockInventario = stockInventario;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
