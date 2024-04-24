
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bienvenido</title>
        <link rel="stylesheet" href="./css/home.css"/>
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
    </head>
    <body>
        <div class="container">
            <%//Aqui debe ir el menu (juego local, multiplayer y con computadora), de momento ponemos un mensaje de bienvenida%>
            
            <h1>Bienvenido</h1>
            <p>¡Hola, <%= session.getAttribute("username") %>! Has iniciado sesión correctamente.</p>
            <form action="LogoutServlet" method="post">
                <input type="submit" value="Cerrar sesión">
            </form>
        </div>

    </body>
</html>
