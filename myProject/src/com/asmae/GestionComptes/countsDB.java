package com.asmae.GestionComptes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countsDB {
        private Map<String,Compte> allComptes;


        public countsDB(){
            allComptes=new HashMap<>();
        }
        public Map<String,Compte> getDataBase(){
            return allComptes;
        }
        public void addCompte(Compte compte){
            allComptes.put(compte.getNuméro(),compte);
            System.out.println("compte ajouté avec succes");
            System.out.println("numero de votre compte : "+compte.getNuméro());
        }
}
