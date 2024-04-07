package controller;


import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        try {
            if (!password.equals(confirmPassword)) {
                // Las contraseñas no coinciden
                response.sendRedirect("error.jsp?error=password_mismatch");
                return;
            }

            if (UserModel.userExists(username)) {
                // El nombre de usuario ya está en uso
                response.sendRedirect("error.jsp?error=username_exist");
                return;
            }

            // Intentar registrar el nuevo usuario
            if (UserModel.registerNewUser(username, password, email)) {
                // Registro exitoso, redirigir a la página de inicio de sesión
                response.sendRedirect("login.jsp");
            } else {
                // Hubo un problema al registrar el usuario
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Manejar cualquier excepción que ocurra
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirigir a una página de error
        }
    }

}
