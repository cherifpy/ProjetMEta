package Classes;

import java.util.Comparator;

public class ComparatorTaquin implements Comparator<ETaquin> {


    private ETaquin but;

    ComparatorTaquin(ETaquin but){
        this.but = but;
    }

    @Override
    public int compare(ETaquin T1, ETaquin T2) {
        return T1.Evaluate(this.but) - T2.Evaluate(this.but);
    }
}
