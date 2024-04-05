
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
      <link rel="stylesheet" href="./css/home.css"/>
</head>
<body>
    <div class="container">
    <h1>Bienvenido</h1>
    <p>¡Hola, <%= session.getAttribute("username") %>! Has iniciado sesión correctamente.</p>
    <form action="LogoutServlet" method="post">
        <input type="submit" value="Cerrar sesión">
    </form>
</div>

</body>
</html>
