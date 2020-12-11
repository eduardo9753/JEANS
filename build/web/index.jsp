<%-- 
    Document   : index
    Created on : 20-oct-2020, 11:15:48
    Author     : Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- CSS -->
        <link rel="stylesheet" href="css/styles.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@300&display=swap" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>

        <header class="header">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                
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
                            <a class="nav-link" href="#productos">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#mapa">Ubicanos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#empresa">La Empresa</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown08">
                                <form action="ControllerAdmin" method="POST">
                                    <div class="container">
                                        <input type="submit" value="Login" name="accion" class="btn btn-warning btn-block text-white"> 
                                    </div>
                                </form>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

        <div class="Fondo">
            <div class="container">
                <h1 class="">Moda y Estilos</h1>
            </div>
            <div class="flex-img-diseños">
                <div>
                    <img src="imgEmpresa/key1.jpg" alt="jean1"/>
                </div>
                <div>
                    <img src="imgEmpresa/key2.jpg" alt="jean1"/>
                </div>
                <div>
                    <img src="imgEmpresa/key3.jpg" alt="jean1"/>
                </div>
            </div>
        </div>

        <section class="Empresa py-5">
            <div class="container">

                <div>
                    <h2 class="text-uppercase my-4 color-izquiedo">ropa y estilos</h2>
                </div>

                <div class="row centrado">
                    <div class="col-md-6">
                        <div>
                            <p class="lead">Somos una empresa solida , brindando los ,mejores servicios a nuestros mejores clientes
                                en moda y estilo para cada estacion del año con las ultimas tendencias juvenil y usniset</p>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="imgEmpresa/slide1.jpg" alt="First slide">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>...</h5>
                                        <p class="h1">compromiso</p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="imgEmpresa/slide2.jpg" alt="Second slide">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5></h5>
                                        <p class="h1">calidad</p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="imgEmpresa/slide3.jpg" alt="Third slide">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>...</h5>
                                        <p class="h1">garanatia</p>
                                    </div>
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="Empresa-Caracteristicas" id="empresa">
            <div class="container">
                <div class="">
                    <h2 class="leadpy-5 text-uppercase my-4 color-izquiedo">La Empresa</h2>
                </div>

                <div class="row">

                    <div class="col-md-4">
                        <div class="card text-center">
                            <div class="card-header">
                                <div class="">
                                    <h2 class="card-title">Mision</h2>
                                </div>
                            </div>
                            <div class="card-body">
                                <img src="imgEmpresa/mision.jpg" alt="slide1"/>
                            </div>
                            <div class="card-footer">
                                <p class="lead"> </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card text-center">
                            <div class="card-header">
                                <div class="">
                                    <h2 class="card-title">Vision</h2>
                                </div>
                            </div>
                            <div class="card-body">
                                <img src="imgEmpresa/vision.jpg" alt="slide1"/>
                            </div>
                            <div class="card-footer">
                                <p class="lead"> </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card text-center">
                            <div class="card-header">
                                <div class="">
                                    <h2 class="card-title">Valores</h2>
                                </div>
                            </div>
                            <div class="card-body">
                                <img src="imgEmpresa/valores.jpg" alt="slide1"/>
                            </div>
                            <div class="card-footer">
                                <ul>
                                    <li>Respeto</li>
                                    <li>Amabilidad</li>
                                    <li>Compromiso</li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>


        <section class="Productos py-5" id="productos">
            <div class="container">
                <h2 class="mb-5 text-white color-izquiedo">Ver Nuestro Productos</h2>

                <div class="row text-center">

                    <div class="col-md-6 mb-3">
                        <div class="producto-img">
                            <a href="ServletController?accion=VerProductos">
                                <img src="imgEmpresa/CategoriaCasa.jpg"/>
                            </a>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="producto-img">
                            <a href="ServletController?accion=VerProductos">
                                <img src="imgEmpresa/CategoriaJeans.jpg"/>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <section class="Contactanos py-5">
            <div class="container">

                <div>
                    <h2 class="title-Contactanos text-center">Dejanos tu correo para mas Promociones</h2>
                </div>
                <div class="row">
                    <div class="col-md-8 m-auto">
                        <form>
                            <div class="form-group">
                                <label class="label">Nombre</label>
                                <input type="text" name="" placeholder="Nombre" class="form-control">
                            </div>

                            <div class="form-group">
                                <label class="label">Correo</label>
                                <input type="email" name="" placeholder="correo Electronico" class="form-control">
                            </div>

                            <input type="submit" name="" class="btn btn-danger btn-block">
                        </form>
                    </div>
                </div>
            </div>

        </section>


        <section class="MapaGeneral" id="mapa">
            <div class="container">
                <div>
                    <h2 class="text-uppercase my-5 color-izquiedo">Nuestra Ubicacion</h2>
                </div>
                <div class="mapa">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3903.757098433159!2d-77.02607018597826!3d-11.921985291550502!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105d15889b76e93%3A0xa8021ebde06f9592!2sColegio%20Cristo%20Hijo%20de%20Dios%202075!5e0!3m2!1ses-419!2spe!4v1603316549364!5m2!1ses-419!2spe" width="0" height="0" class="miMapa" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                </div>
            </div>
        </section>



        <footer class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 pt-5 pb-3">
                        <p class="pf color-izquiedo">Contactos</p>
                        <div class="contactos">
                            <div class="flex-contactos">
                                <img src="imgEmpresa/email.svg"/>
                                <p class="title-contact">: miempresa@email.com</p>
                            </div>
                            <div class="flex-contactos">
                                <img src="imgEmpresa/phone.svg"/>
                                <p class="title-contact">: 1234567</p>
                            </div>
                            <div class="flex-contactos">
                                <img src="imgEmpresa/whatsapp.svg"/>
                                <p class="title-contact">: +51 987965943</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 pt-5 pb-3">
                        <p class="pf color-izquiedo">Redes Sociales</p>
                        <div class="redes-sociales">
                            <ul class="flex-redes">
                                <li class="flex-redes">
                                    <a href="">
                                        <img src="imgEmpresa/youtube.svg" width="" height="" alt="mision"/>
                                        <p class="title-redes">Youtube</p>
                                    </a>
                                </li>
                                <li class="flex-redes">
                                    <a href="">
                                        <img src="imgEmpresa/facebook.svg" width="" height="" alt="mision"/>
                                        <p class="title-redes">Facebook</p>
                                    </a>
                                </li>
                                <li class="flex-redes">
                                    <a href="">
                                        <img src="imgEmpresa/instagram.svg" width="" height="" alt="mision"/>
                                        <p class="title-redes">Instagram</p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-4 pt-5 pb-3 text-center">
                        <p class="pf color-izquiedo">Libro de Reclamaciones</p>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Relizar un Reclamo</button>

                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Consultas O Reclamos</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="form-group">
                                                <label for="recipient-name" class="label">Nombre:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="recipient-name" class="label">Correo:</label>
                                                <input type="text" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="form-group">
                                                <label for="message-text" class="label">Mensage o Queja:</label>
                                                <textarea class="form-control" id="message-text"></textarea>
                                            </div>

                                            <input type="submit" class="btn btn-danger btn-block" >
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 bg-dark">
                        <p class="pie">Grupo 6 - Soluciones Web</p>
                    </div>
                </div>

            </div>
        </footer>

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
