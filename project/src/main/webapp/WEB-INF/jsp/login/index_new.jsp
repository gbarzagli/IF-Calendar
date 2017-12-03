<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="<c:url value=" /css/bootstrap.min.css "/>">
            <link rel="stylesheet" href="../styles/main.css">
            <script src="../js/jquery-3.2.1.min.js"></script>
            <script src="../js/bootstrap.min.js"></script>
            <title>IFCalendar - Login</title>
        </head>

        <body class="login-body">
            <div class="login-page-bg">
                <div class="container">
                    <div class="row">
                        <div class="login-container col-md-push-4 col-md-4 col-sm-push-4 col-sm-4 col-lg-push-4 col-lg-4">
                            <h3>Faça seu login!</h3>
                            <label for="username">Usuário</label>
                            <input type="email" placeholder="example@example.com" id="username" />
                            <label for="password">Senha</label>
                            <input type="password" id="password" />
                            <button class="button-primary">LOGIN</button>
                            <button class="button-primary" name="signup" value="signup">SIGNUP</button>
                        </div>
                    </div>
                </div>
            </div>

            <script src="<c:url value=" /js/jquery-3.2.1.min.js "/>"></script>
            <script src="<c:url value=" /js/bootstrap.min.js "/>"></script>
        </body>

        </html>