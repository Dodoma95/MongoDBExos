<%--
    Document : Authentification.jsp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/WebApplicationMongoDB/css/main.css" />
        <title>Authentification</title>
    </head>
    <body>
        <header>
            <%@include file="Header.jsp" %>
        </header>
        <nav>
            <%@include file="Nav.jsp" %>
        </nav>
        <article>

            <h1>Se Connecter</h1>
            <br>

            <form action="/ServletsJSPJSTLCoursSeptembre2019/AuthentificationValidation" method="POST">
                <label class="etiquette">Pseudo : </label>
                <input type="text" name="pseudo" value="Casta" />
                <br>
                <label class="etiquette">Mot de passe : </label>
                <input type="password" name="mdp" value="mdp123" /> 
                <br>
                <label class="etiquette">&nbsp;</label>
                <button type="submit" id="btSubmit">
                    <img src="/ServletsJSPJSTLCoursSeptembre2019/icones/connect_gris.jpg" alt="Valider" title="Valider" width="48"/>
                </button>
            </form>

            <br>
            <label>
                ${message}
            </label>

        </article>
        <footer>
            <%@include file="Footer.jsp" %>
        </footer>
    </body>
</html>