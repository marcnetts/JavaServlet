package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcnetts
 */
@WebServlet(name = "UpperDownCase", urlPatterns = {"/upperdowncase"})
public class UpperDownCase extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String palavra = request.getParameter("palavra");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ELE2 - 5º. ADS - mat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Fatec-RL</h1>");
            out.println("   <h2>ADS - ELE2 - 5o. matutino</h2>");
            out.println("   <h4>Upper/Lowercase JSP</h4>");
            out.println("   ");
            if(palavra != null && palavra != ""){
                out.println(String.format("   <span>Palavra original: %s</span><br>", palavra));
                out.println(String.format("   <span>Palavra original: %s</span><br>", retornarMaiusculo(palavra)));
                out.println(String.format("   <span>Palavra original: %s</span><br>", retornarMinusculo(palavra)));
                out.println("<br>");
            }
            out.println("   ");
            out.println("   <form action=''>");
            out.println("      <label for='nome'>Palavra a testar: <input type='text' name='palavra'><br>");
            out.println("      <input type='submit' value='Enviar dados'>");
            out.println("   </form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String retornarMaiusculo(String palavra){
        return palavra.toUpperCase();
    }
    
    public String retornarMinusculo(String palavra){
        return palavra.toLowerCase();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
