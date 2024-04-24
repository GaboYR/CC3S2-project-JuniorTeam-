
import java.sql.Connection;
import java.sql.PreparedStatement;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import model.DBConnection;
import model.UserModel;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class RegisterServletTest {
    private final String username = "newuser";
    private final String password = "password";
    private final String confirmPassword = "password_2";
    private final String email = "test@example.com";

    // 1.1 Creación exitosa de una cuenta con un username válido
    @Test
    void testSuccessfulAccountCreation() throws SQLException, ClassNotFoundException {

        assertFalse(UserModel.userExists(username), "User should not exist");

        boolean result = UserModel.registerNewUser(username, password, email);

        assertTrue(result, "Account should be created successfully");
    }

    // 1.2 Creación de una cuenta fallida con un username existente
    @Test
    void testAccountCreationWithExistingUsername() throws SQLException, ClassNotFoundException {
        assertTrue(UserModel.userExists(username), "User already exist");
    }

    // 1.3 Creacion de una cuenta fallida debido a una incorrecta confirmacion de contraseña
    @Test
    void testAccountCreationWithMismatchedPasswords() throws SQLException, ClassNotFoundException {
        assertFalse(UserModel.areSamePassword(password, confirmPassword), "Passwords do not match");
    }

    @AfterAll
    void cleanUp() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM users WHERE username = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.executeUpdate();

        }
    }
}

