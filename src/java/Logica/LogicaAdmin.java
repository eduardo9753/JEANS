package Logica;

import Conexion.ConexionBD;
import Datos.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogicaAdmin {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;
   

    //REGISTROS DE USUARIOS
    public boolean InsertAdmin(Admin a) {
        try {
            String sql = "INSERT INTO administrador (nombre,primerApellido,nombreAdmin,correo,idrol)"
                    + "VALUES(?,?,?,?,?)";
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, a.getNombre());
            consulta.setString(2, a.getPrimerApellido());
            consulta.setString(3, a.getNombreAdmin());
            consulta.setString(4, a.getCorreo());
            consulta.setInt(5, a.getIdrol());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error insert Admin :" + ex.getLocalizedMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }

    public Admin BuscarAdmin(Admin a) {
        String sql = "SELECT nombre,nombreAdmin,correo FROM administrador"
                + " WHERE correo=? AND nombreAdmin=?";
        Admin am = new Admin();
        try {

            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, a.getCorreo());
            consulta.setString(2, a.getNombreAdmin());
            data = consulta.executeQuery();

            while (data.next()) {
                am.setNombre(data.getString("nombre"));
                am.setNombreAdmin(data.getString("nombreAdmin"));
                am.setCorreo(data.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("Error Buscar Admin: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return am;
    }
}
