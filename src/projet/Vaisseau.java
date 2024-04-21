/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author e0010u
 */
public class Vaisseau {
    // les actions doivent etre coodees comme des fontions ou methode dans jeu en mettantb en exergue les PA , PMO PO PV qu'elles permettent de gagner ou perdre 
    
    public int point_armure;
    public int point_oxygene ;
    public int point_fuel ;
    Salle dortoir , baie_Alpha , baie_Beta, baie_Icarus , laboratoire,salle_Moteur,pont ,nexus ,espaceDeStockage, refectoire ;
 
 public Vaisseau (){
   this.point_armure= 200;
   this.point_oxygene=500;
   this.point_fuel=50;
 }
 public void journaldeBoard(){
     /* Le Daedalus dispose d’un journal de bord pour afficher la liste des joueurs présents dans les
pièces où il y a une caméra installée, afficher les incendies en cours et la liste des équipements
endommagés.... */
 }
  public void canalDeCommunication(){}
    /* Tous les personnages disposent d’un talkiewalkie pour échanger des messages sur un canal commun à tous. Les personnages mush
peuvent aussi communiquer entre eux par télépathie. Vous ferez donc en sorte que les joueurs
humains puissent ajouter des messages sur le canal commun ou consulter les 10 derniers
messages de ce canal dans la console. la gestion de la communication entre les joueurs, notamment la messagerie sur le canal commun et les canaux de communication spécifiques aux mushs.*/
    
}
