
package modelo;


public class Productos {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;

    public Productos() {
    }

    public Productos(int id, String nombre, String categoria, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public Productos(String nombre, String categoria, int cantidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" + "id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", cantidad=" + cantidad + '}';
    }
    
    
}
