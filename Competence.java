/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

/**
 *
 * @author Utilisateur
 */
public class Competence {
     private String nom;
    private String description;
     private int DiminutionPA;
    private int DiminutionPM;
    private int degat;

    public Competence(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
}
