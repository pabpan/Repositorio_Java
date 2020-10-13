package controller;

import model.*;

public class controller {

    private int position;
    private listShow ls;
    public access acc = new access();

    public controller() {

        position = 0;
        ls = new listShow();
        ls = acc.loadLS();
    }

    public show first() {
        position = 0;
        return ls.getShow(position);
    }

    public show previous() {
        if (position > 0) {
            position--;
        }
        return ls.getShow(position);
    }

    public show next() {
        position++;
        if (position==ls.lenght()) {
            position--;
        }
        return ls.getShow(position);
    }
    
    public void nuevo(show s) {
        ls.setShow(s);
        position=ls.lenght()-1;
        acc.SaveLS(ls);
    }
}
