package testAufgabe3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import praktikum.aufgabe3.Box;
import praktikum.aufgabe3.Lager;

public class TesteLager {
    @Test
    public void testeGetFreierPlatzindex(){
        Lager lager = new Lager(10);
        Box box1 = new Box(4);
        Box box2 = new Box(6);
        //Fall: leeres Lager und Boxlänge 4
        assertEquals(lager.getFreierPlatzindex(box1), 0);

        //Fall: 6 / 10 Plaetzen belegt und Boxlänge 6
        lager.einlagern(box2);
        assertEquals(lager.getFreierPlatzindex(box1), 6);

        //Fall: volles Lager und Boxlänge 4
        lager.einlagern(box1);
        assertEquals(lager.getFreierPlatzindex(box1), -1);
    }

    @Test
    public void testeEinlagern(){
        System.out.println("----- Test Einlagern -----");
        Lager lager = new Lager(10);
        Box box1 = new Box(4);
        Box box2 = new Box(6);
        System.out.println(lager);

        //Fall: Box mit ID [0] und Länge 4 in leeres Lager einlagern
        lager.einlagern(box1);
        System.out.println(lager);

        //Fall: Box mit ID [1] und Länge 6 in Lager mit 4 belegten Plätzen einlagern
        lager.einlagern(box2);
        System.out.println(lager);

        //Fall: Box mit ID [2] und Länge 4 in volles Lager einlagern [Endlosschleife erwartet!]
        /*
        lager.einlagern(box1);
        System.out.println(lager);
        */
    }

    @Test public void testeEntnehmen(){
        System.out.println("----- Test Entnehmen -----");
        Lager lager = new Lager(10);
        Box box1 = new Box(4);
        Box box2 = new Box(6);

        //Fall: entnehmen aus leerem Lager [Endlosschleife erwartet!]
        /*
        lager.entnehmen();
        System.out.println(lager);
        */

        //Fall: entnehmen aus Lager, welches eine Box mit Länge 4 enthält
        lager.einlagern(box1);
        System.out.println(lager);
        lager.entnehmen();
        System.out.println(lager);

        //Fall: entnehmen aus Lager, welches zwei Boxen mit Länge 4 und 6 enthält
        lager.einlagern(box1);
        lager.einlagern(box2);
        System.out.println(lager);
        lager.entnehmen();
        System.out.println(lager);
        lager.entnehmen();
        System.out.println(lager);
    }

}
