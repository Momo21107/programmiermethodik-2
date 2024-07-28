package praktikum.aufgabe2;

public class Pruefungsleistung {
    private final String fach;
    private final int note;

    public Pruefungsleistung(String fach, int note) {
        this.fach = fach;
        this.note = note;
    }

    public String getFach() {
        return fach;
    }

    public int getNote() {
        return note;
    }

    @Override
    public String toString() {
        return '[' + fach + " / " + note + " Punkte" + ']';
    }
}
