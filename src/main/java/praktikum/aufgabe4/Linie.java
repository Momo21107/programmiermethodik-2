package praktikum.aufgabe4;

public class Linie extends GeometrieObjekt{
    private Punkt[] punkte = new Punkt[2];
    public Linie(Punkt punkt1, Punkt punkt2){
        punkte[0] = punkt1;
        punkte[1] = punkt2;
        this.setBeschreibung("Linie");
        this.setKoordinaten(punkt1.getX() + " , " + punkt1.getY() + " - " + punkt2.getX() + " , " + punkt2.getY());
    }
    public Punkt[] getPunkte() {
        return punkte;
    }
}
