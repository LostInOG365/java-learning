public class Angebotsvergleich {
    public static void main(String[] args) {

        // Objekt 1 erstellen (Hemak AG)
        Angebot hemak = new Angebot("Hemak AG", 533.01, 10.0, 25.0, 2.0);

        // Objekt 2 erstellen (DiWin GmbH)
        Angebot diwin = new Angebot("DiWin GmbH", 595.00, 20.0, 50.0, 3.0);

        // Tabelle ausgeben
        druckeTabelle(hemak, diwin);

        // Entscheidung treffen
        entscheide(hemak, diwin);
    }

    private static void druckeTabelle(Angebot a1, Angebot a2) {
        System.out.println("\t\t\t\t\t" + a1.getLieferant() + "\t\t\t" + a2.getLieferant());
        System.out.println("\t\t\t\t\t%\t€\t\t\t%\t€");

        System.out.printf("Warenwert\t\t\t\t\t%.2f\t\t\t\t%.2f%n",
                a1.getWarenwert(), a2.getWarenwert());

        System.out.printf("Rabatt\t\t\t\t\t%.1f\t%.2f\t\t%.1f\t%.2f%n",
                a1.getRabattProzent(), a1.getRabattBetrag(),
                a2.getRabattProzent(), a2.getRabattBetrag());

        System.out.printf("Verpackung/Versand\t\t\t\t%.2f\t\t\t\t%.2f%n",
                a1.getVersandkosten(), a2.getVersandkosten());

        System.out.printf("Zwischensumme netto\t\t\t\t%.2f\t\t\t\t%.2f%n",
                a1.getZwischensummeNetto(), a2.getZwischensummeNetto());

        System.out.printf("Umsatzsteuer 19%%\t\t\t\t%.2f\t\t\t\t%.2f%n",
                a1.getUstBetrag(), a2.getUstBetrag());

        System.out.printf("Endpreis brutto\t\t\t\t\t%.2f\t\t\t\t%.2f%n",
                a1.getEndpreisBrutto(), a2.getEndpreisBrutto());

        System.out.printf("Skonto\t\t\t\t\t%.1f\t%.2f\t\t%.1f\t%.2f%n",
                a1.getSkontoProzent(), a1.getSkontoBetrag(),
                a2.getSkontoProzent(), a2.getSkontoBetrag());

        System.out.printf("Zahlungsbetrag (mit Skonto)\t\t\t%.2f\t\t\t\t%.2f%n",
                a1.getZahlungsbetragMitSkonto(), a2.getZahlungsbetragMitSkonto());
    }

    private static void entscheide(Angebot a1, Angebot a2) {
        double betrag1 = a1.getZahlungsbetragMitSkonto();
        double betrag2 = a2.getZahlungsbetragMitSkonto();

        System.out.println("\n=== ENTSCHEIDUNG ===");
        if (betrag1 < betrag2) {
            System.out.printf("Günstiger ist %s mit %.2f € (Ersparnis: %.2f €)%n",
                    a1.getLieferant(), betrag1, betrag2 - betrag1);
        } else if (betrag2 < betrag1) {
            System.out.printf("Günstiger ist %s mit %.2f € (Ersparnis: %.2f €)%n",
                    a2.getLieferant(), betrag2, betrag1 - betrag2);
        } else {
            System.out.println("Beide Angebote sind preisgleich.");
        }
    }
}
