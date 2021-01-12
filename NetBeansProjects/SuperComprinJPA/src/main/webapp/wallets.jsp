<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="Modelo.GestionWallets,java.util.ArrayList,mx.com.gm.sga.domain.Wallet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Wallets</title>
    </head>
    <body>
        <c:set var="wallets" value="${requestScope.wallets}"/>
        <br/><br/><br/>
        <c:choose>
            <c:when test="${!empty wallets}">
                <table border="1">
                    <tr>
                        <th>id_wallet</th>
                        <th>nombre</th>
                        <th>apellidos</th>
                        <th>DNI</th>
                        <th>fecha_nacimiento</th>
                        <th>email</th>
                        <th>saldo_puntos</th>
                        <th>saldo_euros</th>
                        <th></th>
                    </tr>

                    <c:forEach var="cont" items="${wallets}">
                        <tr><td>${cont.id_wallet}</td>
                            <td>${cont.nombre}</td>
                            <td>${cont.apellidos}</td>
                            <td>${cont.DNI}</td>
                            <td>${cont.fecha_nacimiento}</td>
                            <td>${cont.email}</td>
                            <td>${cont.saldo_puntos}</td>
                            <td>${cont.saldo_euros}</td>
                            <td><a href="Controller?op=EliminarAction&id_wallet=${cont.id_wallet}">Eliminar</a></td></tr>
                        </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay wallets</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="index.html">Menu</a>
    </body>
</html>