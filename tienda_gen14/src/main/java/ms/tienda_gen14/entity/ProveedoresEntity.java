package ms.tienda_gen14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")  // Nombre de la tabla en la base de datos
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProveedoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provedores")  // Nombre de la columna en la base de datos
    private Integer idProvedor;  // Identificador único del proveedor

    @Column(name = "nombre_empresa", nullable = false)  // Nombre de la empresa (no puede ser nulo)
    private String nombreEmpresa;

    @Column(name = "contacto", nullable = false)  // Nombre del contacto (no puede ser nulo)
    private String contacto;

    @Column(name = "correo_electronico", unique = true)  // Correo electrónico (debe ser único)
    private String correoElectronico;

    @Column(name = "telefono")  // Número de teléfono
    private String telefono;

    @Column(name = "is_active", columnDefinition = "boolean default true")  // Indica si el proveedor está activo
    private Boolean isActive;



}
