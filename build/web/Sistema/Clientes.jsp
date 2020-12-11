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
        <title>Clientes</title>
    </head>
    <body>
        <section>
            <div class="container">
                <form action="ControllerSistema?menu=Clientes" method="POST">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="form-group">
                                <label>Nº DNI</label>
                                <input type="" placeholder="" class="form-control" name="txtdni" value="${cli.getDni()}" >
                            </div>
                        </div> 
                        <div class="col-md-3">  
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" placeholder="" class="form-control" name="txtnombre" value="${cli.getNombres()}" required="">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label>Primer Apellido</label>
                            <div class="form-group">
                                <input type="textl" placeholder="" class="form-control" name="txtprimerapellido" value="${cli.getPrimerApellido()}" required="">
                            </div>
                        </div> 

                        <div class="col-md-4">                          
                            <div class="form-group">
                                <label>Direccion</label>
                                <input type="text" placeholder="direccion" class="form-control" name="txtdireccion" value="${cli.getDireccion()}" required="">
                            </div>                         
                        </div> 
                    </div>

                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <input type="email" placeholder="example@email.com" class="form-control" name="txtemail" value="${cli.getEmail()}" required="">
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="form-group">
                                <input type="text" placeholder="# de Calular" class="form-control" name="txtcelular" value="${cli.getCelular()}" required="">
                            </div>
                        </div>

                        <div class="col-md-2">
                            <div class="form-group">
                                <select name="cbosector" class="form-control">
                                    <c:forEach var="sector" items="${sector}">
                                        <option value="${sector.getIdsector()}">${sector.getSector()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3">
                           <!--  <input type="submit" class="btn btn-outline-warning btn-block" value="Registrar" name="accion">-->
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
                                    <th>DNI</th>
                                    <th>Nombre</th>
                                    <th>APELLIDO</th>
                                    <th>DIRECCION</th>
                                    <th>EMAIL</th>
                                    <th>CELULAR</th>
                                    <th>#SECTOR</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cli" items="${cliente}">
                                    <tr>
                                        <td>${cli.getDni()}</td>
                                        <td>${cli.getNombres()}</td>
                                        <td>${cli.getPrimerApellido()}</td>
                                        <td>${cli.getDireccion()}</td>
                                        <td>${cli.getEmail()}</td>
                                        <td>${cli.getCelular()}</td>
                                        <td>${cli.getIdsector()}</td>
                                        <td>
                                            <a href="ControllerSistema?menu=Clientes&accion=Editar&dni=${cli.getDni()}" class="btn btn-outline-warning">EDITAR</a>
                                            <a href="ControllerSistema?menu=Clientes&accion=Eliminar&dni=${cli.getDni()}" class="btn btn-danger">DELETE</a>
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
