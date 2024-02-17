
/*
Application CONSOLE <<gestion de comptes bancaires>> qui
permet à l'utilisateur de:
1. Créer un compte et l'associer à un client
2. Réaliser des opérations qur un compte
3. Afficher le détail d'un compte

----------------------------
COMPTE : id - numéro - opérations - solde courant - client
OPERATION : date - type(versement/retrait) - montant
CLIENT : id - nom - prenom
--------------------------
-> Avant de créer un compte, o doit créer un client
--------------------------
_____ Classes & entités atomiques(attributs) & liens entre les classes_____
COMPTE : id - numéro - solde(àcalculer)
CLIENT : id - nom - prenom
>> association entre un client et un compte : un compte appartient à exactement un seul client
   pour simplifier on suppose qu'un client possede un seul compte

OPERATION : date - type(versement/retrait) - montant)
>> association entre un compte et une opération :
   un compte contient plusiers opérations
   une opération appartient à un seul compte


 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}