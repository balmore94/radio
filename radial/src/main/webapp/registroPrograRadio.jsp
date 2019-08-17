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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
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
                    <h2>Programas</h2>
                    <p>Asignar programa a radio</p>

                </div>
            </section>
            <!-- ##### Breadcumb Area End ##### -->

            <section class="section-padding-100">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-12 col-lg-8">
                        ${msg}
                        <div class="login-content">
                            <h3>Registro de programas</h3>
                            <!-- Login Form -->
                            <div class="login-form">
                                <form action="programaradio?action=insertar" method="post">

                                    <div class="form-group">
                                        <label>Programa:</label> 
                                        <select name="programa" class="form-control">
                                            <option>Seleccione el programa</option>
                                            <c:forEach items="${programas}" var="p">
                                                <option value="<c:out value="${p.id_programa}"/>"><c:out value="${p.nombre_programa}"/></option>
                                            </c:forEach> 
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label>Radio:</label>
                                        <select name="radio" class="form-control">
                                            <option>Seleccione la radio</option>
                                            <c:forEach items="${radios}" var="r">
                                                <option value="<c:out value="${r.id_radio}"/>"><c:out value="${r.nombre_radio}"/></option>
                                            </c:forEach> 
                                        </select> 
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha de nacimiento </label>
                                        <div id="datetimepicker" class="input-append date">
                                            <input class="form-control" name="fecha" data-date-format="yyyy-mm-dd" id="datepicker">
                                            <!--<input class="form-control" name="fecha" >-->
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Hora de Inicio:</label>
                                        <div>
                                            <input type="time" class="form-control" name="hora" placeholder="08:30">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Duración:</label>
                                        <div>
                                            <input type="number" class="form-control" name="duracion" placeholder="Ingrese la duracion en minutos">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Emision:</label>
                                        <div>
                                            <select name="emision" class="form-control">
                                                <option selected>Seleccione el tipo de emisión</option>
                                                <c:forEach items="${emisiones}" var="e">
                                                    <option value="${e.id_emisiones}">${e.emision}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-check">
                                        
                                        <input type="checkbox" name="whatever" value="true"/>
                                        <label class="form-check-label">Repeticion?</label>
                                        <input   id="res" name="rpe">
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>



        <style type="text/css">

            .datepicker {
                font-size: 0.875em;
            }
            /* solution 2: the original datepicker use 20px so replace with the following:*/

            .datepicker td, .datepicker th {
                width: 1.5em;
                height: 1.5em;
            }

        </style>
        <script type="text/javascript">
            $('#datepicker').datepicker({
                weekStart: 1,
                daysOfWeekHighlighted: "6,0",
                autoclose: true,
                todayHighlight: true
            });
            $('#datepicker').datepicker("setDate", new Date());
        </script>
        <script type="text/javascript">
            $('#checkbox-value').text($('#checkbox1').val());

            $("#checkbox1").on('change', function () {
                if ($(this).is(':checked')) {
                    $(this).attr('value', '1');
                } else {
                    $(this).attr('value', '0');
                }

                $('#checkbox-value').text($('#checkbox1').val());
                //alert($('#checkbox1').val());
                document.getElementById('res').value = $('#checkbox1').val();
            });
        </script>
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
    </body>

</html>
