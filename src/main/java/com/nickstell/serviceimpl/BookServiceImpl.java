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
        this.bookDao.save(book);
    }

    @Override
    @Transactional
    public void removeBook(Long id) {
        this.bookDao.delete(id);
    }

    @Override
    @Transactional
    public Book getBookById(Long id) {
        return this.bookDao.findOne(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.findAll();
    }

    @Override
    public Book findByBookTitle(String bookTitle) {
        return this.bookDao.findByBookTitle(bookTitle);
    }
}
