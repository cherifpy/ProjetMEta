package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class main {



    public static void main(String[] args) {

        //int taquin[][] = {{2, 8, 3 , 15}, {1, 6, 4 , 9}, {7, 13, 5 , 10}, {12,-1 ,11  ,14}};
        int taquin[][] = {{2 , 8 , 3},
                          {1 , 6 , 4},
                          {7 , 0, 5}};

        int but[][] = {{1 , 2 , 3},
                       {8 , 0 , 4},
                       {7 , 6 , 5}};

        int taquin_[][] = {{1 , 2 , 3},
                {8 , 0 , 4},
                {7 , 6 , 5}};


        ArrayList<Integer> regles ;

        ETaquin pere = new ETaquin(taquin, 3, 2, 1);
        ETaquin fin = new ETaquin(but, 3, 1, 1);
        System.out.println("Etat de depart:");
        pere.PrintTaquin();
        System.out.println("Etat de fin:");
        fin.PrintTaquin();





        if(false){

            System.out.println("Probleme Insolvable");
        }else {
            System.out.println("Probleme Solvable");


            System.out.println("Resolution .....");


            AEtoile Algo = new AEtoile(pere, fin);
            regles = Algo.Resolution();
            System.out.println("\nL'ensemble de regles qu'on doit appliquer est (A*): "
                    + (regles != null ? regles.toString() : "Rien Echec"));


            BFSAlgo Algo1 = new BFSAlgo(pere, fin);
            regles = Algo1.Resolution(5);
            System.out.println("\nL'ensemble de regles qu'on doit appliquer est (BFS): "
                    + (regles != null ? regles.toString() : "Etat non trouve(Changez la profondeur pour elargire le champs de recherche) "));

            DFSAlgo Algo2 = new DFSAlgo(pere, fin);
            regles = Algo2.Resolution(5);
            System.out.println("\nL'ensemble de regles qu'on doit appliquer est (DFS): "
                    + (regles != null ? regles.toString() : "Rien"));
        }


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Jeu du taquin");
            frame.setResizable(false);
            frame.add(new Taquin(3, 550, 30), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
