package model;

public class compte {
    private String numero;
    private double solde;
    private int proprietaire_id;

    public compte(String numero,double solde,int id_proprietaire){
        this.numero=numero;
        this.solde=solde;
        this.proprietaire_id=id_proprietaire;


    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public int getProprietaire_id() {
        int proprietaire_id;
        return proprietaire_id;
    }

    public  getProprietaire_Id() {
    }
}


