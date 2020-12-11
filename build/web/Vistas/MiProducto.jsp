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
        <!-- CSS -->
        <link rel="stylesheet" href="css/styles.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
        <title>Mi producto</title>
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
                            <a class="nav-link btn btn-outline-warning" href="ServletController?accion=CarritoCompras"><label>(${contador})</label>Carrito</a>
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

        <div class="fondo-MiProducto">
            <h1 class="text-center text-uppercase lead">Tu Producto</h1>                
        </div>

        <section class="container mt-4 My-producto">

            <div class="row vertical-center">
                <div class="col-md-4 mb-2">
                    <form action="ServletController" method="POST">
                        <div class="form-group">
                            <label>Cantidad Requerida</label>
                            <input type="number" class="form-control" min="1" max="5" name="txtcantidad" required="">
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h2 class="card-title lead">Producto: ${producto.getNombres()}</h2>
                            </div>
                            <div class="card-body">
                                <div>
                                    <p class="lead">${producto.getDescripcion()}</p>
                                    <p class="lead">Categoria: ${producto.getCategoria()}</p>
                                    <p class="lead">Estado: ${producto.getEstado()}</p>
                                </div>
                                <div>
                                    <span class="">Precio: ${producto.getPrecio()}</span>
                                    <span class="">Cantidad: ${producto.getStock()}</span>
                                </div>
                            </div>
                            <div class="card-footer">
                                <input type="submit" value="Agregar" name="accion" class="btn btn-warning btn-block text-white">
                              <!--  <a href="ServletController?accion=AgregarCarrito&idpro=${producto.getIdProducto()}" class="btn btn-warning btn-block text-white">Agregar a Canasta</a>
                                <a href="" class="btn btn-info btn-block">Comprar este Articulo</a> -->
                                <input type="text" value="${producto.getIdProducto()}" name="txtidpro" hidden="">
                            </div>
                        </div>
                    </form>
                </div>

                <div class="col-md-8">
                    <div class="caja-img">
                        <img src="img/${producto.getImagen()}" alt="img1" class="img-fluid  img-my-ptoduct"/>
                    </div>
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
