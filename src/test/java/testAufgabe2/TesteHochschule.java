package testAufgabe2;

import org.junit.jupiter.api.Test;
import praktikum.aufgabe2.Hochschule;
import praktikum.aufgabe2.Studi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TesteHochschule {
    @Test
    public void testeEinschreiben(){
        Hochschule hochschule = new Hochschule();
        //alle Studenten in interner Arraylist enthalten?
        assertTrue(hochschule.getListeStudis().contains(hochschule.einschreiben("Frodo", "Beutlin")));
        assertTrue(hochschule.getListeStudis().contains(hochschule.einschreiben("Lucky", "Luke")));
        assertTrue(hochschule.getListeStudis().contains(hochschule.einschreiben("Sherlock", "Holmes")));
        //Matrikelnummern aufsteigend?
        assertTrue(hochschule.getListeStudis().get(0).getMatrikelnummer() < hochschule.getListeStudis().get(1).getMatrikelnummer());
        assertTrue(hochschule.getListeStudis().get(1).getMatrikelnummer() < hochschule.getListeStudis().get(2).getMatrikelnummer());
    }
}
