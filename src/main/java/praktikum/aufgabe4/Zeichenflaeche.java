package praktikum.aufgabe4;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Random;

public class Zeichenflaeche extends Canvas implements Beobachter {
    private Zeichenobjekte zeichenobjekte;
    private GraphicsContext gc = getGraphicsContext2D();
    public Zeichenflaeche(Zeichenobjekte zeichenobjekte){
        super(500, 500);
        this.zeichenobjekte = zeichenobjekte;
        //Zeichenflaeche als Beobachter bei den Zeichenobjekten registrieren
        zeichenobjekte.hinzufuegen(this);
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,500,500);
        gc.setFill(Color.BLACK);
    }

    @Override
    public void update(Object payload) {
        paint();
    }

    /**
     * paint fuehrt je nach Typ der Objekte in der Liste, die entsprechende draw Methode auf der Zeichenflaeche aus
     */
    public void paint(){
        gc.clearRect(0, 0, 500, 500);
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,500,500);
        gc.setFill(Color.BLACK);
        for(GeometrieObjekt g : zeichenobjekte.getListeGeometrieObjekte()){
            if(g instanceof Punkt){
                gc.setStroke(Color.BLACK);
                paintPunkt(((Punkt) g).getX(), ((Punkt) g).getY());
            }
            else if(g instanceof Linie){
                gc.setStroke(Color.BLUE);
                paintLinie(((Linie) g).getPunkte()[0], ((Linie) g).getPunkte()[1]);
            }
        }
    }
    private void paintPunkt(int x, int y){
        //Circle dot = new Circle(20, 30, 10, Color.BLACK);
        gc.strokeArc(x, y, 2,2,0,360, ArcType.ROUND);
    }
    private void paintLinie(Punkt p1, Punkt p2){
        gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
