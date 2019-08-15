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
                                                <li><a href="index.jsp">Registrar</a></li>
                                                <li><a href="albums-store.html">Mostrar</a></li>
                                                <li><a href="#">Generos</a>
                                                    <ul class="dropdown">
                                                        <li><a href="#">Registrar</a></li>
                                                        <li><a href="#">Mostrar</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="event.html">Events</a></li>
                                        <li><a href="blog.html">News</a></li>
                                        <li><a href="contact.html">Contact</a></li>
                                    </ul>

                                    <!-- Login/Register & Cart Button -->
                                    <div class="login-register-cart-button d-flex align-items-center">
                                        <!-- Login/Register -->
                                        <div class="login-register-btn mr-50">
                                            <a href="login.html" id="loginBtn">Login / Register</a>
                                        </div>

                                        <!-- Cart Button -->
                                        <div class="cart-btn">
                                            <p><span class="icon-shopping-cart"></span> <span class="quantity">1</span></p>
                                        </div>
                                    </div>
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
                <h2>Trabajadores</h2>
                <p>Modificar registro de trabajador</p>

            </div>
        </section>
        <!-- ##### Breadcumb Area End ##### -->

        <section class="section-padding-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-8">
                        ${msg}
                        <div class="login-content">
                            
                            <h3>Editar Trabajador</h3>
                            <!-- Login Form -->
                            <div class="login-form">
                                <c:forEach items="${trabajador}" var="v">
                                <form action="trabajadores?action=actualizar" method="post">
                                    <div class="form-group">
                                        <label>Nombres:</label>
                                        <input class="form-control" name="nombre" value="${v.nombre_trabajador}">
                                        <input value="${v.id_trabajadores}" name="id" type="hidden">
                                        <!--<small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>-->
                                    </div>
                                    <div class="form-group">
                                        <label>Apellidos:</label>
                                        <input class="form-control" name="apellido" value="${v.apellido_trabajador}">
                                    </div>
                                    <div class="form-group">
                                        <label>DUI:</label>
                                        <input class="form-control" name="dui" value="${v.dui}">
                                    </div>
                                    <div class="form-group">
                                        <label>Cargo:</label>
                                        <select name="cargo" class="form-control">
                                            <option value="${v.cargo.id_cargo}" >${v.cargo.nombre_cargo}</option>
                                            <c:forEach items="${cargos}" var="c">
                                                <option value="${c.id_cargo}">${c.nombre_cargo}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Programa:</label>
                                        <select name="programa" class="form-control">
                                            <option value="${v.programa_trabajador.id_programa}">${v.programa_trabajador.nombre_programa}</option>
                                            <c:forEach items="${lista}" var="p">
                                                <option value="${p.id_programa}">${p.nombre_programa}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn oneMusic-btn mt-30">Guardar</button>
                                </form>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>



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
