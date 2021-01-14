<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="Modelo.GestionCompras,java.util.ArrayList,mx.com.gm.sga.domain.Compra"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Compras</title>
    </head>
    <body>
        <c:set var="compras" value="${requestScope.compras}"/>
        <br/><br/><br/>
        <c:choose>
            <c:when test="${!empty compras}">
                <table border="1">
                    <tr>
                        <th>id_compra</th>
                        <th>id_wallet</th>
                        <th>id_producto</th>
                        <th>fecha_compra</th>
                    </tr>

                    <c:forEach var="cont" items="${compras}">
                        <tr><td>${cont.id_compra}</td>
                            <td>${cont.id_wallet}</td>
                            <td>${cont.id_producto}</td>
                            <td>${cont.fecha_compra}</td>
                            <td><a href="Controller?op=EliminarAction&id_compra=${cont.id_compra}">Eliminar</a></td></tr>
                        </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay compras</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>