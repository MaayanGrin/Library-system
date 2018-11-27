<%-- 
    Document   : borrowcho
    Created on : 07/02/2018, 09:59:24
    Author     : Maayan
--%>

<%@page import="mod.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Book> cat=(List<Book>)request.getSession().getAttribute("listbook"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <link href="css.css" type="text/css" rel="Stylesheet">
   <jsp:useBean id="bean" class="mod.Beanclass" scope="session"/>
        <title>JSP Page</title>
    </head>
    <body>
                        <div class="heads"  id="headerDiv" style="background:#ef027d">
            <h>Welcome to the library </h>
        </div>
        
        <div id="middle" style="height: 600px; width: 100%; margin-top: 10px;">
            
         <div id="navigationDiv" class="navigationDiv">

             <form action="AddStudent.jsp" method="post">
            <input type="submit" value="Add Student" class="myButton"/> 
                </form>
            <form action="showstudent" method="post">
            <input type="submit" value="Show Student" class="myButton"/> 
                </form>
             <form action="addbook.jsp" method="post">
            <input type="submit" value="Add Book" class="myButton"/> 
                </form> 
            <form action="removebook.jsp" method="post">
            <input type="submit" value="Remove Book" class="myButton"/> 
                </form>           
            <form action="showbook" method="post">
            <input type="submit" value="Show Book" class="myButton"/> 
                </form>
                <form action="searchpage.jsp" method="post">
            <input type="submit" value="Search Book" class="myButton"/> 
                </form>
            <form action="getcatego" method="post">
            <input type="submit" value="Borrow Book" class="myButton"/> 
                </form>
            <form action="returnbook.jsp" method="post">
            <input type="submit" value="Return Book" class="myButton"/> 
                </form>
            <form action="showborrow" method="post">
            <input type="submit" value="Show Borrow" class="myButton"/> 
                </form>
                <form action="pay.jsp" method="post">
            <input type="submit" value=" pay penalty" class="myButton"/> 
                </form>
        
        </div>
            
            <div id="contentDiv" class="contentDiv"style="background: window">
             <div class="fontpage">
            <div style="color:#ef027d; font-size:50px; margin-top:10px ;text-align: left">  
             <h>Borrow Book</h><br/>
            </div>
                         <table>
              <tr>
    <th>name book</th>
    <th>isbn</th>
    <th>number avalible book</th>
  </tr>

            <%for(Book b:bean.getListbook()){    
            %>
            <tr>
                <td> <%=b.getNamebook()%></td>
                <td><%=b.getIsbn()%></td>
                <td><%=b.getBorrowbook()%></td>
            </tr>  
          <%}%>  
           </table>
           <br><br>
           <form action="borrowbook" method="POST">
               isbn:<input type="number" maxlength="5"name="isbn"><br>
               id<input type="text" maxlength="9"name="id"><br>
               <input type="submit" value="enter to borrow">
           </form>       
             </div>       
            </div>
        </div>
               
        <div class="heads"id="header" style="background:#ef027d; font-size:15px; margin-top:10px ">
        </div>
    </body>
</html>
