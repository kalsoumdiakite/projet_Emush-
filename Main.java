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
        Vaisseau v_Spatial = new Vaisseau();
        String [] tab1= {"Pont","Tour.A", "Tour.B","Coul" , "Labo", "Jardin"};
        boolean [][]tab2 = {{false ,true,true,true,false,false},{true ,false,false,true,false,false},{true ,false,false,true,false,false},{true,true,true,false,true,true},{false ,false,false,true,false,false},{false ,false,false,true,false,false}};
        v_Spatial.init(tab1,tab2);
        System.out.println(v_Spatial.toString());
        System.out.println(v_Spatial.getIDVaisseau());
        Scanner scanner = new Scanner(System.in);
        ArrayList<Joueur> joueurs = creerTousLesJoueurs();
        ArrayList<Joueur> joueursChoisi = new ArrayList<>();
        System.out.println("Tous les joueurs du jeu : ");
        afficherTousLesJoueurs(joueurs);
        int nbMush = 0;
        ArrayList<Integer> mush = new ArrayList<>();
        ArrayList<Integer> nonMush = new ArrayList<>();
        System.out.println("Voulez-vous jouer en tant que mush (Oui/Non) ?");
        for (int i = 0; i < 3; i++) {
            System.out.println("Joueur " + (i + 1) + "Choisissez entre oui ou non ");
            String choix = scanner.nextLine();
            if (choix.equals("oui")) {
                nbMush++;
                mush.add(i);
            } else {
                nonMush.add(i);
                }
            }

        while (nbMush < 2 && nonMush.size() > 0) {
            int random = (int) (Math.random() * nonMush.size());
            int indexjoueurChoix= nonMush.remove(random); // pour qu'il n'y ait pas de répétition
            mush.add(indexjoueurChoix);
            nbMush++;
        }

        System.out.println("Les joueurs suivants sont mushs : ");
        for (int i = 0; i < mush.size(); i++) {
            Joueur joueurChoisi = joueurs.get(mush.get(i));
            joueursChoisi.add(joueurChoisi);
            afficherJoueur(joueurChoisi);
        }

        for (int i = 0; i < nonMush.size(); i++) {
            Joueur joueurChoisi = joueurs.get(nonMush.get(i));
            joueursChoisi.add(joueurChoisi);
            afficherJoueur(joueurChoisi);
        }
        placerJoueurs(joueursChoisi, v_Spatial);
        afficherPosition(joueursChoisi);
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
    public static void afficherPosition(ArrayList<Joueur> joueurs) {
        for (Joueur joueur : joueurs) {
            System.out.println(joueur.getNom() + " est dans la salle : " + joueur.getSalleActuelle());
        }
    }
    public static void placerJoueurs(ArrayList<Joueur> joueurs, Vaisseau vaisseau) {
        for (Joueur joueur : joueurs) {
            int index = (int) (Math.random() * vaisseau.getNbSalles());
            while (vaisseau.getSalle(index).getestOccupe()) {
                index = (int) (Math.random() * vaisseau.getNbSalles());
            }
            joueur.setSalleActuelle(vaisseau.getSalle(index).getnomSalle());
            vaisseau.getSalle(index).setestOccupe(true);
        }
    }
    public static void afficherJoueur(Joueur joueur) {
        System.out.println("Nom du joueur : " + joueur.getNom());
        System.out.println("Points de vie : " + joueur.getPV());
        System.out.println("Points d'action : " + joueur.getPA());
        System.out.println("Points de mouvement : " + joueur.getPM());
        System.out.println("Points de mouvement offensif : " + joueur.getPMO());
        System.out.println("Est un mush : " + joueur.estMush());
        System.out.println("Compétence du joueur : " + joueur.getCompetences());
    } 
}
