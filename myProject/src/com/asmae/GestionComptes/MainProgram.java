package com.asmae.GestionComptes;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// La classe Mainprogam est une classe exécutable, parcequ'elle  contienne la méthode main
public class MainProgram {
    public static String generateRandomString(){
        String allowedChars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        StringBuilder sb=new StringBuilder(5);
        for(int i=0;i<5;i++){
            sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
        return sb.toString();
    }
    public static void menu(){
        System.out.println("0 - Quitter");
        System.out.println("1 - Créer un compte");
        System.out.println("2 - Afficher les détails d'un compte");
        System.out.println("3 - Effectuer des opérations sur ton compte");
    }





    public static void main(String[] args) {
        // Créer une base de données pour stocker les comptes
        countsDB dataBase=new countsDB();



        Scanner scanner=new Scanner(System.in);
        int choixBanque=-1,id,passWord;
        String nom,prenom,numero;
        boolean exist;

        Random randomLong=new Random();







        while(choixBanque!=0){
            menu();
            choixBanque=scanner.nextInt();
            switch (choixBanque) {
                case 1: {
                    exist = false;
                    do {
                        id = randomLong.nextInt();
                        numero = generateRandomString();
                        for (Map.Entry<String, Compte> compte : dataBase.getDataBase().entrySet()) {
                            if (compte.getKey().equals(numero)) {
                                exist = true;
                                break;
                            }
                        }
                    } while (exist);
                    scanner.nextLine();
                    System.out.println("votre nom : ");
                    nom = scanner.nextLine();
                    System.out.println("votre prenom : ");
                    prenom = scanner.nextLine();
                    System.out.println("donnez un mot de passe : ");
                    passWord = scanner.nextInt();
                    Client client = new Client(id, nom, prenom);

                    Compte compte = new Compte(id, numero, client, passWord);
                    dataBase.addCompte(compte);
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("numero de votre compte : ");
                    numero = scanner.nextLine();
                    exist = false;
                    Compte compteAfficher = new Compte();
                    for (Map.Entry<String, Compte> compte : dataBase.getDataBase().entrySet()) {
                        if (compte.getKey().equals(numero)) {
                            compteAfficher = compte.getValue();
                            exist = true;
                            break;
                        }
                    }
                    if (!exist) System.out.println("numéro introuvale");
                    else {
                        System.out.println("votre mot de passe : ");
                        passWord = scanner.nextInt();
                        compteAfficher.afficherDetails(passWord);
                    }
                    break;
                }
                case 3 : {
                    double montant;
                    scanner.nextLine();
                    System.out.println("Donner le numéro de votre compte : ");
                    numero=scanner.nextLine();
                    Compte compte=dataBase.getDataBase().get(numero);
                    System.out.println("Mot de passe : ");
                    passWord=scanner.nextInt();
                    if(compte.verifierCompte(passWord)){
                        int choixOperation=0;
                        while(choixOperation!=4){
                            System.out.println("-------------------------");
                            System.out.println(" <1> : renversement");
                            System.out.println(" <2> : retrait");
                            System.out.println(" <3> : afficher solde");
                            System.out.println(" <4> : quitter");
                            System.out.print("choisir une opération : ");

                            choixOperation=scanner.nextInt();
                            System.out.println("-------------------------");
                            switch (choixOperation){
                                case 1 :{
                                    System.out.println("Montant à renverser : ");
                                    montant=scanner.nextDouble();
                                    compte.setSolde(compte.getSolde()+montant);
                                    System.out.println(montant+" est ajouté à votre solde avec succes");
                                    System.out.println("solde actuel : "+compte.getSolde());
                                    break;
                                }
                                case 2 : {
                                    System.out.println("Montant à retraiter : ");
                                    montant=scanner.nextDouble();
                                    if(compte.getSolde()>=montant) {
                                        compte.setSolde(compte.getSolde()-montant);
                                        System.out.println("solde actuel : "+compte.getSolde());
                                    }
                                    else System.out.println("solde insuffisant ( "+compte.getSolde()+" )");
                                    break;
                                }
                                case 3 :{
                                    System.out.println("votre solde : "+compte.getSolde());
                                    break;
                                }
                                default:
                                    System.out.println("operation introuvable");
                                    break;
                            }
                        }
                    }



                }
            }
        }

    }
}
