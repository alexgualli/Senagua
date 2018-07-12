/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senagua.servlet;

import ec.gob.senagua.entidades.Consumo;
import ec.gob.senagua.entidades.Medidor;
import ec.gob.senagua.implementacion.ImpConsumo;
import ec.gob.senagua.implementacion.ImpMedidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class ServIngresoConsumo extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            Medidor medidor = new Medidor();
            ImpMedidor impm = new ImpMedidor();
            ImpConsumo imp = new ImpConsumo();
            Consumo consumo = new Consumo();
            
            
            String fecha = request.getParameter("txtfecha");
            int lecturan = Integer.parseInt(request.getParameter("txtlecturaAnt"));
            int lecturac = Integer.parseInt(request.getParameter("txtlecturaAct"));
            double valorconsumo = Double.parseDouble(request.getParameter("txtconsumo"));            
            medidor = impm.obtenerCodigo(request.getParameter("txtmedidor"));
            
            
            
            consumo.setConsumo(valorconsumo);
            consumo.setFecha(fecha);
            consumo.setLecturaAct(lecturac);
            consumo.setLecturaAnt(lecturan);
            consumo.setMedidor(medidor);
            
            try {
                imp.insertar(consumo);
            } catch (Exception ex) {
                Logger.getLogger(ServIngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServIngresoConsumo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServIngresoConsumo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
