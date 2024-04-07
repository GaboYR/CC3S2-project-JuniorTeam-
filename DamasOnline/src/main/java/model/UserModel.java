package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    // Método para verificar si el usuario y contraseña son válidos
    public static boolean isValidUser(String username, String password) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // Método para verificar si el usuario existe en la base de datos
    public static boolean userExists(String username) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM users WHERE username=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    //Método para registrar nuevo ususario
    public static boolean registerNewUser(String username, String password, String email) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Devuelve verdadero si se registró correctamente, si es mayor a cero indica que hubo al menos una actualización
        }
    }
}
