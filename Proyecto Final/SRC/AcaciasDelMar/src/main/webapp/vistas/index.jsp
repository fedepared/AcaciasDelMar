<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="/consulta">
            <p>
                <select name="tipoVehiculo">
                    <c:forEach var="tipoVehiculo" items="${tipoVehiculos}" >
                        <option value="${tipoVehiculo}">${tipoVehiculo}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Enviar">
            </p>
        </form>
    </body>
</html>

