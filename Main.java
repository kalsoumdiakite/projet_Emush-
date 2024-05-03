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
        
        ArrayList<Competence> competences = creerToutesLesCompetences();

        ArrayList<Joueur> joueurs = creerTousLesJoueurs(competences);

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
    
    public static ArrayList<Competence> creerToutesLesCompetences() {
        ArrayList<Competence> competences = new ArrayList<>();

        // Création des compétences et ajout à la liste
        competences.add(new Competence("Tireur", "peut tirer 2 fois par jour sans utiliser sans utiliser de PA, s’il a une arme dans son inventaire"));
        competences.add(new Competence("Bourreau", "pour 1 PA, fait perdre 1 PV à la cible puis révèle autant de ses dernières actions qu’il lui manque de PV.."));
        competences.add(new Competence("Seul espoir", " elle ne peut pas être contaminée par un mush ni être mush en début de partie."));
        competences.add(new Competence("Infirmier", "peut soigner gratuitement 1 joueur chaque jour (+4 PV)"));
        competences.add(new Competence("Traqueur", " permet d’accéder aux historiques de déplacements"));
        competences.add(new Competence("Observateur", " l’action fouiller coûte 1 PA de moins"));
        competences.add(new Competence("Biologiste", "+10% de bonus sur les projets de recherche dans le laboratoire"));
        competences.add(new Competence("Astrophysicien", "l’action « scanner une planète » coûte 1 PA de moins et permet de découvrir un secteur de plus par rapport à un autre joueur "));
        competences.add(new Competence("Pilote", "peut piloter un des jets d’attaque ou le vaisseau d’exploration"));
        competences.add(new Competence("Robuste", "les attaques de corps-à-corps infligent 1 point de dégât supplémentaire (- 1PV) "));
        competences.add(new Competence("Paranoïaque", "commence avec deux caméras dans son inventaire, en plus de celles présentes dans le vaisseau"));
        competences.add(new Competence("Technicien", "peut réparer gratuitement 1'équipement par jour"));
        competences.add(new Competence("Mycologiste", "lorsque vous soignez un équipier, il perd automatiquement un spore"));
        competences.add(new Competence("Psy", " peut réconforter un joueur pour 1 PA ce MO "));
        competences.add(new Competence("Informaticien", "donne 2 actions gratuites utilisables pour des projets NERON"));
        competences.add(new Competence("Leader", "pour 2 PA, prononce un discours qui rend 2 PMO à tous les joueurs présents dans la même salle que lui"));
        competences.add(new Competence("Concepteur", "+2 PA par jour"));
        competences.add(new Competence("Optimiste", "perd 1 PMO de moins par jour"));
        competences.add(new Competence("Logistique", "à chaque fin de cycle, distribue 1 PA supplémentaire à un joueur choisi au hasard dans la salle"));
        competences.add(new Competence("Physicien", "1 action gratuite par jour pour réparer PILGRED"));
        competences.add(new Competence("Détaché", "pas de perte de PMO lorsqu’un joueur meurt"));
        competences.add(new Competence("Sprinter", "2 PM supplémentaires en cas de conversion d’1 PA"));
        competences.add(new Competence("Cuistot", "peut cuisiner 4 rations par jour"));
        return competences;
    }

    public static ArrayList<Joueur> creerTousLesJoueurs(ArrayList<Competence> competences) {
        ArrayList<Joueur> joueurs = new ArrayList<>();

        joueurs.add(new Joueur("Wang Chao", 14, 12, 12, 7, false, competences.get(1), competences.get(2)));
        joueurs.add(new Joueur("Zhong Chun", 14, 12, 12, 7, false, competences.get(3), competences.get(4)));
        joueurs.add(new Joueur("Eleesha Williams", 14, 12, 12, 7, false, competences.get(5), competences.get(6)));
        joueurs.add(new Joueur("Finola Keegan", 14, 12, 12, 7, false, competences.get(7), competences.get(8)));
        joueurs.add(new Joueur("Frieda Bergmann", 14, 12, 12, 7, false, competences.get(9), competences.get(10)));
        joueurs.add(new Joueur("Gioele Rinaldao", 14, 12, 12, 7, false, competences.get(11), competences.get(12)));
        joueurs.add(new Joueur("Jiang Hua", 14, 12, 12, 7, false, competences.get(10), competences.get(13)));
        joueurs.add(new Joueur("Ian Soulton (botaniste)", 14, 12, 12, 7, false, competences.get(7), competences.get(14)));
        joueurs.add(new Joueur("Janice Kent (psychologue)", 14, 12, 12, 7, false, competences.get(15), competences.get(16)));
        joueurs.add(new Joueur("Kim Jin Su (commandant)", 14, 12, 12, 7, false, competences.get(17), competences.get(7)));
        joueurs.add(new Joueur("Lai Kuan-Ti (architecte)", 14, 12, 12, 7, false, competences.get(18), competences.get(19)));
        joueurs.add(new Joueur("Paola Rinaldo (officier)", 14, 12, 12, 7, false, competences.get(20), competences.get(1)));
        joueurs.add(new Joueur("Raluca Tomescu (génie)", 14, 12, 12, 7, false, competences.get(21), competences.get(22)));
        joueurs.add(new Joueur("Roland Zuccali (employé fedex)", 14, 12, 12, 7, false, competences.get(23), competences.get(7)));
        joueurs.add(new Joueur("Stephen Seagull (top chef)", 14, 12, 12, 7, false, competences.get(24), competences.get(11)));
        joueurs.add(new Joueur("Terrence Archer (technophile)", 14, 12, 12, 7, false, competences.get(14), competences.get(1)));

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
        System.out.println();
    } 
}
