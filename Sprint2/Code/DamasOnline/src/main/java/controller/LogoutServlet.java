
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Removiendo el atributo del username (atributo colocado en el LoginServlet)
        HttpSession session = request.getSession();
        session.removeAttribute("username"); //Username sera null luego removerlo 
        
        
        // Redirigir al usuario a la página de inicio de sesión
        response.sendRedirect("login.jsp");
    }
  
}
