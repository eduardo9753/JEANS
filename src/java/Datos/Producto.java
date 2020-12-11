package Datos;

public class Producto {

     private int idProducto;
     private String Nombres;
     private String imagen;
     private String Descripcion;
     private double Precio;
     private int stock;
     private int Idcategoria;
     private int Idestado;
     
     //opcionales para ver los nombres
     private String categoria;
     private String estado;

    public Producto() {
    }

    public Producto(int idProducto, String Nombres, String imagen, String Descripcion, double Precio, int stock, int Idcategoria, int Idestado, String categoria, String estado) {
        this.idProducto = idProducto;
        this.Nombres = Nombres;
        this.imagen = imagen;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.stock = stock;
        this.Idcategoria = Idcategoria;
        this.Idestado = Idestado;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdcategoria() {
        return Idcategoria;
    }

    public void setIdcategoria(int Idcategoria) {
        this.Idcategoria = Idcategoria;
    }

    public int getIdestado() {
        return Idestado;
    }

    public void setIdestado(int Idestado) {
        this.Idestado = Idestado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", Nombres=" + Nombres + ", imagen=" + imagen + ", Descripcion=" + Descripcion + ", Precio=" + Precio + ", stock=" + stock + ", Idcategoria=" + Idcategoria + ", Idestado=" + Idestado + ", categoria=" + categoria + ", estado=" + estado + '}';
    }
     

  
   
}
