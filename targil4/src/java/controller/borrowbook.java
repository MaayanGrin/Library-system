/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.dbclass;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mod.Beanclass;
import mod.Book;
import mod.Borrow;
import mod.helper;
import mod.student;

/**
 *
 * @author Maayan
 */
@WebServlet(name = "borrowbook", urlPatterns = {"/borrowbook"})
public class borrowbook extends HttpServlet {

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
            String id=request.getParameter("id");
            String nextpage="";
            String error="";
                 if (h.isNullOrEmpty(isbn)) {
                error += "isbn is empty.<br/>";
            }
                 if (h.isNullOrEmpty(id)|id.length()!=9) {
                error += "id is empty or illegal<br/>";
            }
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","borrowcho.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
            
            DB.dbclass db=new dbclass();
            Book b=db.getbook(Integer.parseInt(isbn));
            if(b==null){
                error="Could not borrow the book the book is not found";
                nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","borrowcho.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
            }
   
            db=new dbclass();
            student s=db.getstudent(id);
            if(s==null){
                 error="Could not borrow the id is not found";
                nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","borrowcho.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response);   
            }
            
            db=new dbclass();
            Date take=h.settimetake();
            String ta=(take.getYear()+1900)+"/"+(take.getMonth()+1)+"/"+take.getDate();
            Date take1=h.settimeback();
            String ta1=(take1.getYear()+1900)+"/"+(take1.getMonth()+1)+"/"+take1.getDate();
           
            Borrow borrow=new Borrow(); 
            borrow.setFirstname(s.getFirstname());
            borrow.setLastname(s.getLastname());
           borrow.setEmail(s.getEmail());
            borrow.setId(s.getId());
            borrow.setPenalty(s.getPenalty());
            borrow.setNamebook(b.getNamebook());
            borrow.setAuthor(b.getAuthor());
            borrow.setCategory(b.getCategory());
            borrow.setYear(b.getYear());
            borrow.setIsbn(b.getIsbn());
            borrow.setNumbercopyes(b.getNumbercopyes());
            borrow.setBorrowbook(b.getBorrowbook()-1);
            borrow.setBorrowed_date(ta);
            borrow.setReturn_date(ta1);
            
            int c=db.setborrow(borrow);
            if(c==0){
                 error="Could not borrow ";
                nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","borrowcho.jsp");
             request.getRequestDispatcher(nextpage).forward(request, response);  
            }
            db=new dbclass();
             db.updedebook((b.getBorrowbook()-1),b.getIsbn());
            
             db=new dbclass();
              db.updedeboorow(borrow);
              nextpage="/success.jsp";
             String success="Details successfully added";
             request.getSession().setAttribute("success",success);
              
             request.getRequestDispatcher(nextpage).forward(request, response); 
                 
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
