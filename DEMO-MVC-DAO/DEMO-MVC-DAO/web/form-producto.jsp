
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Ingreso</title>
    </head>

    <body>
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <div><h1><strong>StockMaster</strong></h1></div>
            </div>
        </nav>
        <h1>Ingresar nuevo producto:</h1>

        <form action="ProductoController" method="post">

            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Nombre:</span>
                <input type="text" name="nombre" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" <c:out value="${producto.nombre}"></c:out>>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Categoria:</span>
                    <input type="text" name="categoria" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" <c:out value="${producto.categoria}"></c:out>><br/>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Cantidad:</span>
                    <input type="text" name="cantidad" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" <c:out value="${producto.cantidad}"></c:out>><br/>
                </div>
                <button class="btn btn-outline-secondary" type="submit" id="button-addon1"><input type="hidden" name="id" value="<c:out value="${producto.id}"></c:out>">Guardar</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
