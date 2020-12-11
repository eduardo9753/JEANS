<%-- 
    Document   : Ventas
    Created on : 22-oct-2020, 21:39:37
    Author     : Eduardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- CSS -->
        <link rel="stylesheet" href="css/styles.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
      
        <section>
            <div class="container">
                <form action="ControllerSistema?menu=Productos" method="POST">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label>DNI CLIENTE</label>
                                <input type="" placeholder="" class="form-control" name="" value="${prod.getIdProducto()}" hidden="">
                                <input type="" placeholder="" class="form-control" name="" value="${prod.getNombres()}" required="">
                            </div>
                        </div> 
                        <div class="col-md-4">  
                            <div class="form-group">
                                <label>FECHA DE COMPRA</label>
                                <input type="text" placeholder="" class="form-control" name="">
                            </div>
                        </div>

                        <div class="col-md-4">                          
                            <div class="form-group">
                                <label>MONTO TOTAL</label>
                                <input type="tel" placeholder="" class="form-control" name="" value="${prod.getPrecio()}" required="">
                            </div>                         
                        </div>   

                        <div class="col-md-3">
                            <div class="form-group">
                                <input type="tel" placeholder="ESTADO" class="form-control" name="" value="${prod.getStock()}" required="">
                            </div>
                        </div>
                       
                        <div class="col-md-9">
                            <input type="submit" class="btn btn-outline-warning btn-block" value="Actualizar" name="accion">
                        </div>
                    </div>
            </div>
        </form>                


        <div class="container mt-4">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <thead class=" bg-dark text-white">
                            <tr>
                                <th># VENTA</th>
                                <th>CODIGO CLIENTE</th>
                                <th>FECHA COMPRADA</th>
                                <th>MONTO TOTAL</th>
                                <th>ESTADO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="compras" items="${compras}">
                            <tr>
                                <td>${compras.getIdCompras()}</td>
                                <td>${compras.getDni()}</td>
                                <td>${compras.getFechaCompras()}</td>
                                <td>${compras.getMonto()}</td>
                                <td>${compras.getEstado()}</td>
                                <td>
                                    <a href="ControllerSistema?menu=Ventas&accion=Eliminar&idcompras=${compras.getIdCompras()}" class="btn btn-outline-warning">DAR BAJA</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
