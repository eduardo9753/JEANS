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
        <title>Administradores</title>
    </head>
    <body>
        <section>
            <div class="container">
                <form action="ControllerSistema?menu=Administrador" method="POST">
                    <div class="row">
                        <div class="col-md-3">  
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="" placeholder="" class="form-control" name="txtidadmin" value="${ad.getIdAmin()}" hidden="">
                                <input type="text" placeholder="" class="form-control" name="txtnombreadmin" value="${ad.getNombre()}" required="">
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label>Primer Apellido</label>
                            <div class="form-group">
                                <input type="textl" placeholder="" class="form-control" name="txtapellidoadmin" value="${ad.getPrimerApellido()}" required="">
                            </div>
                        </div> 

                        <div class="col-md-3">                          
                            <div class="form-group">
                                <label>Nombre de Usuario</label>
                                <input type="text" placeholder="" class="form-control" name="txtnombreusuario" value="${ad.getNombreAdmin()}" required="">
                            </div>                         
                        </div> 

                        <div class="col-md-3">
                            <div class="form-group">
                                <label>TIPO ROL</label>
                                <select name="cborol" class="form-control">
                                    <option value="1">ADMIN</option>
                                    <option value="2">TRABAJADOR</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" placeholder="example@email.com" class="form-control" name="txtcorreo" value="${ad.getCorreo()}" required="">
                            </div>
                        </div>
                        <!--  <div class="col-md-3">
                              <input type="submit" class="btn btn-outline-warning btn-block" value="Registrar" name="accion">
                          </div> -->
                        <div class="col-md-6">
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
                                    <th>Apellido</th>
                                    <th>Nombre Usuario</th>
                                    <th>Tipo Rol</th>
                                    <th>Email</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="admin" items="${admin}">
                                    <tr>
                                        <td>${admin.getNombre()}</td>
                                        <td>${admin.getPrimerApellido()}</td>
                                        <td>${admin.getNombreAdmin()}</td>
                                        <td>${admin.getIdrol()}</td>
                                        <td>${admin.getCorreo()}</td>
                                        <td>
                                            <a href="ControllerSistema?menu=Administrador&accion=Editar&idadmin=${admin.getIdAmin()}" class="btn btn-outline-warning">EDITAR</a>
                                            <a href="ControllerSistema?menu=Administrador&accion=Eliminar&idadmin=${admin.getIdAmin()}" class="btn btn-danger">DELETE</a>
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
