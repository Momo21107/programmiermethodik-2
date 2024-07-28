package praktikum.aufgabe2;

public class Studi {
    private final String vorname;
    private final String nachname;
    private final int matrikelnummer;

    public Studi(String vorname, String nachname, int matrikelnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.matrikelnummer = matrikelnummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + " / " + matrikelnummer;
    }
}
