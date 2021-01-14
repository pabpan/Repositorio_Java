package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionWallets;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarWallet")
public class EliminarWallet extends HttpServlet {

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
        int idWallet = Integer.parseInt(request.getParameter("id_wallet"));
        GestionWallets gestion_wallets = new GestionWallets();
        gestion_wallets.eliminar_Wallet(idWallet);
        request.getRequestDispatcher("RecuperarWallets").forward(request, response);
    }

}
