package com.company;

import java.util.Arrays;
import java.util.Random;

import java.util.Scanner;


public class Main {
    //Declarations des variables globales
    public static int caseADetruireX;
    public static int caseADetruireY;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static String[] score = Fonction.creationTableau();


    /**
     * Fonction qui permet d'éteindre le jeu
     */
    //fonction pour éteindre le jeu
    public static void eteindre(){
        System.exit(0);
    }
    /**
     * Fonction pour relancer une partie
     * @throws InterruptedException Si l'utilisateur marque "o" La partie recommence, Si l'utilisateur marque "n" L'utilisateur retourne au menu
     */
    //Fonction pour relancer une partie
    public static void recommencer() throws InterruptedException {
        System.out.println("Relancer une partie ? [o] [n]");
        Scanner newGame = new Scanner(System.in);
        String newgame = newGame.next();
        if (newgame.equals("n")){            //si non
            menu.menu();
        }
        if (newgame.equals("o")){            //si oui

        }
        else{                           //si autre
            recommencer();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Fonction.sautDeLigne(1);
        System.out.println("Bienvenue dans Block-Breaker :");
        menu.menu();
        while (true) {

            //Déclarations des variables
            String joueur1;
            String joueur2;
            String joueur3 = "null";
            String joueur4 = "null";
            String couleur1;
            String couleur2;
            String couleur3 = "null";
            String couleur4 = "null";
            int joueur1Ligne ;
            int joueur1Colonne ;
            int joueur2Ligne;
            int joueur2Colonne;
            int joueur3Ligne = 0;
            int joueur3Colonne = 0;
            int joueur4Ligne = 0;
            int joueur4Colonne = 0;
            boolean joueur1EnVie = true;
            boolean joueur2EnVie = true;
            boolean joueur3EnVie = true;
            boolean joueur4EnVie = true;
            String[][] plateau;
            Random rd = new Random();
            Scanner sc = new Scanner(System.in);
            int nombreJoueur = 0;
            String nombreJoueurString;
            int tourJoueur;
            boolean signalVictoire = true;
            int joueurVivant;
            String bouton;
            String vainqueur = "null";


            //Choix du nombre de joueur
            System.out.print("Combien de joueurs ? Entre 2 et 4 : ");
            nombreJoueurString = sc.next();
            boolean nombreJoueurboolean = Fonction.estUnNombre(nombreJoueurString);
            if(nombreJoueurboolean){
                nombreJoueur = Integer.parseInt(nombreJoueurString);
            }
            joueurVivant = nombreJoueur;



            //Recuperation des coordonnées de départ en fonction du nombre de joueur
            if ((nombreJoueur >= 2 && nombreJoueur <= 4)) {

                if (nombreJoueur == 2) {
                    joueur1Ligne = 5;
                    joueur1Colonne = 6;
                    joueur2Ligne = 6;
                    joueur2Colonne = 6;
                } else if (nombreJoueur == 3) {
                    joueur1Ligne = 5;
                    joueur1Colonne = 6;
                    joueur2Ligne = 6;
                    joueur2Colonne = 5;
                    joueur3Ligne = 6;
                    joueur3Colonne = 7;
                } else {
                    joueur1Ligne = 5;
                    joueur1Colonne = 6;
                    joueur2Ligne = 6;
                    joueur2Colonne = 5;
                    joueur3Ligne = 6;
                    joueur3Colonne = 7;
                    joueur4Ligne = 7;
                    joueur4Colonne = 6;
                }

                //Choix des pseudo et des couleurs des joueurs + lancement de la partie
                System.out.print("Le joueur 1 choisi son pseudo : ");
                joueur1 = Fonction.choisirPseudo();
                System.out.print(joueur1 + " est de quelle couleur (rouge, bleu, violet, jaune) ? : ");
                couleur1 = Fonction.choisirCouleur(joueur1);
                System.out.print("Le joueur 2 choisi son pseudo : ");
                joueur2 = Fonction.choisirPseudo();
                System.out.print(joueur2 + " est de quelle couleur (rouge, bleu, violet, jaune) ? : ");
                couleur2 = Fonction.choisirCouleur(joueur2);
                if (nombreJoueur == 3) {
                    System.out.print("Le joueur 3 choisi son pseudo : ");
                    joueur3 = Fonction.choisirPseudo();
                    System.out.print(joueur3 + " est de quelle couleur (rouge, bleu, violet, jaune) ? : ");
                    couleur3 = Fonction.choisirCouleur(joueur3);
                    plateau = Fonction.lancerPartie(joueur1, couleur1, joueur2, couleur2, joueur3, couleur3);
                } else if (nombreJoueur == 4) {
                    System.out.print("Le joueur 3 choisi son pseudo : ");
                    joueur3 = Fonction.choisirPseudo();
                    System.out.print(joueur3 + " est de quelle couleur (rouge, bleu, violet, jaune) ? : ");
                    couleur3 = Fonction.choisirCouleur(joueur3);
                    System.out.print("Le joueur 4 choisi son pseudo : ");
                    joueur4 = Fonction.choisirPseudo();
                    System.out.print(joueur4 + " est de quelle couleur (rouge, bleu, violet, jaune) ? : ");
                    couleur4 = Fonction.choisirCouleur(joueur4);
                    plateau = Fonction.lancerPartie(joueur1, couleur1, joueur2, couleur2, joueur3, couleur3, joueur4, couleur4);
                } else {
                    plateau = Fonction.lancerPartie(joueur1, couleur1, joueur2, couleur2);
                }

                //Premier joueur aléatoire
                tourJoueur = rd.nextInt(nombreJoueur);

                //Boucle de jeu
                while (signalVictoire) {

                    if(joueurVivant==1){ //Test de fin de partie
                        signalVictoire = false;
                        System.out.println("##########################################################");
                        Fonction.sautDeLigne(2);
                        if (joueur1EnVie) {vainqueur = joueur1;}
                        else if (joueur2EnVie) {vainqueur = joueur2;}
                        else if (joueur3EnVie) {vainqueur = joueur3;}
                        else if (joueur4EnVie) {vainqueur = joueur4;}
                        System.out.println("La partie est finie ! Victoire de : " + vainqueur);
                        // Stockage des vainqueurs dans le tableau score
                        for (int i = 0; i < score.length; i++){
                            if(score[i].equals("")) {
                                score[i] = vainqueur;
                                break;
                            }
                        }
                         Fonction.sautDeLigne(1);
//                        startnew();
                    }
                    if (joueurVivant==1){break;}
                    //Premier joueur a jouer
                    if (!(joueur1EnVie)) {tourJoueur += 1;}
                    if (joueur1EnVie && plateau[joueur1Ligne][joueur1Colonne+1] != "[]" && plateau[joueur1Ligne][joueur1Colonne-1]!= "[]"
                            && plateau[joueur1Ligne+1][joueur1Colonne]!= "[]" && plateau[joueur1Ligne-1][joueur1Colonne]!= "[]"){
                        System.out.println(joueur1 + " est éliminé");
                        joueur1EnVie = false;
                        joueurVivant -= 1;
                        tourJoueur += 1;
                    }
                    if (tourJoueur % nombreJoueur == 0 && joueur1EnVie) {
                        System.out.print("C'est à " + joueur1 + " (" + couleur1 + ") de jouer, utilise z,q,s,d pour te déplacer : ");
                        bouton = sc.next();

                        if (bouton.equals("z") && plateau[joueur1Ligne-1][joueur1Colonne].equals("[]")) {
                            Fonction.bougeHaut(plateau, joueur1Ligne, joueur1Colonne, joueur1, couleur1);
                            joueur1Ligne -= 1;
                        }
                        if (bouton.equals("s") && plateau[joueur1Ligne+1][joueur1Colonne].equals("[]")) {
                            Fonction.bougeBas(plateau, joueur1Ligne, joueur1Colonne, joueur1, couleur1);
                            joueur1Ligne += 1;
                        }
                        if (bouton.equals("q") && plateau[joueur1Ligne][joueur1Colonne-1].equals("[]")) {
                            Fonction.bougeGauche(plateau, joueur1Ligne, joueur1Colonne, joueur1, couleur1);
                            joueur1Colonne -= 1;
                        }
                        if (bouton.equals("d") && plateau[joueur1Ligne][joueur1Colonne+1].equals("[]")) {
                            Fonction.bougeDroite(plateau, joueur1Ligne, joueur1Colonne, joueur1, couleur1);
                            joueur1Colonne += 1;
                        }if(bouton.equals("retour")){
                            menu.menu();
                        }

                        Fonction.afficherPlateau(plateau);
                        //Détruire une case
                        Scanner tourX = new Scanner(System.in);
                        System.out.println("Quelle case détruire (Horizontal)");
                        String caseToDestructXstring = tourX.next();
                        if (caseToDestructXstring.equals("FORTNITE")){
                            easterEgg.fortnite();
                        }
                        System.out.println("Quelle case détruire (Vertical)");
                        Scanner tourY = new Scanner(System.in);
                        String caseToDestructYstring = tourY.next();
                        boolean numberX = Fonction.estUnNombre(caseToDestructXstring);
                        boolean numberY = Fonction.estUnNombre(caseToDestructYstring);
                        if(numberX && numberY){
                            caseADetruireX = Integer.parseInt(caseToDestructXstring);
                            caseADetruireY = Integer.parseInt(caseToDestructYstring);
                        }
                        if (plateau[caseADetruireY][caseADetruireX].equals("[]")) {
                            if (couleur1.equals("rouge")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_RED + "#" + ANSI_RESET);}
                            if (couleur1.equals("bleu")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_BLUE + "#" + ANSI_RESET);}
                            if (couleur1.equals("violet")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_PURPLE + "#" + ANSI_RESET);}
                            if (couleur1.equals("jaune")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_YELLOW + "#" + ANSI_RESET);}
                        }
                        Fonction.afficherPlateau(plateau);
                        tourJoueur += 1;
                    }
                    if (!(joueur2EnVie)) {tourJoueur += 1;}
                    if (joueur2EnVie && plateau[joueur2Ligne][joueur2Colonne+1] != "[]" && plateau[joueur2Ligne][joueur2Colonne-1]!= "[]"
                            && plateau[joueur2Ligne+1][joueur2Colonne]!= "[]" && plateau[joueur2Ligne-1][joueur2Colonne]!= "[]"){
                        System.out.println(joueur2 + " est éliminé");
                        joueur2EnVie = false;
                        joueurVivant -= 1;
                        tourJoueur += 1;
                    }
                    if (tourJoueur % nombreJoueur == 1 && joueur2EnVie){ //Deuxieme joueur a jouer
                        System.out.print("C'est à " + joueur2 +  " (" + couleur2 + ") de jouer, utilise z,q,s,d pour te déplacer : ");
                        bouton = sc.next();
                        if (bouton.equals("z") && plateau[joueur2Ligne-1][joueur2Colonne].equals("[]")) {
                            Fonction.bougeHaut(plateau, joueur2Ligne, joueur2Colonne, joueur2, couleur2);
                            joueur2Ligne -= 1;
                        }
                        if (bouton.equals("s") && plateau[joueur2Ligne+1][joueur2Colonne].equals("[]")) {
                            Fonction.bougeBas(plateau, joueur2Ligne, joueur2Colonne, joueur2, couleur2);
                            joueur2Ligne += 1;
                        }
                        if (bouton.equals("q") && plateau[joueur2Ligne][joueur2Colonne-1].equals("[]")) {
                            Fonction.bougeGauche(plateau, joueur2Ligne, joueur2Colonne, joueur2, couleur2);
                            joueur2Colonne -= 1;
                        }
                        if (bouton.equals("d") && plateau[joueur2Ligne][joueur2Colonne+1].equals("[]")) {
                            Fonction.bougeDroite(plateau, joueur2Ligne, joueur2Colonne, joueur2, couleur2);
                            joueur2Colonne += 1;
                        }if(bouton.equals("retour")){
                            menu.menu();
                        }
                        Fonction.afficherPlateau(plateau);
                        //Détruire une case
                        Scanner tourX = new Scanner(System.in);
                        System.out.println("Quelle case détruire (Abscisse)");
                        String caseToDestructXstring = tourX.next();
                        if (caseToDestructXstring.equals("FORTNITE")){
                            easterEgg.fortnite();
                        }
                        System.out.println("Quelle case détruire (Ordonnée)");
                        Scanner tourY = new Scanner(System.in);
                        String caseToDestructYstring = tourY.next();
                        boolean numberX = Fonction.estUnNombre(caseToDestructXstring);
                        boolean numberY = Fonction.estUnNombre(caseToDestructYstring);
                        if(numberX && numberY){
                            caseADetruireX = Integer.parseInt(caseToDestructXstring);
                            caseADetruireY = Integer.parseInt(caseToDestructYstring);
                        }
                        if (plateau[caseADetruireY][caseADetruireX].equals("[]")) {
                            if (couleur2.equals("rouge")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_RED + "#" + ANSI_RESET);}
                            if (couleur2.equals("bleu")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_BLUE + "#" + ANSI_RESET);}
                            if (couleur2.equals("violet")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_PURPLE + "#" + ANSI_RESET);}
                            if (couleur2.equals("jaune")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_YELLOW + "#" + ANSI_RESET);}
                        }
                        Fonction.afficherPlateau(plateau);
                        tourJoueur += 1;
                    }
                    if (!(joueur3EnVie)) {tourJoueur += 1;}
                    if (joueur3EnVie && (nombreJoueur >= 3) && plateau[joueur3Ligne][joueur3Colonne+1] != "[]" && plateau[joueur3Ligne][joueur3Colonne-1]!= "[]"
                            && plateau[joueur3Ligne+1][joueur3Colonne]!= "[]" && plateau[joueur3Ligne-1][joueur3Colonne]!= "[]"){
                        System.out.println(joueur3 + " est éliminé");
                        joueur3EnVie = false;
                        joueurVivant -= 1;
                        tourJoueur += 1;
                    }
                    if (tourJoueur % nombreJoueur == 2 && joueur3EnVie){ //Troisieme joueur a jouer
                        System.out.print("C'est à " + joueur3 +  " (" + couleur3 + ") de jouer, utilise z,q,s,d pour te déplacer : ");
                        bouton = sc.next();
                        if (bouton.equals("z") && plateau[joueur3Ligne-1][joueur3Colonne].equals("[]")) {
                            Fonction.bougeHaut(plateau, joueur3Ligne, joueur3Colonne, joueur3, couleur3);
                            joueur3Ligne -= 1;
                        }
                        if (bouton.equals("s") && plateau[joueur3Ligne+1][joueur3Colonne].equals("[]")) {
                            Fonction.bougeBas(plateau, joueur3Ligne, joueur3Colonne, joueur3, couleur3);
                            joueur3Ligne += 1;
                        }
                        if (bouton.equals("q") && plateau[joueur3Ligne][joueur3Colonne-1].equals("[]")) {
                            Fonction.bougeGauche(plateau, joueur3Ligne, joueur3Colonne, joueur3, couleur3);
                            joueur3Colonne -= 1;
                        }
                        if (bouton.equals("d") && plateau[joueur3Ligne][joueur3Colonne+1].equals("[]")) {
                            Fonction.bougeDroite(plateau, joueur3Ligne, joueur3Colonne, joueur3, couleur3);
                            joueur3Colonne += 1;
                        }if(bouton.equals("retour")){
                            menu.menu();
                        }
                        Fonction.afficherPlateau(plateau);
                        //Détruire une case
                        Scanner tourX = new Scanner(System.in);
                        System.out.println("Quelle case détruire (Abscisse)");
                        String caseToDestructXstring = tourX.next();
                        if (caseToDestructXstring.equals("FORTNITE")){
                            easterEgg.fortnite();
                        }
                        System.out.println("Quelle case détruire (Ordonnée)");
                        Scanner tourY = new Scanner(System.in);
                        String caseToDestructYstring = tourY.next();
                        boolean numberX = Fonction.estUnNombre(caseToDestructXstring);
                        boolean numberY = Fonction.estUnNombre(caseToDestructYstring);
                        if(numberX && numberY){
                            caseADetruireX = Integer.parseInt(caseToDestructXstring);
                            caseADetruireY = Integer.parseInt(caseToDestructYstring);
                        }
                        if (plateau[caseADetruireY][caseADetruireX].equals("[]")) {
                            if (couleur3.equals("rouge")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_RED + "#" + ANSI_RESET);}
                            if (couleur3.equals("bleu")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_BLUE + "#" + ANSI_RESET);}
                            if (couleur3.equals("violet")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_PURPLE + "#" + ANSI_RESET);}
                            if (couleur3.equals("jaune")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_YELLOW + "#" + ANSI_RESET);}
                        }
                        Fonction.afficherPlateau(plateau);
                        tourJoueur += 1;
                    }
                    if (!(joueur4EnVie)) {tourJoueur += 1;}
                    if (joueur4EnVie && (nombreJoueur == 4) &&plateau[joueur4Ligne][joueur4Colonne+1] != "[]" && plateau[joueur4Ligne][joueur4Colonne-1]!= "[]"
                            && plateau[joueur4Ligne+1][joueur4Colonne]!= "[]" && plateau[joueur4Ligne-1][joueur4Colonne]!= "[]"){
                        System.out.println(joueur4 + " est éliminé");
                        joueur4EnVie = false;
                        joueurVivant -= 1;
                        tourJoueur += 1;
                    }
                    if (tourJoueur % nombreJoueur == 3 && joueur4EnVie){ //Quatrieme joueur a jouer
                        System.out.print("C'est à " + joueur4 +  " (" + couleur4 + ") de jouer, utilise z,q,s,d pour te déplacer : ");
                        bouton = sc.next();
                        if (bouton.equals("z") && plateau[joueur4Ligne-1][joueur4Colonne].equals("[]")) {
                            Fonction.bougeHaut(plateau, joueur4Ligne, joueur4Colonne, joueur4, couleur4);
                            joueur4Ligne -= 1;
                        }
                        if (bouton.equals("s") && plateau[joueur4Ligne+1][joueur4Colonne].equals("[]")) {
                            Fonction.bougeBas(plateau, joueur4Ligne, joueur4Colonne, joueur4, couleur4);
                            joueur4Ligne += 1;
                        }
                        if (bouton.equals("q") && plateau[joueur4Ligne][joueur4Colonne-1].equals("[]")) {
                            Fonction.bougeGauche(plateau, joueur4Ligne, joueur4Colonne, joueur4, couleur4);
                            joueur4Colonne -= 1;
                        }
                        if (bouton.equals("d") && plateau[joueur4Ligne][joueur4Colonne+1].equals("[]")) {
                            Fonction.bougeDroite(plateau, joueur4Ligne, joueur4Colonne, joueur4, couleur4);
                            joueur4Colonne += 1;
                        }if(bouton.equals("retour")){
                            menu.menu();
                        }
                        Fonction.afficherPlateau(plateau);
                        //Détruire une case
                        Scanner tourX = new Scanner(System.in);
                        System.out.println("Quelle case détruire (Abscisse)");
                        String caseToDestructXstring = tourX.next();
                        if (caseToDestructXstring.equals("FORTNITE")){
                            easterEgg.fortnite();
                        }
                        System.out.println("Quelle case détruire (Ordonnée)");
                        Scanner tourY = new Scanner(System.in);
                        String caseToDestructYstring = tourY.next();
                        boolean numberX = Fonction.estUnNombre(caseToDestructXstring);
                        boolean numberY = Fonction.estUnNombre(caseToDestructYstring);
                        if(numberX && numberY){
                            caseADetruireX = Integer.parseInt(caseToDestructXstring);
                            caseADetruireY = Integer.parseInt(caseToDestructYstring);
                        }
                        if (plateau[caseADetruireY][caseADetruireX].equals("[]")) {
                            if (couleur4.equals("rouge")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_RED + "#" + ANSI_RESET);}
                            if (couleur4.equals("bleu")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_BLUE + "#" + ANSI_RESET);}
                            if (couleur4.equals("violet")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_PURPLE + "#" + ANSI_RESET);}
                            if (couleur4.equals("jaune")) {plateau[caseADetruireY][caseADetruireX] = (ANSI_YELLOW + "#" + ANSI_RESET);}
                        }
                        Fonction.afficherPlateau(plateau);
                        tourJoueur += 1;
                    }
                }
                //Propose de relancer une partie
                recommencer();
            }
            else { //Si l'utilisateur entre un mauvais chiffre pour le nombre de joueur, lui repose la question
                System.out.println("J'ai dit entre 2 et 4 joueurs...");
                menu.menu();
            }
        }
    }
}
