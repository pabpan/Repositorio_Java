package series;

import view.frame;
import controller.controller;

public class Series {

    public static void main(String[] args) {
        
        controller control = new controller();    
        frame f = new frame(control);
        f.setVisible(true);
    }

}
