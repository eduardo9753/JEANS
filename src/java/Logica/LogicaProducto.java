package Logica;

import Conexion.ConexionBD;
import Datos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogicaProducto {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;

    //ME LISTA TODOS LOS PRODUCTOS
    public List listar() {
        ArrayList<Producto> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM View_Produtos";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
                Producto p = new Producto();
                p.setIdProducto(data.getInt("idProducto"));
                p.setNombres(data.getString("Nombres"));
                p.setImagen(data.getString("imagen"));
                p.setDescripcion(data.getString("Descripcion"));
                p.setPrecio(data.getDouble("Precio"));
                p.setStock(data.getInt("Stock"));
                p.setIdcategoria(data.getInt("idcategoria"));
                p.setIdestado(data.getInt("idestado"));
                p.setCategoria(data.getString("categoria"));
                p.setEstado(data.getString("estado"));
                listProduct.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error listar producto: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listProduct;
    }

    //ME LISTA UN PRODUCTO POR IDPRODUCTO
    public Producto VerProductoPorId(int idProducto) {
          Producto p = new Producto();
        String sql = "SELECT * FROM View_Produtos WHERE idProducto = " + idProducto;

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();

            while (data.next()) {
                p.setIdProducto(data.getInt("idProducto"));
                p.setNombres(data.getString("Nombres"));
                p.setImagen(data.getString("imagen"));
                p.setDescripcion(data.getString("Descripcion"));
                p.setPrecio(data.getDouble("Precio"));
                p.setStock(data.getInt("Stock"));
                p.setIdcategoria(data.getInt("idcategoria"));
                p.setIdestado(data.getInt("idestado"));
                p.setCategoria(data.getString("categoria"));
                p.setEstado(data.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error listar producto: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return p;
    }

}
