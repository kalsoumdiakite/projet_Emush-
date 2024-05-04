package projet;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Utilisateur
 */
public class Joueur {
    Scanner sc = new Scanner(System.in);
    private String nom;
    private int PV;
    private int PA;
    private int PM;
    private int PMO;
    private boolean estMush;
    private Competence competence1;
    private Competence competence2;
    private Salle salle;
    private int vaisseau;
    private ArrayList<String> inventaire = new ArrayList<>();
    private String talkie_walkie= sc.nextLine() ;
    private ArrayList<String> canalHumain;
    private ArrayList<String> canalMush;
    
    public Joueur(String nom, int PV, int PA, int PM, int PMO, boolean estMush, Competence competence1, Competence competence2) {
        this.nom = nom;
        this.PV = PV;
        this.PA = PA;
        this.PM = PM;
        this.PMO = PMO;
        this.estMush = estMush;
        this.competence1 = competence1;
        this.competence2 = competence2;
    }
    public Joueur(String name,Salle s,int vaisseau){
        this.nom=name;
        this.salle=s;
        this.vaisseau=vaisseau;   
    }
    
    public void donnerSalle(Salle s){
   
   } 
   public String getTalkie_walkie(){
       String message;
       if(!this.estMush){
           message= "Joueur "+this.nom+": "+this.talkie_walkie ;
      } 
       else{message="les mushs ne possedent pas de talkie-walkie";}
       return message;}
    public void ajouterMessage(){ // cette methode permet d'ajouter aux joueurs d'ajouter des messages sur le canal
        if(!this.estMush){
      this.canalHumain.add(this.getTalkie_walkie());}
        else {System.out.println("Ce canal n'est accessible qu'aux humains");}
      
  }
    public void consulterCanalCom(){ //cette methode permet aux joueurs de consulter les dix derniers messages  
        if(!this.estMush){
        if (this.canalHumain.size()<10){for(String s : this.canalHumain){System.out.println(s);}}
        else {for (int i=this.canalHumain.size()-10;i<this.canalHumain.size();i++){System.out.println(this.canalHumain.get(i));}}
        }
    }
      public void ajouterMessageMush(){ // cette methode permet d'ajouter aux mushs d'ajouter des messages sur leur canal
        if(this.estMush){
      this.canalMush.add(sc.nextLine());}
        else {System.out.println("Ce canal n'est accessible qu'aux mushs");}
      
  }
        public void consulterCanalComMush(){ //cette methode permet aux joueurs de consulter les dix derniers messages  
        if(this.estMush){
        if (this.canalMush.size()<10){for(String s : this.canalMush){System.out.println(s);}}
        else {for (int i=this.canalMush.size()-10;i<this.canalMush.size();i++){System.out.println(this.canalMush.get(i));}}
        }
        else {System.out.println("Ce canal n'est accessible qu'aux mushs");}
    }
    /* Tous les personnages disposent d’un talkiewalkie pour échanger des messages sur un canal commun à tous. Les personnages mush
peuvent aussi communiquer entre eux par télépathie. Vous ferez donc en sorte que les joueurs
humains puissent ajouter des messages sur le canal commun ou consulter les 10 derniers
messages de ce canal dans la console. la gestion de la communication entre les joueurs, notamment la messagerie sur le canal commun et les canaux de communication spécifiques aux mushs.*/
    public void attaqueMainNue(Joueur cible) {
        if (this.PA >= 2) {
            this.perdrePA(2);
            cible.perdrePV(1);
            System.out.println(this.nom + " a attaqué " + cible.getNom() + " à main nue. " + cible.getNom() + " perd 1 PV.");
        } else {
            System.out.println(this.nom + " : PA insuffisant");
        }
    }
    public void attaqueArme(Joueur cible) {
        if (this.PA >= 1) {
            this.perdrePA(1);
            System.out.println(this.nom + " attaque " + cible.getNom());
        } else {
            System.out.println(this.nom + " : PA insuffisant");
        }
    }
    public void perdrePV(int points) {
        this.PV -= points;
        if (this.PV <= 0) {
            System.out.println(this.nom + " est mort");
        }
    }
    public void perdrePA(int points) {
        this.PA -= points;
    }
    public void perdrePM(int points) {
        this.PM -= points;
    }
    
   public void utiliserCompetence(String nomCompetence, Joueur cible) {
    switch (nomCompetence) {
        case "Tireur":
            if (this.inventaire.contains("blaster")) {
                System.out.println(this.nom + " utilise la compétence Tireur.");
                cible.perdrePV(4);
            } else {
                System.out.println("Pour utiliser la compétence Tireur, vous devez avoir une arme dans votre inventaire.");
            }
            break;
        case "Bourreau":
            if (this.PA >= 1) {
                this.perdrePA(1);
                cible.perdrePV(1);
                System.out.println(this.nom + " utilise la compétence Bourreau. " + cible.getNom() + " perd 1 PV.");
            } else {
                System.out.println(this.nom + " : PA insuffisant");
            }
            break;
    }
}
    public void Deplacer(Salle salleDestination) {
        if (salleDestination.estVoisineDe(this.salle)) {
            this.salle = salleDestination;
            this.perdrePM(1);
        }
    }
    public String toString(){
        return this.getNom()+ " dans la salle " + this.salle.getnomSalle();
    }

    public void gererPMO() {
        if (PMO <= 0) {
            PV--;
        }
    }
    public String getNom() {
        return nom;
    }
//À tout moment, chaque joueur sait combien il y a de mushs vivants à bord.
    /* Vous pouvez soit détruire
le Daedalus en sabotant les équipements et en mettant des bâtons dans les roues des humains,
soit transformer les humains en mush. Vous pouvez pour cela créer des spores et poinçonner
les humains avec. Un humain qui a 3 spores poinçonnées sur lui devient un mush. Un joueur
mush ne peut poinçonner qu’une seule fois par jour. Attention aux caméras présentes dans
certaines pièces qui peuvent détecter les actions « Créer une spore » et « Poinçonner une
spore ».*/

    public int getPV() {
        return PV;
    }

    public int getPA() {
        return PA;
    }

    public int getPM() {
        return PM;
    }

    public int getPMO() {
        return PMO;
    }

    public boolean estMush() {
        return estMush;
    }
    
     public Competence getCompetence1() {
        return competence1;
    }

    public Competence getCompetence2() {
        return competence2;
    }
    public ArrayList<String> getInventaire() {
        return inventaire;
    }
    public int  getNumsalle(){
        return this.salle.getID();
    }

    public int soignerJoueur() {
        return this.PA;
    }
}
