package praktikum.aufgabe1;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Random;

public class Menge <T> implements Kontainer<T>{
    protected String mengenBezeichnung = "";
    protected int anzahlElemente;
    protected Object[] elemente;

    /**
     * Fügt Objekte in die Menge hinzu. Prüft dabei, ob sie bereits existieren und ob der Array groß genug ist.
     * Null Objekte werden nicht akzeptiert.
     * @param element das in die Menge einzufügende Objekt.
     * @return false, wenn Objekt bereits in Menge ist.
     *          true, wenn hinzufügen erfolgreich
     */
    @Override
    public boolean hinzufuegen(T element) {
        //element darf nicht null sein
        Preconditions.checkNotNull(element, "Element darf nicht null sein");
        //fall leere Menge
        if(anzahlElemente == 0){
            elemente = new Object[1];
            elemente[0] = element;
            anzahlElemente++;
            return true;
        }
        //überprüfen ob element schon in Menge enthalten ist und wenn ja false zurückgeben
        for(Object o : elemente){
            if(o != null && o.hashCode() == element.hashCode() && o.equals(element)){
                return false;
            }
        }
        //wenn array voll ist, Länge verdoppeln und elemente rüberkopieren
        if(anzahlElemente == elemente.length){
            Object[] tmp = new Object[anzahlElemente * 2];
            System.arraycopy(elemente, 0, tmp, 0, anzahlElemente);
            elemente = tmp;
        }
        for(int i = 0; i < elemente.length; i++){
            if(elemente[i] == null){
                elemente[i] = element;
                anzahlElemente++;
                return true;
            }
        }
        return false;
    }

    /**
     * Liefert true, wenn das übergebene Element bereits in der Menge ist. Die Prüfung wird zuerst mit hashCode() und
     * dann bei Bedarf mit equals() durchgeführt.
     * @param element Objekt das gefunden werden soll
     * @return true, wenn das übergebene Element bereits in der Menge ist, sonst false
     */
    public boolean beinhaltet(T element){
        //iterieren durch array und auf gleichheit prüfen
        for(Object o : elemente){
            if(o != null && o.hashCode() == element.hashCode() && o.equals(element)){
                return true;
            }
        }
        return false;
    }

    /**
     * Liefert ein zufälliges Element aus der Menge. Aufruf ist nur erlaubt, wenn die Anzahl der Elemente größer 0 ist.
     * @return Das zufällig ausgewählte Element aus der Menge.
     */
    public T zufaelliges(){
        //Menge darf nicht leer sein
        Preconditions.checkArgument(anzahlElemente > 0, "Menge darf nicht leer sein");
        //zufallszahl zwischen 0 und anzahlElemente generieren und element an dieser Stelle zurückgeben

        return (T) elemente[(int)(Math.random() * (double)anzahlElemente)];
    }

    /**
     * Entfernt Objekte aus der Menge, sofern diese vorhanden sind.
     * @param element das aus der Menge zu entfernende Object.
     * @return Liefert true, wenn das Element entfernt wurde, ansonsten false
     */
    @Override
    public boolean entferne(T element) {
            Preconditions.checkNotNull(element);
            for(int i = 0; i < anzahlElemente; i++){
                //wenn element einem element aus der Menge entspricht, wird das Element an der Stelle im Array durch null ersetzt
                if(elemente[i].hashCode() == element.hashCode() && elemente[i].equals(element)){
                    elemente[i] = null;
                    anzahlElemente--;
                    //elemente nach entferntem element werden aufgerutscht
                    for(int j = i; j < i + anzahlElemente; j++){
                        elemente[j] = elemente[j + 1];
                    }
                    return true;
                }
            }
            //wenn element keinem element der Menge entspricht, gibt false zurück und die Menge bleibt unverändert
        return false;
    }

    /**
     * Gibt die Anzahl der Elemente, die aktuell in der Menge sind.
     * @return die Anzahl der Elemente als Int in Dezimalsystem.
     */
    @Override
    public int getAnzahlElemente() {
        return anzahlElemente;
    }


    public Object[] getElemente() {
        return elemente;
    }

    @Override
    public String toString() {
        return mengenBezeichnung + ": " + Arrays.toString(elemente);
    }

}
