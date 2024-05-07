/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet;

/**
 *
 * @author e0010u
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       /*L’ensemble des objets est réparti aléatoirement dans les différentes salles du vaisseau au
démarrage du jeu, à l’exception des rations de nourriture entreposées dans le réfectoire. */
        Vaisseau v_Spatial = new Vaisseau();
        String [] tab1= {"Pont","Tour.A", "Tour.B","Coul" , "Labo", "Jardin"};
        boolean [][]tab2 = {{false ,true,true,true,false,false},{true ,false,false,true,false,false},{true ,false,false,true,false,false},{true,true,true,false,true,true},{false ,false,false,true,false,false},{false ,false,false,true,false,false}};
        v_Spatial.init(tab1,tab2);
        System.out.println(v_Spatial.toString());
        System.out.println(v_Spatial.getIDVaisseau());
    }
    
    
}
