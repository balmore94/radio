<%-- 
    Document   : index
    Created on : 08-12-2019, 04:01:23 PM
    Author     : mario.rodriguezusam
--%>

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
                                                <li><a href="#">Por Radio</a>
                                                    <ul class="dropdown">
                                                        <li><a href="programaradio?action=showRegistro">Registrar</a></li>
                                                        <li><a href="programaradio?action=findAll">Mostrar</a></li>
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

                                    <!-- Login/Register & Cart Button 
                                    <div class="login-register-cart-button d-flex align-items-center">
                                        Login/Register 
                                        <div class="login-register-btn mr-50">
                                            <a href="login.html" id="loginBtn">Login / Register</a>
                                        </div>

                                        <!-- Cart Button 
                                        <div class="cart-btn">
                                            <p><span class="icon-shopping-cart"></span> <span class="quantity">1</span></p>
                                        </div>-->
                                    </div>
                                </div>
                                <!-- Nav End -->

                          </nav>  
                    </div>
                        
                    </div>
                </div>
            </div>
        </header>
        <!-- ##### Header Area End ##### -->

        <!-- ##### Hero Area Start ##### -->
        <section class="hero-area">
            <div class="hero-slides owl-carousel">
                <!-- Single Hero Slide -->
                <div class="single-hero-slide d-flex align-items-center justify-content-center">
                    <!-- Slide Img -->
                    <div class="slide-img bg-img" style="background-image: url(img/bg-img/bg-1.jpg);"></div>
                    <!-- Slide Content -->
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <div class="hero-slides-content text-center">
                                    <h6 data-animation="fadeInUp" data-delay="100ms">Latest album</h6>
                                    <h2 data-animation="fadeInUp" data-delay="300ms">Beyond Time <span>Beyond Time</span></h2>
                                    <!--<a data-animation="fadeInUp" data-delay="500ms" href="#" class="btn oneMusic-btn mt-50">Discover <i class="fa fa-angle-double-right"></i></a>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Hero Slide -->
                <div class="single-hero-slide d-flex align-items-center justify-content-center">
                    <!-- Slide Img -->
                    <div class="slide-img bg-img" style="background-image: url(img/bg-img/bg-2.jpg);"></div>
                    <!-- Slide Content -->
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <div class="hero-slides-content text-center">
                                    <h6 data-animation="fadeInUp" data-delay="100ms">Latest album</h6>
                                    <h2 data-animation="fadeInUp" data-delay="300ms">Colorlib Music <span>Colorlib Music</span></h2>
                                    <!--<a data-animation="fadeInUp" data-delay="500ms" href="#" class="btn oneMusic-btn mt-50">Discover <i class="fa fa-angle-double-right"></i></a>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- ##### Hero Area End ##### -->

        <!-- ##### Footer Area Start ##### -->
        <footer class="footer-area">
            <div class="container">
                <div class="row d-flex flex-wrap align-items-center">
                    <div class="col-12 col-md-6">
                        <a href="#"><img src="img/core-img/logo.png" alt=""></a>
                        <p class="copywrite-text"><a href="#"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Hola <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="#" target="_blank">Página</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
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

