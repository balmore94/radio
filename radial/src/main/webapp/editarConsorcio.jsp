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
                <h2>Radios</h2>
                <p>Registro de una radio</p>

            </div>
        </section>
        <!-- ##### Breadcumb Area End ##### -->

        <section class="section-padding-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-8">
                        ${msg}
                        <div class="login-content">
                            <h3>Editar Consorcio</h3>
                            <!-- Login Form -->
                            <c:forEach items="${consorcio}" var="v">
                            <div class="login-form">
                                <form action="consorcios?action=actualizar" method="post">
                                    <div class="form-group">
                                        <label>Radio:</label>
                                        <input value="${v.id_consorcio}" name="id">
                                        <select name="radio" class="form-control">
                                            <option value="${v.radio_consorcio.id_radio}">${v.radio_consorcio.nombre_radio}</option>
                                            <c:forEach items="${radios}" var="r">
                                                <option value="${r.id_radio}">${r.nombre_radio}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Programa:</label>
                                        <select name="programa" class="form-control">
                                            <option selected >${v.programa_consorcio.nombre_programa}</option>
                                            <c:forEach items="${lista}" var="p">
                                                <option value="${p.id_programa}">${p.nombre_programa}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Compañia:</label>
                                        <select class="form-control" name="compania">
                                            <option selected>${v.compania_consorcio.nombre_compania}</option>
                                            <c:forEach items="${companias}" var="l">
                                                <option value="${l.id_compania}">${l.nombre_compania}</option>
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
