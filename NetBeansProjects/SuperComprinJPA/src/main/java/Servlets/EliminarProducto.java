package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionProductos;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("id_producto"));
        GestionProductos gestion_productos = new GestionProductos();
        gestion_productos.eliminar_Producto(idProducto);
        request.getRequestDispatcher("RecuperarProductos").forward(request, response);
    }

}
