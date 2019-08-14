<%-- 
    Document   : editarCompania
    Created on : 08-14-2019, 09:31:37 AM
    Author     : rodrigo.martinezusam
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
        <div class="container">
            <form action="compani?action=update" method="POST">
                <c:forEach items="${compania}" var="c">
                    <div class="row">
                        <div class="col-md-0">   
                            <div class="form-group">                                
                                <input  type="hidden" class="form-control" name="id_compania" value="<c:out value="${c.id_compania}"/>">
                            </div> 
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6" style="text-align: right">
                            <label>RegistroFC:</label>
                        </div>
                        <div class="col-md-6">                            
                            <div class="form-group">                                
                                <input class="form-control" name="registrofc" value="<c:out value="${c.registrofc}"/>">
                            </div> 
                        </div>                       
                    </div>
                    <div class="row">
                        <div class="col-md-6" style="text-align: right">
                            <label>Nombre Compañia:</label>
                        </div>
                        <div class="col-md-6">                            
                            <div class="form-group">                                
                                <input class="form-control" name="nombre_compania" value="<c:out value="${c.nombre_compania}"/>">
                            </div> 
                        </div>                       
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-primary">Enviar</button> 
                        </div>
                    </div>
                </c:forEach>          
            </form>           
        </div>   
    </body>
</html>
