package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleMySQLTest {
    public static void main(String[] args) {
        // DB-Zugangsdaten
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = ""; // Standard bei XAMPP ist leer

        try {
            // Verbindung herstellen
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Verbindung erfolgreich!");

            // SQL-Abfrage
            String query = "SELECT id, name, email FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Ergebnisse ausgeben
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("email"));
            }

            // Verbindung schließen
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}