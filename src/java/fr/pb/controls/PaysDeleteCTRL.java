package fr.pb.controls;

import com.mongodb.client.MongoDatabase;
import fr.pb.entities.Pays;
import fr.pb.entities.PaysDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "PaysDeleteCTRL", urlPatterns = {"/PaysDeleteCTRL"})
public class PaysDeleteCTRL extends HttpServlet {

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
        PaysDAO dao = new PaysDAO(mongoDatabase);
        list = dao.findAll();

        request.setAttribute("listePays", list);
        String lsURL = "PaysDelete.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);

    } /// doGet

    /**
     * Handles the HTTP <code>POST</code> method.
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
        String lsIdPays = request.getParameter("paysList");
        List<Pays> list;

        HttpSession session = request.getSession();
        MongoDatabase mongoDatabase = (MongoDatabase) session.getAttribute("mongoDatabase");
        PaysDAO dao = new PaysDAO(mongoDatabase);
        // L'idPays suffit
        Pays pays = new Pays(lsIdPays, "");
        int liAffected = dao.deleteOneByIdPays(pays);
        lsMessage = Integer.toString(liAffected) + " document supprimé";

        list = dao.findAll();

        request.setAttribute("listePays", list);
        request.setAttribute("message", lsMessage);
        String lsURL = "PaysDelete.jsp";
        getServletContext().getRequestDispatcher("/jsp/" + lsURL).forward(request, response);

    } /// doPost

} /// class
