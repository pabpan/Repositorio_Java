/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebagif;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class PRUEBAGIF {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://kinsta.com/es/wp-content/uploads/sites/8/2019/09/jpg-vs-jpeg.jpg");
            if (isGifFormat(url) == true) {
                System.out.println("Es un gif");
            } else {
                System.out.println("No es un gif");
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
    }

    public static boolean isGifFormat(URL url) {
        boolean ret = false;
        try {
            URLConnection con = url.openConnection();
            String headerType = con.getContentType();
            String guessType = con.guessContentTypeFromName(url.getFile());
            ret = headerType.endsWith("gif") || guessType.endsWith("gif");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return ret;
    }
}
