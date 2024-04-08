package controller;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserModel;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private static final int MAX_FAILED_ATTEMPTS = 4;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            if (LockedUserManager.isUserLocked(username)) {
                response.sendRedirect("error.jsp?error=locked");
                return;
            }

            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                response.sendRedirect("error.jsp?error=empty");
                return;
            }

            if (UserModel.isValidUser(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                
                LockedUserManager.clearFailedAttempts(username);
                LockedUserManager.unlockUser(username);
                
                response.sendRedirect("home.jsp");
            } else {
                if (LockedUserManager.incrementFailedAttempts(username) >= MAX_FAILED_ATTEMPTS) {
                    LockedUserManager.lockUser(username);
                    
                    response.sendRedirect("error.jsp?error=locked");
                } else {
                    response.sendRedirect("error.jsp?error=invalid");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}