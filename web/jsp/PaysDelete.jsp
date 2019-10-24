<%--
    Document : PaysDelete.jsp
    Author : Dodoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/WebApplicationMongoDB/css/main.css" />
        <title>PaysDelete.jsp</title>
    </head>

    <body>

        <header>
            <%@include file="Header.jsp" %>
        </header>

        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article id="articleSuppressionPays">
            <h1>Suppression d'un pays</h1>
            <form action="/WebApplicationMongoDB/PaysDeleteCTRL" method="POST">
                <p><label>Quel pays ? </label></p>
                <select name="paysList" size="5">
                    <c:forEach var="pays" items="${listePays}">
                        <option value="${pays.idPays}">${pays.nomPays}</option>
                    </c:forEach>
                </select>
                <br><br>
                <input type="submit" value="Supprimer" />
                <input type="hidden" name="action" value="deleteValidation" />
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