public class Angebot {
    // Objektvariablen (Attribute/Eigenschaften eines Angebots)
    private String lieferant;
    private double warenwert;
    private double rabattProzent;
    private double versandkosten;
    private double skontoProzent;

    // Konstruktor - erstellt ein neues Angebot-Objekt
    public Angebot(String lieferant, double warenwert, double rabattProzent,
                   double versandkosten, double skontoProzent) {
        this.lieferant = lieferant;
        this.warenwert = warenwert;
        this.rabattProzent = rabattProzent;
        this.versandkosten = versandkosten;
        this.skontoProzent = skontoProzent;
    }

    // Methoden - Berechnungen
    public double getRabattBetrag() {
        return warenwert * (rabattProzent / 100.0);
    }

    public double getZwischensummeNetto() {
        return warenwert - getRabattBetrag() + versandkosten;
    }

    public double getUstBetrag() {
        return getZwischensummeNetto() * 0.19;
    }

    public double getEndpreisBrutto() {
        return getZwischensummeNetto() + getUstBetrag();
    }

    public double getSkontoBetrag() {
        return getEndpreisBrutto() * (skontoProzent / 100.0);
    }

    public double getZahlungsbetragMitSkonto() {
        return getEndpreisBrutto() - getSkontoBetrag();
    }

    // Getter für Ausgabe
    public String getLieferant() { return lieferant; }
    public double getWarenwert() { return warenwert; }
    public double getRabattProzent() { return rabattProzent; }
    public double getVersandkosten() { return versandkosten; }
    public double getSkontoProzent() { return skontoProzent; }
}
