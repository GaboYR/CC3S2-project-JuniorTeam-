package controller;

import   model.DBConnection;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try (Connection con = DBConnection.getConnection()) {
        // Verificar si el correo electrónico ya está registrado
        PreparedStatement checkEmailStmt = con.prepareStatement("SELECT * FROM users WHERE email = ?");
        checkEmailStmt.setString(1, email);
        ResultSet emailResultSet = checkEmailStmt.executeQuery();

        if (emailResultSet.next()) {
            // El correo electrónico ya existe en la base de datos
            response.sendRedirect("registro.jsp?error=email_exist");
        } else {
            // Verificar si el username ya está registrado
            PreparedStatement checkUsernameStmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            checkUsernameStmt.setString(1, username);
            ResultSet usernameResultSet = checkUsernameStmt.executeQuery();

            if (usernameResultSet.next()) {
                // El nombre de usuario ya existe en la base de datos
                response.sendRedirect("registro.jsp?error=username_exist");
            } else {
                // El nombre de usuario no existe, se puede registrar el usuario
                PreparedStatement insertStmt = con.prepareStatement("INSERT INTO users (username, email, password) "
                        + "VALUES (?, ?, ?)");
                insertStmt.setString(1, username);
                insertStmt.setString(2, email);
                insertStmt.setString(3, password);
                insertStmt.executeUpdate();
                response.sendRedirect("login.jsp");
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        // Manejar cualquier excepción que ocurra
        e.printStackTrace();
        response.sendRedirect("error.jsp"); // Redirigir a una página de error
    }
}

}
