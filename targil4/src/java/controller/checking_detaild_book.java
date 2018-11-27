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
@WebServlet(name = "checking_detaild_book", urlPatterns = {"/checking_detaild_book"})
public class checking_detaild_book extends HttpServlet {

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
            String isbn1=request.getParameter("isbn");
            String namebook=request.getParameter("namebook");
            String author=request.getParameter("author");
            String category=request.getParameter("category");
            String year1=request.getParameter("year");  
           String copybook1=request.getParameter("copy");
           /*
            int year=Integer.parseInt(year1);
            
            int isbn=Integer.parseInt(isbn1);
            int copybook=Integer.parseInt(copybook1);
*/
            String error="";
            String nextpage="";

            if (h.isNullOrEmpty(isbn1)| isbn1.length()!=5) {
                error += "isbn is empty or the number is not illegal.<br/>";
            }
            if (h.isNullOrEmpty(namebook)) {
                error += " name book is empty.<br/>";
            }
            if (h.isNullOrEmpty(author)) {
                error += " author is empty .<br/>";
            }
            if (h.isNullOrEmpty(category)) {
                error += "category is empty.<br/>";
            }
             if (h.isNullOrEmpty(year1)) {
                error += "year is empty.<br/>";
            }
              if (h.isNullOrEmpty(copybook1)) {
                error += "copy book is empty.<br/>";
            }
              
              
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                 request.getSession().setAttribute("pri","addbook.jsp");
                 request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
           
            DB.dbclass db=new dbclass();
            if(db.isExistbook(Integer.parseInt(isbn1))==true){
             nextpage="/erroradd.jsp" ;
             String err="the book already in the system";
             request.getSession().setAttribute("pri","addbook.jsp");
             request.getSession().setAttribute("err",err);
             request.getRequestDispatcher(nextpage).forward(request, response);
            }
            else{
               db=new dbclass();
                Book b=new Book();
                b.setNamebook(namebook);
                b.setAuthor(author);
                b.setCategory(category);
                b.setIsbn(Integer.parseInt(isbn1));
                b.setYear(Integer.parseInt(year1));
                b.setNumbercopyes(Integer.parseInt(copybook1));
                b.setBorrowbook(Integer.parseInt(copybook1));
               int c=db.setbook(b);
               if(c==0){
               nextpage="/erroradd.jsp" ;
             String err="The details were not received. Please try again";
             request.getSession().setAttribute("pri","addbook.jsp");
             request.getSession().setAttribute("err",err);
             request.getRequestDispatcher(nextpage).forward(request, response);   
               }
              
              nextpage="/ssuccess.jsp";
             String success="Details successfully added";
             request.getSession().setAttribute("success",success);
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
