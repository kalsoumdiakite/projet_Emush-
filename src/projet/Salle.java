/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objet;

/**
 *
 * @author Utilisateur
 */
public class Salle {
    private String nomSalle;
    private Equipement [] list_equipemet;
    private int id;
    private String vaisseau;
    
    public Salle(String nomSalle , int id , String vaisseau){
        this.nomSalle = nomSalle;
        this.id = id;
        this.vaisseau = vaisseau;
       
    }
    public void AjoutSalle(){
    
    }

    public int getId(){
     return id;
}

    public String getNomSalle(){
    return nomSalle;
            }
    
    public String vaisseau(){
        return vaisseau;
    }
}
    
