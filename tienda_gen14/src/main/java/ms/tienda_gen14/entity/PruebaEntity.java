package ms.tienda_gen14.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PruebaEntity {
    @Id
    @Column(name = "id")
    private Long id;
}
