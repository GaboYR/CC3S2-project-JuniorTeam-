<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkers Game - Create Account</title>
      <link rel="stylesheet" href="./css/register.css"/>
</head>
<body>

<div class="create-account-container">
    <h2>Create Account</h2>
     <%-- Verificar si hay un error de correo electrónico existente y mostrar el mensaje de error si es necesario --%>
        <% String error = request.getParameter("error");
           if ("email_exist".equals(error)) {
        %>
        <div class="error">The email is already registered. Please use another email.</div>
        <% } %>
    
    <form action="RegisterServlet" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="password" name="confirm_password" placeholder="Confirm Password" required>
        <input type="email" name="email" placeholder="Email" required>
        <button type="submit">Create Account</button>
    </form>
    <div class="login">
        Already have an account? <a href="login.jsp">Sign In</a>
    </div>
</div>

</body>
</html>