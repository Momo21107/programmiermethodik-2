package praktikum.aufgabe2;

public class Anwendung {
    public static void main(String[] args) {
        Hochschule haw = new Hochschule();

        haw.einschreiben("Frodo", "Beutlin");
        haw.einschreiben("Lucky", "Luke");
        haw.einschreiben("Sherlock", "Holmes");
        haw.einschreiben("Carl", "Zeiss");

        haw.pruefungsleistungenEintragen(0, "PM2", 3);
        haw.pruefungsleistungenEintragen(0, "DB", 5);
        haw.pruefungsleistungenEintragen(0, "AF", 1);

        haw.pruefungsleistungenEintragen(1, "PM2", 13);
        haw.pruefungsleistungenEintragen(1, "DB", 15);
        haw.pruefungsleistungenEintragen(1, "AF", 3);

        haw.pruefungsleistungenEintragen(2, "PM2", 15);
        haw.pruefungsleistungenEintragen(2, "DB", 5);
        haw.pruefungsleistungenEintragen(2, "AF", 0);

        haw.studisAusgeben(Hochschule.MATRIKEL_GROESSER_ZWEI);
        System.out.println();
        haw.studisAusgeben(Hochschule.ALLE_STUDIS);
        System.out.println();
        haw.studisAusgeben(Hochschule.NACHNAME_BEGINNT_MIT_Z);
        System.out.println();

        haw.pruefungsleistungenAusgeben(0);
        System.out.println();
        haw.pruefungsleistungenAusgeben(1);
        System.out.println();
        haw.pruefungsleistungenAusgeben(2);
        System.out.println();
    }
}
