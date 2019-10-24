<%--
    Document : PaysUpdate.jsp
    Author : Dodoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/WebApplicationMongoDB/css/main.css" />
        <title>PaysUpdate.jsp</title>
    </head>

    <body>

        <header>
            <%@include file="Header.jsp" %>
        </header>

        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article id="articleModificationPays">
            <h1>Modification d'un pays</h1>
            <form action="/WebApplicationMongoDB/PaysUpdateCTRL" method="GET">
                <p><label>Quel pays ? </label></p>
                <select name="paysList" size="5">
                    <c:forEach var="pays" items="${listePays}">
                        <option value="${pays.id}" <c:if test="${pays.id eq selectedCountry}">selected</c:if>>${pays.nomPays}</option>
                    </c:forEach>
                </select>
                <br><br>
                <input type="submit" value="Valider la sélection" />
                <input type="hidden" name="action" value="selectionValidation" />
            </form>
            <br><br>

            <form action="/WebApplicationMongoDB/PaysUpdateCTRL" method="POST">
                <label>ID pays : </label>
                <input type="text" name="id_pays" value="${idPays}" />
                <label>Nom du pays : </label>
                <input type="text" name="nom_pays" value="${nomPays}" />
                <br><br>
                <input type="submit" value="Valider la modification" />
                <input type="hidden" name="_id" value="${_id}" />
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