package Datos;

import java.util.List;

public class Compras {

    private int idCompras;
    private String Dni;//foranea tabla cliente
    private String FechaCompras;
    private double Monto;
    private String Estado;
    private int estado_compras;
   //lista de mi carrito para llenar la tabla detalle compras
    private List<CarritoProducto> DetalleCompras;

    public Compras() {
    }

    public Compras(int idCompras, String Dni, String FechaCompras, double Monto, String Estado, int estado_compras, List<CarritoProducto> DetalleCompras) {
        this.idCompras = idCompras;
        this.Dni = Dni;
        this.FechaCompras = FechaCompras;
        this.Monto = Monto;
        this.Estado = Estado;
        this.estado_compras = estado_compras;
        this.DetalleCompras = DetalleCompras;
    }

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getFechaCompras() {
        return FechaCompras;
    }

    public void setFechaCompras(String FechaCompras) {
        this.FechaCompras = FechaCompras;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getEstado_compras() {
        return estado_compras;
    }

    public void setEstado_compras(int estado_compras) {
        this.estado_compras = estado_compras;
    }

    public List<CarritoProducto> getDetalleCompras() {
        return DetalleCompras;
    }

    public void setDetalleCompras(List<CarritoProducto> DetalleCompras) {
        this.DetalleCompras = DetalleCompras;
    }

    @Override
    public String toString() {
        return "Compras{" + "idCompras=" + idCompras + ", Dni=" + Dni + ", FechaCompras=" + FechaCompras + ", Monto=" + Monto + ", Estado=" + Estado + ", estado_compras=" + estado_compras + ", DetalleCompras=" + DetalleCompras + '}';
    }

   
    
    
}
