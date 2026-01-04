import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taschenrechner {
    // GUI-Komponenten als Klassenattribute
    private JFrame frame;
    private JTextField eingabe1;
    private JTextField eingabe2;
    private JTextField ergebnis;
    
    public Taschenrechner() {
        erstelleGUI();
    }
    
    private void erstelleGUI() {
        // 1) Hauptfenster erstellen
        frame = new JFrame("Taschenrechner");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Mittig positionieren
        frame.setLayout(new BorderLayout());
        
        // 2) Eingabefelder erstellen
        eingabe1 = new JTextField(10);
        eingabe2 = new JTextField(10);
        ergebnis = new JTextField(10);
        ergebnis.setEditable(false);
        ergebnis.setBackground(Color.LIGHT_GRAY);
        
        // 3) Buttons erstellen
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("\u00D7"); // Unicode für ×
        JButton divButton = new JButton("\u00F7"); // Unicode für ÷
        JButton clearButton = new JButton("Löschen");
        
        // Button-Größe festlegen
        Dimension buttonSize = new Dimension(80, 40);
        addButton.setPreferredSize(buttonSize);
        subButton.setPreferredSize(buttonSize);
        mulButton.setPreferredSize(buttonSize);
        divButton.setPreferredSize(buttonSize);
        clearButton.setPreferredSize(new Dimension(120, 40));
        
        // 4) Panels anlegen und anordnen
        
        // Panel für Eingaben (NORTH)
        JPanel eingabePanel = new JPanel(new FlowLayout());
        eingabePanel.add(new JLabel("Erste Zahl:"));
        eingabePanel.add(eingabe1);
        eingabePanel.add(new JLabel("Zweite Zahl:"));
        eingabePanel.add(eingabe2);
        
        // Panel für Buttons (CENTER)
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(clearButton);
        
        // Panel für Ergebnis (SOUTH)
        JPanel ergebnisPanel = new JPanel(new FlowLayout());
        ergebnisPanel.add(new JLabel("Ergebnis:"));
        ergebnisPanel.add(ergebnis);
        
        // Panels zum Hauptfenster hinzufügen
        frame.add(eingabePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(ergebnisPanel, BorderLayout.SOUTH);
        
        // 5) Event-Listener hinzufügen
        addButton.addActionListener(e -> rechnen("+"));
        subButton.addActionListener(e -> rechnen("-"));
        mulButton.addActionListener(e -> rechnen("*"));
        divButton.addActionListener(e -> rechnen("/"));
        clearButton.addActionListener(e -> loeschen());
        
        // Fokus auf erstes Eingabefeld setzen
        SwingUtilities.invokeLater(() -> eingabe1.requestFocus());
    }
    
    // 6) Die Rechen-Methode
    private void rechnen(String operation) {
        try {
            // Text aus Eingabefeldern lesen
            String text1 = eingabe1.getText().trim();
            String text2 = eingabe2.getText().trim();
            
            // Prüfen, ob beide Felder gefüllt sind
            if (text1.isEmpty() || text2.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "Bitte füllen Sie beide Eingabefelder aus!", 
                    "Eingabefehler", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Text in Zahlen umwandeln
            double zahl1 = Double.parseDouble(text1);
            double zahl2 = Double.parseDouble(text2);
            double resultat = 0;
            
            // Berechnung je nach Operation
            switch (operation) {
                case "+":
                    resultat = zahl1 + zahl2;
                    break;
                case "-":
                    resultat = zahl1 - zahl2;
                    break;
                case "*":
                    resultat = zahl1 * zahl2;
                    break;
                case "/":
                    if (zahl2 == 0) {
                        JOptionPane.showMessageDialog(frame, 
                            "Division durch Null ist nicht möglich!", 
                            "Rechenfehler", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultat = zahl1 / zahl2;
                    break;
            }
            
            // Ergebnis formatiert anzeigen
            String ergebnisText;
            if (resultat == (long) resultat) {
                // Ganze Zahl ohne Nachkommastellen
                ergebnisText = String.valueOf((long) resultat);
            } else {
                // Kommazahl auf 2 Nachkommastellen
                ergebnisText = String.format("%.2f", resultat);
            }
            
            ergebnis.setText(ergebnisText);
            
            // Hintergrundfarbe für erfolgreiches Ergebnis ändern
            ergebnis.setBackground(Color.GREEN.brighter());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, 
                "Bitte geben Sie gültige Zahlen ein!", 
                "Eingabefehler", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // 7) Die Löschen-Methode
    private void loeschen() {
        eingabe1.setText("");
        eingabe2.setText("");
        ergebnis.setText("");
        ergebnis.setBackground(Color.LIGHT_GRAY); // Neutrale Farbe zurücksetzen
        eingabe1.requestFocus(); // Cursor in erstes Feld setzen
    }
    
    public void anzeigen() {
        frame.setVisible(true);
    }
    
    // 8) Programmstart
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Begrüßungsnachricht anzeigen
            JOptionPane.showMessageDialog(null, 
                "Willkommen beim Java-Taschenrechner!\n\n" +
                "Geben Sie zwei Zahlen ein und wählen Sie eine Rechenoperation.", 
                "Willkommen", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // GUI erstellen und anzeigen
            new Taschenrechner().anzeigen();
        });
    }
}