package praktikum.aufgabe2;


import java.util.*;
import java.util.function.Predicate;

public class Hochschule {
    private List<Studi> listeStudis = new ArrayList<>();
    private Map<Studi,List<Pruefungsleistung>> mapLeistungen = new HashMap<>();
    private int matrikel = 0;

    /**
     * Predicate überprüft ob die Matrikelnummer von Studenten größer als Zwei ist
     */
    public static final Predicate<Studi> MATRIKEL_GROESSER_ZWEI = new Predicate<Studi>() {
        @Override
        public boolean test(Studi studi) {
            return studi.getMatrikelnummer() > 2;
        }
        @Override
        public String toString(){
            return "Alle Stundenten, deren Matrikelnummer größer als 2 ist: ";
        }
    };

    /**
     * Predicate überprüft ob der Nachname von Studenten mit Z beginnt
     */
    public static final Predicate<Studi> NACHNAME_BEGINNT_MIT_Z = new Predicate<Studi>() {
        @Override
        public boolean test(Studi studi) {
            return studi.getNachname().charAt(0) == 'Z' || studi.getNachname().charAt(0) == 'z';
        }
        @Override
        public String toString(){
            return "Alle Stundenten, deren Nachname mit Z beginnt: ";
        }
    };

    /**
     * Predicate liefert alle Studenten
     */
    public static final Predicate<Studi> ALLE_STUDIS = new Predicate<Studi>() {
        @Override
        public boolean test(Studi studi) {
            return true;
        }
        @Override
        public String toString(){
            return "Alle Stundenten: ";
        }
    };

    /**
     * einschreiben erstellt ein Studi Objekt aus den Parametern, fügt es in die interne Liste der Studenten ein
     * und gibt das erstellte Objekt zurück
     * @param vorname
     * @param nachname
     * @return
     */
    public Studi einschreiben(String vorname, String nachname){
        Studi tmp = new Studi(vorname, nachname, matrikel);
        listeStudis.add(tmp);
        matrikel++;
        return tmp;
    }

    /**
     * studisAusgeben filtert alle Studenten nach der übergebenen Bedingung und gibt entsprechende Studenten auf der Konsole aus
     * @param bedingung
     */
    public void studisAusgeben(Predicate<Studi> bedingung){
        String ans = bedingung.toString() + '{';
        for(Studi s : studisZurueckgeben(bedingung)){
            ans += s.toString();
            ans += studisZurueckgeben(bedingung).indexOf(s) == studisZurueckgeben(bedingung).size() - 1? "" : ", ";
        }
        ans += '}';
        System.out.println(ans);
    }

    /**
     * pruefungsleistungenEintragen erstellt intern ein Pruefungsleistungsobjekt, mit den übergebenen Parametern und fügt dieses in eine Map ein, insofern die Matrikelnummer existiert
     * der Schlüssel ist hierbei die übergebene Matrikelnummer und der Wert eine Liste von Prüfungsleistungen
     * @param matrikelnummer
     * @param fach
     * @param note
     */
    public void pruefungsleistungenEintragen (int matrikelnummer, String fach, int note){
        //Fall: es existiert ein Student mit der übergebenen matrikelnummer
        if(findeStudiInListe(matrikelnummer).isPresent()){
            Pruefungsleistung tmp = new Pruefungsleistung(fach, note);
            Studi tmpStudi = findeStudiInListe(matrikelnummer).get();
            //Fall: es sind noch keine Pruefungsleistungen eingetragen
            if(mapLeistungen.get(tmpStudi) == null){
                List<Pruefungsleistung> initList = new ArrayList<>();
                mapLeistungen.put(tmpStudi, initList);
            }
            mapLeistungen.get(tmpStudi).add(tmp);
        }
    }

    /**
     * prufeungsleistungenAusgeben gibt alle Prüfungsleistungen eines Studenten mit der übergebenen Matrikelnummer auf der Konsole aus, insofern die Matrikelnummer existiert
     * @param matrikelnummer
     */
    public void pruefungsleistungenAusgeben(int matrikelnummer){
        if(findeStudiInListe(matrikelnummer).isPresent()){
            Studi tmpStudi = findeStudiInListe(matrikelnummer).get();
            if(mapLeistungen.get(tmpStudi) == null){
                System.out.println(tmpStudi.toString() + " hat keine Prüfungsleistungen erbracht");
                return;
            }
            String ans = "Prüfungsleistungen von " + tmpStudi.toString() + " = ";
            for(Pruefungsleistung p : mapLeistungen.get(tmpStudi)){
                ans += p.toString();
            }
            System.out.println(ans);
        }
    }

    /**
     * Hilfsmethode findeStudiInListe liefert zu einer übergebenen Matrikelnummer das entsprechende Studi-Objekt, insofern die Matrikelnummer existiert
     * @param matrikelnummer
     * @return
     */
    private Optional<Studi> findeStudiInListe(int matrikelnummer){
        Studi tmp = null;
        for(Studi s : listeStudis){
            if(s.getMatrikelnummer() == matrikelnummer){
                tmp = s;
            }
        }
        return Optional.ofNullable(tmp);
    }

    /**
     * Hilfsmethode studisZurueckgeben erstellt eine Liste und fügt nur eingschriebene Studenten hinzu, die der übergebenen Bedingung entsprechen
     * anschließend wird diese Liste zurückgegeben
     * @param bedingung
     * @return
     */
    private List<Studi> studisZurueckgeben(Predicate<Studi> bedingung){
        List<Studi> ans = new ArrayList<>();
        for(Studi s : listeStudis){
            if(bedingung.test(s)){
                ans.add(s);
            }
        }
        return ans;
    }

    public List<Studi> getListeStudis() {
        return listeStudis;
    }

    public Map<Studi, List<Pruefungsleistung>> getMapLeistungen() {
        return mapLeistungen;
    }
}
