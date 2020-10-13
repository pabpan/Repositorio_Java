package series;

import view.frame;
import controller.controller;

public class Series {

    public static void main(String[] args) {

//        show sh = new show("Breaking Bad", "Vicent Guilligan", 5, "Drama", 5);
//        show sh1 = new show("Games Of Thrones", "David Benioff", 6, "Bélica", 6);
//
//        listShow ls = new listShow();
//        ls.setShow(sh);
//        ls.setShow(sh1);
//        access.SaveLS(ls);
//        System.out.println("Saved Series");
//        show sh2 = new show();
//        sh2 = ls.getShow(0);
//        System.out.println(sh2.getTittle());
//        System.out.println(sh2.getViews());
        
        controller control = new controller();
    
        frame f = new frame(control);
        f.setVisible(true);
    }

}
