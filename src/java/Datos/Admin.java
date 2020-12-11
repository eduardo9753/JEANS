
package Datos;

public class Admin {
   private int idAmin ;
   private String nombre;
   private String primerApellido;
   private String nombreAdmin;
   private String correo;
   
   private int idrol;    
   private int estado_admin ;

    public Admin() {
    }

    public Admin(int idAmin, String nombre, String primerApellido, String nombreAdmin, String correo, int idrol, int estado_admin) {
        this.idAmin = idAmin;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.nombreAdmin = nombreAdmin;
        this.correo = correo;
        this.idrol = idrol;
        this.estado_admin = estado_admin;
    }

    public int getIdAmin() {
        return idAmin;
    }

    public void setIdAmin(int idAmin) {
        this.idAmin = idAmin;
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

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getEstado_admin() {
        return estado_admin;
    }

    public void setEstado_admin(int estado_admin) {
        this.estado_admin = estado_admin;
    }

    @Override
    public String toString() {
        return "Admin{" + "idAmin=" + idAmin + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", nombreAdmin=" + nombreAdmin + ", correo=" + correo + ", idrol=" + idrol + ", estado_admin=" + estado_admin + '}';
    }
   
   
   
   
}
