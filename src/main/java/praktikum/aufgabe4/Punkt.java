package praktikum.aufgabe4;

public class Punkt extends GeometrieObjekt{
    private int x;
    private int y;

    public Punkt(int x, int y){
        this.x = x;
        this.y = y;
        this.setBeschreibung("Punkt");
        this.setKoordinaten(x + " , " + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
