package praktikum.aufgabe3;

import java.util.Comparator;

public class DingComparator implements Comparator<Ding> {
    @Override
    public int compare(Ding o1, Ding o2) {
        if(o1.getZeichenkette().length() > o2.getZeichenkette().length()){
            return 1;
        }
        else if(o1.getZeichenkette().length() < o2.getZeichenkette().length()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
