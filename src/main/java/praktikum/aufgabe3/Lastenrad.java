package praktikum.aufgabe3;

import java.util.Random;
import java.util.function.Supplier;

public class Lastenrad extends Thread {
    private boolean isLieferant = false;
    private boolean isAbholer = false;
    private final Lager aktuellesLager;

    /**
     * Konstruktor setzt lieferant oder abholer flag und weist ein Lager zu
     * @param lastenradTyp
     * @param aktuellesLager
     */
    public Lastenrad(String lastenradTyp, Lager aktuellesLager){
        switch (lastenradTyp.toLowerCase()) {
            case "lieferant" -> isLieferant = true;
            case "abholer" -> isAbholer = true;
        }
        this.aktuellesLager = aktuellesLager;
    }
    @Override
    public void run(){
        while(!isInterrupted()){
            if(isLieferant){
                //Box mit zufälliger ID generieren
                Supplier<Box> boxGenerator = () -> new Box(new Random().nextInt(6) + 1);
                Box tmp = boxGenerator.get();
                aktuellesLager.einlagern(tmp);
                System.err.println(aktuellesLager);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(isAbholer){
                aktuellesLager.entnehmen();
                System.err.println(aktuellesLager);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Lager lager = new Lager(20);
        Lastenrad rad1 = new Lastenrad("Lieferant", lager);
        Lastenrad rad2 = new Lastenrad("Abholer", lager);
        Lastenrad rad3 = new Lastenrad("Lieferant", lager);
        rad1.start();
        rad2.start();
        //rad3.start();
    }
}
