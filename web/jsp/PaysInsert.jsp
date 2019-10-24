<%--
    Document : PaysInsert.jsp
    Author : Dodoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/WebApplicationMongoDB/css/main.css" />
        <title>PaysInsert.jsp</title>
    </head>

    <body>

        <header>
            <%@include file="Header.jsp" %>
        </header>

        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article id="articleNouveauPays">
            <h1>Nouveau pays</h1>
            <form action="/WebApplicationMongoDB/PaysInsertValidationCTRL" method="POST">
                <label>ID pays : </label>
                <input type="text" name="id_pays" value="045" />
                <label>Nom du pays : </label>
                <input type="text" name="nom_pays" value="Danemark" />
                <input type="submit" value="Ajouter" />
            </form>
            <p>
                ${message}
            </p>
        </article>

        <footer>
            <%@include file="Footer.jsp" %>
        </footer>

    </body>

</html>