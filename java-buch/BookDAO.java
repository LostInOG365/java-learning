package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // CREATE - Buch hinzufügen
    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (isbn, title, author, publisher, year) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getPublisher());
            pstmt.setInt(5, book.getYear());
            pstmt.executeUpdate();

            System.out.println("✅ Buch hinzugefügt: " + book.getTitle());
        }
    }

    // READ - Alle Bücher
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year")
                );
                book.setId(rs.getInt("id"));
                book.setAvailable(rs.getBoolean("available"));
                books.add(book);
            }
        }
        return books;
    }

    // READ - Buch suchen nach Titel
    public List<Book> searchByTitle(String title) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + title + "%");  // % = Wildcard
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year")
                );
                book.setId(rs.getInt("id"));
                book.setAvailable(rs.getBoolean("available"));
                books.add(book);
            }
        }
        return books;
    }

    // UPDATE - Buch aktualisieren
    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, year = ?, available = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getYear());
            pstmt.setBoolean(5, book.isAvailable());
            pstmt.setInt(6, book.getId());

            int rows = pstmt.executeUpdate();
            System.out.println("✅ " + rows + " Buch aktualisiert");
        }
    }

    // DELETE - Buch löschen
    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("✅ " + rows + " Buch gelöscht");
        }
    }

    // Buch ausleihen
    public void loanBook(int bookId, String userName) throws SQLException {
        // 1. Prüfen ob verfügbar
        // 2. Available auf false setzen
        // 3. Eintrag in loans-Tabelle
        String sql = "UPDATE books SET available = FALSE WHERE id = ? AND available = TRUE";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, bookId);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                // Eintrag in loans-Tabelle
                String loanSql = "INSERT INTO loans (book_id, user_name, loan_date, due_date) VALUES (?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 14 DAY))";
                try (PreparedStatement loanStmt = conn.prepareStatement(loanSql)) {
                    loanStmt.setInt(1, bookId);
                    loanStmt.setString(2, userName);
                    loanStmt.executeUpdate();
                }
                System.out.println("✅ Buch ausgeliehen an: " + userName);
            } else {
                System.out.println("❌ Buch ist nicht verfügbar!");
            }
        }
    }
}