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
        position=0;
        return ls.getShow(position);
    }

}
