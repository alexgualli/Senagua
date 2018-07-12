/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.servlet;

import ec.gob.senagua.implementacion.ImpUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jhona
 */
@WebServlet(name = "ServLogin", urlPatterns = {"/Login"})
public class ServLogin extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nombre = request.getParameter("txtnombre");
            String clave = request.getParameter("txtclave");
              
        HttpSession session = request.getSession();
            ImpUsuario impuser = new ImpUsuario();
            try {
                impuser.obtenerLogin(nombre, clave);
                
                if(impuser.obtenerLogin(nombre, clave)==null){
                   response.sendRedirect("inicio.jsp");
                           }else{
                if (impuser.obtenerLogin(nombre, clave).equals(nombre)|| impuser.obtenerLogin(nombre, clave).equals(clave)) {
                 
                     response.sendRedirect("inicio.jsp");
                } else {
                     String user=nombre;
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("FormularioPrincipal.jsp").forward(request, response);
                     response.sendRedirect("FormularioPrincipal.jsp");
                     
                }
                }
            } catch (Exception ex) {
                Logger.getLogger(ServLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            

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
