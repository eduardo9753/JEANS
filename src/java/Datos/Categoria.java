
package Datos;

public class Categoria {
    private int idCategoria;
     private String Categoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String Categoria) {
        this.idCategoria = idCategoria;
        this.Categoria = Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", Categoria=" + Categoria + '}';
    }

    
     
}
