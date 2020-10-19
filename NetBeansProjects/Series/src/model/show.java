/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class show implements Serializable{

    private String tittle;
    private String scriptwriter;
    private int seasons;
    private String genre;
    private int views;
    private String plataforma;
    
    public show() {
        this.tittle = "";
        this.scriptwriter = "";
        this.seasons = 0;
        this.genre = "";
        this.views = 0;
        this.plataforma = "";
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    public show(String tittle, String scriptwriter, int seasons, String genre, int views, String plataforma) {
        this.tittle = tittle;
        this.scriptwriter = scriptwriter;
        this.seasons = seasons;
        this.genre = genre;
        this.views = views;
        this.plataforma = plataforma;       
    }    
}
