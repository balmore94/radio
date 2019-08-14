<%-- 
    Document   : compania
    Created on : 08-14-2019, 08:25:57 AM
    Author     : rodrigo.martinezusam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="container col-md-8">
        <div >
            <h2>Compania</h2>        
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>Id Compañia</th>
                        <th>Registro FC</th>
                        <th>Compañia</th>      
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${compania}" var="c">
                        <tr>
                            <td>${c.id_compania}</td>
                            <td>${c.registrofc}</td>
                            <td>${c.nombre_compania}</td> 

                            <td>
                                <a href="compani?action=Eliminar&id_compania=${c.id_compania}"><button class="btn btn-danger">Eliminar</button></a>
                                <a href="compani?action=search&id_compania=${c.id_compania}"><button class="btn btn-warning">Modificar</button></a>                           
                            </td>                    
                        </tr>
                    </c:forEach>                 
                </tbody>
            </table>            
        </div>      
    </div>
    </body>
</html>
