package com.asmae.GestionComptes;
import java.util.ArrayList;
import java.util.List;

public class Compte {
    private int id;
    private String numéro; // capacity=5 => pour faciliter la saisie
    private double solde;
    private int passWord;

    /* la relation qui contient une seule reference */
    private Client client; /* navigation de reference "le client est une reference"
                            (relation d'association)=> un compte il a un client */

    /* un compte contient plusieurs opérations :
    --> collections - List - arrayList
     */
    /*    private List<Opération> operations=new ArrayList<Opération>();*/


    public Compte(){ solde=0; }
    public Compte(int id , String numéro , Client client,int passWord){
        this.id=id;
        this.numéro=numéro;
        this.solde=0; // lorsqu'on crée un compte, on l'initialise son solde à zéro
        this.client=client;
        this.passWord=passWord;
    }

    //public List<Opération> getOperations() {
      //  return operations;}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNuméro() {
        return numéro;
    }
    public void setNuméro(String numéro) {
        this.numéro = numéro;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }


    public boolean verifierCompte(int passWord){
        if(this.passWord!=passWord){
            System.out.println("le mot de passe est incorrect");
            return false;
        }
        return true;
    }
    public void afficherDetails(int passWord){
        if(verifierCompte(passWord)){
            System.out.println("id : "+this.id);
            System.out.println("numéro : "+this.numéro);
            System.out.println("nom et prénom : "+this.client.getNom()+" "+this.client.getPrenom());
            System.out.println("solde : "+this.getSolde());
        }
    }
}
