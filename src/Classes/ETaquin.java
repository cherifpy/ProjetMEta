package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class ETaquin {

    private int[][] Tab;
    private int taille, profondeur , x_vide = 0,y_vide = 0;
    private ArrayList regles = new <Integer>ArrayList();
    private ETaquin pred = null;
    public int getProfondeur() {
        return profondeur;
    }
    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public int[][] getTab() {return Tab.clone();}
    public void setTab(int[][] tab) {Tab = tab;}

    public int getTaille() {return taille;}
    public void setTaille(int taille) {this.taille = taille;}

    public int getX_vide() {return x_vide;}
    public void setX_vide(int x_vide) {this.x_vide = x_vide;}

    public int getY_vide() {return y_vide;}
    public void setY_vide(int y_vide) {this.y_vide = y_vide;}

    public void setRegles(ArrayList<Integer> regles) {this.regles = regles;}
    public ArrayList<Integer> getRegles() {return this.regles;}

    public ETaquin getPred() {return pred;}
    public void setPred(ETaquin pred) {this.pred = pred;}

    ETaquin(int taille){
        this.taille = taille;
        this.Tab = new int[taille][taille];
        for(int i = 0;i<taille;i++){
            for(int j = 0;j<taille;j++){
                this.Tab[i][j] = 0;
            }
        }
        this.profondeur = 0;
    }

    public ETaquin(int[][] taquin, int tail,int x_vide,int y_vide){
        this.taille = tail;
        this.Tab = taquin;
        this.profondeur = 0;
        this.x_vide = x_vide;
        this.y_vide = y_vide;
        this.regles = new ArrayList<>();
    }



    ETaquin(ETaquin Pere, int regle){
        /*
        1 permutation <--
        2 permutation -->
        3 permutation /\
        4 permutation \/
        */

        this.Tab = new int[Pere.getTaille()][Pere.getTaille()];
        this.regles = new <Integer>ArrayList();
        this.taille = (Pere.getTaille());
        this.x_vide = (int) Pere.getX_vide();
        this.y_vide = (int) Pere.getY_vide();
        this.pred = Pere;

        this.regles = (ArrayList) Pere.getRegles().clone();

        this.regles.add(regle);

        this.Tab = Arrays.copyOf(Pere.getTab(),Pere.getTaille());
        for(int i = 0;i<Pere.getTaille();i++){
            this.Tab[i] = Arrays.copyOf(Pere.getTab()[i],Pere.getTaille());
        }


        if(regle == 1){
            this.Tab[this.x_vide][this.y_vide] = this.Tab[this.x_vide][this.y_vide - 1];
            this.Tab[this.x_vide][this.y_vide - 1] = 0;
            this.y_vide -=1;
        }
        if(regle == 2){
            this.Tab[this.x_vide][this.y_vide] = this.Tab[this.x_vide][this.y_vide + 1 ];
            this.Tab[this.x_vide][this.y_vide + 1] = 0;
            this.y_vide +=1;
        }
        if(regle == 3){
            this.Tab[this.x_vide][this.y_vide] = this.Tab[this.x_vide - 1][this.y_vide];
            this.Tab[this.x_vide - 1][this.y_vide] = 0;
            this.x_vide-=1;
        }
        if (regle == 4){
            this.Tab[this.x_vide][this.y_vide] = this.Tab[this.x_vide + 1][this.y_vide];
            this.Tab[this.x_vide + 1][this.y_vide] = 0;
            this.x_vide+=1;
        }

        this.profondeur = Pere.getProfondeur() + 1 ;

    }

    private int H_Mal_Placees(ETaquin but){
        int nbr = 0;
        for(int i = 0;i<this.taille;i++){
            for(int j = 0;j<this.taille;j++){
                if((this.Tab[i][j] != 0) && (this.Tab[i][j] != (but.getTab())[i][j])){
                    nbr++;
                }
            }
        }
        return nbr;
    }

    private static int H_Manhattan(ETaquin etat , ETaquin etat_but)
    {
        int nb = 0 ;
        int nb_temp = 0 ;
        int ligne_init=0 , ligne_but=0 , colonne_init=0 , colonne_but=0 ;

        for(int n = 1 ; n < etat.getTaille()*etat.getTaille() ; n++)  {

            for(int i = 0 ; i < etat.getTaille(); i++){

                for(int j = 0 ; j < etat.getTaille() ; j++){
                    if(etat.getTab()[i][j] == n) {
                        ligne_init = i ;
                        colonne_init = j;
                    }

                    if(etat_but.getTab()[i][j] == n){
                        ligne_but = i ;
                        colonne_but = j ;
                    }
                }
            }
            nb_temp = Math.abs(ligne_init-ligne_but) + Math.abs(colonne_init-colonne_but) ;
            nb = nb + nb_temp ;
        }

        return nb ;
    }

    public int Evaluate(ETaquin but){
        return this.profondeur + H_Mal_Placees(but);
    }

    public void PrintTaquin(){
        for(int i = 0;i<taille;i++){
            for(int j = 0;j<taille;j++){
                System.out.print(this.Tab[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public ArrayList getRegles_App(){
        ArrayList regles =  new <Integer>ArrayList();
        boolean add;
        /*
        1 permutation <--
        2 permutation -->
        3 permutation /\
        4 permutation \/
        */
        if(this.y_vide != 0){
            add = regles.add(1);}

        if(this.y_vide != (this.taille-1)){
            add = regles.add(2);
        }

        if(this.x_vide != 0){
            add = regles.add(3);}

        if(this.x_vide != (this.taille-1)){
            add = regles.add(4);}

        return regles;
    }

    public String ToTabString(){
        String str = "";
        for(int i = 0;i<this.taille;i++){
            for(int j= 0;j<this.taille;j++){
                    str += this.Tab[i][j];
            }
        }
        return str;
    }


}
