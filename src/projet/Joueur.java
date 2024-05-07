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
    private String [] competences; // tableau des deux competences 
    private Objets [] inventaire = new Objets [3];
    private Salle   salle;// Salle  dans le quel il se trouve
    private int vaisseau;// numéro vaisseau dans le quel il se trouve 
    private String talkie_walkie= sc.nextLine() ;
    private ArrayList<String> canalHumain; // canal des huamins 
    private ArrayList<String> canalMush;
    private ArrayList<String> historiqueDeplacement;
    private boolean propre;// permet de dire si le joueur est propre ou pas 
      


    
    public Joueur(String nom, String [] compt) {
        this.nom = nom;
        this.PV = 14;
        this.PA = 12;
        this.PM = 12;
        this.PMO = 7;
        this.competences=compt;
      
    }
    public Joueur(String name,Salle s,int vaisseau){
        this.nom=name;
        this.salle=s;
        this.vaisseau=vaisseau;
        
    }
    @Override
    public String toString(){return this.getNom()+" dans la salle "+this.salle.getnomSalle()+" ";}

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
    
     public String [] getCompetences() {
        return competences;
    }
      public String  getCompetence(int i) {
          
        return competences[i];
    }
      public ArrayList<String> getHistorique(){ return this.historiqueDeplacement;}
 public  Objets [] getInventaire(){ return this.inventaire;}
 
 public boolean getpropre(){ return this.propre;}
    public void propre(){ this.propre=true;} // le joueur est propre avec cette methode 
    
    public int  getNumsalle(){return this.salle.getID();} // retourne l'identifiant de la salle ou se trouve le joueur 
    public Salle getSalle(){ return this.salle;}
    
   public String getTalkie_walkie(){
       String message;
       if(!this.estMush){
           message= "Joueur "+this.nom+": "+this.talkie_walkie + Date(System.currentTimeMillis());
      } 
       else{message="les mushs ne possedent pas de talkie-walkie";}
       return message;}
   
   
   public void ajouterObjet(Objets obj){for(int i=0;i<this.inventaire.length;i++){if(this.inventaire[i]==null){
       if(obj!=null){this.inventaire[i]=obj;
       return;}
       else{System.out.println("Objet à ajouter est null ");}
   }
   else {System.out.println("impossible d'ajouter l'objet");}}}
   
   
   
   public void afficherEtatJoueur(){ // acheivement2
       System.out.println("le nombre de points de vie "+this.PV);
       System.out.println("le nombre de points d'action "+this.PA);
       System.out.println("le nombre de points de mouvement "+this.PM);
       System.out.println("le nombre de points de moral "+this.PMO);
       System.out.println("inventaire:");
       for(int i=0;i<this.inventaire.length;i++){System.out.println(this.inventaire[i]);}
       if(this.estMush){System.out.println("Type:mush");}
       else{System.out.println("Type:joueur");}
       System.out.println("nom:"+this.nom);
       System.out.println("Compétences:");
       for(int i=0;i<this.competences.length;i++){System.out.println(this.competences[i]);}
       
    
    }
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
      this.canalMush.add( "Joueur "+this.nom+": "+ sc.nextLine() + Date(System.currentTimeMillis()));}
        else {System.out.println("Ce canal n'est accessible qu'aux mushs");}
      
  }
        public void consulterCanalComMush(){ //cette methode permet aux joueurs de consulter les dix derniers messages  
        if(this.estMush){
        if (this.canalMush.size()<10){for(String s : this.canalMush){System.out.println(s);}}
        else {for (int i=this.canalMush.size()-10;i<this.canalMush.size();i++){System.out.println(this.canalMush.get(i));}}
        }
        else {System.out.println("Ce canal n'est accessible qu'aux mushs");}
    }
        
        
         public void perdrePV(int points) {  // quand le joueur perd des PV 
   
        if (this.PV <= 0) {
            System.out.println(this.nom + " est mort");
        }else {
            
            this.PV -= points;}
    }
         
         
    public void perdrePA(int points) {  // quand le joueur perd des PA
        
        this.PA -= points;
    }
    
    
    public void perdrePM(int points) { // quand le joueur perd des PO
        this.PM -= points;
    }
    
    
     public void perdrePMO(int points) { // quand le joueur perd des PMO
        this.PMO -= points;
    }
      public void recupererPV(int points) {  // quand le joueur perd des PV 
        
        if (this.PV >14) {
            System.out.println("le nombre maximum de PV est de 14");
        }
        else {this.PV += points;}
    }
      
      
         public void recupererPMO(int points) {  // quand le joueur perd des PV 
        
        if (this.PMO >14) {
            System.out.println("le nombre maximum de PMO est de 14");
        }
        else {this.PMO += points;}
    }
         
         
    public void recupererPA(int points) {  // quand le joueur perd des PA
        if (this.PA>12){System.out.println("le nombre maxiamum de PA est de 12");}
        else{
        this.PA += points;}
    }
    
    
    public void recupererPM(int points) { // quand le joueur perd des PO
                if (this.PM>12){System.out.println("le nombre maxiamum de PM est de 12");}
        else{
        this.PM += points;}
    }
    
    
      public void gestionDesPoints(){// cette methode permet de calculer les PA PM PMO PV  a chaque nouvel cycle
          for (int cycle=1;cycle<=8;cycle++){
          this.recupererPA(1); //A chaque cycle, chaque joueur récupère 1 PA
          this.recupererPM(1); //A chaque cycle, chaque joueur récupère 1 PM.
          while(this.PMO==0){this.perdrePV(1);}//Si le nombre de PMO tombe à zéro, le joueur perd 1 PV par cycle tant qu’il a 0 PMO
           if (this.PV <= 0) {
            System.out.println(this.nom + " est mort"); //Si le nombre de PV tombe à zéro, le joueur meurt.
        }
          }
     
      }
      
      
      public void conversionPA_PM(){if(this.PM==0){this.perdrePA(1);
       this.recupererPM(2);//Si un joueur est à court de PM, il peut utiliser 1 PA pour récupérer 2 PM.
      }}
  /*  public String  destination(){
        String texte ;
        System.out.println("Ou voudriez-vous aller?");
        texte= sc.nextLine();
        return texte;
        
    }*/
      
      
     public void Deplacer(Salle salleDestination) {// permet au joueur de se deplacer dans une salle 
         if(this.PM>0){
           
        if (salleDestination.estVoisineDe(this.salle)) {
            this.salle = salleDestination;
            this.perdrePM(1);
            this.historiqueDeplacement.add(this.nom+" se deplace à la salle "+salleDestination.getnomSalle()+" à "+ Date(System.currentTimeMillis()));
        }}
         
    }
   

    private String Date(long currentTimeMillis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    public void utiliserCompetence(String nomCompetence, Joueur cible, ArrayList<Joueur> joueurs) {
    switch (nomCompetence) {
        case "Tireur":
            for(Objets o :this.getInventaire()){if(o.getNom().equals("Blaster")) {
                    System.out.println(this.nom + " utilise la compétence Tireur.");
                    tirer(cible);
                    tirer(cible);
                } else {
                    System.out.println("Pour utiliser la compétence Tireur, vous devez avoir une arme dans votre inventaire.");
                }
            }
            break;
        case "Bourreau":
            if (this.PA >= 1) {
                this.perdrePA(1);
                cible.perdrePV(1);
                System.out.println(this.nom + " utilise la compétence Bourreau.");
                
            } else {
                System.out.println(this.nom + " : PA insuffisant");
            }
            break;
        case "Seul espoir":
            break;
        case "Infirmier":
            System.out.println(this.nom + " utilise la compétence Infirmier.");
            for(int jour = 1; jour <= 30; jour++){
                for(Joueur joueur : joueurs){
                    joueur.recupererPV(4);
                }
            }
            break;
        case "Traqueur":
            System.out.println(this.nom + " utilise la compétence Traqueur.");
            break;
        case "Observateur":
            System.out.println(this.nom + " utilise la compétence Observateur.");
            break;
        case "Biologiste":
            System.out.println(this.nom + " utilise la compétence Biologiste.");
            break;
        case "Astrophysicien":
            System.out.println(this.nom + " utilise la compétence Astrophysicien.");
            break;
            case "Paranoïaque":
            System.out.println(this.nom + " utilise la compétence Paranoïaque.");
            break;
        case "Pilote":
            System.out.println(this.nom + " utilise la compétence Pilote.");
            break;
        case "Robuste":
            System.out.println(this.nom + " utilise la compétence Robuste.");
            attaqueMainNue(cible);
            cible.perdrePV(1);
            break;
        case "Physicien":
            System.out.println(this.nom + " utilise la compétence Physicien.");
            break;
        case "Détaché":
            System.out.println(this.nom + " utilise la compétence Détaché.");
            break;
        case "Sprinter":
            System.out.println(this.nom + " utilise la compétence Sprinter.");
            this.conversionPA_PM();
            this.PM = this.PM + 2;
            break;
        case "Psy":
            System.out.println(this.nom + " utilise la compétence Psy");
            cible.perdrePA(1);
            cible.PMO = cible.PMO + 2;
        case "Leader":
            System.out.println(this.nom + " utilise la compétence Leader");
            this.perdrePA(2);
            for (Joueur joueur : joueurs) {
                if (joueur.salle.getnomSalle().equals(this.salle.getnomSalle())) {
                    joueur.PMO = joueur.PMO + 2;
                }
            }
            break;
        case "Concepteur":
            System.out.println(this.nom + " utilise la compétence Concepteur");
            for (int jour = 1; jour <= 30 ;jour++){
                this.PA = this.PA + 2;
            }
            break;
        case "Optimiste":
            System.out.println(this.nom + " utilise la compétence Optimiste");
            for (int jour = 1; jour <= 30; jour++){
                this.PMO -= this.PMO;
            }
            break;
        case "Technicien":
            System.out.println(this.nom + " utilise la compétence Technicien");
            break;
        case "Mycologiste":
            System.out.println(this.nom + " a utilisé la compétence Mycologiste");
        default:
            System.out.println("Compétence inconnue.");
            break;
    }
}
public void tirer(Joueur cible) {
    cible.perdrePV(4);
}
  public void attaqueMainNue(Joueur cible) {
        if (this.PA >= 2) {
            this.perdrePA(2);
            cible.perdrePV(1);
            System.out.println(this.nom + " a attaqué " + cible.getNom() + " à main nue. " + cible.getNom() + " perd 1 PV.");
        } else {
            System.out.println(this.nom + " : PA insuffisant");
        }
    }
  
  public class Action {
   public void CarresserChat(Joueur j){
         for(Objets o :this.inventaire){if(o.getNom().equals("chat de schrödinger")){
             j.perdrePA(1);
         }else{ j.perdrePA(0);}
     }}
  
  
  
  
  }
    /*  Si un joueur consomme
une ration standard, il récupère 2 PA mais perd 1 PMO (point de moral -> voir page 3). S’il
consomme une ration cuisinée, il récupère 4 PA et 3 PMO. Une fois la ration consommée, il
entre dans un état de satiété et ne peut plus manger pendant 3 cycles. */
  
}
