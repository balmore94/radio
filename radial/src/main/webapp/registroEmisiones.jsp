<%-- 
    Document   : registroEmisiones
    Created on : 08-13-2019, 10:42:22 AM
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
        <div class="container">
        <div class="col-md-4">
            <br>
            <h2>EMISIONES</h2>
            <br>
            <form action="emisiones?action=insertar" method="POST">
                <div class="form-group">
                    <label>Emision</label>
                    <input class="form-control" name="emision">
                </div> 
                                
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
            ${msg}
        </div>
    </div>
    </body>
</html>
