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
class Objet {
      private String nom;
      
    public Objet(String nom){
          this.nom = nom ;
    }
      public String getNom(){
      return this.nom ;}
     
     
 public void  utiliser(Personne joueur  ){ 
   
         if(!joueur.estMush()){  /* on verifie si le joueur n'est pas un mush car les objets sont utilisables par 
             les humains sinon les mushs ne puvent pas les utiliser*/
         
          switch(this.nom){
                   
                 case "Armure":
 
                 break;
            
                 case "clé à molette":
                     joueur.getInventaire().contains("clé à molette");// on verifie si 
 
                 break;
                 case "combinaison":
                     // verifie si li'nventaore du joueur contient une combinaison sionn il est doit mourir
                      if(joueur.getInventaire().contains("combinaison")){
                          System.out.println("vous pouvez piloter le jet....");
                      }
                      else {
                      System.out.println("mort");}
                     
 
                 break;
                
                 case "paire de gan de protection":
                     joueur.getInventaire();
 
                 break;
                 case "savon":
                     if(joueur.getInventaire().contains("savon")){ /* on doit verifier si le savon est
                         dans l'inventaire du joueur ,il aura une reduction de PA*/
                         joueur.perdrePA(1);
                     }
                       case "couteau": // si le joueur utilise un couteau , il 2PV
                    joueur.perdrePV(2); 
 
                 break;
                 case "Blaster":
                     joueur.perdrePV(4);// ...4PV
 
 
                 break;
                 case "tablier intachable":
                       if(joueur.getInventaire().contains("tablier intachable")){
                          System.out.println("vous êtes propres");
                      }
                      else {
                      System.out.println("vous êtes sali");}
                       break;
                       
                case "Médikit":
                    /* le joueur peut soigner lui meme ou un autre j donc on va verifier
                    si le kit et bel bien dans l'inventaire
                    et que son PA est supperieur >= 2 pour pouvoir se soigner sinon il ne peut pas etre soigner */
                    if(joueur.getInventaire().contains("médikit")&& joueur.getPA()>=2){
                        // joueur.soignerJoueur();
                         joueur.perdrePA(2);
                        
                      }
                    else {
                      System.out.println("Dommage ,vous n'avez pas assez de PA");}
                  break;
                            
 
                 case "tortinette":
                       joueur.utiliserTortinette();
                 break;
                 
                 case "Souche de test de Mush":
 
                 break;
                 case "débris métallique":
 
                 break;
                 case "chat de schrödinger":
                     if(joueur.getInventaire().contains("chat de schrödinger")){
                     
                     }
                      case "Talki":
                     joueur.getTalkie_walkie();
 
                 break; 
                 
                 case "Grénade":
                     if(joueur.donnerSalle(s).presenceJoueur()){
                          joueur.perdrePV(6);
                     }
                    
                 break; 
                  case "jet d'attaque":
                    joueur.attaqueArme(joueur);
                   
                 break; 
                 
                 case "Exteincteur":
                  joueur.Deplacer(salleDestinaion).eteindreIncendie();
 
                 break; 
 
                 
                 case "ration standard":
 
                 break;
                 
                 case "extracteur de spore":
 
                 break;
                 
                 case "sérum retro-fongique":
 
                 break;
                 
                 case "mycoscan":
 
                 break; 
                 
                 
                default: 
                     System.out.println("dedolé cet objet n'a pas d'action ");// ou n'existe pas 
        }       
    }
    else{
     System.out.println("vous ne pouvez pas utiliser cet objet");
    }
         
}
 
   ArrayList<String> listeObjet= new ArrayList <>();
  public void Objets(){
       //Création et ajout des objets dans la liste
       listeObjet.add("Armure");
      // listeObjet.add("clé à molette"); 
      // listeObjet.add("combinaison");
       //listeObjet.add("paire de gan de protection");
       //listeObjet.add("savon");
      // listeObjet.add("tablier intachable");
      // listeObjet.add("tortinette");
       //listeObjet.add("éxtinteur");
     //  listeObjet.add("couteau");
      // listeObjet.add("blaster");
      // listeObjet.add("grénade");
      // listeObjet.add("médikit");
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
       //listeObjet.add("jet d'attaque");
       listeObjet.add("terminal de recherche");
       listeObjet.add("terminal");
       listeObjet.add("reacteur BILGRED");   
       listeObjet.add("gaz antispore");
       listeObjet.add("sérum de constipaspore");
       listeObjet.add("savon mushicide");
       //listeObjet.add("talki"); 
    }
   public ArrayList<String> getListeObjet() {
       listeObjet.add(0, "Absorbe point de degat");
      // listeObjet.add(1, "Nécessaire dans l’inventaire pour réparer un equipement");
      // listeObjet.add(2, "Nécessaire dans l’inventaire pour piloter sinon mort");
      // listeObjet.add(3, "Nécessaire dans l'inventaire pour pas se salir");
      // listeObjet.add(4, "Côute un PA s'il est dans l'inventaire");
      // listeObjet.add(5, "Si c'est dans l'inventaire on se sali pas");
      // listeObjet.add(6, "Losrque qu'on converti PA en PM s'ajoute 2PM");
      // listeObjet.add(7, "Eteint l'incendie");fait d'abord le 
      // listeObjet.add(8, "Fait perde 2PV");
      // listeObjet.add(9, "Fait perdre 4PV");
       //listeObjet.add(10, "Fait perdre 6PV à tous les joueures de la salle");
      // listeObjet.add(11, "Doit etre dans l'inventaire pour soigner");
       listeObjet.add(12, "Permet de voir les actions des mush et afficher les logs de la salle");
       listeObjet.add(13, "Débloque les recherches si present dans la salle");
       listeObjet.add(14, "Nécessaire pour reparer le vaisseau");
       listeObjet.add(15, "Si un joueur le caresse il gagne un PMO par jour, Peut être contaminé par 1spore mush (ce qui augmente le nombre de spore sur les humains");
       listeObjet.add(16, "Peuvent être cuisiner par Stephane dans le refectoire");
       listeObjet.add(17, "Extrait un spore pour 1PA");
       listeObjet.add(18, "Guerit un humain pour 2PA");
       listeObjet.add(19, "Augmente la recherche de 3% à 10%");
       listeObjet.add(20, "Pour se reposer");
       listeObjet.add(21, "Être propre");
       listeObjet.add(22, "Permet d'explorer d'autre planete");
       //listeObjet.add(23, "Permet de se defendre des attaques ennemis");
       listeObjet.add(24, "Endroit où se fait les differents recherche");
       listeObjet.add(25, "Endroit où on peut consulter tous ce qui cincerne le vaisseau");
       listeObjet.add(26, "Réparer, ils pemettent de rentrer sur terre");
       listeObjet.add(27, "Permet de reduire le nombre d'extraction de spores à 2 par jour");
       listeObjet.add(28, "Augmente le côut de la production de spores à 2PA pour n mush");
       listeObjet.add(29, "Permet d'extraire un spore losrqu'on prend une douche avec");
      // listeObjet.add(30, "Permet de comuniquer entre les joueurs");
        return listeObjet;
    }
    
}
