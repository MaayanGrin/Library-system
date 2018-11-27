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
import mod.Book;
import mod.helper;

/**
 *
 * @author Maayan
 */
@WebServlet(name = "removbook", urlPatterns = {"/removbook"})
public class removbook extends HttpServlet {

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
        try {
        String isbn=request.getParameter("isbn");
        String nextpage="";
        String error="";
            if (h.isNullOrEmpty(isbn)) {
                error += "  isbn is empty.<br/>";
            }
      
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                 request.getSession().setAttribute("pri","removebook.jsp");
                 request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
            DB.dbclass db=new dbclass();
            Book book=db.getbook(Integer.parseInt(isbn));
            if(book==null){
                  nextpage="/erroradd.jsp" ;
                  error="No book with this  isbn found";
                 request.getSession().setAttribute("err",error);
                 request.getSession().setAttribute("pri","removebook.jsp");
                 request.getRequestDispatcher(nextpage).forward(request, response);  
            }
            if(book.getBorrowbook()==book.getNumbercopyes()){
            db=new dbclass();
            int c=db.removebook(book);
             nextpage="/ssuccess.jsp";
             String success="Details successfully removed";
             request.getSession().setAttribute("success",success);
              request.getRequestDispatcher(nextpage).forward(request, response); 
            }
            else{
              nextpage="/erroradd.jsp" ;
                  error="Can not remove book There are books on rent";
                 request.getSession().setAttribute("err",error);
                 request.getSession().setAttribute("pri","removebook.jsp");
                 request.getRequestDispatcher(nextpage).forward(request, response);    
            }
            
     
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
