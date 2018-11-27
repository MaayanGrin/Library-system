/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Maayan
 */
public class Beanclass implements Serializable{
    private student strudent;
    private List<student>liststudList;
    private Book book;
    private List<Book>Listbook;
    private List<Borrow> Listborrow;
    
    
    
    
    
    
    /**
     * @return the strudent
     */
    public student getStrudent() {
        return strudent;
    }

    /**
     * @param strudent the strudent to set
     */
    public void setStrudent(student strudent) {
        this.strudent = strudent;
    }

    /**
     * @return the liststudList
     */
    public List<student> getListstudList() {
        return liststudList;
    }

    /**
     * @param liststudList the liststudList to set
     */
    public void setListstudList(List<student> liststudList) {
        this.liststudList = liststudList;
    }

    /**
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return the Listbook
     */
    public List<Book> getListbook() {
        return Listbook;
    }

    /**
     * @param Listbook the Listbook to set
     */
    public void setListbook(List<Book> Listbook) {
        this.Listbook = Listbook;
    }

    /**
     * @return the Listborrow
     */
    public List<Borrow> getListborrow() {
        return Listborrow;
    }

    /**
     * @param Listborrow the Listborrow to set
     */
    public void setListborrow(List<Borrow> Listborrow) {
        this.Listborrow = Listborrow;
    }
    
    
    
    
    
    
    
}
