import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import model.UserModel;

class RegisterServletTest {

//    @BeforeEach
//    void setUp() throws SQLException, ClassNotFoundException {
//       //AQui debe haber un metodo de reseteo de la base de datos ya que en el primer test se crea newuser
//    }

    // 1.1 Creación exitosa de una cuenta con un username válido
    @Test
    void testSuccessfulAccountCreation() throws SQLException, ClassNotFoundException {
        String username = "newuser";
        String password = "password";
        String email = "test@example.com";

        assertFalse(UserModel.userExists(username), "User should not exist");

        boolean result = UserModel.registerNewUser(username, password, email);
        assertTrue(result, "Account should be created successfully");

        assertTrue(UserModel.isValidUser(username, password), "Newly created user should be valid");
    }

    // 1.2 Creación de una cuenta fallida con un username existente
    @Test
    void testAccountCreationWithExistingUsername() throws SQLException, ClassNotFoundException {
//        String username = "existinguser";
//        String password = "password";
//        String confirmPassword = "password";
//        String email = "test@example.com";
//
//        // Asumimos que previamente creamos un usuario con este username
//        UserModel.registerNewUser(username, password, email);
//        
//        assertTrue(UserModel.userExists(username), "User should exist");

//        boolean result = UserModel.registerNewUser(username, password, email);
//        assertFalse(result, "Account should not be created with an existing username");
    }

    // 1.3 Creacion de una cuenta fallida debido a una incorrecta confirmacion de contraseña
    @Test
    void testAccountCreationWithMismatchedPasswords() throws SQLException, ClassNotFoundException {
//        String username = "newuser";
//        String password = "password";
//        String confirmPassword = "differentpassword";
//        String email = "test@example.com";
//
//        assertFalse(UserModel.userExists(username), "User should not exist");
//
//        // Se simula un intento fallido de registro por contraseñas no coincidentes
//        if (!password.equals(confirmPassword)) {
//            assertThrows(IllegalArgumentException.class,
//                () -> UserModel.registerNewUser(username, password, email),
//                "Exception should be thrown for mismatched passwords");
//        } else {
//            fail("Passwords should not match");
//        }
    }
}

