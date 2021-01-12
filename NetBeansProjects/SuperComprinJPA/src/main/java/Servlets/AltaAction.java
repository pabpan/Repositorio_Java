package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.GestionWallets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class AltaWallet
 */
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String DNI = request.getParameter("DNI");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String email = request.getParameter("email");
            int saldo_puntos = Integer.parseInt(request.getParameter("saldo_puntos"));
            int saldo_euros = Integer.parseInt(request.getParameter("saldo_euros"));
            //creamos un objeto de la capa de lgica de negocio
            //y llamamos al método encargado de hacer el alta
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_java = sdf.parse(fecha_nacimiento);
            java.sql.Date fecha_sql = new java.sql.Date(fecha_java.getDay(), fecha_java.getMonth(), fecha_java.getYear());            
            GestionWallets gestion_wallets = new GestionWallets();
            gestion_wallets.alta_Wallet(nombre, apellidos, DNI, fecha_sql, email, saldo_puntos, saldo_euros);
            request.getRequestDispatcher("RecuperarAction").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AltaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
