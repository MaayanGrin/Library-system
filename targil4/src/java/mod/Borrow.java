/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Maayan
 */
public class Borrow implements Serializable{
    
    private String firstname;
    private String lastname;
    private String email;
    private String id;
   private  int penalty;
    private String namebook;
    private String author;
    private String category;
    private int isbn;
    private int year;
    private int numbercopyes;
    private int borrowbook;

    private String Borrowed_date;
    private String return_date;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the penalty
     */
    public int getPenalty() {
        return penalty;
    }

    /**
     * @param penalty the penalty to set
     */
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    /**
     * @return the namebook
     */
    public String getNamebook() {
        return namebook;
    }

    /**
     * @param namebook the namebook to set
     */
    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the numbercopyes
     */
    public int getNumbercopyes() {
        return numbercopyes;
    }

    /**
     * @param numbercopyes the numbercopyes to set
     */
    public void setNumbercopyes(int numbercopyes) {
        this.numbercopyes = numbercopyes;
    }

    /**
     * @return the borrowbook
     */
    public int getBorrowbook() {
        return borrowbook;
    }

    /**
     * @param borrowbook the borrowbook to set
     */
    public void setBorrowbook(int borrowbook) {
        this.borrowbook = borrowbook;
    }

    /**
     * @return the Borrowed_date
     */
    public String getBorrowed_date() {
        return Borrowed_date;
    }

    /**
     * @param Borrowed_date the Borrowed_date to set
     */
    public void setBorrowed_date(String Borrowed_date) {
        this.Borrowed_date = Borrowed_date;
    }

    /**
     * @return the return_date
     */
    public String getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
    
    

    
  
    
}
