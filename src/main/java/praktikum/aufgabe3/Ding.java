package praktikum.aufgabe3;

public class Ding implements Comparable<Ding>{
    private int zahl;
    private String zeichenkette;

    public Ding(int zahl, String zeichenkette) {
        this.zahl = zahl;
        this.zeichenkette = zeichenkette;
    }

    public int getZahl() {
        return zahl;
    }

    public String getZeichenkette() {
        return zeichenkette;
    }

    @Override
    public String toString() {
        return "Ding{" +
                "zahl=" + zahl +
                ", zeichenkette='" + zeichenkette + '\'' +
                '}';
    }

    @Override
    public int compareTo(Ding o) {
        if(zahl > o.zahl){
            return 1;
        }
        else if(zahl < o.zahl){
            return -1;
        }
        else{
            return 0;
        }
    }
}
