<%-- 
    Document   : inicio
    Created on : 30 mar. 2024, 14:30:19
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h1 {
            color: #007bff;
        }
        p {
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bienvenido</h1>
        <p>¡Hola, <%= session.getAttribute("username") %>! Has iniciado sesión correctamente.</p>
        <!-- Aquí puedes añadir más contenido HTML para la página de inicio -->
    </div>
</body>
</html>
