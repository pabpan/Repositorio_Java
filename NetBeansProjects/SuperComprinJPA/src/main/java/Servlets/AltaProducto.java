package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionProductos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class AltaWallet
 */
@WebServlet("/AltaProducto")
public class AltaProducto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int puntos = Integer.parseInt(request.getParameter("puntos"));
        //creamos un objeto de la capa de lgica de negocio
        //y llamamos al método encargado de hacer el alta
        GestionProductos gestion_productos = new GestionProductos();
        gestion_productos.alta_Producto(nombre, precio, puntos);
        request.getRequestDispatcher("RecuperarProductos").forward(request, response);
    }
}
