<%-- 
    Document   : showbook
    Created on : 06/02/2018, 11:31:56
    Author     : Maayan
--%>

<%@page import="mod.Book"%>
<%@page import="java.util.List"%>
<%@page import="mod.Beanclass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Beanclass bean=(Beanclass)request.getSession().getAttribute("bean");%>
<%!List<Book>t;%>
<%t=bean.getListbook();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <link href="css.css" type="text/css" rel="Stylesheet">

        <title>Show Book</title>
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
                           
                <table>
             <tr>
             <th>Isbn</th>
             <th>Name book</th>
             <th>Author</th>
             <th>Category</th>
             <th>Year Publishing</th>  
             <th>Copies</th>  
             <th>Available Book</th>  
              </tr>
              
       <%
       for (int i = 0; i < t.size(); i++) {                
 %>       
     <tr>
    <td><%=t.get(i).getIsbn()%></td>
    <td><%=t.get(i).getNamebook()%></td>
    <td><%=t.get(i).getAuthor()%></td>
    <td><%=t.get(i).getCategory()%></td>
    <td><%=t.get(i).getYear()%></td>
     <td><%=t.get(i).getNumbercopyes()%></td>
    <td><%=t.get(i).getBorrowbook()%></td>
     </tr>
  <%}%>
                </table>
            </div>
        
        </div>
               
        <div class="heads"id="header" style="background:#ef027d; font-size:15px; margin-top:10px ">
            <h> C Maayan Grinshtat 2017-2018</h>
        
        </div>
    </body>
</html>
