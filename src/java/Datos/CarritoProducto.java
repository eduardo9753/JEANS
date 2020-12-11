package Datos;

public class CarritoProducto {

     private int catidadProducto;
     private int idProducto;
     private String nombre;
     private String imagen;
     private String descripcion;
     private double precio;
     private int categoria;
     private int estado;

     private int cantidad;
     private double subtotal;

    public CarritoProducto() {
    }

    public CarritoProducto(int catidadProducto, int idProducto, String nombre, String imagen, String descripcion, double precio, int categoria, int estado, int cantidad, double subtotal) {
        this.catidadProducto = catidadProducto;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getCatidadProducto() {
        return catidadProducto;
    }

    public void setCatidadProducto(int catidadProducto) {
        this.catidadProducto = catidadProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "CarritoProducto{" + "catidadProducto=" + catidadProducto + ", idProducto=" + idProducto + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion + ", precio=" + precio + ", categoria=" + categoria + ", estado=" + estado + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }

    public double Costo(){
        return precio*cantidad;
    }
}
