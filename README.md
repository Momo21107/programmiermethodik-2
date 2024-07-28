# Vorgabeframework Programmiermethodik 2

## Projekt einrichten

Projekt (als Gradle-Projekt) in IntelliJ öffnen. Konfiguration und Auflösen der Abhängigkeiten (insbesondere JavaFX und JUnit) sollte automatisch durchgeführt werden

## JavaFX-Anwendung starten

* Startklasse (mit *main()*-Methode) in der Gradle-Konfigurationsdatei *build.gradle* als *mainClassName* setzen. Beispiel:
    
        mainClassName = 'praktikum.aufgabe4.HerrDerRingeGUI'

* Gradle-Menü öffnen (in der IDE rechts mit Elefanten-Symbol)
* dort: *Tasks - application - run* ausführen
