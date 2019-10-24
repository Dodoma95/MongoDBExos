package fr.pb.controls;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pascal
 */
@WebServlet(name = "PaysInsertCTRL", urlPatterns = {"/PaysInsertCTRL"})
public class PaysInsertCTRL extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        //response.sendRedirect("/jsp/PaysInsert.jsp");
        response.sendRedirect("/WebApplicationMongoDB/jsp/PaysInsert.jsp");
        
    } /// doGet

} /// class
