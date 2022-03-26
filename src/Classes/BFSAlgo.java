package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BFSAlgo extends  Algoitheme {


    BFSAlgo(ETaquin debut,ETaquin fin){
        super(debut,fin);
    }


    public ArrayList<Integer> Resolution(int prod_limite){
        ETaquin temp = null;
        ArrayList<ETaquin> file_etat = new ArrayList<ETaquin>();
        ArrayList<Integer> regles = new ArrayList<Integer>();
        file_etat.add(this.getDebut());
        while (!file_etat.isEmpty()){
            temp = file_etat.remove(0);
            regles = temp.getRegles_App();
            if(Arrays.deepEquals(temp.getTab(),this.getFin().getTab())){

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
