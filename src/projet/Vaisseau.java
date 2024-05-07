/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author e0010u
 */
public class Vaisseau {
   Random rand = new Random();
        
    private int point_armure;
    private  int point_oxygene ;
    private  int point_fuel ;
    private final int IDVaisseau =(int)(Math.random()*200) ;
    private HashSet<Salle> salles = new HashSet<>();   // Salle dortoir , baie_Alpha , baie_Beta, baie_Icarus , laboratoire,salle_Moteur,pont ,nexus ,espaceDeStockage, refectoire ;
    private ArrayList<String> listEquipementsEndommages ;// liste des équipemnts endommagés 
   private String informationPlanete ;// informations sur la  planéte si détectée et uniquement les informations scannées
   private int nbVaisseauxAliens= rand.nextInt(5) ;
   private ArrayList<Objets> objetFouilles;
   private ArrayList<String> projetNeron;//que dans le nexus (termines a afficher)
   private int  nbMush;// nombre de mush à bord 
   private int nbJoueurMort ; // le nombre de joueurs morts 
 


 
 public Vaisseau(){
   this.point_armure= 200;
   this.point_oxygene=500;
   this.point_fuel=50;
   
   
   
 }

 public void init (String[]nomSalle,boolean[][]portes){
     for (int i=0;i<nomSalle.length;i++){
         Salle s = new Salle(nomSalle[i],i+10,this.IDVaisseau);
         salles.add(s);
       for(int j=0;j<portes[i].length;j++){if (portes[i][j] && i!=j){s.getSalleVoisines().add(nomSalle[j]);}}
     }
     
 }
 public void ajoutSalle(Salle s ){ this.salles.add(s);} //permet d'ajouter une salle au vaisseau
    @Override
  public String toString(){
      
      String text = "";
      for (Salle s :salles ){text =text + s.getnomSalle() +", id:"+ String.valueOf(s.getID())+", salles voisines[ "+afficher(s.getSalleVoisines())+"]\n";}
      return text;
    }
  public String  afficher (ArrayList<String>tab){
          String text ="";
       for (String tab1 : tab) {
           text= text +", "+  tab1;
       }
       return text;
      }
  public int getIDVaisseau(){return this.IDVaisseau;}
  public HashSet<Salle> getsalles(){return this.salles;}
 
 public void journaldeBoard(){
     /* Le Daedalus dispose d’un journal de bord pour afficher la liste des joueurs présents dans les
pièces où il y a une caméra installée, afficher les incendies en cours et la liste des équipements
endommagés...afficher la position des
objets dans les unités de stockage (uniquement si un joueur a fouillé cette unité de stockage et
affiche la liste des objets au moment de la dernière fouille)Fouiller l’unité de stockage (2 PA). Rend à nouveau visible les objets cachés ;  */
     System.out.println("Journal de bord du vaisseau:");
     for (Salle s:salles){if (s.getStockage().contains("caméra")){s.afficherList();}}// affiche la liste des joueurs présent dans les salles qui contiennent des caméras 

     System.out.println("Liste des équipements endommagé:");
     this.afficherliste_equipemnt();//affiche la liste des equipemets endommages 
     System.out.println("Etat du vaisseau "+ this.misJourEtatvaisseau());// etat du vaisseau 
     System.out.println("Informations sur la planéte à proximité ");
   if(this.informationPlanete!=null){  System.out.println(this.informationPlanete);}
     System.out.println("le nombre de vaisseaux alien est de: "+this.nbVaisseauxAliens );
     System.out.println("liste des objets fouillés et leurs position dans les unités de stockage");
     this.afficherObjetfouille();
     System.out.println("Le nombre de mush à bord est "+this.nbMush);
     System.out.println("Le nombre de mush à bord est "+this.nbJoueurMort); 
     System.out.println("Les événements dans une salle");
     this.incendie(8);// 8 ; cycles affiches les incendies dans le vaisseau en cours
     this.plafondTombe(8); // affiche les salles ou le plafond est tombé 
     System.out.println("attaques vaisseaux Aliens");
     this.attaqueVaisseauAlien(8);
     System.out.println("les projets Neron terminés:");
     System.out.println("----------------------------------------------");  
     System.out.println("les projets en laboratoire:");
     System.out.println("----------------------------------------------");
     
 }
 public String  misJourEtatvaisseau(){return "s";}
 
  public void informationsPlanete(String informations) {
        this.informationPlanete = informations;
    }
  
 public void equipementEndommage(String s ){this.listEquipementsEndommages.add(s);}// ajouter un équipement endommagé à la liste des équipements endommagés
  public void  afficherliste_equipemnt () {for (String  s :this.listEquipementsEndommages ){System.out.println(s);}}// afficher la liste des equipements endommages
  public void afouiller(Objets o ){
  // si joueur a fouille cet objet methode boolenne A TERMINER 
  this.objetFouilles.add(o);
  }
  public void afficherPosition(){
    for(Objets o : this.objetFouilles){ for (Salle s : salles){if(s.getStockage().contains(o)){System.out.println("l'objet "+0+"est a la position"+s.getStockage().indexOf(o));}}}
    }
   public void  afficherObjetfouille(){for(Objets o :this.objetFouilles){System.out.println(o);}
   this.afficherPosition();
   }
   public int  mushABord(ArrayList<Joueur> liste){ // ici liste represente la liste des joueurs au lancement du jeu 
       for (Joueur j: liste){if(j.estMush()){this.nbMush+=1;}}
       return this.nbMush;}
   
   public int  joueurMort(ArrayList<Joueur> liste){ // ici liste represente la liste des joueurs au lancement du jeu 
       for (Joueur j: liste){if(j.getPA()==0){this.nbJoueurMort+=1;}}
       return this.nbJoueurMort;}
   
   // -------------------------Evenements-----------------------
   
     public void  incendie(int nbcycles){
         // nombre de cycles
         for (int i =1;i<=nbcycles;i++){
         for(Salle s : this.salles){if(s.evenementIncendie()){ System.out.println(s.getnomSalle()+" est en feu");// s'il y a feu dans une salle 
         this.point_armure-=5;// reduit le nombre de point d'armure
         
         } else {System.out.println("Pas d'incendie");
         }}}}
     
     public void  plafondTombe(int nbcycles){
         // nombre de cycles
         for (int i =1;i<=nbcycles;i++){
         for(Salle s : this.salles){if(s.plafondTombe()){ System.out.println(s.getnomSalle()+" le plafond est tombé");// si le plafond est tombé dans une salle 
         for(Joueur j : s.getlisteJoueur()){j.perdrePV(6);}// chaque joueur present dans la salle perd 6 point de vie (Dans chaque salle y aune liste qui prend en compte tous les joueurs presents dans la salle )
         
         } else {System.out.println("Pas de plafond tombé");
         }}}}
     
     
   public void attaqueVaisseauAlien(int nbcycles){ if(this.nbVaisseauxAliens>0){for(int i=2;i<nbcycles;i++){System.out.println("Il y a attaque");
   
   for(int j=1;j<this.nbVaisseauxAliens;j++){ this.point_armure-=1;}}}} // font 1 dégât d’armure par cycle chacun

  
  
    
}
