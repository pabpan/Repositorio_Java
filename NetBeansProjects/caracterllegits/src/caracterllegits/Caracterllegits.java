/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caracterllegits;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author pabpan
 */
public class Caracterllegits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.rfc-editor.org/rfc/rfc8973.txt");
            printContent(url);
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Caracterllegits.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private static void printContent(URL url) {
        InputStream in;
        char[] cbuf = new char[512];
        int caractersLlegits;
        if (!isText(url)) {
            return;
        }
        try {
            in = url.openStream();
            InputStreamReader inr = new InputStreamReader(in);
            caractersLlegits = inr.read(cbuf);
            while (caractersLlegits != -1) {
                String str = String.copyValueOf(cbuf, 0, caractersLlegits);
                try {
                    Thread.sleep(1000);
                    System.out.print(str);
                } catch (Exception e) {
                }
                caractersLlegits = inr.read(cbuf);
            }
            System.out.println();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

    private static boolean isText(URL url) {

        boolean ret = false;
        try {
            URLConnection con = url.openConnection();
            String headerType = con.getContentType();
            String guessType = con.guessContentTypeFromName(url.getFile());
            ret = headerType.endsWith("text/plain") || guessType.endsWith("text/plain");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return ret;
    }

}
