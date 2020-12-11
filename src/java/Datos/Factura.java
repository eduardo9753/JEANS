
package Datos;

public class Factura {
    private String dni;
    private String nombre;
    private String primerApellido;
    private String direccion;
    private String email;
    private int celular;
    private String fecha;
    private double monto;
    private String estado;

    public Factura() {
    }

    public Factura(String dni, String nombre, String primerApellido, String direccion, String email, int celular, String fecha, double monto, String estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Factura{" + "dni=" + dni + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", direccion=" + direccion + ", email=" + email + ", celular=" + celular + ", fecha=" + fecha + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
}
