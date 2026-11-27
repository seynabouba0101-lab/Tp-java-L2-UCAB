package model;

import com.sun.jdi.connect.Connector;

public class proprietaire {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;


    public proprietaire (int id,String nom,String prenom,String aresse){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
    }
    public proprietaire (String nom,String prenom,String adresse){
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdressedresse() {
        return adresse;
    }
}

