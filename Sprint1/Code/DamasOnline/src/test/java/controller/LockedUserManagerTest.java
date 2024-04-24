package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import controller.LockedUserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

public class LockedUserManagerTest {

    @BeforeEach
    public void setUp() {
        // Limpiar datos antes de cada test
        LockedUserManager.clearFailedAttempts("testUser");
        LockedUserManager.unlockUser("testUser");
    }

    @Test
    public void testIsUserLocked() {
        assertFalse(LockedUserManager.isUserLocked("testUser"));
        LockedUserManager.lockUser("testUser");
        assertTrue(LockedUserManager.isUserLocked("testUser"));
    }

    @Test
    public void testIncrementFailedAttempts() {
        assertEquals(1, LockedUserManager.incrementFailedAttempts("testUser"));
        assertEquals(2, LockedUserManager.incrementFailedAttempts("testUser"));
        assertEquals(3, LockedUserManager.incrementFailedAttempts("testUser"));
    }

    @Test
    public void testClearFailedAttempts() {
        LockedUserManager.incrementFailedAttempts("testUser");
        LockedUserManager.incrementFailedAttempts("testUser");
        LockedUserManager.clearFailedAttempts("testUser");
        assertEquals(0, LockedUserManager.incrementFailedAttempts("testUser"));
    }

    @Test
    public void testUnlockUser() {
        LockedUserManager.lockUser("testUser");
        LockedUserManager.unlockUser("testUser");
        assertFalse(LockedUserManager.isUserLocked("testUser"));
    }

    @Test
    public void testLockUser() {
        LockedUserManager.lockUser("testUser");
        assertTrue(LockedUserManager.isUserLocked("testUser"));
    }
}
