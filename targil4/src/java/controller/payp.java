/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.dbclass;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mod.Beanclass;
import mod.helper;
import mod.student;

/**
 *
 * @author Maayan
 */
@WebServlet(name = "payp", urlPatterns = {"/payp"})
public class payp extends HttpServlet {

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
        helper h=new helper();
        String error="";
        String nextpage="";
        try{
            String id =request.getParameter("id");
            
              if (h.isNullOrEmpty(id)) {
                error += "id is empty.<br/>";
              }
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","pay.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
            DB.dbclass db=new dbclass();
            student s=db.getstudent(id);
            if(s==null){
               nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","pay.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response);   
            }
            Beanclass bean=new Beanclass();
            bean.setStrudent(s);
            request.getSession().setAttribute("bean", bean);
           request.getRequestDispatcher("paymentstudent.jsp").forward(request, response); 
        }
        catch(Exception e){
            
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
