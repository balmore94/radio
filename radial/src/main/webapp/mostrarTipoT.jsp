<%-- 
    Document   : MostrarTipoT
    Created on : 08-13-2019, 02:16:16 PM
    Author     : mario.rodriguezusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th style="text-align: center">Codigo</th>
                    <th style="text-align: center">Transmisión</th>
                </tr>
            <tbody>
                <c:forEach items="${tipo}" var="t">
                    <tr>
                        <td style="text-align: center">${t.id_transmision}</td>
                        <td style="text-align: center">${t.nombre_transmision}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </thead>
    </table>
</body>
</html>
