<%-- 
    Document   : registroProgramas
    Created on : 08-13-2019, 04:42:30 PM
    Author     : mario.rodriguezusam
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
                        <jsp:include page="nav.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        </header>
        <!-- ##### Header Area End ##### -->

        <!-- ##### Breadcumb Area Start ##### -->
        <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb.jpg);">
            <div class="bradcumbContent">
                <h2>Registro de encuesta</h2>
                <p>Guardar encuesta</p>

            </div>
        </section>
        <!-- ##### Breadcumb Area End ##### -->

        <section class="section-padding-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-8">
                        ${msj}
                        <div class="login-content">
                            <h3>Registro de encuestas</h3>
                            <!-- Login Form -->
                            <div class="login-form">
                                <form action="encuestas?action=guardar" method="post">
                                    <div class="form-group">
                                        <label>Total encuestados</label>
                                        <input type="number" step="any" min="0" name="total" class="form-control" placeholder="Ingrese total encuestados">
                                        <!--<small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>-->
                                    </div>
                                    <div class="form-group">
                                        <label>Aprobaciones</label>
                                        <input type="number" name="aprobaciones" step="any" min="0" class="form-control" placeholder="Ingrese numero de aprobados">
                                        <!--<small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>-->
                                    </div>
                                    <div class="form-group">
                                        <label>Rechazos</label>
                                        <input type="number" name="rechazos" step="any" min="0" class="form-control" placeholder="Ingrese numero de rechazados">
                                        <!--<small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>-->
                                    </div>
                                    <div class="form-group">
                                        <label>Indiferentes</label>
                                        <input type="number" name="indiferentes" step="any" min="0" class="form-control" placeholder="Ingrese numero de indiferentes">
                                        <!--<small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>-->
                                    </div>
                                    <div class="form-group">
                                        <label>Seleccione genero del programa</label>
                                        <select name="programa" class="form-control">
                                            <c:forEach items="${programa}" var="p">
                                                <option value="<c:out value="${p.id_programa}"/>"><c:out value="${p.nombre_programa}"/></option>
                                            </c:forEach> 
                                        </select> 
                                    </div>
                                    <button type="submit" class="btn oneMusic-btn mt-30">Guardar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>



        <!-- ##### Footer Area Start ##### -->
        <jsp:include page="footer.jsp"></jsp:include>
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
