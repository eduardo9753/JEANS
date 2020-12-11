
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionBD {
   /* 
    protected String usuario = "sa";
    protected String contra = "elizabeth";
    protected String base = "ROPA";
    protected String url = "jdbc:sqlserver://localhost:1433;databaseName="+base;
    */
    
    protected String usuario = "ROPA";
    protected String contra = "ropafinal";
    protected String url = "jdbc:oracle:thin:@localhost:1521:XE";
    protected Connection conexion = null;
    protected Statement declaracion = null;
    protected ResultSet data = null;

    //MI FUNCION PARA CONECTARME
    public Connection MiConexion() {
        try {
           //sql-> Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conexion = DriverManager.getConnection(url, usuario, contra);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error de Conexion : " + ex.toString());
        }
        return conexion;
    }
    
  
    //MI FUNCION PARA DESCONECTARME
    public void CerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error de cerrar conexion  : " + e.toString());
        }
    }
    
    
    //consultas
    public ResultSet consultas(String sql){
        conexion = MiConexion();
        try {
            declaracion = conexion.createStatement();
            data = declaracion.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error de consulta: "+e.getMessage());
        }
        return data;
    }  
}
