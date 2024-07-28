package praktikum.aufgabe1;

public interface Kontainer<T> {
    boolean hinzufuegen(T element);
    boolean entferne(T element);
    int getAnzahlElemente();
}
