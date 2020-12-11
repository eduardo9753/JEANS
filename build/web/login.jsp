<%-- 
    Document   : index
    Created on : 22-oct-2020, 21:21:24
    Author     : Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/styles.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    </head>
    <body>
        <section class="Fondo-login">
            <div>
                <div class="py-5">
                    <h1 class="text-center h1">Login</h1>
                </div>
            </div>

            <div class="Formulario">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 m-auto">
                            <form action="ControllerAdmin" method="POST" class="frm">
                                <div class="">
                                    <label>Usuario</label>
                                    <input type="text" placeholder="Nombre de usuario" name="txtnomUsuario" class="caja-login" required="">
                                </div>

                                <div class="">
                                    <label>Correo</label>
                                    <input type="text" placeholder="tucorreo@email.com" name="txtcorreo" class="caja-login" required="">
                                </div>

                                <input type="submit" value="Ingresar" name="accion" class="btn-login">
                            </form>
                            
                            <div class="caja-redes-sociales">
                                <div>
                                    <img src="imgEmpresa/" width="" height="" alt="vision"/>
                                </div>
                                <div>
                                    <img src="imgEmpresa/" width="" height="" alt="vision"/>
                                </div>
                                <div>
                                    <img src="imgEmpresa/" width="" height="" alt="vision"/>
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </section>
    </body>
</html>
