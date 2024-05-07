/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author outou
 */
public class EquipementMardi {
    String nomEquipement;
    // actions permettront de definir les pa po et pf ie les methodes associees 
    public EquipementMardi(){}
    public void ReparerEquip(Joueur j, EquipementMardi p, Salle s){
        String rep="Oui";
        if(j.prensenceJoueur && p.nomEquipement){/*On érifie d'abord que le joueur se trouve bien dans la salle où il veut reparer l'équiepement*/
            System.out.println("Voulez-vous reparer cet equipement ?");
            if(rep.equals("Oui")){
                j.perdrePA(1); /*Réparer l'équipement coûte un pa au joueur*/
                System.out.println("L'équipement" +this.nomEquipement+"est reparer");
            }
        }
    }
}