<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Checkers Game Login</title>
        <link rel="stylesheet" href="./css/login.css"/>
    </head>
    <body>

        <div class="login-container">
            <h2>Checkers Game Login</h2>
            <form action="LoginServlet" method="POST">
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit">Sign In</button>
            </form>
            <div class="create-account">
                Don't have an account? <a href="./register.jsp">Create one</a>
            </div>
        </div>

    </body>
</html>
