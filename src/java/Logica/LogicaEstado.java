/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.ConexionBD;
import Datos.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class LogicaEstado {

    ConexionBD bd = new ConexionBD();
    Connection enlace = null;
    PreparedStatement consulta = null;
    ResultSet data = null;
    
    //ME LISTA TODOS LAS CATEGORIAS
    public List listarEstado() {
        ArrayList<Estado> listProduct = new ArrayList<>();
        String sql = "SELECT * FROM View_Estado";

        try {
            enlace = bd.MiConexion();
            consulta = enlace.prepareStatement(sql);
            data = consulta.executeQuery();
            while (data.next()) {
              Estado e = new Estado();
                e.setIdEstado(data.getInt("idestado"));
                e.setEstado(data.getString("estado"));
                listProduct.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Error listar Estado: " + e.getMessage());
        } finally {
            try {
                bd.CerrarConexion();
            } catch (Exception e) {
                System.out.print("Error de Cierre" + e.getLocalizedMessage());
            }
        }
        return listProduct;
    }
}
