package ms.tienda_gen14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes") // Nombre de la tabla en la base de datos
@AllArgsConstructor // Constructor con todos los argumentos (generado por Lombok)
@NoArgsConstructor  // Constructor vacío (generado por Lombok)
@Data               // Genera getters, setters, toString, equals y hashCode (Lombok)
public class ClientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    @Column(name = "id_clientes") // Nombre de la columna en la tabla
    private Integer idClientes;

    @Column(name = "nombre") // Columna para el nombre
    private String nombre;

    @Column(name = "apellido") // Columna para el apellido
    private String apellido;

    @Column(name = "direccion") // Columna para la dirección
    private String direccion;

    @Column(name = "correo_electronico") // Columna para el correo electrónico
    private String correoElectronico;

    @Column(name = "telefono") // Columna para el teléfono
    private String telefono;

    @Column(name = "is_active") // Columna para indicar si el cliente está activo
    private Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL) // Relación ManyToOne con la tabla proveedores
    @JoinColumn(name = "id_provedores") // Columna que hace la relación con la tabla proveedores
    private ProveedoresEntity idProvedor;  // Asocia el cliente con un proveedor específico
}
