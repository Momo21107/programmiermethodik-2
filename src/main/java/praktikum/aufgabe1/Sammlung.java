package praktikum.aufgabe1;

import java.util.Iterator;
import java.util.Random;

public class Sammlung extends Menge<Sammelkarte> implements Iterable<Sammelkarte> {
    public Sammlung(String name){
        super.mengenBezeichnung = name;
    }

    @Override
    public Iterator<Sammelkarte> iterator() {
        return new SammelkarteIterator();
    }

    private class SammelkarteIterator implements Iterator<Sammelkarte>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index != anzahlElemente;
        }

        @Override
        public Sammelkarte next() {
            return (Sammelkarte) elemente[index++];
        }
    }

    public static void main(String[] args) {
        Sammlung test = new Sammlung("meine Sammelkarten");
        Sammelkarte riese = new Sammelkarte("Riese", Seltenheit.HAEUFIG);
        Sammelkarte zwerg = new Sammelkarte("Zwerg", Seltenheit.NORMAL);
        Sammelkarte elf = new Sammelkarte("Elf", Seltenheit.SELTEN);
        test.hinzufuegen(elf);
        test.hinzufuegen(riese);
        test.hinzufuegen(zwerg);
        test.entferne(riese);
        test.hinzufuegen(riese);

        Iterator<Sammelkarte> it = test.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(test.zufaelliges());

        System.out.println(test);

    }
}
