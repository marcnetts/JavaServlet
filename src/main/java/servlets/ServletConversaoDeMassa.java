package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Massa;

/**
 *
 * @author marcnetts
 */
@WebServlet(name = "ServletConversaoDeMassa", urlPatterns = {"/massasresut"})
public class ServletConversaoDeMassa extends HttpServlet {

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
            
            String operacao;
            Massa massa = new Massa();
            float massaInic, massaConv;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ELE2 - 5º. ADS - mat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Fatec-RL</h1>");
            out.println("   <h2>ADS - ELE2 - 5o. matutino</h2>");
            out.println("   <h4>Conversão de Peso</h4>");
            out.println("   ");
            out.println("<br><a href='formmassa'>Voltar</a><br>");
            out.println("<br>");
            try{
                operacao = request.getParameter("operacao");
                massaInic = Float.valueOf(request.getParameter("massa"));
            }
            catch(NumberFormatException e){
                out.println("   Houve um erro em um dos parâmetros passados.");
                out.println("</body>");
                out.println("</html>");
                return;
            }
            switch(operacao){
                case "libraparakg":
                    massaConv = massa.converterLibraParaQuilo(massaInic);
                    out.println(String.format("   <span>%flb para kg = %fkg</span><br>", massaInic, massaConv));
                    break;
                case "kgparalibra":
                    massaConv = massa.converterQuiloParaLibra(massaInic);
                    out.println(String.format("   <span>%fkg para lb = %flb</span><br>", massaInic, massaConv));
                    break;
                default:
                    out.println("   Houve um erro em um dos parâmetros passados.");
                    out.println("</body>");
                    out.println("</html>");
                    return;
            }
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