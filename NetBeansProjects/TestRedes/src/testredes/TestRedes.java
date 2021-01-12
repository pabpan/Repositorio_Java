package testredes;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestRedes {

    static InetAddress[] addresses = new InetAddress[2];

    public static void main(String[] args) throws UnknownHostException {

    addresses[0] = InetAddress.getLoopbackAddress();
    addresses[1] = InetAddress.getByName("ioc.xtec.cat");
        
        for (InetAddress adress : addresses) {
            if (adress.isLoopbackAddress()) {
                System.out.println(adress.getHostName() + "té una adreça loopback");
            } else {
                System.out.println(adress.getHostName() + " no té una adreça loopback");
            }
        }
    }
}
