<%-- 
    Document   : registroCompania
    Created on : 08-14-2019, 08:32:57 AM
    Author     : rodrigo.martinezusam
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-md-4">
                <br>
                <h2>Compañia</h2>
                <br>
                <form action="compani?action=Insertar" method="POST">
                    <div class="form-group">
                        <label>Compañia</label>
                        <input class="form-control" name="nombre_compania">
                    </div> 

                    <div class="form-group">
                        <label>Registro FC</label>
                        <input class="form-control" name="registrofc">
                    </div> 

                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
                ${msg}
            </div>
        </div>
    </body>
</html>
