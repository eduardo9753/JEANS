package Mantenimiento;

import Conexion.ConexionBD;
import Datos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDProducto {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;

    //ME LISTA TODOS LOS PRODUCTOS(Paquete Sistema)
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

    
    //OBJETO PRODUCTO PARA LLENERLO POR ID(Paquete Sistema)
    public Producto ProductoPorId(int idProducto) {
        String sql = "SELECT * FROM View_Produtos WHERE idProducto = " + idProducto;
        Producto p = new Producto();
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

    
    //REGISTRAR UN PRODUCTO EN LA TABLA(Paquete Sistema)
    public boolean InsertProducto(Producto p) {
        try {
            String sql = "INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)"
                    + "VALUES(?,?,?,?,?,?,?)";
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, p.getNombres());
            consulta.setString(2, p.getImagen());
            consulta.setString(3, p.getDescripcion());
            consulta.setDouble(4, p.getPrecio());
            consulta.setInt(5, p.getStock());
            consulta.setInt(6, p.getIdcategoria());
            consulta.setInt(7, p.getIdestado());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error add Producto:" + ex.getLocalizedMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }

    
    //ACTUALIZAR UN PRODUCTO EN LA TABLA(Paquete Sistema)
    public boolean UpdateProducto(Producto p) {
        try {
            String sql = "UPDATE producto SET Nombres=?,"
                    + "imagen=?,"
                    + "Descripcion=?,"
                    + "Precio=?,"
                    + "Stock=?,"
                    + "idcategoria=?,"
                    + "idestado=? WHERE idProducto=?";

            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.setString(1, p.getNombres());
            consulta.setString(2, p.getImagen());
            consulta.setString(3, p.getDescripcion());
            consulta.setDouble(4, p.getPrecio());
            consulta.setInt(5, p.getStock());
            consulta.setInt(6, p.getIdcategoria());
            consulta.setInt(7, p.getIdestado());
            consulta.setInt(8, p.getIdProducto());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Error Update Product :" + ex.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception ex) {
                System.out.print("Error de cierre: " + ex.getMessage());
            }
        }
        return true;
    }

    
    //ACTUALIZAR UN PRODUCTO EN LA TABLA(Paquete Sistema)
    public boolean DeleteProducto(int idProducto) {
        try {
            String sql = "DELETE FROM producto WHERE idProducto = " + idProducto;
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.print("Error Delete Product :" + ex.getLocalizedMessage());
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
