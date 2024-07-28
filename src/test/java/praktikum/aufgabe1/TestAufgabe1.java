package praktikum.aufgabe1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Dies ist eine Platzhalter-Klasse. An dieser Stelle müssen die Unit-Testklassen
 * abgelegt werden.
 */
public class TestAufgabe1 {
    @Test
    public void testeHinzufuegen() {
        Menge<Integer>testMenge = new Menge<>();

        //teste hinzufügen von null-Objekt
        try{
            testMenge.hinzufuegen(null);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        //teste hinzufügen von zwei gleichen Objekten
        assertTrue(testMenge.hinzufuegen(1));
        assertFalse(testMenge.hinzufuegen(1));
        assertEquals(testMenge.getAnzahlElemente(), 1);
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(1));

        //teste hinzufügen von zwei unterschiedlichen Objekten
        assertTrue(testMenge.hinzufuegen(2));
        assertEquals(testMenge.getAnzahlElemente(), 2);
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(2));
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(1));
    }
    @Test
    public void testeBeinhaltet(){
        Menge<Integer> testMenge = new Menge<>();
        testMenge.hinzufuegen(1);
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(1));
        assertFalse(Arrays.asList(testMenge.getElemente()).contains(0));
    }
    @Test
    public void testeZufaelliges(){
        Menge<Integer> testMenge = new Menge<>();

        //teste zufälliges einer leeren Menge
        try{
            testMenge.zufaelliges();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //teste, ob Zufälliges in Menge enthalten ist
        testMenge.hinzufuegen(1);
        testMenge.hinzufuegen(2);
        testMenge.hinzufuegen(3);
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(testMenge.zufaelliges()));
    }

    @Test
    public void testeEntferne(){
        Menge<Integer> testMenge = new Menge<>();
        testMenge.hinzufuegen(1);
        testMenge.hinzufuegen(2);
        testMenge.hinzufuegen(3);
        int laengeVorEntfernen = testMenge.getElemente().length;

        //teste entfernen vorhandenes Element
        assertTrue(testMenge.entferne(1));
        assertFalse(Arrays.asList(testMenge.getElemente()).contains(1));
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(2));
        assertTrue(Arrays.asList(testMenge.getElemente()).contains(3));
        assertEquals(laengeVorEntfernen, testMenge.getElemente().length);

        //teste entfernen nicht vorhandenes Element
        assertFalse(testMenge.entferne(0));
        assertEquals(laengeVorEntfernen, testMenge.getElemente().length);
    }
}
