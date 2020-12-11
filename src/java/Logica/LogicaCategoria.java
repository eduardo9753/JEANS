
package Logica;

import Conexion.ConexionBD;
import Datos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LogicaCategoria {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;
    
    
    //ME LISTA TODOS LAS CATEGORIAS
    public List listarCategoria() {
        ArrayList<Categoria> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM View_Categoria";
        
        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                
                Categoria c = new Categoria();
                c.setIdCategoria(data.getInt("idcategoria"));
                c.setCategoria(data.getString("categoria"));
                listProduct.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error listar Categoria: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listProduct;
    }
}
