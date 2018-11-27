<%-- 
    Document   : showsearch
    Created on : 07/02/2018, 22:44:53
    Author     : Maayan
--%>

<%@page import="java.util.List"%>
<%@page import="mod.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Book>list=(List<Book>)request.getSession().getAttribute("text");%>
<>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                               <link href="css.css" type="text/css" rel="Stylesheet">

        <title>Search</title>
    </head>
    <body>
        
                
         <div class="heads"  id="headerDiv" style="background:#ef027d">
            <h>Welcome to the library </h>
        </div>
        
        <div id="middle" style="height: 600px; width: 100%; margin-top: 10px;">
            
            <div id="navigationDiv" class="navigationDiv"  >

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
            <h>search results</h><br/>
            </div>
       
                
                
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
              
   
       <%for(Book b: list){
       %>
       
     <tr>
     <td><%=b.getIsbn()%></td>
    <td><%=b.getNamebook()%></td>
    <td><%=b.getAuthor()%></td>
    <td><%=b.getCategory()%></td>
    <td><%=b.getYear()%></td>
     <td><%=b.getNumbercopyes()%></td>
    <td><%=b.getBorrowbook()%></td>

     </tr>
  <%}%>
                </table>
       
                <br>
     </div>
                <a href="borrow.jsp"><input type="button" value="borrow"></a>
                     
            </div>  
                
        
        </div>
               
        <div class="heads"id="header" style="background:#ef027d; font-size:15px; margin-top:10px ">
            <h> C Maayan Grinshtat 2017-2018</h>
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
       <%for(Book b: list){
       %>
       <%=b.getNamebook()%>
       
       <%}%>
    </body>
</html>
