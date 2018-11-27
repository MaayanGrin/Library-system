/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.dbclass;
import com.sun.xml.bind.util.CalendarConv;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mod.Borrow;
import mod.helper;

/**
 *
 * @author Maayan
 */
@WebServlet(name = "returnbookserver", urlPatterns = {"/returnbookserver"})
public class returnbookserver extends HttpServlet {

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
            String dam=request.getParameter("damaged");
             String error="";
          String nextpage="";
          
                 if (h.isNullOrEmpty(isbn)) {
                error += "isbn  is empty.<br/>";
            }
          
            if (h.isNullOrEmpty(id)|id.length()!=9) {
                error += " id is empty or illegal.<br/>";
            }
            if (h.isNullOrEmpty(dam)) {
                error += "radio button not clicked .<br/>";
            }
            
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","returnbook.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
            System.out.println(dam);
            dbclass db=new dbclass();
            Borrow b=db.getborrow(Integer.parseInt(isbn), id);
            Date d=h.constringdate(b.getReturn_date());
            System.out.println("date return:"+d);
            System.out.println("h"+h.settimetake());
            
            if(h.settimetake().after(d)){
            System.out.println("נכנס ללולאה");
            int after=h.settimetake().getDate()-d.getDay();
            System.out.println(after);   
            db=new dbclass(); 
            db.updatepanstudent(b.getId(),b.getPenalty()+(after*20));
            
              if(dam.equals("YES")){
              db=new dbclass();
              db.updatemaxbook(b.getIsbn(), b.getNumbercopyes()-1);
             db=new dbclass();
              db.updatepanstudent(b.getId(),b.getPenalty()+100);
                db=new dbclass();
              db.deleteborrow(b);

             }
             else{
              db=new dbclass();
              db.updedebook(b.getBorrowbook()+1,b.getIsbn());
                db=new dbclass();
              db.deleteborrow(b);
             }
            }
            else{
             if(dam.equals("YES")){
              db=new dbclass();
              db.updatemaxbook(b.getIsbn(), b.getNumbercopyes()-1);
             db=new dbclass();
              db.updatepanstudent(b.getId(),b.getPenalty()+100);
                db=new dbclass();
              db.deleteborrow(b);

             }
             else{
              db=new dbclass();
              db.updedebook(b.getBorrowbook()+1,b.getIsbn());
                db=new dbclass();
              db.deleteborrow(b);
             }
             }
            nextpage="/showborrow";
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
