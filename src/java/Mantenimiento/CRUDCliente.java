package Mantenimiento;

import Conexion.ConexionBD;
import Datos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDCliente {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;

    //ME LISTA TODOS LOS CLIENTES(Paquete Sistema)
    public List listar() {
        ArrayList<Cliente> listCliente = new ArrayList<>();
        String sql = "SELECT * FROM View_Cliente WHERE estado_cliente=1";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {

                Cliente c = new Cliente();
                c.setDni(data.getString("Dni"));
                c.setNombres(data.getString("Nombre"));
                c.setPrimerApellido(data.getString("PrimerApellido"));
                c.setDireccion(data.getString("Direccion"));
                c.setEmail(data.getString("Email"));
                c.setCelular(data.getInt("Celular"));
                c.setIdsector(data.getString("idsector"));
                c.setEstado_cliente(data.getInt("estado_cliente"));
                listCliente.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error listar cliente: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listCliente;
    }

    //OBJETO CLIENTE PARA LLENERLO POR ID(Paquete Sistema)
    public Cliente ClientePorId(int idcliente) {
        String sql = "SELECT * FROM View_Cliente WHERE Dni =" + idcliente;
        Cliente c = new Cliente();
        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                c.setDni(data.getString("Dni"));
                c.setNombres(data.getString("Nombre"));
                c.setPrimerApellido(data.getString("PrimerApellido"));
                c.setDireccion(data.getString("Direccion"));
                c.setEmail(data.getString("Email"));
                c.setCelular(data.getInt("Celular"));
                c.setIdsector(data.getString("idsector"));
                c.setEstado_cliente(data.getInt("estado_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error listar cliente: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return c;
    }

    //REGISTRAR UN PRODUCTO EN LA TABLA(Paquete Sistema)
    public boolean InsertCliente(Cliente c) {
        try {
            String sql = "INSERT INTO cliente(Dni,Nombre,PrimerApellido,Direccion,Email,Celular,idsector,estado_cliente)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, c.getDni());
            consulta.setString(2, c.getNombres());
            consulta.setString(3, c.getPrimerApellido());
            consulta.setString(4, c.getDireccion());
            consulta.setString(5, c.getEmail());
            consulta.setInt(6, c.getCelular());
            consulta.setString(7, c.getIdsector());
            consulta.setInt(8, c.getEstado_cliente());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error add CLIENTE:" + ex.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return true;
    }

    //ACTUALIZAR UN PRODUCTO EN LA TABLA(Paquete Sistema)
    public boolean Updatecliente(Cliente c) {
        try {
            String sql = "UPDATE cliente SET Nombre=?,"
                    + "PrimerApellido=?,"
                    + "Direccion=?,"
                    + "Email=?,"
                    + "Celular=?,"
                    + "idsector=?,"
                    + "estado_cliente=? WHERE Dni=?";

            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, c.getNombres());
            consulta.setString(2, c.getPrimerApellido());
            consulta.setString(3, c.getDireccion());
            consulta.setString(4, c.getEmail());
            consulta.setInt(5, c.getCelular());
            consulta.setString(6, c.getIdsector());
            consulta.setInt(7, c.getEstado_cliente());
            consulta.setString(8, c.getDni());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error Update Cliente :" + ex.getLocalizedMessage());
        } finally {
            try {
                bd.CerrarConexion();
                consulta.close();
            } catch (SQLException ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }

    //ACTUALIZAR UN PRODUCTO EN LA TABLA(Paquete Sistema)
    public boolean DeleteCliente(int idcliente) {
        try {
            String sql = "DELETE FROM cliente WHERE Dni =" + idcliente;
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.print("Error Delete Cliente:" + ex.getLocalizedMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }
}
