<%-- 
    Document   : telefonos
    Created on : 08-13-2019, 11:29:47 AM
    Author     : maria.aguillonusam
--%>

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
        <div class="container col-md-8">
        <div >
            <h2>AEROPUERTO</h2>        
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>Id Telefono</th>
                        <th>Telefono 1</th>
                        <th>Compania</th>      
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="ver">
                        <tr>
                            <td>${ver.id_telefono}</td>
                            <td>${ver.telefono1}</td>
                            <td>${ver.compania}</td> 

                            <td>
                                <a href="telefonos?action=eliminar&id_telefono=${ver.id_telefono}"><button class="btn btn-danger">Eliminar</button></a>
                                <a href="telefonos?action=consultarById&id_telefono=${ver.id_telefono}"><button class="btn btn-info">Modificar</button></a>                           
                            </td>                    
                        </tr>
                    </c:forEach>                 
                </tbody>
            </table>
            ${msg}
        </div>      
    </div>
    </body>
</html>
