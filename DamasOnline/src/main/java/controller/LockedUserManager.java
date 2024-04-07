package controller;

import java.util.HashMap;
import java.util.Map;

public class LockedUserManager {
    private static final Map<String, Integer> failedLoginAttempts = new HashMap<>();
    private static final Map<String, Long> lockedUsers = new HashMap<>();
    private static final long LOCK_TIME = 120000; // 120 segundos en milisegundos

    public static boolean isUserLocked(String username) {
        return lockedUsers.containsKey(username) && System.currentTimeMillis() - lockedUsers.get(username) < LOCK_TIME;
    }

    public static int incrementFailedAttempts(String username) {
        int attempts = failedLoginAttempts.getOrDefault(username, 0) + 1;
        failedLoginAttempts.put(username, attempts);
        return attempts;
    }

    public static void clearFailedAttempts(String username) {
        failedLoginAttempts.remove(username);
    }
    
    public static void unlockUser(String username) {
        lockedUsers.remove(username);
    }

    public static void lockUser(String username) {
        lockedUsers.put(username, System.currentTimeMillis());
    }
}
