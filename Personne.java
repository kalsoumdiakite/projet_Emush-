/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class Personne {
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
    private Personne s;
   // private boolean c;
    
    
    public Personne(String nom, int PV, int PA, int PM, int PMO, boolean estMush, Competence competence1, Competence competence2) {
        this.nom = nom;
        this.PV = PV;
        this.PA = PA;
        this.PM = PM;
        this.PMO = PMO;
        this.estMush = estMush;
        this.competence1 = competence1;
        this.competence2 = competence2;
    }
    public Personne(String name,Salle s,int vaisseau){
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
    public void attaqueMainNue(Personne cible) {
        if (this.PA >= 2) {
            this.perdrePA(2);
            cible.perdrePV(1);
            System.out.println(this.nom + " a attaqué " + cible.getNom() + " à main nue. " + cible.getNom() + " perd 1 PV.");
        } else {
            System.out.println(this.nom + " : PA insuffisant");
        }
    }
    public void attaqueArme(Personne cible) {
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
    // le j peut convertir ses pa en pm afin de se deplacr dans le vaisseau
    /*public void ajouterPM(int points){ // 
    this.PM+= points;
    }*/

   
    public void perdrePA(int points) {
        this.PA -= points;
    }
    public void gagnerPMO(int points) {
        this.PMO += points;
    }
    public void perdrePM(int points) {
        this.PM -= points;
    }
    public void utiliserCompetence(Competence competence, Personne cible) {
        if (this.PA > 0) {
            if (this.competence1.equals(competence) || this.competence2.equals(competence)) {
                this.perdrePA(1);
                System.out.println(this.nom + " la compétence " + competence.getNom() + "a été utilisé sur le joueur " + cible.getNom());
            } else {
                System.out.println(this.nom + " pas de compétence " + competence.getNom());
            }
        } else {
            System.out.println(this.nom + " : PA insuffisant");
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
      
    /*public void depotObjet(Objet objets){
        if(this.inventaire.contains("objets")){
            Syteme.out.println("depose"+ )
        }*/

    /* la methode se doucher , on va verifier si le joueur a 2 ou plus de pa est mush
    il va prendre une douche et perdre perdre 3pv sinon prendre une douche */
    public void seDoucher(){
        if(this.PA>=2){
     if(this.estMush){
      System.out.println(this.nom+"prend une douche et perd 3pv");
     this.perdrePV(3);
     }
     else
    System.out.println(this.nom+"vous pouvez prendre une douche");
    }   
    }
     // faire une recherche dans le laboratoire
     public void recherLabo(Personne joueur){ // methode pour faire une recherche dans la salle 
     if(joueur.getPA() >=2){
        this.perdrePA(2);
         System.out.println(this.nom +"fait une recherche");
     }
     else{
           System.out.println(this.nom+"PA insuffisant pour faire une recherche");           
    }
       
    }
     
      public void utiliserTortinette(){ // utiliser la tortinette pour se deplacer
        if(this.PA>=2){
            this.perdrePA(2);
            this.PM+=2;
        } else{
        System.out.println(this.nom + "tu ne peux pas utiliser la tortinette");
        }
    }   
        //methode prendre un objet
      public void prendreObjet(Personne joueur , Objet objet , Salle salle){/* verifie si l'objet choisi est que veut prendre le joueur 
          est disponible dans dans l'espace de stockage*/
          if(salle.getStockage().contains("objet"){
          inventaire.add(objet);
          salle.getStockage().remove(objet);
          System.out.println("prend un "+objet+"dans l'unité de stockaege");}
          else{
          
          System.out.println("l'objet n'est pas disponible dans l'unité de stockage de la salle ");}
      }

      
      // methode scanner
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
    
     //methode fouiller dans l'unité de stockage
     public void fouillerUniteStokage(Salle s){
    //on va verifier si le j est present dans la salle et a de pa suffisantes pour fouiller 
     if(s.presenceJoueur(this.s)&&this.PA>=2){
        this.perdrePA(2);
        
        for(Objet Objet : salle.getStockage()){ // on va parcourir l'unité de stockage de la salle
            boolean objetCache = false; // j'ai initialisé objetCache est faux s'il es pas cacher , 
            if(objetCache = true){
            System.out.printltn("affiche l'objet caché"+objet.getNom);}//pour l'afficher
        }
     }
     else{
          System.out.println("vous devez etre present dans la salle et avoirassez de pa pour pouvoir fouiler");
        }
       this.perdrePA(2);

}     
     //methode carresser le chat
    public void carresserChat(){
     if(inventaire.contains("chat de schrödinger")){
      this.perdrePA(1);
      if(Math.random()<0.5){  //  le j peut etre contaminé par 1spore / a une chance d'etre contaminer par une spore lorsqu'il carresse le chat
      System.out.println("vous etes contaminé par un mush");
       this.gagnerPMO(1);
       }
    }
     else{
         System.out.println("le chat n'est pas dans l'inventaire vous ne pouvez pas le carresser ");
     }    
    }
    
     // le joueur terminer son tour
     public void termineTour(){
         if(this.getPA()==0 && this.getPM()==0){
         System.out.println("vous avez fini votre tour ");} 
         else{
             System.out.println("vous avez toojours de point d'action ou de mouvement ,");
             }
     }
       
     // changer salle 
     public void changeSalle(Salle s){ // s : la salle dont le j veut changer
         if(this.getPM()>=1){
          if(s.salle.getSalleVoisines(s)){
          s.ajouterJoueur(s);// ajoute le j dans la nouvelle salle
          this.perdrePM(1);}
          else{ System.out.println("vous avez chnger de salle"+s); }
        }
         else{ System.out.println("vous avez pas assezde PM pour chnger de salle ");}
     }
       // methode detecter la planete à proximité
     public void detecterPlanetProximite(){
         if(this.salle.getnomSalle().equals("pont")&& this.PA>=2){ // on va verifier d'abord si le joueur est au pont et a suffisement de pa
             
    
     }
     
    }
     // pour Eleesha 
      public void consulterEntreeSortie(){
     
                                          }
      /*se coucher 
     public void seCoucher(){}*/
    
    /*public void creerSpores(){//verifie d'abord si lejoueur est  mush et est seul dans la salle , il perd 2pa et devient sale
        if(this.estMush) &&(!this.estMush).prenceJoueur(this.salle){
        this.perdrePA(2);
    */
 
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

   
}

   
    
    
    
    
