/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.io.Serializable;

/**
 *
 * @author Maayan
 */
public class Book implements Serializable{
    private String namebook;
    private String author;
    private String category;
    private int isbn;
    private int year;
    private int numbercopyes;
    private int borrowbook;
    
    
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
    
    
    
    
    
}
