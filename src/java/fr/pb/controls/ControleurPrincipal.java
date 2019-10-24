/*
 * ControleurPrincipal.java
 */
package fr.pb.controls;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import fr.pb.entities.DBMongoDB;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pascal
 */
@WebServlet(name = "ControleurPrincipal", urlPatterns = {"/ControleurPrincipal"})
public class ControleurPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lsURL;
        String lsMessage = "Jusque là tout va bien !!!";
        try {
            MongoClient mc = DBMongoDB.getServerConnection("127.0.0.1", 27017);
//            MongoClient mc = null;
            MongoDatabase mdb = DBMongoDB.getDB(mc, "cours");
            // Récupération de la session courante
            HttpSession session = request.getSession();
            // Création d'une variable de session
            session.setAttribute("mongoDatabase", mdb);
            // Récupération d'un objet Application
//            ServletContext app = this.getServletContext();
            // Création d'une variable de niveau Application
//            app.setAttribute("mongoDatabase", mdb);

            lsURL = "Accueil.jsp";
        } catch (Exception e) {
            lsURL = "Erreur.jsp";
            lsMessage = e.getMessage() + "<br>Erreur générale ! Contactez vos administrateurs ... Stéphane et Jean-Marc";
        }

        request.setAttribute("message", lsMessage);
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);
    } /// doGet

} /// class
