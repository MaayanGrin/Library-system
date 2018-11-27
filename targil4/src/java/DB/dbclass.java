/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mod.Book;
import mod.Borrow;
import mod.student;

/**
 *
 * @author Maayan
 */
public class dbclass {
      private Connection connection =null;
  
   public dbclass() throws SQLException, ClassNotFoundException {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
            String urlCn="jdbc:derby://localhost:1527/db_4";
            connection = DriverManager.getConnection(urlCn, "root", "root");
}
   
  //                       student db                                                           //
  public boolean isExistsstudent(String id) throws SQLException {
           PreparedStatement pStatement ;
        try {
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.STUDENT ");
            ResultSet rs =pStatement.executeQuery();
          
            while (rs.next()) {
             student temp=new student();
            temp.setFirstname(rs.getString("FIRSTNAME"));
            temp.setLastname(rs.getString("LASTNAME"));
            temp.setEmail(rs.getString("EMAIL"));
             temp.setId(rs.getString("ID"));
             temp.setPenalty(rs.getInt("PENALTY"));
                System.out.println(temp.getId());
           if(id.equals(temp.getId())){
               return true;
          
            }
        }

        }  
        catch(SQLException s){
        s.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception s) {
        }
        }
        return false;
        
}

  public int setstudent(student s){

       int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("INSERT INTO ROOT.STUDENT (FIRSTNAME, LASTNAME, EMAIL, ID,PENALTY)" +"VALUES (?,?,?,?,?)");
       System.out.println("hfhjdhj");
        pStatement.setString(1,s.getFirstname());
        pStatement.setString(2,s.getLastname());
        pStatement.setString(3,s.getEmail());
        pStatement.setString(4,s.getId());
       pStatement.setInt(5,s.getPenalty());
        con=pStatement.executeUpdate();
              
        System.out.println(con);
          
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;

    }   
      
  public List<student> getliststudent(){
             List<student> List = new ArrayList<>();
        try {
            PreparedStatement pStatement ;
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.STUDENT");
            ResultSet rs =pStatement.executeQuery();
          
            while (rs.next()) {
            student temp=new student();
            temp.setFirstname(rs.getString("FIRSTNAME"));
            temp.setLastname(rs.getString("LASTNAME"));
            temp.setEmail(rs.getString("EMAIL"));
            temp.setId(rs.getString("ID"));
          temp.setPenalty(rs.getInt("PENALTY"));
            List.add(temp);
        }
        }
          catch(SQLException e){
        e.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return List;
    }
    
  public student getstudent(String id) throws SQLException {
           PreparedStatement pStatement ;
        try {
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.STUDENT ");
            ResultSet rs =pStatement.executeQuery();
          
            while (rs.next()) {
             student temp=new student();
            temp.setFirstname(rs.getString("FIRSTNAME"));
            temp.setLastname(rs.getString("LASTNAME"));
            temp.setEmail(rs.getString("EMAIL"));
             temp.setId(rs.getString("ID"));
             temp.setPenalty(rs.getInt("PENALTY"));
             System.out.println(temp.getId());
           if(id.equals(temp.getId())){
               return temp;
          
            }
        }

        }  
        catch(SQLException s){
        s.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception s) {
        }
        }
        return null;
        
}
  
  public int updatepanstudent(String s,int p){
   int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("UPDATE ROOT.STUDENT SET PENALTY=? WHERE ID=?");
           System.out.println("שם קנס");
         pStatement.setInt(1,p);
         pStatement.setString(2,s);

         con=pStatement.executeUpdate();       
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;   
          }   
  
  
    //                       book db                                                           //

  public boolean  isExistbook(int isbn){
               PreparedStatement pStatement ;
        try {
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.BOOK ");
            ResultSet rs =pStatement.executeQuery();
          
            while (rs.next()) {
             Book temp=new Book();
            temp.setNamebook(rs.getString("NAMEBOOK"));
            temp.setAuthor(rs.getString("AUTHOR"));
            temp.setIsbn(rs.getInt("ISBN"));
             temp.setCategory(rs.getString("CATEGORY"));
             temp.setYear(rs.getInt("YEARPUBLISHING"));
             temp.setNumbercopyes(rs.getInt("COPIES"));
             temp.setBorrowbook(rs.getInt("AVAILABLEBOOK"));
           if(isbn==temp.getIsbn()){
               return true;

          
            }
        }

        }  
        catch(SQLException s){
        s.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception s) {
        }
        }
        return false; 
  }
  
public int setbook(Book s){

       int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("INSERT INTO ROOT.BOOK (NAMEBOOK, AUTHOR, ISBN,CATEGORY,YEARPUBLISHING,COPIES,AVAILABLEBOOK)" +"VALUES (?,?,?,?,?,?,?)");
       System.out.println("hfhjdhj");
        pStatement.setString(1,s.getNamebook());
        pStatement.setString(2,s.getAuthor());
        pStatement.setInt(3,s.getIsbn());
        pStatement.setString(4,s.getCategory());
        pStatement.setInt(5,s.getYear());
        pStatement.setInt(6,s.getNumbercopyes());
        pStatement.setInt(7,s.getBorrowbook());       
        con=pStatement.executeUpdate();       
        System.out.println(con);
          
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;

    }  

public List<Book> getlistbook(){
             List<Book> List = new ArrayList<>();
        try {
            PreparedStatement pStatement ;
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.BOOK");
            ResultSet rs =pStatement.executeQuery();
          
                  
            while (rs.next()) {
             Book temp=new Book();
            temp.setNamebook(rs.getString("NAMEBOOK"));
            temp.setAuthor(rs.getString("AUTHOR"));
            temp.setIsbn(rs.getInt("ISBN"));
            temp.setCategory(rs.getString("CATEGORY"));
            temp.setYear(rs.getInt("YEARPUBLISHING"));
            temp.setNumbercopyes(rs.getInt("COPIES"));
            temp.setBorrowbook(rs.getInt("AVAILABLEBOOK"));
            List.add(temp);
        }
            
        }
          catch(SQLException e){
        e.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return List;
    }

  public Book getbook(int isbn){
               PreparedStatement pStatement ;
        try {
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.BOOK");
            ResultSet rs =pStatement.executeQuery();
          
            while (rs.next()) {
             Book temp=new Book();
            temp.setNamebook(rs.getString("NAMEBOOK"));
            temp.setAuthor(rs.getString("AUTHOR"));
            temp.setIsbn(rs.getInt("ISBN"));
             temp.setCategory(rs.getString("CATEGORY"));
             temp.setYear(rs.getInt("YEARPUBLISHING"));
             temp.setNumbercopyes(rs.getInt("COPIES"));
             temp.setBorrowbook(rs.getInt("AVAILABLEBOOK"));
           if(isbn==temp.getIsbn()){
               return temp;

            }
        }

        }  
        catch(SQLException s){
        s.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception s) {
        }
        }
        return null; 
  }
         
  public int removebook(Book b){
  int con=0;
      try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("DELETE FROM ROOT.BOOK WHERE NAMEBOOK=? AND AUTHOR=? AND ISBN=? AND CATEGORY=? AND YEARPUBLISHING=? AND COPIES=? AND AVAILABLEBOOK=?");
         pStatement.setString(1,b.getNamebook());
         pStatement.setString(2,b.getAuthor());
         pStatement.setInt(3,b.getIsbn());
         pStatement.setString(4,b.getCategory());
         pStatement.setInt(5,b.getYear());
         pStatement.setInt(6,b.getNumbercopyes());
         pStatement.setInt(7,b.getBorrowbook());
         con=pStatement.executeUpdate();       
          System.out.println(con);  
      }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;   
          }
          
   public int updedebook(int upbook,int b){
     int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("UPDATE  ROOT.BOOK SET AVAILABLEBOOK=? WHERE ISBN=?");

         
         pStatement.setInt(2,b);
         pStatement.setInt(1,upbook);

         con=pStatement.executeUpdate();       
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;   
          }  
 
   public int updatemaxbook(int isbn,int copy){
     int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("UPDATE  ROOT.BOOK SET COPIES=? WHERE ISBN=?");

         
         pStatement.setInt(2,isbn);
         pStatement.setInt(1,copy);
           System.out.println("מוריד כמות ספר");
         con=pStatement.executeUpdate();       
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;   
          }  

 public List<String> getcat(){
             List<String> List = new ArrayList<>();
        try {
            PreparedStatement pStatement ;
            pStatement = connection.prepareStatement("SELECT CATEGORY FROM ROOT.BOOK GROUP BY CATEGORY,AVAILABLEBOOK HAVING AVAILABLEBOOK > 0 ");
            ResultSet rs =pStatement.executeQuery();
            String temp="";
            while (rs.next()) {
             temp=(rs.getString("CATEGORY"));
                System.out.println(temp);
             List.add(temp);
            }            
        }
          catch(SQLException e){
        e.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return List;

 }
                
 public List<Book> getbookbycat(String cat){
             List<Book> List = new ArrayList<>();
        try {
            PreparedStatement pStatement ;
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.BOOK where CATEGORY="+"'"+cat+"'"+"and AVAILABLEBOOK > 0 ");
            
          //  pStatement.setString(1,cat);
            ResultSet rs =pStatement.executeQuery();
            
             while (rs.next()) {
            Book temp=new Book();
            temp.setNamebook(rs.getString("NAMEBOOK"));
            temp.setAuthor(rs.getString("AUTHOR"));
            temp.setIsbn(rs.getInt("ISBN"));
             temp.setCategory(rs.getString("CATEGORY"));
             temp.setYear(rs.getInt("YEARPUBLISHING"));
             temp.setNumbercopyes(rs.getInt("COPIES"));
             temp.setBorrowbook(rs.getInt("AVAILABLEBOOK"));
             if(cat.equals(temp.getCategory())){
               List.add(temp);

            }            
        }
        }
          catch(SQLException e){
        e.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return List;

 }          

     //                       borrow db                                                           //

 public  int setborrow(Borrow b){
     
       int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement(" INSERT INTO ROOT.BORROW (NAMEBOOK, AUTHOR, SBN, CATEGORY, YEARPUBLISHING, COPIES, AVAILABLEBOOK, FIRSTNAME, LASTNAME, EMAIL, ID,PENALTY, TAKEDATE, RETURNDATE) "+
"	VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

        pStatement.setString(1,b.getNamebook());
        pStatement.setString(2,b.getAuthor());
        pStatement.setInt(3,b.getIsbn());
        pStatement.setString(4,b.getCategory());
        pStatement.setInt(5,b.getYear());
        pStatement.setInt(6,b.getNumbercopyes());
        pStatement.setInt(7,b.getBorrowbook());       
       pStatement.setString(8,b.getFirstname());
        pStatement.setString(9,b.getLastname());
        pStatement.setString(10,b.getEmail());
        pStatement.setString(11,b.getId());
        pStatement.setInt(12, b.getPenalty());
        pStatement.setString(13,b.getBorrowed_date());
        pStatement.setString(14,b.getReturn_date());

        con=pStatement.executeUpdate();       
        System.out.println(con);
          
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;

     
     
 }

public List<Borrow> getlistborrow(){
             List<Borrow> List = new ArrayList<>();
        try {
            PreparedStatement pStatement ;
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.BORROW");
            ResultSet rs =pStatement.executeQuery();
                 
            while (rs.next()) {
                
             Borrow temp=new Borrow();
            
            temp.setNamebook(rs.getString("NAMEBOOK"));
            temp.setAuthor(rs.getString("AUTHOR"));
            temp.setIsbn(rs.getInt("SBN"));
            temp.setCategory(rs.getString("CATEGORY"));
            temp.setYear(rs.getInt("YEARPUBLISHING"));
            temp.setNumbercopyes(rs.getInt("COPIES"));
            temp.setBorrowbook(rs.getInt("AVAILABLEBOOK"));
            temp.setFirstname(rs.getString("FIRSTNAME"));
            temp.setLastname(rs.getString("LASTNAME"));
            temp.setEmail(rs.getString("EMAIL"));
            temp.setId(rs.getString("ID"));
            temp.setPenalty(rs.getInt("PENALTY"));
            temp.setBorrowed_date(rs.getString("TAKEDATE"));
            temp.setReturn_date(rs.getString("RETURNDATE"));
            
            List.add(temp);
        }
            
        }
          catch(SQLException e){
        e.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return List;
    }

   public int updedeboorow(Borrow b){
     int con=0;
       try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("UPDATE  ROOT.BORROW SET AVAILABLEBOOK=? WHERE ISBN=?");

         
         pStatement.setInt(2,b.getIsbn());
         pStatement.setInt(1,(b.getBorrowbook()-1));

         con=pStatement.executeUpdate();       
        }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;   
          }  

  public int deleteborrow(Borrow b){
  int con=0;
      try{
        PreparedStatement pStatement ;           
        pStatement = connection.prepareStatement("DELETE FROM ROOT.BORROW WHERE SBN=? AND ID=? " );
      
         pStatement.setInt(1,b.getIsbn());
         pStatement.setString(2,b.getId());
         con=pStatement.executeUpdate();       
          System.out.println(con);  
      }
        catch(Exception e){
        }
          finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return con;   
          }

  public  Borrow getborrow(int isbn,String id){
        try {
            PreparedStatement pStatement ;
            pStatement = connection.prepareStatement("SELECT * FROM ROOT.BORROW");
            ResultSet rs =pStatement.executeQuery();
                 
            while (rs.next()) {
                
             Borrow temp=new Borrow();
            
            temp.setNamebook(rs.getString("NAMEBOOK"));
            temp.setAuthor(rs.getString("AUTHOR"));
            temp.setIsbn(rs.getInt("SBN"));
            temp.setCategory(rs.getString("CATEGORY"));
            temp.setYear(rs.getInt("YEARPUBLISHING"));
            temp.setNumbercopyes(rs.getInt("COPIES"));
            temp.setBorrowbook(rs.getInt("AVAILABLEBOOK"));
            temp.setFirstname(rs.getString("FIRSTNAME"));
            temp.setLastname(rs.getString("LASTNAME"));
            temp.setEmail(rs.getString("EMAIL"));
            temp.setId(rs.getString("ID"));
            temp.setPenalty(rs.getInt("PENALTY"));
            temp.setBorrowed_date(rs.getString("TAKEDATE"));
            temp.setReturn_date(rs.getString("RETURNDATE"));
            if(isbn==temp.getIsbn()&&id.equals(temp.getId())){
                return temp;
            }
        }
            
        }
          catch(SQLException e){
        e.getSQLState();
        }
        finally {
        try {
         connection.close(); 
        } catch (Exception e) {
        }
        }
        return null;
        
 }
}

