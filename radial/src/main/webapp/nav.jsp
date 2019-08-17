<%-- 
    Document   : nav
    Created on : 08-16-2019, 01:56:37 PM
    Author     : ronald.reyesusam
--%>
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