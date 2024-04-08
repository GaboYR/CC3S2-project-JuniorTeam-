package model;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.DBConnection;

public class DBConnectionTest {

    @Test
    public void testConnection() {
        try {
            Connection connection = DBConnection.getConnection();
            assertNotNull(connection);
            assertFalse(connection.isClosed());
            connection.close();
            assertTrue(connection.isClosed());
        } catch (ClassNotFoundException | SQLException e) {
            fail("Error during database connection: " + e.getMessage());
        }
    }
}
