package controller;

import model.DBConnection;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private static final int MAX_FAILED_ATTEMPTS = 4;
    private static final long LOCK_TIME = 120000; // 120 segundos (esta en milisegundos)

    private static final Map<String, Integer> failedLoginAttempts = new HashMap<>();
    private static final Map<String, Long> lockedUsers = new HashMap<>();

    public static void setFailedLoginAttempts(Map<String, Integer> attempts) {
        failedLoginAttempts.clear();
        failedLoginAttempts.putAll(attempts);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificar si el usuario está bloqueado temporalmente
        if (lockedUsers.containsKey(username)) {
            long lockedTime = lockedUsers.get(username);
            if (System.currentTimeMillis() - lockedTime < LOCK_TIME) {
                response.sendRedirect("error.jsp?error=locked");
                return;
            } else {
                // Si ha pasado el tiempo de bloqueo, eliminamos al usuario de la lista de bloqueados
                lockedUsers.remove(username);
                failedLoginAttempts.remove(username);
            }
        }

        // Validar los campos de usuario y contraseña (no deben ser vacios o nulos)
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            response.sendRedirect("error.jsp?error=empty");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Iniciar sesion y redirigir a la pagina de inicio
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        
                        // Restablecer los intentos fallidos si el usuario ha iniciado sesión correctamente
                        failedLoginAttempts.remove(username);
                        response.sendRedirect("home.jsp");
                    } else {
                        // Incrementar el contador de "intentos fallidos" y verificar si ha alcanzado el limite
                        int attempts = failedLoginAttempts.getOrDefault(username, 0) + 1;
                        failedLoginAttempts.put(username, attempts);
                        
                        if (attempts >= MAX_FAILED_ATTEMPTS) {
                            lockedUsers.put(username, System.currentTimeMillis());
                            response.sendRedirect("error.jsp?error=locked");
                        } else {
                            response.sendRedirect("error.jsp?error=invalid");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
