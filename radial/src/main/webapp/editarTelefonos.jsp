<%-- 
    Document   : editarTelefonos
    Created on : 08-13-2019, 01:31:04 PM
    Author     : maria.aguillonusam
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
    </head>
    <body>
    <div class="container">
        <c:forEach items="${lista}" var="ver">
                        <form action="telefonos?action=actualizar" method="POST">
                                <div class="container col-md-6">
                    <hr>                   
                    <div class="form-group">
                        <label>Id Telefono</label>
                        <input class="form-control" name="id_telefono" value="${ver.id_telefono}">
                    </div> 

                    <div class="form-group">
                        <label>Telefono 1</label>
                        <input class="form-control" name="telefono1" value="${ver.telefono1}">
                    </div> 

                    <div class="form-group">
                        <label>Compania</label>
                        <input class="form-control" name="compania" value="${ver.compania}">
                    </div> 
                 
                    <button type="submit" class="btn btn-primary">Enviar</button> 
        </c:forEach>
        </form>
        ${msg}
    </div>
</div>
    </body>
</html>
