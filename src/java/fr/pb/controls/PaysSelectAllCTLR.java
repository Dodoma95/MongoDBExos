package fr.pb.controls;

import com.mongodb.client.MongoDatabase;
import fr.pb.entities.Pays;
import fr.pb.entities.PaysDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "PaysSelectAllCTLR", urlPatterns = {"/PaysSelectAllCTLR"})
public class PaysSelectAllCTLR extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        List<Pays> list;
        HttpSession session = request.getSession();
        MongoDatabase mongoDatabase = (MongoDatabase) session.getAttribute("mongoDatabase");

//        ServletContext app = this.getServletContext();
// Récupération du contenu d'une variable d niveau Application
//        MongoDatabase mongoDatabase = (MongoDatabase) app.getAttribute("mongoDatabase");
        PaysDAO dao = new PaysDAO(mongoDatabase);
        list = dao.findAll();

        request.setAttribute("listePays", list);
        String lsURL = "PaysSelectAll.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);

    } /// doGet

} /// class
