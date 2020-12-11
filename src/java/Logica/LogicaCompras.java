package Logica;

import Conexion.ConexionBD;
import Datos.CarritoProducto;
import Datos.Cliente;
import Datos.Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogicaCompras {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;

    public boolean GenerarCompra(Compras compras, Cliente cli) {
        String sql = "INSERT INTO compras(Dni,FechaCompras,Monto,Estado,estado_compras) VALUES(?,?,?,?,?)";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, cli.getDni());
            consulta.setString(2, compras.getFechaCompras());
            consulta.setDouble(3, compras.getMonto());
            consulta.setString(4, compras.getEstado());
            consulta.setInt(5, compras.getEstado_compras());
            consulta.executeUpdate();

            //capturamos id de la ultima compra
            sql = "SELECT MAX(idCompras) FROM compras";
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            data.next();
            int idcompras = data.getInt("idCompras");
            data.close();

            //foreach para llenar tabla detalle_ventas
            for (CarritoProducto detalleCompras : compras.getDetalleCompras()) {
                sql = "INSERT INTO detalle_compras(idProducto,idCompras,Cantidad,PrecioCompra) VALUES(?,?,?,?)";
                consulta = enlace.prepareStatement(sql);
                consulta.setInt(1, detalleCompras.getIdProducto());
                consulta.setInt(2, idcompras);
                consulta.setInt(3, detalleCompras.getCantidad());
                consulta.setDouble(4, detalleCompras.Costo());
                consulta.executeUpdate();
            }//cierre for
        } catch (SQLException e) {
            System.out.println("Error Generar Compra: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return true;
    }
}
