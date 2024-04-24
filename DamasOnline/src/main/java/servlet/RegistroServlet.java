package servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // You can write any HTML response here if needed
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registration Result</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login", "postgres", "postgres");
            
            // Verificar si el correo electrónico ya está registrado
            PreparedStatement checkEmailStmt = con.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
            checkEmailStmt.setString(1, email);
            ResultSet rs = checkEmailStmt.executeQuery();
            if (rs.next()) {
                // El correo electrónico ya existe en la base de datos
                response.sendRedirect("registro.jsp?error=email_exist");
            } else {
                // El correo electrónico no existe, se puede registrar el usuario
                PreparedStatement insertStmt = con.prepareStatement("INSERT INTO usuarios (username, email, password) VALUES (?, ?, ?)");
                insertStmt.setString(1, username);
                insertStmt.setString(2, email);
                insertStmt.setString(3, password);
                insertStmt.executeUpdate();
                response.sendRedirect("login.jsp");
            }
            con.close(); // Cerrar la conexión cuando hayas terminado
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier excepción que ocurra
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirigir a una página de error
        }
    }
}
