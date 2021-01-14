<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="Modelo.GestionWallets,java.util.ArrayList,mx.com.gm.sga.domain.Wallet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <style type="text/css">
        .tftable {font-size:14px;color:#333333;width:50%;border-width: 1px;border-color: #729ea5;border-collapse: collapse;margin-left:auto;margin-right:auto;}
        .tftable th {font-size:14px;background-color:#acc8cc;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5;text-align:left;}
        .tftable tr {background-color:#ffffff;}
        .tftable td {font-size:14px;border-width: 1px;padding: 8px;border-style: solid;border-color: #729ea5;}
        .tftable tr:hover {background-color:#ffff99;}
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Wallets</title>
    </head>
    <body>
        <c:set var="wallets" value="${requestScope.wallets}"/>
        <c:choose>
            <c:when test="${!empty wallets}">
                <table class="tftable" border="1">
                    <tr><th colspan="9"><center>SUPERCOMPRÍN - PABLO SUÁREZ</center></th></tr>
                    <tr>
                        <th><center>Nº Wallet</center></th>
                        <th><center>Nombre</center></th>
                        <th><center>Apellidos</center></th>
                        <th><center>DNI</center></th>
                        <th><center>Fecha de nacimiento</center></th>
                        <th><center>Email</center></th>
                        <th><center>Saldo puntos</center></th>
                        <th><center>Saldo euros</center></th>
                        <th><center>Eliminar</center></th>
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
                            <td><a href="Controller?op=EliminarWallet&id_wallet=${cont.id_wallet}">Eliminar</a></td></tr>
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