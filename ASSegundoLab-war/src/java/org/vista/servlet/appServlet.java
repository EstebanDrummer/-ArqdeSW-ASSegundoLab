/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vista.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bean.entidad.Productos;
import org.ejb.bean.ProductosFacadeLocal;

/**
 *
 * @author yepesk8r
 */
public class appServlet extends HttpServlet {
    
    
    
    @EJB
    private ProductosFacadeLocal productosFacade;

    
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet appServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet appServlet at " + request.getContextPath() + "</h1>");
            //
             out.println("<h1>Servlet appservlet_ejb at </h1>");
            
            List productos = productosFacade.findAll();// crea lista de los productos 
            out.println("<table border=1><thead><tr><th>Id Producto</th><th>Nombre</th></tr></thead><tbody>");
            for(int i=0;i<productos.size();i++){//recorro la lista
               Productos it=(Productos) productos.get(i);
              out.println("<tr><td>" + it.getIdPro() + " </td><td> " + it.getDescPro() + "</td1></tr>");//tomo cada fila y los llamo desd el pojo
            }
            out.println("</tbody></table>");//construye una tabla de datos
             //
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
