package psp_cliente_servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        try {
            //bytes del missatge a enviar
            byte[] missatge = "Salutacions".getBytes();
//adreça IP del destí
            InetAddress adrecaDesti = InetAddress.getByName("localhost");
//port destí
            int portDesti = 5555;
//creació del paquet a enviar
            DatagramPacket packet
                    = new DatagramPacket(missatge, missatge.length, adrecaDesti, portDesti);
//creació d’un socket temporal amb el qual realitzar l’enviament
            DatagramSocket socket = new DatagramSocket();
//Enviament del missatge
            socket.send(packet);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
