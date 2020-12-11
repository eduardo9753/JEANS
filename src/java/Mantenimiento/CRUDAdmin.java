package Mantenimiento;

import Conexion.ConexionBD;
import Datos.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDAdmin {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;

    //ME LISTA TODOS LOS ADMINISTRADORES(Paquete Sistema)
    public List listar() {
        ArrayList<Admin> listAdmin = new ArrayList<>();
        String sql = "SELECT * FROM  View_Admi_Rol WHERE estado_admin=1";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                Admin a = new Admin();
                a.setIdAmin(data.getInt("idAdmin"));
                a.setNombre(data.getString("nombre"));
                a.setPrimerApellido(data.getString("primerApellido"));
                a.setNombreAdmin(data.getString("nombreAdmin"));
                a.setCorreo(data.getString("correo"));
                a.setIdrol(data.getInt("idrol"));
                a.setEstado_admin(data.getInt("estado_admin"));
                listAdmin.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error listar administrador: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listAdmin;
    }

    //OBJETO ADMIN PARA LLENERLO POR ID(Paquete Sistema)
    public Admin AdminPorId(int idadmin) {
        String sql = "SELECT * FROM View_Admi_Rol WHERE idadmin = " + idadmin;
        Admin a = new Admin();
        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                a.setIdAmin(data.getInt("idAdmin"));
                a.setNombre(data.getString("nombre"));
                a.setPrimerApellido(data.getString("primerApellido"));
                a.setNombreAdmin(data.getString("nombreAdmin"));
                a.setCorreo(data.getString("correo"));
                a.setIdrol(data.getInt("idrol"));
                a.setEstado_admin(data.getInt("estado_admin"));
            }
        } catch (SQLException e) {
            System.out.println("Error listar Admin: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return a;
    }

    //REGISTROS DE ADMNISTRADORES
    public boolean InsertAdmin(Admin a) {
        try {
            String sql = "INSERT INTO administrador (nombre,primerApellido,nombreAdmin,correo,idrol,estado_admin)"
                    + "VALUES(?,?,?,?,?,?)";
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, a.getNombre());
            consulta.setString(2, a.getPrimerApellido());
            consulta.setString(3, a.getNombreAdmin());
            consulta.setString(4, a.getCorreo());
            consulta.setInt(5, a.getIdrol());
            consulta.setInt(6, a.getEstado_admin());
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

    //APDATE DE ADMINISTRADORES 
    public boolean UpdateAdmin(Admin a) {
        try {
            String sql = "UPDATE administrador SET nombre=?,"
                    + "primerApellido=?,"
                    + "nombreAdmin=?,"
                    + "correo=?,"
                    + "idrol=?,"
                    + "estado_admin=? WHERE idAdmin=?";

            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, a.getNombre());
            consulta.setString(2, a.getPrimerApellido());
            consulta.setString(3, a.getNombreAdmin());
            consulta.setString(4, a.getCorreo());
            consulta.setInt(5, a.getIdrol());
            consulta.setInt(6, a.getEstado_admin());
            consulta.setInt(7, a.getIdAmin());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error Update Admin :" + ex.getLocalizedMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }

    //DELETE DE ADMINISTRADORES
    public boolean DeleteAdmin(int idcliente) {
        try {
            String sql = "DELETE FROM administrador WHERE idAdmin =" + idcliente;
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.print("Error Delete Admin:" + ex.getLocalizedMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }

    //BUSCAR ADMIN POR CORREO Y NOMBREUSUARIO PARA ENTRAR AL SISTEMA
    public Admin BuscarAdmin(Admin a) {
        String sql = "SELECT nombre,nombreAdmin,correo,estado_admin FROM administrador"
                + " WHERE correo =? AND nombreAdmin =?";
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
