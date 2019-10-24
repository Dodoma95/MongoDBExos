package fr.pb.controls;

import com.mongodb.client.MongoDatabase;
import fr.pb.entities.Pays;
import fr.pb.entities.PaysDAO;
import java.io.IOException;
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
@WebServlet(name = "PaysInsertValidationCTRL", urlPatterns = {"/PaysInsertValidationCTRL"})
public class PaysInsertValidationCTRL extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String lsMessage;
        // Récupération des données saisies par l'utilisateur dans le formulaire
        String lsIdPays = request.getParameter("id_pays");
        String lsNomPays = request.getParameter("nom_pays");

        HttpSession session = request.getSession();
        MongoDatabase mongoDatabase = (MongoDatabase) session.getAttribute("mongoDatabase");
        PaysDAO dao = new PaysDAO(mongoDatabase);
        Pays pays = new Pays(lsIdPays, lsNomPays);
        int liAffected = dao.insertOne(pays);
        lsMessage = Integer.toString(liAffected) + " document ajouté";

        request.setAttribute("message", lsMessage);
        String lsURL = "PaysInsert.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);

    } /// doPost

} /// class
