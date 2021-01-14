package Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionDevoluciones;
import mx.com.gm.sga.domain.Devolucion;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarDevoluciones")
public class RecuperarDevoluciones extends HttpServlet {

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
        
        //COMPRAS
        GestionDevoluciones gestion_devoluciones = new GestionDevoluciones();
        List<Devolucion> devoluciones = gestion_devoluciones.recuperar_Devoluciones();
        //guardamos contactos en un atributo de petici�n
        request.setAttribute("devoluciones", devoluciones);
        //trasnferencia de la petici�n
        request.getRequestDispatcher("devoluciones.jsp").forward(request, response);

    }

}
