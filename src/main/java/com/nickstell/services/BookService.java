package com.nickstell.services;


import com.nickstell.model.Book;

import java.util.List;

public interface BookService  {

   void addBook(Book book);
   void updateBook(Book book);
   void removeBook(Long id);
   Book getBookById(Long id);
   List<Book> listBooks();
}
