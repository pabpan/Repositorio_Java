package Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionCompras;
import mx.com.gm.sga.domain.Compra;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarCompras")
public class RecuperarCompras extends HttpServlet {

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
        GestionCompras gestion_compras = new GestionCompras();
        List<Compra> compras = gestion_compras.recuperar_Compras();
        //guardamos contactos en un atributo de petici�n
        request.setAttribute("compras", compras);
        //trasnferencia de la petici�n
        request.getRequestDispatcher("compras.jsp").forward(request, response);

    }

}
