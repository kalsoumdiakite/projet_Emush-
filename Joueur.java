
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
    private int nbrSpore;
    private String[] competence;
    private Salle salle;
    private int vaisseau;
    private boolean spore;
    private ArrayList<String> inventaire = new ArrayList<>();
    private String talkie_walkie= sc.nextLine() ;
    private ArrayList<String> canalHumain;
    private ArrayList<String> canalMush;
    
    public Joueur(String nom, int PV, int PA, int PM, int PMO, boolean estMush, String[] competence) {
        this.nom = nom;
        this.PV = PV;
        this.PA = PA;
        this.PM = PM;
        this.PMO = PMO;
        this.estMush = estMush;
        this.competence = competence;
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
    public void utiliserCompetence(String nomCompetence, Joueur cible, ArrayList<Joueur> joueurs) {
    switch (nomCompetence) {
        case "Tireur":
            for(int jour = 1; jour <= 30;jour++){
                if (this.inventaire.contains("blaster")) {
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
            this.ScannerPlanete();
            this.PA += this.PA;
            System.out.println("Vous avez découvert un secteur de plus");
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
            this.soignerEquipier(cible);
            perdreSpore(1, cible);
        default:
            System.out.println("Compétence inconnue.");
            break;
    }
}
public void soignerEquipier(Joueur cible) {
    if (this.PA >= 2) {
        this.perdrePA(2);
        cible.recupererPV(4);
        System.out.println(this.nom + " soigne " + cible.getNom() + ".");
    } else {
        System.out.println(this.nom + " : PA insuffisant");
    }
}
public void perdreSpore(int point,Joueur cible){
    int nombreSpore = 0;
    if (cible.estMush()) {
            nombreSpore = nombreSpore - point;
        }
}
public void tirer(Joueur cible) {
    cible.perdrePV(4);
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
    public String[] getCompetences(){
        return competence;
    }
    public void setCompetences(String[] competences) {
        this.competence = competences;
    }
    public ArrayList<String> getInventaire() {
        return inventaire;
    }
    public int  getNumsalle(){
        return this.salle.getID();
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
      
      
      public void conversionPA_PM(){if(this.PM==0){this.recupererPA(1);
       this.recupererPM(2);//Si un joueur est à court de PM, il peut utiliser 1 PA pour récupérer 2 PM.
      }}
  /*  public String  destination(){
        String texte ;
        System.out.println("Ou voudriez-vous aller?");
        texte= sc.nextLine();
        return texte;
        
    }*/
       public void CarresserChat(Joueur j){
         if(j.getInventaire().contains("chat de schrödinger")){
             j.perdrePA(1);
         }else{ j.perdrePA(0);}
     }
    
     public void Fouiller(Joueur j){}
    
    public void SeCoucher(Joueur j, Salle s){
        if(s.getnomSalle().equals("Dortoire")){
            j.perdrePA(0);
        } else{ System.out.println("Vous ne pouvez pas dormir ici");}
    }
    
    public void SeLever(Joueur j, Salle s){
        j.perdrePA(0);
    }
    
    
    public void Réparer(Joueur j){
        String rep="Oui";
        System.out.println("Voulez-vous reparer cette equiepement ?");
        if(rep.equals("Oui")){ j.perdrePA(1);}
    }
    
    public void ReparerPilgred(Salle s, Joueur j){
        if(s.getnomSalle().equals("Moteurs")){
            j.perdrePA(3);
        }
    }
    
    public void Sedoucher(Joueur j){
        if(j.estMush){ j.perdrePA(2); j.perdrePV(3);}
        else{ j.perdrePA(2);}
    }
    
    public void MettreCam(Joueur j, Salle s){
        System.out.println("Voulez-vous mettre cette salle sous surveillance ?");
        String rep="Oui";
        if(rep.equals("Oui")){ j.perdrePA(4);}
        else{ j.perdrePA(0);}
    }
    
    public void RechercheLabo(Joueur j, Salle s){
        if(s.getnomSalle().equals("Laboratoire")){ j.perdrePA(2);}
    }
    
    public void ChangerDeSalle(Joueur j, Salle s, Salle n){
        if(s.estVoisineDe(n)){ j.perdrePA(1);}
    }
    
    public void Attaquer(Joueur joueur, Joueur joueurcible){
         if(this.PA>2){
             joueur.perdrePA(2);
             joueurcible.perdrePV(1);
         }/* Si un joueur attauqe un autre joueur a main nu le joueur perd 2PA et l'autre un pv*/
    }
     
     public void AttaqueCouteau(Joueur j, Joueur cible){
         if(j.inventaire.contains("Couteau")){
             cible.perdrePV(2);
         }/*Le joueur qui s'est fait attaquer perd 2PV*/
     }
    
     public void ScannerPlanet(Salle s, Joueur j){
         if(s.getnomSalle().equals("Pont")){
             j.perdrePA(2);
         }
     }
    
     public void CreerSpore(Joueur j,Salle s){
         int nbr=0;
        if (this.estMush() && this.salle.getNombreJoueurs() == 1) {
        this.spore = true;
        nbr += nbr;
        System.out.println(this.nom + " a créé un spore.");
    } else {
        System.out.println("Conditions non remplies pour créer un spore.");
    }
    }
    
     public void Poinçonner(Joueur ciblej){
        if(!ciblej.estMush && this.nbrSpore>0){
            ciblej.RecevoirSpore();
             /*il créé un spore*/
            System.out.println("Vous avez poiçonner le joueur"+ ciblej);
        } if(this.nbrSpore==0){System.out.println("Vous n'avez plus de spore");}
    }
    
    private void RecevoirSpore(){ }
    
    public void InfecterRation(Joueur j){
        if(j.estMush){
        j.perdrePA(1);}
    }
    
    public void MangerSpore(Joueur j){ j.perdrePA(1); j.recupererPA(3); j.recupererPM(2);}
    
    public void Tirer(Joueur j, Joueur cible){
        if(j.inventaire.contains("Blaster")){
             cible.perdrePA(4);
        }/* Si le joueur utilise un couteau ou un blaster il perd un pa*/
    }
    public void Cacher(Joueur j){
        System.out.println("Voulez-vous cacher cette objet");
        String rep="Oui";
        if(rep.equals("Oui")){
            j.perdrePA(1);
            System.out.println("Vous avez cacher l'objet");
        }
    }
    public void PrendreObjet(Joueur j){
        System.out.println("Voulez_vous prendre cette objet");
        String rep="Oui";
        if(rep.equals("Oui")){
            j.perdrePA(0);
            System.out.println("Vous avez pris l'objet il se trouve maintenant dans votre inventaire");
        }
    }
    public void Fouiller(Joueur j, Salle s){
        if(presenceJoueur(j)){j.perdrePA(2);}
    }
    
    public void VoirObjetCacher(Joueur j, Salle s){
        if(j.presenceJoueur(j)){j.perdrePA(0);}
    }
      public void Saboter(int PA, Joueur joueur){
        System.out.println("Voulez-vous saboter cette équipement");
        joueur.perdrePA(0);
        String rep="Oui";
        if( joueur.estMush){
            if(rep.equals("Oui")){
                joueur.perdrePA(3);
                System.out.println("Equipement saboter");
            }
        }    
    }
        
    public void ConsulterJournaldeBoard(Joueur j){
        if(!this.estMush()){
            
        }
        else{}
    }
    
     public void eleesha(Joueur joueur){
         if(this.equals("Eleesha")){
             System.out.println("Voulez vous consulter les entrées et sorties de cette salle");
             String rep="Oui";
             if(rep.equals("Oui")){
                 joueur.perdrePA(1);
             } else {}
         }
     }
    public void AttaqueAllienne(Salle s, Joueur j){
        if(s.getnomSalle().equals("Tourelle")|| s.getnomSalle().equals("baie")){
            j.perdrePA(1);
        }
        else{
            System.out.println("Vous devez vous trouvez dans une salle ");
        }
        
    }
    public void ScannerPlanete(){
        if(this.salle.getnomSalle().equals("pont")&& this.PA>=3){// on verifie si le j es sur le pont et a assez de pa;
            
              
              int s = (int)(Math.random()*3); //random , ici on choisi 1 secteur de la planete à scanner de façon aleatoir
              int qtiteDeRessource = (int) (Math.random()*26);//e la quantité de ressources disponibles dans un des secteurs non scaner et choisi aleatoirement 
                switch(s){
                   case  1: 
                     System.out.println("scane oxygne"+qtiteDeRessource+"unité");
                   break;
                   case  2 : 
                     System.out.println("scane fuel"+qtiteDeRessource+"unité");
                   break;
                   case  3 : 
                     System.out.println("scane débris métallique"+qtiteDeRessource+"unité");
                   break;
        }
          this.perdrePA(3);//le joueur perd alors 3pa
    }
     }
    private boolean presenceJoueur(Joueur j) {
        return j.getNumsalle()==salle.getID();
    }
    public int getNombreJoueurs() {
    int nombreJoueurs = 0;
    for (Joueur joueur : this.salle.getlisteJoueur()) {
        if (!joueur.equals(this)) {
            nombreJoueurs++;
        }
    }
    return nombreJoueurs;
}
}
