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

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validar los campos de usuario y contraseña
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            response.sendRedirect("error.jsp"); // Redirigir a página de error si los campos están vacíos
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            // Utilizar PreparedStatement para prevenir inyecciones SQL
            String query = "SELECT * FROM users WHERE username=? AND password=?";

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    // Verificar si se encontraron resultados
                    if (rs.next()) {
                        // Iniciar sesión y redirigir a la página de inicio
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        response.sendRedirect("home.jsp");
                    } else {
                        // Usuario no encontrado, redirigir a página de error
                        response.sendRedirect("error.jsp");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar excepciones de base de datos
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirigir a página de error en caso de excepción
        }
    }
}

