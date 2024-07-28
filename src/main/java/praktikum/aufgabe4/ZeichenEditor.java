package praktikum.aufgabe4;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ZeichenEditor extends Application {
    private Punkt punktTmp;
    private boolean isStartingPoint = true;
    @Override
    public void start(Stage stage) throws Exception {
        Zeichenobjekte zeichenobjekte = new Zeichenobjekte();
        ObservableList<GeometrieObjekt> listeGeometrieobjekte = zeichenobjekte.getListeGeometrieObjekte();
        //Observable ArrayList updated Beobachter wenn sie sich veraendert
        listeGeometrieobjekte.addListener(new ListChangeListener<GeometrieObjekt>() {
            @Override
            public void onChanged(Change<? extends GeometrieObjekt> c) {
                zeichenobjekte.update(null);
            }
        });
        BorderPane wurzel = new BorderPane();
        stage.setScene(new Scene(wurzel, 800, 800));

        Zeichenflaeche zeichenflaeche = new Zeichenflaeche(zeichenobjekte);
        wurzel.setCenter(zeichenflaeche);

        //Tabelle initialisieren
        TableView<GeometrieObjekt> tabellenAnsicht = new TableView<>();
        tabellenAnsicht.setItems(listeGeometrieobjekte);

        //Tabellenspalte beschreibung
        TableColumn<GeometrieObjekt, String> beschreibungSpalte = new TableColumn<>("Beschreibung");
        tabellenAnsicht.getColumns().add(beschreibungSpalte);
        beschreibungSpalte.setCellValueFactory(new PropertyValueFactory<GeometrieObjekt, String>("beschreibung"));

        //Tabellenspalte Koordinaten
        TableColumn<GeometrieObjekt, String> koordinatenSpalte = new TableColumn<>("Koordinaten");
        tabellenAnsicht.getColumns().add(koordinatenSpalte);
        koordinatenSpalte.setCellValueFactory(new PropertyValueFactory<GeometrieObjekt, String>("koordinaten"));

        //Knopf zum Entfernen von Geometrieobjekten
        Button button = new Button("entferne ausgewaehltes Objekt");
        wurzel.setBottom(button);

        wurzel.setLeft(tabellenAnsicht);

        /*
        wenn ein Mausklick auf der Zeichenflaeche registriert wird, wird ein Punkt mit diesen Koordinaten erstellt
        und in die Liste eingefuegt. Wenn es der zweite Punkt ist, wird der vorherige Punkt mit dem jetzigen Punkt
        zu einer Linie verknuepft und der Liste hinzugefuegt.
         */
        zeichenflaeche.setOnMouseClicked(mouseEvent -> {
            Punkt p = new Punkt((int) mouseEvent.getX(), (int) mouseEvent.getY());
            listeGeometrieobjekte.add(p);
            if(isStartingPoint){
                punktTmp = p;
                isStartingPoint = false;
            }
            else{
                Linie l = new Linie(punktTmp, p);
                listeGeometrieobjekte.add(l);
                isStartingPoint = true;
            }
        });
        /*
        wenn der Knopf gecklickt wird, wird das Geometrieobjekt aus der ausgewaehlten aus der Liste entfernt
         */
        button.setOnMouseClicked(mouseEvent -> {
            GeometrieObjekt g = tabellenAnsicht.getSelectionModel().getSelectedItem();
            listeGeometrieobjekte.remove(g);
        });
        wurzel.setStyle("-fx-background-color: grey;");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
