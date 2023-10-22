/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Lachgar
 */

public class Machine implements Serializable{

   
    private int id;
    private String ref;
    private String marque;
    private double prix;
  
    private Salle sl;

    public Machine() {
    }
     public Machine(String ref, String marque, double prix) {
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
 
    }

    public Machine(String ref, String marque, double prix,Salle s) {
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
        this.sl = s;
    }

    public int getId() {
        return id;
    }

    public Salle getSl() {
        return sl;
    }

    public void setSl(Salle sl) {
        this.sl = sl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Machine{" + "id=" + id + ", ref=" + ref + ", marque=" + marque + ", prix=" + prix + ", sl=" + sl + '}';
    }

    

}
