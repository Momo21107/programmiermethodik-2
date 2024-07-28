package praktikum.aufgabe3;

public class Box {
    private final int laenge;
    private final int id;
    private static int counter = 0;

    public Box(int laenge) {
        this.laenge = laenge;
        this.id = counter;
        counter++;
    }

    public int getLaenge() {
        return laenge;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Box{" +
                "laenge=" + laenge +
                ", id=" + id +
                '}';
    }
}
