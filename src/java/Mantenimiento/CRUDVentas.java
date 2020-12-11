
package Mantenimiento;

import Conexion.ConexionBD;
import Datos.Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDVentas {
    
    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;
    
    //ME LISTA TODOS LAS COMPRAS(Paquete Sistema)
    public List listar() {
        ArrayList<Compras> listCompra = new ArrayList<>();
        String sql = "SELECT * FROM View_Compras WHERE estado_compras =1";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {

                Compras c = new Compras();
                c.setIdCompras(data.getInt("idCompras"));
                c.setDni(data.getString("Dni"));
                c.setFechaCompras(data.getString("FechaCompras"));
                c.setMonto(data.getFloat("Monto"));
                c.setEstado(data.getString("Estado"));
                c.setEstado_compras(data.getInt("estado_compras"));
                listCompra.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error listar Compras: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listCompra;
    }
    
    //OBJETO COMPRAS PARA LLENERLO POR ID(Paquete Sistema)
    public Compras ComprasPorId(int idcompras) {
        String sql = "SELECT * FROM View_Compras WHERE idCompras =" + idcompras;
        Compras c = new Compras();
        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                c.setIdCompras(data.getInt("idCompras"));
                c.setDni(data.getString("Dni"));
                c.setFechaCompras(data.getString("FechaCompras"));
                c.setMonto(data.getFloat("Monto"));
                c.setEstado(data.getString("Estado"));
                c.setEstado_compras(data.getInt("estado_compras"));
            }
        } catch (SQLException e) {
            System.out.println("Error listar Compras: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return c;
    }
    
    //FUNCION PARA DAR DE BAJA A UNA COMPRA()
    public boolean UpdateCompra(Compras compra) {
        try {
            String sql = "UPDATE compras SET Dni=?,"
                    + "FechaCompras=?,"
                    + "Monto=?,"
                    + "Estado=?,"
                    + "estado_compras=? WHERE idCompras=?";

            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, compra.getDni());
            consulta.setString(2, compra.getFechaCompras());
            consulta.setDouble(3, compra.getMonto());
            consulta.setString(4, compra.getEstado());
            consulta.setInt(5, compra.getEstado_compras());
            consulta.setInt(6, compra.getIdCompras());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error Update Compra :" + ex.getLocalizedMessage());
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

    //DELETE DE ADMINISTRADORES

}
