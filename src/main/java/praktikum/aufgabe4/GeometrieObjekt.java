package praktikum.aufgabe4;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class GeometrieObjekt extends Beobachteter {
    protected StringProperty beschreibung = new SimpleStringProperty();
    protected StringProperty koordinaten = new SimpleStringProperty();
    protected BooleanProperty isSelected = new SimpleBooleanProperty();
    public final void setBeschreibung(String wert){
        beschreibung.set(wert);
    }
    public final String getBeschreibung(){
        return beschreibung.get();
    }
    public final void setKoordinaten(String wert){
        koordinaten.set(wert);
    }
    public final String getKoordinaten(){
        return koordinaten.get();
    }

}
