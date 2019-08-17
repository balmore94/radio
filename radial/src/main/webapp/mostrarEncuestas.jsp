<%-- 
    Document   : MostrarTipoT
    Created on : 08-13-2019, 02:16:16 PM
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
                <h2>Encuestas radiales</h2>
                <p>Listado de encuestas</p>

            </div>
        </section>
        <!-- ##### Breadcumb Area End ##### -->

        <!-- ##### Contact Area Start ##### -->
        <section class="contact-area section-padding-100-0">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-3"> 
                        ${msj}
                        <div class="contact-content mb-100">
                            <table id="example" class="table table-striped table-bordered" style="width:100%">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Aprobaciones</th>
                                        <th>Rechazos</th>
                                        <th>Indiferencias</th>
                                        <th>Total Encuestas</th>
                                        <th>Programa</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach  items="${encuestab}" var="en">
                                        <tr>
                                            <td>${en.id_encuestas}</td> 
                                            <td>${en.aprobaciones}</td>
                                            <td>${en.rechazos}</td>
                                            <td>${en.indiferencias}</td>
                                            <td>${en.total_encuestados}</td>
                                            <td>${en.programa.nombre_programa}</td> 
                                            <td>
                                                <a href="encuestas?action=eliminar&id=${en.id_encuestas}"><button class="btn btn-danger btn-sm">Eliminar</button></a>
                                            </td>
                                            <td>
                                                <a href="encuestas?action=getById&id=${en.id_encuestas}"><button class="btn btn-info btn-sm">Modificar</button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-4">
                        <a href="encuestas?action=show" class="btn btn-block btn-outline-dark">Nuevo</a>
                    </div>
                </div>
                <br>
            </div>
        </section>
        <!-- ##### Contact Area End ##### -->



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