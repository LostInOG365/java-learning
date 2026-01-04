import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class GuiGrundlagen {
   
    // ========================================
    // KOMPONENTEN ALS KLASSENVARIABLEN
    // ========================================
    // So können wir von allen Methoden darauf zugreifen
   
    private JFrame fenster;           // Das Hauptfenster
    private JLabel textLabel;         // Text anzeigen
    private JTextField eingabefeld;   // Text eingeben
    private JButton knopf1, knopf2;   // Buttons zum Klicken
    private JTextArea textbereich;    // Großer Textbereich
    private JCheckBox checkbox;       // Ankreuzfeld
    private JComboBox<String> dropdown; // Auswahlmenü
   
   
    // ========================================
    // KONSTRUKTOR - GUI WIRD AUFGEBAUT
    // ========================================
   
    public GuiGrundlagen() {
        guiErstellen();
    }
   
   
    // ========================================
    // GUI KOMPONENTEN ERSTELLEN UND ANORDNEN
    // ========================================
   
    private void guiErstellen() {
       
        // 1. HAUPTFENSTER ERSTELLEN
        fenster = new JFrame("Meine erste GUI - Grundlagen");
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X schließt Programm
        fenster.setSize(500, 400);                              // Größe festlegen
        fenster.setLocationRelativeTo(null);                    // Fenster zentrieren
       
       
        // 2. LAYOUT MANAGER SETZEN
        // BorderLayout teilt Fenster in 5 Bereiche: NORTH, SOUTH, EAST, WEST, CENTER
        fenster.setLayout(new BorderLayout());
       
       
        // 3. KOMPONENTEN ERSTELLEN
        textLabel = new JLabel("Willkommen zur GUI-Demo!");
        textLabel.setHorizontalAlignment(JLabel.CENTER); // Text zentrieren
        textLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Schriftart ändern
       
        eingabefeld = new JTextField("Hier Text eingeben...", 20);
       
        knopf1 = new JButton("Text übernehmen");
        knopf2 = new JButton("Alles löschen");
       
        textbereich = new JTextArea(8, 30);
        textbereich.setEditable(false); // Nur lesen, nicht editieren
        textbereich.setText("Hier erscheinen Nachrichten...\n");
       
        checkbox = new JCheckBox("Großbuchstaben verwenden");
       
        // Dropdown-Menü mit Optionen
        String[] optionen = {"Rot", "Grün", "Blau", "Gelb"};
        dropdown = new JComboBox<>(optionen);
       
       
        // 4. PANELS FÜR BESSERE ANORDNUNG
       
        // Top Panel für Überschrift
        JPanel topPanel = new JPanel();
        topPanel.add(textLabel);
       
        // Input Panel für Eingabe-Elemente
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout()); // Elemente nebeneinander
        inputPanel.add(new JLabel("Eingabe:"));
        inputPanel.add(eingabefeld);
        inputPanel.add(knopf1);
       
        // Options Panel für Optionen
        JPanel optionsPanel = new JPanel();
        optionsPanel.add(checkbox);
        optionsPanel.add(new JLabel("Farbe:"));
        optionsPanel.add(dropdown);
        optionsPanel.add(knopf2);
       
        // Center Panel für Textbereich mit Scrollbalken
        JScrollPane scrollPane = new JScrollPane(textbereich);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Ausgabe"));
       
       
        // 5. PANELS ZUM HAUPTFENSTER HINZUFÜGEN
        fenster.add(topPanel, BorderLayout.NORTH);      // Oben
        fenster.add(inputPanel, BorderLayout.CENTER);   // Mitte
        fenster.add(optionsPanel, BorderLayout.SOUTH);  // Unten
        fenster.add(scrollPane, BorderLayout.EAST);     // Rechts
       
       
        // 6. EVENT LISTENERS HINZUFÜGEN (was passiert beim Klicken?)
        knopf1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textUebernehmen(); // Methode wird aufgerufen
            }
        });
       
        // Moderne Alternative mit Lambda-Ausdruck (Java 8+)
        knopf2.addActionListener(e -> allesLoeschen());
       
        // Checkbox-Listener
        checkbox.addActionListener(e -> {
            if (checkbox.isSelected()) {
                nachrichtHinzufuegen("✓ Großbuchstaben aktiviert\n");
            } else {
                nachrichtHinzufuegen("✗ Großbuchstaben deaktiviert\n");
            }
        });
       
        // Dropdown-Listener
        dropdown.addActionListener(e -> {
            String gewaehlteFarbe = (String) dropdown.getSelectedItem();
            nachrichtHinzufuegen("Farbe gewählt: " + gewaehlteFarbe + "\n");
            farbeAendern(gewaehlteFarbe);
        });
       
       
        // 7. FENSTER ANZEIGEN
        fenster.setVisible(true);
       
        // Begrüßungsnachricht
        nachrichtHinzufuegen("=== GUI Demo gestartet! ===\n");
        nachrichtHinzufuegen("Probieren Sie die verschiedenen Elemente aus.\n\n");
    }
   
   
    // ========================================
    // EVENT-HANDLING METHODEN
    // ========================================
   
    // Was passiert beim Klick auf "Text übernehmen"
    private void textUebernehmen() {
        String eingabe = eingabefeld.getText();
       
        if (eingabe.trim().isEmpty()) {
            JOptionPane.showMessageDialog(fenster,
                "Bitte geben Sie einen Text ein!",
                "Warnung",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
       
        // Großbuchstaben verwenden?
        if (checkbox.isSelected()) {
            eingabe = eingabe.toUpperCase();
        }
       
        nachrichtHinzufuegen("Eingabe: " + eingabe + "\n");
        eingabefeld.setText(""); // Eingabefeld leeren
    }
   
   
    // Was passiert beim Klick auf "Alles löschen"
    private void allesLoeschen() {
        int antwort = JOptionPane.showConfirmDialog(fenster,
            "Wirklich alles löschen?",
            "Bestätigung",
            JOptionPane.YES_NO_OPTION);
       
        if (antwort == JOptionPane.YES_OPTION) {
            textbereich.setText("=== Alles gelöscht ===\n");
            eingabefeld.setText("");
            checkbox.setSelected(false);
            dropdown.setSelectedIndex(0);
        }
    }
   
   
    // Hilfsmethode: Nachricht zum Textbereich hinzufügen
    private void nachrichtHinzufuegen(String nachricht) {
        textbereich.append(nachricht);
        textbereich.setCaretPosition(textbereich.getDocument().getLength()); // Scroll nach unten
    }
   
   
    // Hintergrundfarbe ändern basierend auf Dropdown-Auswahl
    private void farbeAendern(String farbe) {
        Color neuerHintergrund;
       
        switch (farbe) {
            case "Rot":
                neuerHintergrund = new Color(255, 200, 200);
                break;
            case "Grün":
                neuerHintergrund = new Color(200, 255, 200);
                break;
            case "Blau":
                neuerHintergrund = new Color(200, 200, 255);
                break;
            case "Gelb":
                neuerHintergrund = new Color(255, 255, 200);
                break;
            default:
                neuerHintergrund = Color.WHITE;
        }
       
        fenster.getContentPane().setBackground(neuerHintergrund);
    }
   
   
    // ========================================
    // MAIN-METHODE - PROGRAMM STARTEN
    // ========================================
   
    public static void main(String[] args) {
       
        // GUI im Event Dispatch Thread erstellen (wichtig für Thread-Sicherheit)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiGrundlagen(); // GUI starten
            }
        });
       
       
        // ========================================
        // ERKLÄRUNG DER WICHTIGSTEN GUI-KOMPONENTEN:
        // ========================================
       
        System.out.println("=== GUI-KOMPONENTEN ERKLÄRT ===");
        System.out.println("• JFrame:      Hauptfenster");
        System.out.println("• JLabel:      Text anzeigen (nicht editierbar)");
        System.out.println("• JTextField:  Einzeilige Texteingabe");
        System.out.println("• JTextArea:   Mehrzeilige Texteingabe/-ausgabe");
        System.out.println("• JButton:     Anklickbare Schaltfläche");
        System.out.println("• JCheckBox:   Ankreuzfeld (ja/nein)");
        System.out.println("• JComboBox:   Dropdown-Auswahlmenü");
        System.out.println("• JPanel:      Container für andere Komponenten");
        System.out.println("• JScrollPane: Scrollbalken für große Inhalte");
        System.out.println();
        System.out.println("=== LAYOUT MANAGER ===");
        System.out.println("• BorderLayout: 5 Bereiche (North, South, East, West, Center)");
        System.out.println("• FlowLayout:   Komponenten nebeneinander");
        System.out.println("• GridLayout:   Rasteranordnung");
        System.out.println();
        System.out.println("GUI-Fenster sollte jetzt geöffnet sein!");
    }
}