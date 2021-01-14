package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionCompras;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class AltaWallet
 */
@WebServlet("/RealizarCompra")
public class RealizarCompra extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id_wallet = Integer.parseInt(request.getParameter("id_wallet"));
            int id_producto = Integer.parseInt(request.getParameter("id_producto"));
            String fecha_compra = request.getParameter("fecha_compra");
            //creamos un objeto de la capa de lgica de negocio
            //y llamamos al método encargado de hacer el alta
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_java = sdf.parse(fecha_compra);
            java.sql.Date fecha_sql = new java.sql.Date(fecha_java.getDay(), fecha_java.getMonth(), fecha_java.getYear());
            GestionCompras gestion_compras = new GestionCompras();
            gestion_compras.alta_Compra(id_wallet, id_producto, fecha_sql);
            request.getRequestDispatcher("RecuperarCompras").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RealizarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
