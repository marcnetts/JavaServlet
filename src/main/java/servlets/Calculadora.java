package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Adicao;
import negocio.Calculo;
import negocio.Divisao;
import negocio.Multiplicacao;
import negocio.Subtracao;

/**
 *
 * @author marcnetts
 */
@WebServlet(name = "Calculadora", urlPatterns = {"/calculadora"})
public class Calculadora extends HttpServlet {

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
            
            String operacao = request.getParameter("operacao");
            Calculo calculo = null;
            
            switch(operacao){
                case "+":
                    calculo = new Adicao();
                    break;
                case "-":
                    calculo = new Subtracao();
                    break;
                case "*":
                    calculo = new Multiplicacao();
                    break;
                case "/":
                    calculo = new Divisao();
                    break;
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ELE2 - 5º. ADS - mat</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("   <h1>Fatec-RL</h1>");
            out.println("   <h2>ADS - ELE2 - 5o. matutino</h2>");
            out.println("   <h4>Calculadora JSP</h4>");
            out.println("   ");
            try{
                calculo.setValor1(Float.valueOf(request.getParameter("numero1")));
                calculo.setValor2(Float.valueOf(request.getParameter("numero2")));
                try{
                    calculo.calcular();
                    out.println(String.format("   <span>Numeros passados: %f %s %f = %f</span><br>", calculo.getValor1(), operacao, calculo.getValor2(), calculo.getResultado()));
                }
                catch(Exception e){
                    out.println(String.format("   <span>Numeros passados: %f %s %f = Divisao por zero!</span><br>", calculo.getValor1(), operacao, calculo.getValor2()));
                }
            }
            catch(Exception e){
                out.println("   <span>Um ou mais valores passados estão incorretos! Passe apenas números.</span><br>");
            }
            out.println("<br>");
            out.println("   ");
            out.println("   <form action=''>");
            out.println(String.format("       <label for='nome'>Valor 1: <input type='number' name='numero1' value='%.0f'><br>", calculo.getValor1()));
            out.println(String.format("       <label for='nome'>Valor 2: <input type='number' name='numero2' value='%.0f'><br>", calculo.getValor2()));
            out.println("<br>");
            out.println("       <input type='submit' name='operacao' value='+'>");
            out.println("       <input type='submit' name='operacao' value='-'>");
            out.println("       <input type='submit' name='operacao' value='*'>");
            out.println("       <input type='submit' name='operacao' value='/'>");
            out.println("   </form>");
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
