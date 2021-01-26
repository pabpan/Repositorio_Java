package psp_cliente_servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        try {
            //port a escoltar el servei que estem implementant
            int portAEscoltar = 5555;
//vector de bytes en el cual recibir el mensaje con capacidad de 1.024 bytes
            byte[] missatge = new byte[1024];
//creació del paquet en el qual rebre les dades de 1.024 bytes com a màxim
            DatagramPacket packet = new DatagramPacket(missatge, missatge.length);
//creació d’un socket que escolti el port passat per paràmetre
            DatagramSocket socket = new DatagramSocket(portAEscoltar);
//recepció d’un paquet
            socket.receive(packet);
            String mostrar = new String(packet.getData(), 0, packet.getData().length);
            System.out.println(mostrar);
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
