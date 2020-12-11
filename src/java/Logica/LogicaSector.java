
package Logica;

import Conexion.ConexionBD;
import Datos.Sector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogicaSector {
     
    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;
    
     //ME LISTA TODOS LAS SECTOR
    public List listarSector() {
        ArrayList<Sector> listEstado = new ArrayList<>();
        String sql = "SELECT * FROM View_Sector";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
              Sector s = new Sector();
                s.setIdsector(data.getString("idsector"));
                s.setSector(data.getString("sector"));
                listEstado.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error listar Sector: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listEstado;
    }
}
