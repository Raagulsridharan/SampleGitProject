package com.revature.book;

public class Book {

    private int isbn;
    private String bookName;
    public Book(){}
    public Book(int isbn, String bookName){
        this.isbn = isbn;
        this.bookName = bookName;
    }
//    public void setIsbn(int isbn){
//        this.isbn=isbn;
//    }
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
    public int getIsbn(){
        return isbn;
    }
    public String getBookName(){
        return bookName;
    }
}
