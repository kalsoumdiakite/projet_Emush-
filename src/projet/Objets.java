/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author outou
 */
public class Objets {
      Scanner sc = new Scanner(System.in);
    private String nom;
    public Objets (String n){
    this.nom=n;}
    public String getNom(){return this.nom;}
     public void  utiliser(Joueur joueur  ){ 
   
         if(!joueur.estMush()){  /* on verifie si le joueur n'est pas un mush car les objets sont utilisables par 
             les humains sinon les mushs ne puvent pas les utiliser*/
         
          switch(this.nom){
                   
                 case "Armure": /* On verifie si c'est dans l'inventaire sinon le joueur perd des PA lors de l'attaque*/
                     for(Objets o :joueur.getInventaire()){if(o.getNom().equals("Armure")){ System.out.println("Absorbe un point de degat");}}
                        
                    
 
                 break;
            
                 case "clé à molette":
                        for(Objets o :joueur.getInventaire()){if(o.getNom().equals("clé à molette")){
                         System.out.println("Vous pouvez reparer un equipement");
                     }
                     else{
                         System.out.println("Vous ne pouvez pas utliser cet objet");
                     }}
 
                 break;
                 case "combinaisons":
                     // verifie si l'inventaore du joueur contient une combinaison sionon il est doit mourir
                         for(Objets o :joueur.getInventaire()){if(o.getNom().equals("combinaisons")){
                          System.out.println("vous pouvez piloter le jet....");
                      }
                      else {
                      joueur.perdrePV(joueur.getPV());
                      System.out.println(joueur.getNom()+" est mort");}}
                     
 
                 break;
                
                 case "paire de gants de protection":
                        for(Objets o :joueur.getInventaire()){if(o.getNom().equals("paire de gants de protection")){ 
                         System.out.println("Vous ne vous salirez pas");
                         joueur.propre();
                     }
                     else{
                         System.out.println("Vous risquez de vous salir pendant la reparation");
                     }}
 
                 break;
                 case "savon":
                        for(Objets o :joueur.getInventaire()){if(o.getNom().equals("savon")){ /* on doit verifier si le savon est
                         dans l'inventaire du joueur ,il aura une reduction de1 PA*/
                         joueur.perdrePA(1);//L’action « se laver » coûte un PA de moins
                     }}
                 case "couteau": // si le joueur utilise un couteau , son adversaire perd 2PV
                     // action attaquer cible
                           for(Objets o :joueur.getInventaire()){if(o.getNom().equals("couteau")){}}
                     
 
                 break;
                 case "Blaster":
                    for(Objets o :joueur.getInventaire()){if(o.getNom().equals("Blaster")){}}
                      
 
 
                 break;
                 case "tablier intachable":
                       for(Objets o :joueur.getInventaire()){if(o.getNom().equals("tablier intachable")){
                          joueur.propre();
                      }
                      else {
                      System.out.println("vous pouvez vous salir");}}
                       break;
                    
                       case "extincteurs":
                       for(Objets o :joueur.getInventaire()){if(o.getNom().equals("3 extincteurs")){
                          joueur.getSalle().eteindreIncendie();
                      }
                       else{System.out.println("Pas d'extincteur trouvé dans l'inventaire");}
                      }
                      /* case "caméra": si il y a une action des mushs qui se realise dans la salle de ce joueur on les affiche  */

                          
                       
                       
                      
                case "Médikit":
                    
                   for(Objets o :joueur.getInventaire()){if(o.getNom().equals("couteau")){ /* le joueur peut soigner lui meme ou un autre j donc on va verifier
                    si le kit et bel bien dans l'inventaire
                    et que son PA est supperieur >= 2 pour pouvoir se soigner sinon il ne peut pas etre soigner */}
                        
                      
                    else {
                      System.out.println("Dommage! le medikit ne se trouve pas dans l'inventaire");}}
                break;
                  case "Grenade": // fait perdre 6 PV au joueur prsents dans la salle 
                     
                    for(Objets o :joueur.getInventaire()){if(o.getNom().equals("Grenade")){}}{
                       
                         for(Joueur j : joueur.getSalle().getlisteJoueur()){j.perdrePV(6);} // list joueur prend en compte tous les joueurs presents dans la salle 
                    }           
 
                 case "trotinette":
                     /*quand le joueur utilise et qu'il convertit 1PA en PM sa ajoute 2PM*/
                 for(Objets o :joueur.getInventaire()){if(o.getNom().equals("trotinette")){
                     System.out.println("Désires-tu faire une conversion?");
                     boolean convertir = sc.hasNextBoolean();
                        if(convertir==true){
                            joueur.conversionPA_PM();// apres une conversion rajoute  2 PM aux joueurs
                            joueur.recupererPM(2);} 
                        else{System.out.println("pas de conversion donc pas de gain de PM");}
                         
                    }
                    else{
                      System.out.println("Vous ne posseder pas cette objet dans l'inventaire");
                    }}
         
                 break;
                 
                 case "Souche de test de Mush": // Débloque des recherches si présent au laboratoire
                     

 
                 break;
                 case "débris métallique" : //Nécessaire pour les réparations. Le maximum entreposable dans le vaisseau est 100.


                
                 break;
                 case "chat de schrödinger":
                   // si action caresser fait perdre un PMO au joueur   
                     //Caresser le chat (1 PA). Si le chat est dans l’inventaire ;
                     /* Peut être contaminé par 1
spore mush (ce qui augmente le nombre de
spores sur les joueurs humains de 1 à chaque caresse)*/

 
                 break;
                 case "ration standard":
     // action cuisiner que par stephan dans le refectoire 
                 break;
                 
                 case "extracteur de spore":
                     /* Permet d’extraire 1 spore pour 1 PA (n’existe pas en début de partie, apparait dans le laboratoire lorsque l */
 
                 break;
                 
                 case "sérum retro-fongique":
                  /*Permet d’extraire 1 spore pour 1 PA (n’existe pas en début de partie, apparait dans le laboratoire lorsque la recherche est realise  */
                 break;
                 
                 case "mycoscan":
 
                 break; 
                 default: 
                     System.out.println("dedolé cet objet n'a pas d'action ");// ou n'existe pas 
                 break;
                 
            }       
    }
    else{
     System.out.println("vous ne pouvez pas utiliser cet objet");
    }
         
}
   ArrayList<String> listeObjet= new ArrayList <>();
  public void Objet(){
       //Création et ajout des objets dans la liste
       listeObjet.add("Armure");
       listeObjet.add("clé à molette");
       listeObjet.add("combinaison");
       listeObjet.add("paire de gan de protection");
       listeObjet.add("savon");
       listeObjet.add("tablier intachable");
       listeObjet.add("tortinette");
       listeObjet.add("éxtinteur");
       listeObjet.add("couteau");
       listeObjet.add("blaster");
       listeObjet.add("grénade");
       listeObjet.add("médikit");
       listeObjet.add("caméra");
       listeObjet.add("souche de teste de mush");
       listeObjet.add("débris métallique");
       listeObjet.add("chat de schrödinger");
       listeObjet.add("ration standard");
       listeObjet.add("extracteur de spore");
       listeObjet.add("sérum retro-fongique");
       listeObjet.add("mycoscan");
       listeObjet.add("lit");
       listeObjet.add("douche");
       listeObjet.add("jet d'exploration");
       listeObjet.add("jet d'attaque");
       listeObjet.add("terminal de recherche");
       listeObjet.add("terminal");
       listeObjet.add("reacteur BILGRED");   
       listeObjet.add("gaz antispore");
       listeObjet.add("sérum de constipaspore");
       listeObjet.add("savon mushicide");
       listeObjet.add("talki"); 
    }
   
  

    public static int Donner(int PMO){
        return PMO;
        
    }
    
    
    
}
