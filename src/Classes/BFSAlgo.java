package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BFSAlgo {

    private ETaquin debut;
    private ETaquin fin;

    public ETaquin getDebut() {return debut;}
    public void setDebut(ETaquin debut) {this.debut = debut;}

    public ETaquin getFin() {return fin;}
    public void setFin(ETaquin fin) {this.fin = fin;}

    BFSAlgo(ETaquin debut,ETaquin fin){
        this.debut = debut;
        this.fin = fin;


    }


    public ArrayList<Integer> Resolution(int prod_limite){
        ETaquin temp = null;
        ArrayList<ETaquin> file_etat = new ArrayList<ETaquin>();
        ArrayList<Integer> regles = new ArrayList<Integer>();
        file_etat.add(this.debut);
        while (!file_etat.isEmpty()){
            temp = file_etat.remove(0);
            regles = temp.getRegles_App();
            if(Arrays.deepEquals(temp.getTab(),this.fin.getTab())){

                return temp.getRegles();
            }
            else {
                if(temp.getProfondeur() < prod_limite){
                    for (int i=0;i<regles.size();i++) {
                        int j = regles.get(i);
                        file_etat.add(new ETaquin(temp,j));
                    }
                    regles.clear();
                }

            }
        }


        return null;
    }

}
