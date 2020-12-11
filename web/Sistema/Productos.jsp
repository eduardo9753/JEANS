<%-- 
    Document   : Productos
    Created on : 22-oct-2020, 21:38:59
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
        <title>Productos</title>
    </head>
    <body>
        <section>
            <div class="container">
                <form action="ControllerSistema?menu=Productos" method="POST">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="form-group">
                                <label>Nombre del Producto</label>
                                <input type="tel" placeholder="" class="form-control" name="txtidpro" value="${prod.getIdProducto()}" hidden="">
                                <input type="text" placeholder="" class="form-control" name="txtnombre" value="${prod.getNombres()}" required="">
                            </div>
                        </div> 
                        <div class="col-md-3">  
                            <div class="form-group">
                                <label>Imagen del Producto</label>
                                <input type="file" placeholder="" class="form-control" name="txtimagen" required="">
                            </div>
                        </div>

                        <div class="col-md-1">                          
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="tel" placeholder="" class="form-control" name="txtprecio" value="${prod.getPrecio()}" required="">
                            </div>                         
                        </div>   

                        <div class="col-md-1">
                            <div class="form-group">
                                <label>Stock</label>
                                <input type="tel" placeholder="" class="form-control" name="txtstock" value="${prod.getStock()}" required="">
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="form-group">
                                <label>Categoria</label>
                                <select name="cboCategoria" class="form-control">
                                    <c:forEach var="cat" items="${categorias}">
                                        <option value="${cat.getIdCategoria()}">${cat.getCategoria()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <label>Estado</label>
                                <select name="cboEstado" class="form-control">
                                    <c:forEach var="cat" items="${estados}">
                                        <option value="${cat.getIdEstado()}">${cat.getEstado()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-6">                      
                            <input class="form-control" name="txtdescripcion" placeholder="Decripcion del producto" value="${prod.getDescripcion()}" required="">  
                        </div>

                        <div class="col-md-3">
                            <input type="submit" class="btn btn-outline-warning btn-block" value="Registrar" name="accion">
                        </div>
                        <div class="col-md-3">
                            <input type="submit" class="btn btn-outline-warning btn-block" value="Actualizar" name="accion">
                        </div>
                    </div>
                </form> 
            </div>



            <div class="container mt-4">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover">
                            <thead class=" bg-dark text-white">
                                <tr>
                                    <th>Nombre</th>
                                    <th>Imagen</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Stock</th>
                                    <th>categoria</th>
                                    <th>Estado</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="prod" items="${productos}">
                                    <tr>
                                        <td>${prod.getNombres()}</td>
                                        <td>
                                            <img src="img/${prod.getImagen()}" style="width: 30px;height: 30px;border-radius: 100%" alt="img1" class="img-fluid"/>
                                        </td>
                                        <td>${prod.getDescripcion()}</td>
                                        <td>${prod.getPrecio()}</td>
                                        <td>${prod.getStock()}</td>
                                        <td>${prod.getCategoria()}</td>
                                        <td>${prod.getEstado()}</td>
                                        <td>
                                            <a href="ControllerSistema?menu=Productos&accion=Editar&id=${prod.getIdProducto()}" class="btn btn-outline-warning">EDITAR</a>
                                            <a href="ControllerSistema?menu=Productos&accion=Eliminar&id=${prod.getIdProducto()}" class="btn btn-danger">DELETE</a>
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
