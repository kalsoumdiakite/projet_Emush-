/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class NewSalle {
     private  String nomSalle ;
     private int identifiant ;
     private  int  vaisseau;
     private boolean incendie;
  private  ArrayList <String> SalleVoisines = new ArrayList<>(); 
   private  ArrayList<String> list_equipement;
   private ArrayList<Objet> espace_de_stockage;// espace de stockage d'une salle 
   private ArrayList<Personne> listeJoueur = new ArrayList<>();// liste des joueurs présents dans une salle 
    /*Objet[] espaceDeStockage;Chaque salle est équipée d’un espace de stockage dans lequel différents objets sont
entreposés. Les joueurs ont la possibilité de regarder les items présents dans un espace de
stockage dès lors qu’ils sont physiquement présents dans la salle correspondante. Ils peuvent
y déposer des objets ou en prendre pour les mettre dans leur inventaire personnel*/
   
    public NewSalle (String nom,int id,int v, boolean inc ){
     this.nomSalle=nom;
     
    this.identifiant=id;
    this.vaisseau=v;
    this.incendie = false; }

    
    public  void ajouSalle (NewSalle s) {if(s instanceof NewSalle){this.SalleVoisines.add(s.nomSalle);}}
    public String getnomSalle (){return this.nomSalle;}
     public int getID  (){return this.identifiant;}
      public  ArrayList <String> getSalleVoisines (){return this.SalleVoisines;}
      public boolean estVoisineDe (NewSalle s){ return this.SalleVoisines.contains(s.getnomSalle());}
   @Override
      public String toString(){ return this.nomSalle +", id:"+ String.valueOf(this.identifiant)+", salles voisines["+afficher(this.SalleVoisines)+"]";}
      public String  afficher (ArrayList<String>tab){
          String text ="";
       for (String tab1 : tab) {
           text= text +", "+  tab1;
       }
       return text;
      }
      public boolean presenceJoueur(Personne j){
       return j.getNumsalle()==this.identifiant;
      }
     public void ajouterJoueur(Personne J){
         
         if (this.presenceJoueur(J)){this.listeJoueur.add(J);}
    
     }
     public void  afficherList () {for (Personne j :this.listeJoueur ){System.out.println(j.toString()+" ");}}
     public ArrayList<Objet> getStockage() {return this.espace_de_stockage;} 
      public ArrayList<Personne> getlisteJoueur() {return this.listeJoueur;} 
      
    public void remplirEquipement(){
    if(this.nomSalle.equals("Pont")){this.list_equipement.add("terminal");
    this.list_equipement.add("systéme de naviguation");}
     if(this.nomSalle.equals("Labo de recherche")){this.list_equipement.add("terminal");
   }
      if(this.nomSalle.equals("Pont")){this.list_equipement.add("terminal");
    this.list_equipement.add("systéme de naviguation");}
       if(this.nomSalle.equals("nexus")){this.list_equipement.add("neron");
       }
    }
public void eteindreIncendie( boolean incendi){
   if(incendi){
   this.incendie = true;
   System.out.println("il ya une incendis dans"+this.nomSalle);}
}
   

    
}
