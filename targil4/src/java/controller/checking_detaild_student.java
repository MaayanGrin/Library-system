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
import mod.helper;
import mod.student;

/**
 *
 * @author Maayan
 */
@WebServlet(name = "checking_detaild_student", urlPatterns = {"/checking_detaild_student"})
public class checking_detaild_student extends HttpServlet {

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
          String firstname=request.getParameter("firstname");
          String lastname=request.getParameter("lastname");
          String email=request.getParameter("email");
          String id=request.getParameter("id");
          String error="";
          String nextpage="";
                 if (h.isNullOrEmpty(firstname)) {
                error += "First name is empty.<br/>";
            }
            if (h.isNullOrEmpty(lastname)) {
                error += "Last name is empty.<br/>";
            }
            if (h.isNullOrEmpty(id)|id.length()!=9) {
                error += " id is empty or illegal.<br/>";
            }
            if (h.isNullOrEmpty(email)) {
                error += "mail is empty.<br/>";
            }
            
            if(!error.equals("")) {
                 nextpage="/erroradd.jsp" ;
                 request.getSession().setAttribute("err",error);
                request.getSession().setAttribute("pri","AddStudent.jsp");
              request.getRequestDispatcher(nextpage).forward(request, response); 
                return;
            }
       
           DB.dbclass db=new dbclass();
            if(db.isExistsstudent(id)==true){
             nextpage="/erroradd.jsp" ;
             String err="the student already in the system";
              request.getSession().setAttribute("pri","AddStudent.jsp");
             request.getSession().setAttribute("err",err);
              request.getRequestDispatcher(nextpage).forward(request, response);      
            }
            else{
              db=new dbclass();
              student temp=new student();
              temp.setFirstname(firstname);
              temp.setLastname(lastname);
              temp.setEmail(email);
              temp.setId(id);
              temp.setPenalty(0);
              int c=db.setstudent(temp);
              if(c==0){
              nextpage="/erroradd.jsp" ;
             String err="The details were not received. Please try again";
             request.getSession().setAttribute("err",err);
              request.getSession().setAttribute("pri","AddStudent.jsp"); 
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
