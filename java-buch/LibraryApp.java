package library;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static BookDAO bookDAO = new BookDAO();
    private static UserDAO userDAO = new UserDAO();
    private static LoanDAO loanDAO = new LoanDAO();

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  📚 LIBRARY MANAGEMENT SYSTEM 📚     ║");
        System.out.println("║      By Ela - Portfolio Project       ║");
        System.out.println("╚═══════════════════════════════════════╝");

        while (true) {
            showMainMenu();
            int choice = getIntInput("Wahl: ");

            try {
                switch (choice) {
                    case 1 -> bookMenu();
                    case 2 -> userMenu();
                    case 3 -> loanMenu();
                    case 4 -> showStatistics();
                    case 0 -> {
                        System.out.println("\n👋 Auf Wiedersehen! Danke für die Nutzung der Bibliothek!");
                        return;
                    }
                    default -> System.out.println("❌ Ungültige Eingabe!");
                }
            } catch (Exception e) {
                System.err.println("❌ Fehler: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📖 HAUPTMENÜ");
        System.out.println("=".repeat(40));
        System.out.println("1️⃣  Bücher verwalten");
        System.out.println("2️⃣  Benutzer verwalten");
        System.out.println("3️⃣  Ausleihen verwalten");
        System.out.println("4️⃣  Statistiken");
        System.out.println("0️⃣  Beenden");
        System.out.println("=".repeat(40));
    }

    // ===== BUCH-MENÜ =====
    private static void bookMenu() throws Exception {
        while (true) {
            System.out.println("\n📚 BÜCHER-VERWALTUNG");
            System.out.println("1. Buch hinzufügen");
            System.out.println("2. Alle Bücher anzeigen");
            System.out.println("3. Buch suchen");
            System.out.println("4. Buch löschen");
            System.out.println("0. Zurück");

            int choice = getIntInput("Wahl: ");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> showAllBooks();
                case 3 -> searchBook();
                case 4 -> deleteBook();
                case 0 -> { return; }
                default -> System.out.println("❌ Ungültige Eingabe!");
            }
        }
    }

    private static void addBook() throws Exception {
        System.out.println("\n➕ NEUES BUCH HINZUFÜGEN");

        String isbn = getStringInput("ISBN: ");
        String title = getStringInput("Titel: ");
        String author = getStringInput("Autor: ");
        String publisher = getStringInput("Verlag: ");
        int year = getIntInput("Erscheinungsjahr: ");
        String category = getStringInput("Kategorie: ");

        Book book = new Book(isbn, title, author, publisher, year, category);
        bookDAO.addBook(book);
    }

    private static void showAllBooks() throws Exception {
        List<Book> books = bookDAO.getAllBooks();

        System.out.println("\n📖 ALLE BÜCHER (" + books.size() + ")");
        System.out.println("=".repeat(80));

        if (books.isEmpty()) {
            System.out.println("❌ Keine Bücher in der Datenbank!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void searchBook() throws Exception {
        System.out.println("\n🔍 BUCH SUCHEN");
        String searchTerm = getStringInput("Suchbegriff (Titel): ");

        List<Book> books = bookDAO.searchByTitle(searchTerm);

        if (books.isEmpty()) {
            System.out.println("❌ Keine Bücher gefunden!");
        } else {
            System.out.println("\n✅ " + books.size() + " Buch/Bücher gefunden:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void deleteBook() throws Exception {
        int id = getIntInput("Buch-ID zum Löschen: ");

        String confirm = getStringInput("Wirklich löschen? (j/n): ");
        if (confirm.equalsIgnoreCase("j")) {
            bookDAO.deleteBook(id);
        } else {
            System.out.println("❌ Abgebrochen!");
        }
    }

    // ===== BENUTZER-MENÜ =====
    private static void userMenu() throws Exception {
        while (true) {
            System.out.println("\n👤 BENUTZER-VERWALTUNG");
            System.out.println("1. Benutzer hinzufügen");
            System.out.println("2. Alle Benutzer anzeigen");
            System.out.println("3. Benutzer löschen");
            System.out.println("0. Zurück");

            int choice = getIntInput("Wahl: ");

            switch (choice) {
                case 1 -> addUser();
                case 2 -> showAllUsers();
                case 3 -> deleteUser();
                case 0 -> { return; }
                default -> System.out.println("❌ Ungültige Eingabe!");
            }
        }
    }

    private static void addUser() throws Exception {
        System.out.println("\n➕ NEUEN BENUTZER HINZUFÜGEN");

        String name = getStringInput("Name: ");
        String email = getStringInput("E-Mail: ");
        String phone = getStringInput("Telefon: ");
        String address = getStringInput("Adresse: ");

        User user = new User(name, email, phone, address);
        userDAO.addUser(user);
    }

    private static void showAllUsers() throws Exception {
        List<User> users = userDAO.getAllUsers();

        System.out.println("\n👥 ALLE BENUTZER (" + users.size() + ")");
        System.out.println("=".repeat(80));

        if (users.isEmpty()) {
            System.out.println("❌ Keine Benutzer in der Datenbank!");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private static void deleteUser() throws Exception {
        int id = getIntInput("Benutzer-ID zum Löschen: ");

        String confirm = getStringInput("Wirklich löschen? (j/n): ");
        if (confirm.equalsIgnoreCase("j")) {
            userDAO.deleteUser(id);
        } else {
            System.out.println("❌ Abgebrochen!");
        }
    }

    // ===== AUSLEIHE-MENÜ =====
    private static void loanMenu() throws Exception {
        while (true) {
            System.out.println("\n📋 AUSLEIHE-VERWALTUNG");
            System.out.println("1. Buch ausleihen");
            System.out.println("2. Buch zurückgeben");
            System.out.println("3. Aktive Ausleihen anzeigen");
            System.out.println("4. Alle Ausleihen anzeigen");
            System.out.println("0. Zurück");

            int choice = getIntInput("Wahl: ");

            switch (choice) {
                case 1 -> loanBook();
                case 2 -> returnBook();
                case 3 -> showActiveLoans();
                case 4 -> showAllLoans();
                case 0 -> { return; }
                default -> System.out.println("❌ Ungültige Eingabe!");
            }
        }
    }

    private static void loanBook() throws Exception {
        System.out.println("\n📤 BUCH AUSLEIHEN");

        int bookId = getIntInput("Buch-ID: ");
        int userId = getIntInput("Benutzer-ID: ");
        int days = getIntInput("Ausleihe-Dauer (Tage, Standard: 14): ");

        if (days <= 0) days = 14; // Standard: 14 Tage

        loanDAO.loanBook(bookId, userId, days);
    }

    private static void returnBook() throws Exception {
        System.out.println("\n📥 BUCH ZURÜCKGEBEN");

        // Erst aktive Ausleihen anzeigen
        showActiveLoans();

        int loanId = getIntInput("\nAusleihe-ID zum Zurückgeben: ");
        loanDAO.returnBook(loanId);
    }

    private static void showActiveLoans() throws Exception {
        List<Loan> loans = loanDAO.getActiveLoans();

        System.out.println("\n📋 AKTIVE AUSLEIHEN (" + loans.size() + ")");
        System.out.println("=".repeat(100));

        if (loans.isEmpty()) {
            System.out.println("✅ Keine aktiven Ausleihen!");
        } else {
            for (Loan loan : loans) {
                String status = loan.getStatus();
                String icon = status.equals("overdue") ? "⚠️ ÜBERFÄLLIG" : "✅ Aktiv";
                System.out.println(icon + " " + loan);
            }
        }
    }

    private static void showAllLoans() throws Exception {
        List<Loan> loans = loanDAO.getAllLoans();

        System.out.println("\n📜 ALLE AUSLEIHEN (" + loans.size() + ")");
        System.out.println("=".repeat(100));

        if (loans.isEmpty()) {
            System.out.println("❌ Keine Ausleihen in der Datenbank!");
        } else {
            for (Loan loan : loans) {
                System.out.println(loan);
            }
        }
    }

    // ===== STATISTIKEN =====
    private static void showStatistics() throws Exception {
        List<Book> books = bookDAO.getAllBooks();
        List<User> users = userDAO.getAllUsers();
        List<Loan> activeLoans = loanDAO.getActiveLoans();

        long availableBooks = books.stream().filter(Book::isAvailable).count();
        long loanedBooks = books.size() - availableBooks;
        long overdueLoans = activeLoans.stream()
                .filter(l -> l.getStatus().equals("overdue"))
                .count();

        System.out.println("\n📊 STATISTIKEN");
        System.out.println("=".repeat(40));
        System.out.println("📚 Bücher gesamt:       " + books.size());
        System.out.println("✅ Verfügbar:           " + availableBooks);
        System.out.println("📤 Ausgeliehen:         " + loanedBooks);
        System.out.println("👥 Benutzer:            " + users.size());
        System.out.println("📋 Aktive Ausleihen:    " + activeLoans.size());
        System.out.println("⚠️  Überfällig:          " + overdueLoans);
        System.out.println("=".repeat(40));
    }

    // ===== HILFSFUNKTIONEN =====
    private static int getIntInput(String ") {
            while (true) {
        try {
            System.out.print(prompt);
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Bitte eine Zahl eingeben!");
        }
    }
}

private static String getStringInput(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine().trim();
}

