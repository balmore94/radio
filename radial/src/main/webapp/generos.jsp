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
                        <jsp:include page="nav.jsp"></jsp:include>
                    </div>
                </div>
            </div>
        </header>
        <!-- ##### Header Area End ##### -->

        <!-- ##### Breadcumb Area Start ##### -->
        <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb.jpg);">
            <div class="bradcumbContent">
                <h2>Géneros</h2>
                <p>Listado de géneros</p>

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
                                        <th hidden>id_radio</th>
                                        <th>Género</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                       
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${generos}" var="ver">
                                        <tr>
                                            <td hidden>${ver.id_genero}</td>
                                            <td>${ver.nombre_genero}</td>
                                            <td><a href="genero?action=findById&id=${ver.id_genero}"><button class="btn btn-info btn-sm">Editar</button></a></td>

                                            <td><a href="genero?action=eliminar&id=${ver.id_genero}"><button class="btn btn-danger btn-sm">Eliminar</button></a></td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th hidden>id_radio</th>
                                        <th>Género</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                        
                                       
                                    </tr>
                                </tfoot>
                            </table>


                        </div>



                    </div>
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