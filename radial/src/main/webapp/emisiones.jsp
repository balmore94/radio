<%-- 
    Document   : generos
    Created on : 08-14-2019, 09:26:44 AM
    Author     : ronald.reyesusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title -->
        <title>One Music - Modern Music HTML5 Template</title>

        <!-- Favicon -->
        <link rel="icon" href="img/core-img/favicon.ico">

        <!-- Stylesheet -->
        <link rel="stylesheet" href="style.css">

    </head>

    <body>
        <!-- Preloader -->
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="lds-ellipsis">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>

        <!-- ##### Header Area Start ##### -->
        <header class="header-area">
            <!-- Navbar Area -->
            <div class="oneMusic-main-menu">
                <div class="classy-nav-container breakpoint-off">
                    <div class="container">
                        <!-- Menu -->
                        <nav class="classy-navbar justify-content-between" id="oneMusicNav">

                            <!-- Nav brand -->
                            <a href="index.html" class="nav-brand"><img src="img/core-img/logo.png" alt=""></a>

                            <!-- Navbar Toggler -->
                            <div class="classy-navbar-toggler">
                                <span class="navbarToggler"><span></span><span></span><span></span></span>
                            </div>

                            <!-- Menu -->
                            <div class="classy-menu">

                                <!-- Close Button -->
                                <div class="classycloseIcon">
                                    <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                                </div>

                                <!-- Nav Start -->
                                <div class="classynav">
                                      <ul>
                                        <li><a href="index.jsp">Inicio</a></li>
                                        <li><a href="#">Radios</a>
                                            <ul class="dropdown">
                                                <li><a href="registroRadio.jsp">Registrar</a></li>
                                                <li><a href="radio?action=findAll">Mostrar</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Programas</a>
                                            <ul class="dropdown">
                                                <li><a href="programa?action=show">Registrar</a></li>
                                                <li><a href="programa?action=mostrar">Mostrar</a></li>
                                                <li><a href="#">Generos</a>
                                                    <ul class="dropdown">
                                                        <li><a href="registroGenero.jsp">Registrar</a></li>
                                                        <li><a href="genero?action=findAll">Mostrar</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Compañia</a>
                                            <ul class="dropdown">
                                                <li><a href="registroCompania.jsp">Registrar</a></li>
                                                <li><a href="compani?action=findAll">Compañias</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Consorcios</a>
                                            <ul class="dropdown">
                                                <li><a href="consorcios?action=showRegistro">Registrar</a></li>
                                                <li><a href="consorcios?action=findAll">Mostrar</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Trabajadores</a>
                                            <ul class="dropdown">
                                                <li><a href="trabajadores?action=showRegistro">Registrar</a></li>
                                                <li><a href="trabajadores?action=findAll">Mostrar</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Encuesta</a>
                                            <ul class="dropdown">
                                                <li><a href="encuestas?action=show">Registrar</a></li>
                                                <li><a href="encuestas?action=mostrar">Mostrar</a></li>
                                            </ul>
                                        </li>
                                    </ul>

                                    
                                </div>
                                <!-- Nav End -->

                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ##### Header Area End ##### -->

        <!-- ##### Breadcumb Area Start ##### -->
        <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb.jpg);">
            <div class="bradcumbContent">
                <h2>Emisiones</h2>
                <p>Listado de Emisiones</p>

            </div>
        </section>
        <!-- ##### Breadcumb Area End ##### -->

        <!-- ##### Contact Area Start ##### -->
        <section class="contact-area section-padding-100-0">
            <div class="container">
                <div class="row">

                    <div class="col-md-12 col-md-offset-3">
                        ${msg}
                        <div class="contact-content mb-100">

                            <table id="example" class="table table-striped table-bordered" style="width:100%">
                                <thead class="thead-dark">
                                    <tr>
                                        <th hidden>Id Emisiones</th>
                                        <th>Emision</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${lista}" var="ver">
                                        <tr>
                                            <td hidden>${ver.id_emisiones}</td>
                                            <td>${ver.emision}</td>
                                            <td><a href="emisiones?action=eliminar&id_emisiones=${ver.id_emisiones}"><button class="btn btn-danger btn-sm">Eliminar</button></a></td>
                                            <td><a href="emisiones?action=consultarById&id_emisiones=${ver.id_emisiones}"><button class="btn btn-info btn-sm">Editar</button></a></td>    
                                        </tr>
                                    </c:forEach>                                       
                                </tbody>                                    
                            </table>


                        </div>



                    </div>
                </div>
        </section>
        <!-- ##### Contact Area End ##### -->



        <!-- ##### Footer Area Start ##### -->
        <footer class="footer-area">
            <div class="container">
                <div class="row d-flex flex-wrap align-items-center">
                    <div class="col-12 col-md-6">
                        <a href="#"><img src="img/core-img/logo.png" alt=""></a>
                        <p class="copywrite-text"><a href="#"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>

                    <div class="col-12 col-md-6">
                        <div class="footer-nav">
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Albums</a></li>
                                <li><a href="#">Events</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- ##### Footer Area Start ##### -->

        <!-- ##### All Javascript Script ##### -->
        <!-- jQuery-2.2.4 js -->
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!-- Popper js -->
        <script src="js/bootstrap/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <!-- All Plugins js -->
        <script src="js/plugins/plugins.js"></script>
        <!-- Active js -->
        <script src="js/active.js"></script>
    </body>

</html>
<script>
                                    $(function () {
                                        var alert = $('div.alert[auto-close]');
                                        alert.each(function () {
                                            var that = $(this);
                                            var time_period = that.attr('auto-close');
                                            setTimeout(function () {
                                                that.alert('close');
                                            }, time_period);
                                        });
                                    });
</script>