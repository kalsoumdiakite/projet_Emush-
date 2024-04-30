/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author e0010u
 */
public class Vaisseau {
    // les actions doivent etre coodees comme des fontions ou methode dans jeu en mettantb en exergue les PA , PMO PO PV qu'elles permettent de gagner ou perdre 
    // code  vaisseau 
    private int point_armure;
    private  int point_oxygene ;
    private  int point_fuel ;
    private final int IDVaisseau =(int)(Math.random()*200) ;
    private HashSet<Salle> salles = new HashSet<>();
   // Salle dortoir , baie_Alpha , baie_Beta, baie_Icarus , laboratoire,salle_Moteur,pont ,nexus ,espaceDeStockage, refectoire ;
 
 public Vaisseau (){
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
 /* Ajoutez deux méthodes getSalle et getTaille dans la classe Vaisseau. La première méthode
prend en paramètre un numéro de salle et retourne la salle correspondante. La deuxième
méthode retourne le nombre de salles dans le vaisseau. */
 public void journaldeBoard(){
     /* Le Daedalus dispose d’un journal de bord pour afficher la liste des joueurs présents dans les
pièces où il y a une caméra installée, afficher les incendies en cours et la liste des équipements
endommagés.... */
     System.out.println("Journal de bord du vaisseau:/n");
     for (Salle s:salles){if (s.getStockage().contains("caméra")){s.afficherList();}}// affiche la liste des joueurs présent dans les salles qui contiennent des caméras 
     System.out.println("Etat du vaisseau "+ this.point_armure+", "+this.point_fuel+", "+this.point_oxygene+", ");// etat du vaisseau 
 }
 public void misJourEtatvaisseau(){}
  public void canalDeCommunication(){}
    /* Tous les personnages disposent d’un talkiewalkie pour échanger des messages sur un canal commun à tous. Les personnages mush
peuvent aussi communiquer entre eux par télépathie. Vous ferez donc en sorte que les joueurs
humains puissent ajouter des messages sur le canal commun ou consulter les 10 derniers
messages de ce canal dans la console. la gestion de la communication entre les joueurs, notamment la messagerie sur le canal commun et les canaux de communication spécifiques aux mushs.*/
    
}
