/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.dbclass;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "searchbook", urlPatterns = {"/searchbook"})
public class searchbook extends HttpServlet {

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
        try{
            String text=request.getParameter("search");
            String error="";
            String nextpage="";
            helper h=new helper();
            System.out.println(text);
                if (h.isNullOrEmpty(text)) {
                error += "  the text that you enter is empty.<br/>";
            }
      
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                 request.getSession().setAttribute("pri","searchpage.jsp");
                 request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
           List<Book>temp=new ArrayList<>();
            DB.dbclass db=new dbclass();
            List<Book>Listbook=db.getlistbook();
            System.out.println("Listbook"+Listbook.size());
            for(Book b: Listbook){
                System.out.println("loop");
            if(b.getNamebook().contains(text)){
            System.out.println("enter looP"+b.getNamebook());
                temp.add(b);
            }
        }
             System.out.println("temp"+temp.size());
            if(temp.size()==0){
                 System.out.println("temp sizw=0"+temp.size());
                error="not found this text";
              nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                 request.getSession().setAttribute("pri","searchpage.jsp");
                 request.getRequestDispatcher(nextpage).forward(request, response);    
            }
            else{
                 System.out.println("temp size 1"+temp.size());
                nextpage="showsearch.jsp";
              request.getSession().setAttribute("text",temp);
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
