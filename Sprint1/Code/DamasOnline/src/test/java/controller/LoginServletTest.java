package controller;

import static org.mockito.Mockito.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.LoginServlet;

public class LoginServletTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(request.getParameter("username")).thenReturn("testuser");
        when(request.getParameter("password")).thenReturn("testpassword");
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testSuccessfulLogin() throws Exception {
        LoginServlet servlet = new LoginServlet();

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        // Verificar que no se redirige a una página de error
        verify(response, never()).sendRedirect("error.jsp");
        // Verificar que se redirige a la página de inicio
        verify(response).sendRedirect("home.jsp");

        // Verificar que se establece el atributo "username" en la sesión
        verify(session).setAttribute("username", "testuser");
    }

    @Test
    public void testFailedLogin() throws Exception {
        // Modificamos el request para simular un usuario inválido
        when(request.getParameter("username")).thenReturn("invaliduser");
        when(request.getParameter("password")).thenReturn("invalidpassword");

        LoginServlet servlet = new LoginServlet();

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        // Verificar que no se redirige a la página de inicio
        verify(response, never()).sendRedirect("home.jsp");
        // Verificar que se redirige a la página de error de credenciales inválidas
        verify(response).sendRedirect("error.jsp?error=invalid");
    }

    @Test
    public void testLockedUser() throws Exception {
        // Simulamos un usuario que ha excedido el número máximo de intentos fallidos
        Map<String, Integer> failedLoginAttempts = new HashMap<>();
        failedLoginAttempts.put("lockeduser", 4);

        // Modificamos el request para simular este usuario
        when(request.getParameter("username")).thenReturn("lockeduser");
        when(request.getParameter("password")).thenReturn("invalidpassword");

        // Seteamos el mapa de intentos fallidos en la clase LoginServlet para simular el estado del usuario
        LoginServlet.setFailedLoginAttempts(failedLoginAttempts);

        LoginServlet servlet = new LoginServlet();

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        // Verificar que no se redirige a la página de inicio
        verify(response, never()).sendRedirect("home.jsp");
        // Verificar que se redirige a la página de error de usuario bloqueado
        verify(response).sendRedirect("error.jsp?error=locked");
    }
}
