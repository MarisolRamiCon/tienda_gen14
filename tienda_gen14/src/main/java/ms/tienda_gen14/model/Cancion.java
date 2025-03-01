package ms.tienda_gen14.model;

public class Cancion {
    private Long id;
    private String nombre;
    private String genero;
    private Double precio;


    public Cancion() {
    }

    public Cancion(Long id, String nombre, String genero, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
