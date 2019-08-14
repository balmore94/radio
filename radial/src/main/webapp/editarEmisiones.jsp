<%-- 
    Document   : editarEmisiones
    Created on : 08-13-2019, 01:33:24 PM
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
        
            <form action="emisiones?action=actualizar" method="POST">
                <c:forEach items="${lista}" var="ver">
                   <div class="container col-md-4">
                                    
                    <div class="form-group">
               
                        <input  type="hidden" class="form-control" name="id_emisiones" value="<c:out value="${ver.id_emisiones}"/>">
                    </div> 

                    <div class="form-group">
                        <label>Emision</label>
                        <input class="form-control" name="emision" value="<c:out value="${ver.emision}"/>">
                    </div> 
                 
                    <button type="submit" class="btn btn-primary">Enviar</button> 
                </c:forEach>
        </form>
        ${msg}
    </div>
</div>
    </body>
</html>
