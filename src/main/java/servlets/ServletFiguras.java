package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Figura;
import negocio.Retangulo;
import negocio.Triangulo;

/**
 *
 * @author marcnetts
 */
@WebServlet(name = "ServletFiguras", urlPatterns = {"/figurasresult"})
public class ServletFiguras extends HttpServlet {

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
            Figura figura = null;
            float largura, altura;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ELE2 - 5º. ADS - mat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Fatec-RL</h1>");
            out.println("   <h2>ADS - ELE2 - 5o. matutino</h2>");
            out.println("   <h4>Figuras JSP</h4>");
            out.println("   ");
            out.println("<br><a href='figurasform'>Voltar</a><br>");
            try{
                operacao = request.getParameter("operacao");
                largura = Float.valueOf(request.getParameter("largura"));
                altura = Float.valueOf(request.getParameter("altura"));
            }
            catch(NumberFormatException e){
                out.println("   Houve um erro em um dos parâmetros passados.");
                out.println("</body>");
                out.println("</html>");
                return;
            }
            switch(operacao){
                case "tri":
                    figura = new Triangulo(largura,altura);
                    break;
                case "ret":
                    figura = new Retangulo(largura,altura);
                    break;
                default:
                    out.println("   Houve um erro em um dos parâmetros passados.");
                    out.println("</body>");
                    out.println("</html>");
                    return;
            }
            figura.calcularArea();
            out.println(String.format("   <span>Área da forma de base %f e altura %f = %f</span><br>", figura.getLargura(), figura.getAltura(), figura.getArea()));
            out.println("<br>");
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