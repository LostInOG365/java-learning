// Basisklasse Person
class Person {
    protected String name;
    
    // Konstruktor
    public Person(String name) {
        this.name = name;
    }
    
    // Getter für name
    public String getName() {
        return name;
    }
}

// Klasse Schueler erbt von Person
class Schueler extends Person {
    private int note;
    
    // Konstruktor mit name und note
    public Schueler(String name, int note) {
        super(name);
        this.note = note;
    }
    
    // Getter für note
    public int getNote() {
        return note;
    }
}

// Klasse NotenRechner mit statischer Bewertungsmethode
class NotenRechner {
    
    // Statische Methode zur Notenbewertung
    public static String bewerteNote(int note) {
        switch (note) {
            case 1:
                return "sehr gut";
            case 2:
                return "gut";
            case 3:
                return "befriedigend";
            case 4:
                return "ausreichend";
            case 5:
                return "mangelhaft";
            case 6:
                return "ungenügend";
            default:
                return "ungültige Note";
        }
    }
}

// Hauptklasse mit main-Methode
public class Main {
    public static void main(String[] args) {
        // Erstelle Schüler-Objekte
        Schueler schueler1 = new Schueler("Max Mustermann", 2);
        Schueler schueler2 = new Schueler("Anna Schmidt", 1);
        Schueler schueler3 = new Schueler("Tom Weber", 4);
        
        // Ausgabe der Schülerdaten mit Notenbewertung
        System.out.println("=== SCHÜLER-NOTEN ===");
        
        System.out.println("Schüler: " + schueler1.getName());
        System.out.println("Note: " + schueler1.getNote() + " (" + 
                          NotenRechner.bewerteNote(schueler1.getNote()) + ")");
        System.out.println();
        
        System.out.println("Schüler: " + schueler2.getName());
        System.out.println("Note: " + schueler2.getNote() + " (" + 
                          NotenRechner.bewerteNote(schueler2.getNote()) + ")");
        System.out.println();
        
        System.out.println("Schüler: " + schueler3.getName());
        System.out.println("Note: " + schueler3.getNote() + " (" + 
                          NotenRechner.bewerteNote(schueler3.getNote()) + ")");
        System.out.println();
        
        // Test mit ungültiger Note
        System.out.println("Test mit ungültiger Note (7): " + 
                          NotenRechner.bewerteNote(7));
    }
}