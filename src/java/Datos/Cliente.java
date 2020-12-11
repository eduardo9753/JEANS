
package Datos;

public class Cliente {
   
    private String Dni;
    private String Nombres;
    private String PrimerApellido;
    private String Direccion;
    private String Email;
    private int celular;
    private String idsector;
    private int estado_cliente;

    public Cliente() {
    }

    public Cliente(String Dni, String Nombres, String PrimerApellido, String Direccion, String Email, int celular, String idsector, int estado_cliente) {
        this.Dni = Dni;
        this.Nombres = Nombres;
        this.PrimerApellido = PrimerApellido;
        this.Direccion = Direccion;
        this.Email = Email;
        this.celular = celular;
        this.idsector = idsector;
        this.estado_cliente = estado_cliente;
    }

    public int getEstado_cliente() {
        return estado_cliente;
    }

    public void setEstado_cliente(int estado_cliente) {
        this.estado_cliente = estado_cliente;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getIdsector() {
        return idsector;
    }

    public void setIdsector(String idsector) {
        this.idsector = idsector;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Dni=" + Dni + ", Nombres=" + Nombres + ", PrimerApellido=" + PrimerApellido + ", Direccion=" + Direccion + ", Email=" + Email + ", celular=" + celular + ", idsector=" + idsector + ", estado_cliente=" + estado_cliente + '}';
    }

    
   
}
