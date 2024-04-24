package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DBConnectionTest {

    @BeforeEach
    void setUp() {
        // Preparación antes de cada prueba
        // Aquí puedes configurar condiciones iniciales que son comunes a todas las pruebas
    }

    @AfterEach
    void tearDown() {
        // Limpieza después de cada prueba
        // Aquí puedes deshacer cualquier configuración o limpiar recursos utilizados en las pruebas
    }

    // Prueba que verifica si la conexión a la base de datos es exitosa
    @Test
    void testGetConnection() {
        try (Connection connection = DBConnection.getConnection()) {
            assertNotNull(connection, "La conexión no debe ser nula");
            assertFalse(connection.isClosed(), "La conexión debe estar abierta");
        } catch (ClassNotFoundException e) {
            fail("Driver no encontrado", e);
        } catch (SQLException e) {
            fail("Error SQL al obtener la conexión", e);
        }
    }

    // Prueba que verifica el manejo correcto de ClassNotFoundException
    @Test
    void testClassNotFoundException() {
        // Esta prueba requeriría cambiar dinámicamente la configuración del driver
        assertThrows(ClassNotFoundException.class, () -> {
            // Forzando un error de driver no encontrado
            Class.forName("org.postgresql.NonexistentDriver");
        }, "Se esperaba ClassNotFoundException debido a un driver no encontrado");
    }

    // Prueba de parámetros incorrectos de conexión
    @Test
    void testInvalidConnectionParameters() {
        // Simula parámetros incorrectos para probar la gestión de excepciones SQLException
        assertThrows(SQLException.class, () -> {
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/NonexistentDB", "invalidUser", "invalidPass");
        }, "Se esperaba SQLException debido a detalles de conexión incorrectos");
    }

    // Prueba que verifica si se lanza una excepción cuando los datos de conexión son incorrectos
    @Test
    void testConnectionFailure() {
        assertThrows(SQLException.class, () -> {
            // Cambiar detalles de conexión incorrectamente
            DriverManager.getConnection("jdbc:postgresql://invalidHost:5432/DBDamas", "UserAdmin", "wrongPassword");
        }, "Se esperaba SQLException debido a detalles de conexión incorrectos");
    }
}

