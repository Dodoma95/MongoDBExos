<%--
    Document : PaysSelectAll.jsp
    Author : Dodoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/WebApplicationMongoDB/css/main.css" />
        <title>PaysSelectAll.jsp</title>
    </head>

    <body>

        <header>
            <%@include file="Header.jsp" %>
        </header>

        <nav>
            <%@include file="Nav.jsp" %>
        </nav>

        <article id="pays">
            <h1>Les pays</h1>
            <br>

            <table border="1">
                <thead>
                    <tr>
                        <th>ID pays</th>
                        <th>Nom du pays</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pays" items="${listePays}">
                        <tr>
                            <td>${pays.idPays}</td><td>${pays.nomPays}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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