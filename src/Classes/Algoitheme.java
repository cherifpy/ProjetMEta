package Classes;

public class Algoitheme {
    private ETaquin debut;
    private ETaquin fin;

    public ETaquin getDebut() {return debut;}
    public void setDebut(ETaquin debut) {this.debut = debut;}

    public ETaquin getFin() {return fin;}
    public void setFin(ETaquin fin) {this.fin = fin;}


    public Algoitheme(ETaquin debut,ETaquin fin){
        this.debut = debut;
        this.fin = fin;
    }


    public boolean Verifier(){
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

}
