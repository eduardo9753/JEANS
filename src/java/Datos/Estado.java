
package Datos;

public class Estado {
    private int idEstado;
    private String Estado;

    public Estado() {
    }

    public Estado(int idEstado, String Estado) {
        this.idEstado = idEstado;
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", Estado=" + Estado + '}';
    }
    
    
    
}
