package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

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
        String op = request.getParameter("op");
        String url = "";
        switch (op) {
            case "AltaWallet":
                url = "AltaWallet";
                break;
            case "AltaProducto":
                url = "AltaProducto";
                break;     
            case "RealizarCompra":
                url = "RealizarCompra";
                break;
            case "RealizarDevolucion":
                url = "RealizarDevolucion";
                break;                 
            case "RecuperarWallets":
                url = "RecuperarWallets";
                break;
            case "RecuperarProductos":
                url = "RecuperarProductos";
                break;  
            case "RecuperarCompras":
                url = "RecuperarCompras";
                break; 
            case "RecuperarDevoluciones":
                url = "RecuperarDevoluciones";
                break;  
            case "EliminarWallet":
                url = "EliminarWallet";
                break;  
            case "EliminarProducto":
                url = "EliminarProducto";
                break;                  
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
