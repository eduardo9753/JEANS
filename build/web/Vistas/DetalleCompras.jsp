<%-- 
    Document   : Productos
    Created on : 20-oct-2020, 13:03:05
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
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
        <title>Detalles de tu Compras</title>
    </head>

    <body>
        <header class="header">          
            <nav class="container navbar navbar-expand-lg navbar-dark bg-primary">

                <a href="" class="navbar-brand">
                    <img src="imgEmpresa/logo.PNG" class="logo" alt="logo"/>
                </a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">MODA Y ESTILOS<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ServletController?accion=VerProductos">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn btn-outline-warning" href="ServletController?accion=VerProductos">Serguir Comprando</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown08">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

        <div class="fondo-carrito-compras">
            <h1 class="text-center text-uppercase">Detalle Compras</h1>
        </div>

        <section class="tabla-compras">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover mt-5">
                            <thead>
                                <tr>
                                    <th>Cantidad</th>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Foto</th>
                                    <th>Codigo</th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="carro" items="${carrito}">
                                    <tr>
                                        <td>${carro.getCantidad()}</td>
                                        <td>${carro.getNombre()}</td>
                                        <td>${carro.getDescripcion()}</td>
                                        <td>${carro.getPrecio()}</td>
                                        <td>
                                            <img src="img/${carro.getImagen()}" alt="img1" class="img-fluid"/>
                                        </td>
                                        <td>${carro.getIdProducto()}</td>
                                        <td>${carro.Costo()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div><!--cierre row-->

                <div class="">
                    <div class="">
                        <h2 class="leadpy-5 text-uppercase my-4 color-izquiedo">Datos del Cliente Para la Compra</h2>
                    </div>
                    <form action="ServletController" method="POST">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label>Nº DNI</label>
                                    <input type="" placeholder="" class="form-control" name="txtdni" value="${cli.getDni()}" required="">
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
                                <div class="form-group">
                                    <input type="text" class="form-control" value="${TotalPago}" readonly="">
                                </div>
                            </div>

                            <div class="col-md-3">
                                <input type="submit" class="btn btn-danger btn-block" value="Facturar" name="accion">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>


        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        -->
    </body>
</html>
