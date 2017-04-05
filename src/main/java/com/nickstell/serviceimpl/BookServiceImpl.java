package com.nickstell.serviceimpl;

import com.nickstell.dao.BookDao;
import com.nickstell.model.Book;
import com.nickstell.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.save(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        //String s = "";
       // s += book.getId();
        Book bookNew = this.bookDao.getOne(book.getId());

        this.bookDao.save(bookNew);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDao.delete(id);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return this.bookDao.getOne(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.findAll();
    }
}
