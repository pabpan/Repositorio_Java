<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="Modelo.GestionProductos,java.util.ArrayList,mx.com.gm.sga.domain.Producto"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Productos</title>
    </head>
    <body>
        <c:set var="productos" value="${requestScope.productos}"/>
        <br/><br/><br/>
        <c:choose>
            <c:when test="${!empty productos}">
                <table border="1">
                    <tr>
                        <th>id_producto</th>
                        <th>nombre</th>
                        <th>precio</th>
                        <th>puntos</th>
                    </tr>

                    <c:forEach var="cont" items="${productos}">
                        <tr><td>${cont.id_producto}</td>
                            <td>${cont.nombre}</td>
                            <td>${cont.precio}</td>
                            <td>${cont.puntos}</td>
                            <td><a href="Controller?op=EliminarProducto&id_producto=${cont.id_producto}">Eliminar</a></td></tr>
                        </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay productos</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>