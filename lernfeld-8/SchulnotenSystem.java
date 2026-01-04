// Basisklasse Person
class Person {
    protected String name;
    
    // Konstruktor
    public Person(String name) {
        this.name = name;
    }
    
    // Getter-Methode für den Namen
    public String getName() {
        return name;
    }
}

// Klasse Schueler erbt von Person
class Schueler extends Person {
    private int note;
    
    // Konstruktor mit name und note
    public Schueler(String name, int note) {
        super(name); // Aufruf des Parent-Konstruktors
        this.note = note;
    }
    
    // Getter-Methode für die Note
    public int getNote() {
        return note;
    }
}

// Klasse NotenRechner mit statischer Bewertungsmethode
class NotenRechner {
    
    // Statische Methode zur Bewertung der Note
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

// Hauptklasse mit main-Methode zum Testen
public class SchulnotenSystem {
    public static void main(String[] args) {
        // Beispiel-Schüler erstellen
        Schueler schueler1 = new Schueler("Max Mustermann", 2);
        Schueler schueler2 = new Schueler("Anna Schmidt", 1);
        Schueler schueler3 = new Schueler("Tom Weber", 4);
        
        // Schüler und ihre Bewertungen ausgeben
        System.out.println("=== Schulnoten-Bewertungssystem ===");
        System.out.println();
        
        bewerteSschueler(schueler1);
        bewerteSschueler(schueler2);
        bewerteSschueler(schueler3);
        
        // Test mit ungültiger Note
        System.out.println("Test mit ungültiger Note (7): " + 
                          NotenRechner.bewerteNote(7));
    }
    
    // Hilfsmethode zur Ausgabe der Schülerbewertung
    private static void bewerteSschueler(Schueler schueler) {
        System.out.println("Schüler: " + schueler.getName());
        System.out.println("Note: " + schueler.getNote());
        System.out.println("Bewertung: " + NotenRechner.bewerteNote(schueler.getNote()));
        System.out.println();
    }
}