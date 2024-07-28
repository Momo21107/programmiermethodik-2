package praktikum.aufgabe3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lager {
    private final Box[] lagerraum;
    private final List<Box> eingelegteBoxen = new ArrayList<>();
    public Lager(int anzahlStellplaetze){
        this.lagerraum = new Box[anzahlStellplaetze];
    }

    /**
     * einlagern fuegt eine Box ein, solange genug Platz im internen Array fuer die Laenge der Box ist
     * @param box
     */
    public synchronized void einlagern(Box box){
        //Thread parken bis genug Platz frei ist
        while(getFreierPlatzindex(box) == -1){
            try{
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //Box hinzufügen
        int index = getFreierPlatzindex(box);
        for(int i = index; i < box.getLaenge() + index; i++){
            lagerraum[i] = box;
        }
        eingelegteBoxen.add(box);
        //alle anderen Threads benachrichtigen
        notifyAll();
    }

    /**
     * entnehmen entfernt eine box aus dem Array, solange mindestens ein Element existiert
     * @return
     */
    public synchronized Box entnehmen(){
        //Thread parken bis mindestens eine Box enthalten ist
        while(eingelegteBoxen.isEmpty()){
            try{
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //zufällige Box entnehmen
        Box randomBox = eingelegteBoxen.get((int) (Math.random() * (double)eingelegteBoxen.size()));
        for(int i = 0; i < lagerraum.length; i++){
            if(lagerraum[i] != null && lagerraum[i].equals(randomBox)){
                lagerraum[i] = null;
            }
        }
        eingelegteBoxen.remove(randomBox);
        //alle anderen Threads benachrichtigen
        notifyAll();
        return randomBox;
    }

    /**
     * Hilfsmethode getFreierPlatzindex gibt den Index im Array zurück, ab dem eine Box hineinpasst
     * Sie gibt -1 zurück, wenn es keinen passenden Index gibt
     * @param box
     * @return
     */
    public int getFreierPlatzindex(Box box){
        int counter = 0;
        for(int i = 0; i < lagerraum.length; i++){
            if(lagerraum[i] == null){
                if(counter >= box.getLaenge() - 1){
                    return i - counter;
                }
                counter++;
            }
            else{
                counter = 0;
            }
        }
        return -1;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Box b : lagerraum){
            if(b == null){
                res.append("x ");
                continue;
            }
            res.append(b.getId()).append(" ");
        }
        return res.toString();
    }
}
