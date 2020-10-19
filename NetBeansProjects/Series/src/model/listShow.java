package model;

import java.io.Serializable;
import java.util.*;

public class listShow implements Serializable {

    private ArrayList<show> seriesList;

    public void removeShow(int position) {
        seriesList.remove(position);
    }

    public show editShow(int position) {
        return seriesList.get(position);
    }

    public listShow() {
        seriesList = new ArrayList<>();
    }

    public show getShow(int p) {
        return seriesList.get(p);
    }

    public void setShow(show s) {
        seriesList.add(s);
    }

    public int lenght() {
        return seriesList.size();
    }
}
