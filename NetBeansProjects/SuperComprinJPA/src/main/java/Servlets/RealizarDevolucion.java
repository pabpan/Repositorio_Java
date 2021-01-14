package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionDevoluciones;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class AltaWallet
 */
@WebServlet("/RealizarDevolucion")
public class RealizarDevolucion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id_wallet = Integer.parseInt(request.getParameter("id_wallet"));
            int id_producto = Integer.parseInt(request.getParameter("id_producto"));
            String fecha_devolucion = request.getParameter("fecha_devolucion");
            //creamos un objeto de la capa de lgica de negocio
            //y llamamos al método encargado de hacer el alta
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_java = sdf.parse(fecha_devolucion);
            java.sql.Date fecha_sql = new java.sql.Date(fecha_java.getDay(), fecha_java.getMonth(), fecha_java.getYear());
            GestionDevoluciones gestion_devoluciones = new GestionDevoluciones();
            gestion_devoluciones.realizar_Devolucion(id_wallet, id_producto, fecha_sql);
            request.getRequestDispatcher("RecuperarDevoluciones").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RealizarDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
