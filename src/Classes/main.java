package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class main {

    public static boolean Verifier(ETaquin debut,ETaquin fin){
        String str_debut = debut.ToTabString(),str_fin = fin.ToTabString();
        int i_deb,j_deb,i_fin,j_fin,n = debut.getTaille()* debut.getTaille(),solv = 0;
        for(int i = 1;i<(n-1);i++){

            i_deb = str_debut.indexOf(""+i);
            i_fin = str_fin.indexOf(""+i);
            for(int j= (i+1);j<n;j++){
                j_deb = str_debut.indexOf(""+j);
                j_fin = str_fin.indexOf(""+j);

                if(((i_deb-j_deb)<0 && (i_fin-j_fin)>0)||((i_deb-j_deb)>0 && (i_fin-j_fin)<0)){

                    solv++;
                }
            }
        }

        return solv%2 == 0;
    }


    public static void main(String[] args) {

        //int taquin[][] = {{2, 8, 3 , 15}, {1, 6, 4 , 9}, {7, 13, 5 , 10}, {12,-1 ,11  ,14}};
        int taquin[][] = {{0, 2 , 4},
                          {3 , 1 , 5},
                          {7 , 6, 8}};

        int but[][] = {{0, 1 , 2},
                       {3 ,4 , 5},
                       {6 , 7 , 8}};

        ArrayList<Integer> regles ;

        ETaquin pere = new ETaquin(taquin, 3, 0, 0);
        ETaquin fin = new ETaquin(but, 3, 0, 0);
        System.out.println("Etat de depart:");
        pere.PrintTaquin();
        System.out.println("Etat de fin:");
        fin.PrintTaquin();

        if(Verifier(pere,fin)){
            System.out.println("Probleme Solvable");
        }else{
            System.out.println("Probleme Insolvable");

        }

        AEtoile Algo = new AEtoile(pere,fin);
        regles = Algo.Resolution();
        System.out.println("\nL'ensemble de regles qu'on doit appliquer est (A*): "
                + (regles!=null?regles.toString():"Rien Echec"));

        /*
        BFSAlgo Algo1 = new BFSAlgo(pere,fin);
        regles = Algo1.Resolution(5);
        System.out.println("\nL'ensemble de regles qu'on doit appliquer est (BFS): "
                + (regles!=null?regles.toString():"Etat non trouve(Changez la profondeur pour elargire le champs de recherche) "));
        */
        /*

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Jeu du taquin");
            frame.setResizable(false);
            frame.add(new Taquin(3, 550, 30), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });*/
    }
}
