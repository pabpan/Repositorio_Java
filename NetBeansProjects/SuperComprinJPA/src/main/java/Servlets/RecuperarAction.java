package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionWallets;
import mx.com.gm.sga.domain.Wallet;

/**
 * Servlet implementation class RecuperarAction
 */
@WebServlet("/RecuperarAction")
public class RecuperarAction extends HttpServlet {

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
        GestionWallets gestion_wallets = new GestionWallets();
        List<Wallet> wallets = gestion_wallets.recuperar_Wallets();
        //guardamos contactos en un atributo de petici�n
        request.setAttribute("wallets", wallets);
        //trasnferencia de la petici�n
        request.getRequestDispatcher("wallets.jsp").forward(request, response);
    }

}
