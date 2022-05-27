package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Media;

/**
 *
 * @author marcnetts
 */
@WebServlet(name = "ServletConversaoDeMedia", urlPatterns = {"/mediaresut"})
public class ServletConversaoDeMedia extends HttpServlet {

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
            
            Media media = new Media();
            float p1, p2, tp;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ELE2 - 5º. ADS - mat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Fatec-RL</h1>");
            out.println("   <h2>ADS - ELE2 - 5o. matutino</h2>");
            out.println("   <h4>Médias de nota</h4>");
            out.println("   ");
            out.println("<br><a href='formmedia'>Voltar</a><br>");
            out.println("<br>");
            try{
                p1 = Float.valueOf(request.getParameter("p1"));
                p2 = Float.valueOf(request.getParameter("p2"));
            }
            catch(NumberFormatException e){
                out.println("   Houve um erro em um dos parâmetros passados.");
                out.println("</body>");
                out.println("</html>");
                return;
            }
            if (request.getParameter("tp") != ""){
                try{
                    tp = Float.valueOf(request.getParameter("tp"));
                }
                catch(NumberFormatException e){
                    out.println("   Houve um erro em um dos parâmetros passados.");
                    out.println("</body>");
                    out.println("</html>");
                    return;
                }
                media.calcularMedia(p1, p2, tp);
            }
            else{
                media.calcularMedia(p1, p2);
            }
            
            out.println(String.format("   <h3>Média das notas = %f</h3><br>", media.getMedia()));
            out.println("</body>");
            out.println("</html>");
        }
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