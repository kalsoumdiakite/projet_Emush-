
package projet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author e0010u
 */
public class Salle {
   private  String nomSalle ;
   private int identifiant ;
   private  int  vaisseau;
   private boolean estOccupe;
   private  ArrayList <String> SalleVoisines = new ArrayList<>(); 
   private  ArrayList<String> list_equipement;
   private ArrayList<Objets> espace_de_stockage;// espace de stockage d'une salle 
   private ArrayList<Joueur> listeJoueur = new ArrayList<>();// liste des joueurs présents dans une salle 
    /*Objet[] espaceDeStockage;Chaque salle est équipée d’un espace de stockage dans lequel différents objets sont
entreposés. Les joueurs ont la possibilité de regarder les items présents dans un espace de
stockage dès lors qu’ils sont physiquement présents dans la salle correspondante. Ils peuvent
y déposer des objets ou en prendre pour les mettre dans leur inventaire personnel*/
   private boolean incendie;
    public Salle (String nom,int id,int v){
     this.nomSalle=nom;
     this.estOccupe = false;
     this.identifiant=id;
     this.vaisseau=v;}

    
    public  void ajouSalle (Salle s) {
        if(s instanceof Salle){
            this.SalleVoisines.add(s.nomSalle);
        }
    }
    public String getnomSalle (){
        return this.nomSalle;
    }
     public int getID  (){
         return this.identifiant;
    }
    public  ArrayList <String> getSalleVoisines (){
          return this.SalleVoisines;
    }
    public boolean estVoisineDe (Salle s){ 
          return this.SalleVoisines.contains(s.getnomSalle());
    }
   @Override
      public String toString(){ return this.nomSalle +", id:"+ String.valueOf(this.identifiant)+", salles voisines["+afficher(this.SalleVoisines)+"]";}
      public String  afficher (ArrayList<String>tab){
          String text ="";
       for (String tab1 : tab) {
           text= text +", "+  tab1;
       }
       return text;
      }

    /**
     *
     * @param j
     * @return
     */
    public boolean presenceJoueur(Joueur j){
       return j.getNumsalle()==this.identifiant;
      }
     public void ajouterJoueur(Joueur J){
         
         if (this.presenceJoueur(J)){this.listeJoueur.add(J);}
    
     }
     public void  afficherList () {
         for (Joueur j :this.listeJoueur ){
             System.out.println(j.toString()+" ");
         }
     }
     public ArrayList<Objets> getStockage() {
         return this.espace_de_stockage;
     } 
      public ArrayList<Joueur> getlisteJoueur() {
          return this.listeJoueur;
      } 
      
    public void remplirEquipement(){
        if(this.nomSalle.equals("Pont")){
        this.list_equipement.add("terminal");
        this.list_equipement.add("systéme de naviguation");}
    if(this.nomSalle.equals("Labo de recherche")){
        this.list_equipement.add("terminal");
   }
    if(this.nomSalle.equals("Pont")){
        this.list_equipement.add("terminal");
        this.list_equipement.add("systéme de naviguation");
        }
       if(this.nomSalle.equals("nexus")){
           this.list_equipement.add("neron");
       }
    }
    public int getNombreJoueurs() {
    int nombreJoueurs = 0;
    for (Joueur joueur : this.getlisteJoueur()) {
        if (!joueur.equals(this)) {
            nombreJoueurs++;
        }
    }
       return nombreJoueurs;
}
    public boolean getestOccupe() {
        return estOccupe;
    }

    // Setter pour le statut d'occupation de la salle
    public void setestOccupe(boolean occupe) {
        this.estOccupe = occupe;
    }

    public void eteindreIncendie(){
   if(incendie){ // s'il y a incendie 
      this.incendie=false; // on l'éteind
   System.out.println("il ya plus d'incendie  dans "+this.nomSalle);}}
    
    public boolean  evenementIncendie(){ // Evenement incendie dans une salle 
         Random rand = new Random();
         int probabilite = rand.nextInt(101);// probabilite entre 0 et 100 
        if(probabilite<=5){this.incendie=true;
         return true;}
        else{System.out.println("Pas d'incendie");
        return false;}
                }
     public boolean  plafondTombe(){ // Evenement incendie dans une salle 
         Random rand = new Random();
         int probabilite = rand.nextInt(101);// probabilite entre 0 et 100 
        if(probabilite<=2){this.incendie=true;// chance que cet evenement se produise 
         return true;}
        else{System.out.println("Aucun plafond n'est tombé");
        return false;}
                }
}

