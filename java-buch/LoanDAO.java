package library;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {

    // Buch ausleihen
    public void loanBook(int bookId, int userId, int loanDays) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Transaktion starten

            // 1. Prüfen ob Buch verfügbar
            String checkSql = "SELECT available FROM books WHERE id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, bookId);
                ResultSet rs = checkStmt.executeQuery();

                if (!rs.next() || !rs.getBoolean("available")) {
                    System.out.println("❌ Buch ist nicht verfügbar!");
                    return;
                }
            }

            // 2. Buch als ausgeliehen markieren
            String updateBookSql = "UPDATE books SET available = FALSE WHERE id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateBookSql)) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
            }

            // 3. Ausleihe in loans-Tabelle eintragen
            String insertLoanSql = "INSERT INTO loans (book_id, user_id, loan_date, due_date, status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertLoanSql)) {
                LocalDate today = LocalDate.now();
                LocalDate dueDate = today.plusDays(loanDays);

                insertStmt.setInt(1, bookId);
                insertStmt.setInt(2, userId);
                insertStmt.setDate(3, Date.valueOf(today));
                insertStmt.setDate(4, Date.valueOf(dueDate));
                insertStmt.setString(5, "active");
                insertStmt.executeUpdate();
            }

            conn.commit(); // Transaktion abschließen
            System.out.println("✅ Buch erfolgreich ausgeliehen! Rückgabe bis: " + LocalDate.now().plusDays(loanDays));

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Bei Fehler zurückrollen
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    // Buch zurückgeben
    public void returnBook(int loanId) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            // 1. book_id aus loan holen
            String getBookIdSql = "SELECT book_id FROM loans WHERE id = ? AND status = 'active'";
            int bookId = -1;

            try (PreparedStatement getStmt = conn.prepareStatement(getBookIdSql)) {
                getStmt.setInt(1, loanId);
                ResultSet rs = getStmt.executeQuery();

                if (rs.next()) {
                    bookId = rs.getInt("book_id");
                } else {
                    System.out.println("❌ Ausleihe nicht gefunden oder bereits zurückgegeben!");
                    return;
                }
            }

            // 2. Loan aktualisieren
            String updateLoanSql = "UPDATE loans SET return_date = ?, status = 'returned' WHERE id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateLoanSql)) {
                updateStmt.setDate(1, Date.valueOf(LocalDate.now()));
                updateStmt.setInt(2, loanId);
                updateStmt.executeUpdate();
            }

            // 3. Buch wieder verfügbar machen
            String updateBookSql = "UPDATE books SET available = TRUE WHERE id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateBookSql)) {
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
            }

            conn.commit();
            System.out.println("✅ Buch erfolgreich zurückgegeben!");

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    // Alle aktiven Ausleihen anzeigen
    public List<Loan> getActiveLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT l.*, b.title as book_title, u.name as user_name " +
                "FROM loans l " +
                "JOIN books b ON l.book_id = b.id " +
                "JOIN users u ON l.user_id = u.id " +
                "WHERE l.status = 'active' " +
                "ORDER BY l.due_date";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Loan loan = new Loan(
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getDate("loan_date").toLocalDate(),
                        rs.getDate("due_date").toLocalDate()
                );
                loan.setId(rs.getInt("id"));
                loan.setStatus(rs.getString("status"));
                loan.setBookTitle(rs.getString("book_title"));
                loan.setUserName(rs.getString("user_name"));

                // Überfällig?
                if (loan.getDueDate().isBefore(LocalDate.now())) {
                    loan.setStatus("overdue");
                }

                loans.add(loan);
            }
        }
        return loans;
    }

    // Alle Ausleihen (inkl. zurückgegebene)
    public List<Loan> getAllLoans() throws SQLException {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT l.*, b.title as book_title, u.name as user_name " +
                "FROM loans l " +
                "JOIN books b ON l.book_id = b.id " +
                "JOIN users u ON l.user_id = u.id " +
                "ORDER BY l.loan_date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Loan loan = new Loan(
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getDate("loan_date").toLocalDate(),
                        rs.getDate("due_date").toLocalDate()
                );
                loan.setId(rs.getInt("id"));
                loan.setStatus(rs.getString("status"));
                loan.setBookTitle(rs.getString("book_title"));
                loan.setUserName(rs.getString("user_name"));

                Date returnDate = rs.getDate("return_date");
                if (returnDate != null) {
                    loan.setReturnDate(returnDate.toLocalDate());
                }

                loans.add(loan);
            }
        }
        return loans;
    }
}

