package praktikum.aufgabe1;

public class Sammelkarte {
    private final String titel;
    private final Seltenheit seltenheit;
    public Sammelkarte(String titel, Seltenheit seltenheit){
        this.seltenheit = seltenheit;
        this.titel = titel;
    }

    @Override
    public String toString() {
        return titel + "/" + seltenheit.toString();
    }
}
