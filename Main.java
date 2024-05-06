package projet;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Utilisateur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Joueur> joueurs = creerTousLesJoueurs();

        System.out.println("Tous les joueurs du jeu : ");
        afficherTousLesJoueurs(joueurs);

        System.out.println("Joueurs, veuillez choisir votre personnage : ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Joueur " + (i + 1) + ", choisissez un personnage en saisissant son numéro : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            if (choix >= 1 && choix <= joueurs.size()) {
                Joueur joueurChoisi = joueurs.get(choix - 1);
                System.out.println("Joueur " + (i + 1) + ", voici votre personnage : ");
                afficherJoueur(joueurChoisi);
            } else {
                System.out.println("Choix invalide .");
                i--;
            }
        }

        scanner.close();
    }

    public static ArrayList<Joueur> creerTousLesJoueurs() {
        ArrayList<Joueur> joueurs = new ArrayList<>();

        joueurs.add(new Joueur("Wang Chao", 14, 12, 12, 7, false,new String[]{"Tireur","Bourreau"}));
        joueurs.add(new Joueur("Zhong Chun", 14, 12, 12, 7, false,new String[]{"Seul espoir","Infirmier"}));
        joueurs.add(new Joueur("Eleesha Williams", 14, 12, 12, 7, false,new String[]{"Traqueur","Observateur"}));
        joueurs.add(new Joueur("Finola Keegan", 14, 12, 12, 7, false,new String[]{"Biologiste","Infirmier"}));
        joueurs.add(new Joueur("Frieda Bergmann", 14, 12, 12, 7, false,new String[]{"Astrophysicien","Pilote"}));
        joueurs.add(new Joueur("Gioele Rinaldao", 14, 12, 12, 7, false,new String[]{"Robuste","Paranoïaque"}));
        joueurs.add(new Joueur("Jiang Hua", 14, 12, 12, 7, false,new String[]{"Pilote","Technicien"}));
        joueurs.add(new Joueur("Ian Soulton (botaniste)", 14, 12, 12, 7, false,new String[]{"Biologiste","Mycologiste"}));
        joueurs.add(new Joueur("Janice Kent (psychologue)", 14, 12, 12, 7, false,new String[]{"Psy","Informaticien"}));
        joueurs.add(new Joueur("Kim Jin Su (commandant)", 14, 12, 12, 7, false,new String[]{"Leader","Pilote"}));
        joueurs.add(new Joueur("Lai Kuan-Ti (architecte)", 14, 12, 12, 7, false,new String[]{"Concepteur","Optimiste"}));
        joueurs.add(new Joueur("Paola Rinaldo (officier)", 14, 12, 12, 7, false,new String[]{"Logistique","Tireur"}));
        joueurs.add(new Joueur("Raluca Tomescu (génie)", 14, 12, 12, 7, false,new String[]{"Physicien","Détaché"}));
        joueurs.add(new Joueur("Roland Zuccali (employé fedex)", 14, 12, 12, 7, false,new String[]{"Sprinter","Pilote"}));
        joueurs.add(new Joueur("Stephen Seagull (top chef)", 14, 12, 12, 7, false,new String[]{"Cuistot","Robuste"}));
        joueurs.add(new Joueur("Terrence Archer (technophile)", 14, 12, 12, 7, false,new String[]{"Technicien","Tireur"}));

        return joueurs;
    }

    public static void afficherTousLesJoueurs(ArrayList<Joueur> joueurs) {
        for (int i = 0; i < joueurs.size(); i++) {
            System.out.println("Joueur " + (i + 1) + " : ");
            afficherJoueur(joueurs.get(i));
        }
    }

    public static void afficherJoueur(Joueur joueur) {
        System.out.println("Nom du joueur : " + joueur.getNom());
        System.out.println("Points de vie : " + joueur.getPV());
        System.out.println("Points d'action : " + joueur.getPA());
        System.out.println("Points de mouvement : " + joueur.getPM());
        System.out.println("Points de mouvement offensif : " + joueur.getPMO());
        System.out.println("Est un mush : " + joueur.estMush());
        System.out.println("Compétence1 du joueur : " + joueur.getCompetences());
    } 
}
