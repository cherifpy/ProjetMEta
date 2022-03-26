package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSAlgo extends Algoitheme{


    private ArrayList regles;
    private ETaquin temp_taquin;
    private boolean trouve_ = false;


    DFSAlgo(ETaquin debut,ETaquin fin){
        super(debut,fin);
    }

    public ArrayList<Integer> Resolution(int profondeur){

        Profondeur_dabord(this.getDebut(), profondeur);

        return this.regles;
    }


    private void Profondeur_dabord(ETaquin depart, int max_prof){


        ArrayList<Integer> regles_app;
        if(!(depart.getProfondeur() > max_prof)){
            if(Arrays.deepEquals(depart.getTab(),this.getFin().getTab())){
                this.trouve_ = true;
                this.regles = depart.getRegles();
            }else{
                regles_app = depart.getRegles_App();
                for(int i = 0; (i<regles_app.size()) && (!this.trouve_);i++){
                    this.temp_taquin = new ETaquin(depart,(int) regles_app.get(i));
                    Profondeur_dabord(this.temp_taquin,max_prof);
                }
            }
        }
    }




}
