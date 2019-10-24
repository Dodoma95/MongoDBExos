<%--
    Document : Erreur.jsp
    Author : Dodoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/WebApplicationMongoDB/css/main.css" />
        <title>Erreur.jsp</title>
    </head>

    <body>

        <header>
            <%@include file="Header.jsp" %>
        </header>

        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article id="articleErreur">
            <h1>Erreur</h1>
            <br>
            <label class="messageOrange">
                ${message}
            </label>
        </article>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>

    </body>

</html>