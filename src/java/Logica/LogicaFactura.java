
package Logica;

import Conexion.ConexionBD;
import Datos.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogicaFactura {
    
    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;
    
   
    //OBJETO ADMIN PARA LLENERLO POR ID(Paquete Sistema)
    public Factura FacturaCliente(int dni , String fecha) {
        String sql = "SELECT * FROM FACTURA_CLIENTE  WHERE dni = "+dni+" AND fechacompras = "+fecha;
        Factura f = new Factura();
        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                f.setDni(data.getString("dni"));
                f.setNombre(data.getString("nombre"));
                f.setPrimerApellido(data.getString("primerapellido"));
                f.setDireccion(data.getString("direccion"));
                f.setEmail(data.getString("email"));
                f.setCelular(data.getInt("celular"));
                f.setFecha(data.getString("fechacompras"));
                f.setMonto(data.getDouble("monto"));
                f.setEstado(data.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error listar Factura: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return f;
    }
}
