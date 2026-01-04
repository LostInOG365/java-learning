package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // CREATE - Benutzer hinzufügen
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, phone, address) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getAddress());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                // ID des neu eingefügten Users holen
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
                System.out.println("✅ Benutzer hinzugefügt: " + user.getName());
            }
        }
    }

    // READ - Alle Benutzer
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY name";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                user.setId(rs.getInt("id"));
                users.add(user);
            }
        }
        return users;
    }

    // READ - Benutzer nach ID
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                user.setId(rs.getInt("id"));
                return user;
            }
        }
        return null;
    }

    // DELETE - Benutzer löschen
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("✅ " + rows + " Benutzer gelöscht");
        }
    }
}
