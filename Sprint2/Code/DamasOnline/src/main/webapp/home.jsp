<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bienvenido</title>
        <link rel="stylesheet" href="css/board.css"/>
         <%
            response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate");
           
            if(session.getAttribute("username") == null){
                response.sendRedirect("login.jsp");
            }
        %>
    </head>
    
    <body>
        <div class="info-turno">
            <h2 class="turno-texto">Turno de:</h2>
            <div id="ficha-turno"></div>
        </div>
        <div class="tablero" id="tablero">
            <div class="fila fila-1">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>

            <div class="fila fila-2">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>

            <div class="fila fila-3">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>

            <div class="fila fila-4">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>

            <div class="fila fila-5">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>

            <div class="fila fila-6"><div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div></div>

            <div class="fila fila-7">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>

            <div class="fila fila-8">
                <div class="casillero-1 casillero"></div>
                <div class="casillero-2 casillero"></div>
                <div class="casillero-3 casillero"></div>
                <div class="casillero-4 casillero"></div>
                <div class="casillero-5 casillero"></div>
                <div class="casillero-6 casillero"></div>
                <div class="casillero-7 casillero"></div>
                <div class="casillero-8 casillero"></div>
            </div>
        </div>

        <div class="info-ganador-contenedor" id="info-ganador-contenedor">
            <h1>GANADOR!</h1>
            <h2 id="info-ganador">Fichas Oscuras</h2>
        </div>

        
        <p>¡Hola, <%= session.getAttribute("username") %>! Has iniciado sesión correctamente.</p>
            <form action="LogoutServlet" method="post">
                <input type="submit" value="Cerrar sesión">
            </form>
        
        
        
        <script src="js/Casillero.js" ></script>
        <script src="js/Ficha.js" ></script>
        <script src="js/Juego.js" ></script>
        <script src="js/index.js" ></script>
    </body>
</html>