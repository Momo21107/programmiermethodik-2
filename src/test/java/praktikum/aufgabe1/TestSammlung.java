package praktikum.aufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.xml.stream.events.StartDocument;

public class TestSammlung {
    @Test
    public void testeHinzufuegen() {
        Sammlung sammlung = new Sammlung("Star Wars I");
        Sammelkarte anakinSkywalker = new Sammelkarte("Anakin Skywalker",Seltenheit.SELTEN );
        Sammelkarte cloneTrooper = new Sammelkarte("Clone Trooper",Seltenheit.HAEUFIG);
        Sammelkarte senator = new Sammelkarte("Senator",Seltenheit.NORMAL );
        Sammelkarte rex = new Sammelkarte("Rex",Seltenheit.SELTEN);
        Sammelkarte obiWanKenobi = new Sammelkarte("Obi-Wan Kenobi",Seltenheit.SELTEN );


        //mehrere hinzufügen.
        Assertions.assertTrue(sammlung.hinzufuegen(anakinSkywalker));
        Assertions.assertEquals(1,sammlung.getAnzahlElemente());
        Assertions.assertTrue(sammlung.beinhaltet(anakinSkywalker));

        Assertions.assertTrue(sammlung.hinzufuegen(cloneTrooper));
        Assertions.assertEquals(2,sammlung.getAnzahlElemente());
        Assertions.assertTrue(sammlung.beinhaltet(cloneTrooper));

        Assertions.assertTrue(sammlung.hinzufuegen(senator));
        Assertions.assertEquals(3,sammlung.getAnzahlElemente());
        Assertions.assertTrue(sammlung.beinhaltet(senator));

        Assertions.assertTrue(sammlung.hinzufuegen(rex));
        Assertions.assertEquals(4,sammlung.getAnzahlElemente());
        Assertions.assertTrue(sammlung.beinhaltet(rex));

        Assertions.assertTrue(sammlung.hinzufuegen(obiWanKenobi));
        Assertions.assertEquals(5,sammlung.getAnzahlElemente());
        Assertions.assertTrue(sammlung.beinhaltet(obiWanKenobi));

        //Wie löse ich sowas? NullPointerEx von mir geworfen, aber wenn nicht von mir geworfen dann von
        //hashCode.
        //Null Objekt hinzufügen.
        try {
            sammlung.hinzufuegen(null);
            Assertions.fail();
        }
        catch (NullPointerException exception) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testeEntferne() {
        Sammlung sammlung = new Sammlung("Star Wars II");
        Sammelkarte anakinSkywalker = new Sammelkarte("Anakin Skywalker",Seltenheit.SELTEN );
        Sammelkarte senator = new Sammelkarte("Senator",Seltenheit.NORMAL );
        Sammelkarte rex = new Sammelkarte("Rex",Seltenheit.SELTEN);
        Sammelkarte obiWanKenobi = new Sammelkarte("Obi-Wan Kenobi",Seltenheit.SELTEN );

        //Gleiches Problem wie Oben!
        //Null Object entfernen.
        try {
            sammlung.entferne(null);
            Assertions.fail();
        }
        catch (NullPointerException exception) {
            Assertions.assertTrue(true);
        }

        sammlung.hinzufuegen(anakinSkywalker);
        Assertions.assertEquals(1, sammlung.getAnzahlElemente());

        //Zweimal denselben Entfernen.
        Assertions.assertTrue(sammlung.entferne(anakinSkywalker));
        Assertions.assertEquals(0, sammlung.getAnzahlElemente());
        Assertions.assertFalse(sammlung.entferne(anakinSkywalker));
        Assertions.assertEquals(0, sammlung.getAnzahlElemente());

        //Sammlung füllen.
        sammlung.hinzufuegen(anakinSkywalker);
        sammlung.hinzufuegen(rex);
        sammlung.hinzufuegen(obiWanKenobi);
        sammlung.hinzufuegen(senator);
        Assertions.assertEquals(4, sammlung.getAnzahlElemente());

        //Letztes Entfernen.
        Assertions.assertTrue(sammlung.entferne(senator));
        Assertions.assertEquals(3, sammlung.getAnzahlElemente());
        //Mitte Entfernen.
        Assertions.assertTrue(sammlung.entferne(rex));
        Assertions.assertEquals(2, sammlung.getAnzahlElemente());
        //Anfang Entfernen.
        Assertions.assertTrue(sammlung.entferne(anakinSkywalker));
        Assertions.assertEquals(1, sammlung.getAnzahlElemente());
    }

    @Test
    public void testeBeinhaltet() {
        Sammlung sammlung = new Sammlung("Star Wars III");
        Sammelkarte anakinSkywalker = new Sammelkarte("Anakin Skywalker",Seltenheit.SELTEN );
        Sammelkarte senator = new Sammelkarte("Senator",Seltenheit.NORMAL );

        //Sammlung füllen.
        sammlung.hinzufuegen(anakinSkywalker);
        sammlung.hinzufuegen(senator);

        //Alles drin was reinsoll?
        Assertions.assertTrue(sammlung.beinhaltet(anakinSkywalker));
        Assertions.assertTrue(sammlung.beinhaltet(senator));

        //Entfernen.
        sammlung.entferne(senator);

        //Erkennt es, dass Senator nicht mehr drin ist?
        Assertions.assertFalse(sammlung.beinhaltet(senator));

        //Gleiches Problem wie Oben!
        //Null Object.
        try {
            sammlung.beinhaltet(null);
            Assertions.fail();
        }
        catch (NullPointerException exception) {
            Assertions.assertTrue(true);
        }
    }

    @RepeatedTest(10)
    public void testeZufaellig() {
        Sammlung sammlung = new Sammlung("Star Wars IV");
        Sammelkarte anakinSkywalker = new Sammelkarte("Anakin Skywalker",Seltenheit.SELTEN );
        Sammelkarte senator = new Sammelkarte("Senator",Seltenheit.NORMAL );
        Sammelkarte rex = new Sammelkarte("Rex",Seltenheit.SELTEN);
        Sammelkarte obiWanKenobi = new Sammelkarte("Obi-Wan Kenobi",Seltenheit.SELTEN );
        Sammelkarte vader = new Sammelkarte("Darth Vader",Seltenheit.SELTEN );

        //Aufruf möglich wenn keine Elemente in Sammlung?
        try {
            sammlung.zufaelliges();
            Assertions.fail();
        }
        catch (IllegalArgumentException exception) {
            Assertions.assertTrue(true);
        }

        //Sammlung füllen.
        sammlung.hinzufuegen(anakinSkywalker);
        sammlung.hinzufuegen(senator);
        sammlung.hinzufuegen(rex);
        sammlung.hinzufuegen(obiWanKenobi);
        sammlung.hinzufuegen(vader);

        Sammelkarte g = sammlung.zufaelliges();
        //System.out.println(g);

        if(g != anakinSkywalker && g != senator && g != rex && g != obiWanKenobi && g != vader) {
            System.out.println(g);
            Assertions.fail();
        }
    }
}
