// Basisklasse Fahrzeug
class Fahrzeug {
    protected String hersteller;
    protected int baujahr;
    
    // Konstruktor
    public Fahrzeug(String hersteller, int baujahr) {
        this.hersteller = hersteller;
        this.baujahr = baujahr;
    }
    
    // Methode anzeigen() - gibt Hersteller und Baujahr aus
    public void anzeigen() {
        System.out.println("Hersteller: " + hersteller);
        System.out.println("Baujahr: " + baujahr);
    }
}

// Unterklasse Auto
class Auto extends Fahrzeug {
    private int anzahlTueren;
    
    // Konstruktor
    public Auto(String hersteller, int baujahr, int anzahlTueren) {
        super(hersteller, baujahr);
        this.anzahlTueren = anzahlTueren;
    }
    
    // Getter für anzahlTueren
    public int getAnzahlTueren() {
        return anzahlTueren;
    }
    
    // Setter für anzahlTueren
    public void setAnzahlTueren(int anzahlTueren) {
        this.anzahlTueren = anzahlTueren;
    }
}

// Unterklasse Motorrad
class Motorrad extends Fahrzeug {
    private boolean hatBeiwagen;
    
    // Konstruktor
    public Motorrad(String hersteller, int baujahr, boolean hatBeiwagen) {
        super(hersteller, baujahr);
        this.hatBeiwagen = hatBeiwagen;
    }
    
    // Getter für hatBeiwagen
    public boolean getHatBeiwagen() {
        return hatBeiwagen;
    }
    
    // Setter für hatBeiwagen
    public void setHatBeiwagen(boolean hatBeiwagen) {
        this.hatBeiwagen = hatBeiwagen;
    }
}

// Hauptklasse mit main-Methode
public class Main {
    public static void main(String[] args) {
        // Erstelle ein Auto-Objekt
        Auto meinAuto = new Auto("BMW", 2020, 4);
        
        // Erstelle ein Motorrad-Objekt
        Motorrad meinMotorrad = new Motorrad("Harley-Davidson", 2019, true);
        
        // Anzeige für Auto
        System.out.println("=== AUTO ===");
        meinAuto.anzeigen();
        System.out.println("Anzahl Türen: " + meinAuto.getAnzahlTueren());
        
        System.out.println(); // Leerzeile
        
        // Anzeige für Motorrad
        System.out.println("=== MOTORRAD ===");
        meinMotorrad.anzeigen();
        System.out.println("Hat Beiwagen: " + (meinMotorrad.getHatBeiwagen() ? "Ja" : "Nein"));
    }
}