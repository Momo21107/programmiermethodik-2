package praktikum.aufgabe4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Zeichenobjekte extends Beobachteter implements Beobachter{
    private ObservableList<GeometrieObjekt> listeGeometrieObjekte = FXCollections.<GeometrieObjekt>observableArrayList();
    public ObservableList<GeometrieObjekt> getListeGeometrieObjekte() {
        return listeGeometrieObjekte;
    }
    @Override
    public void update(Object payload) {
        melden(null);
    }
}
