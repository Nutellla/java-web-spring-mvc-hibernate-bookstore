package com.nickstell.controllers;

import com.nickstell.model.Book;
import com.nickstell.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.GET)
    public String createBook(Model model){
        model.addAttribute("bookForm", new Book());

        return "create-book";
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.POST)
    public String registration(@ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "create-book";
        }

        this.bookService.addBook(bookForm);

        return "redirect:/books";
    }

//    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
//    public String addBook(@ModelAttribute("book") Book book){
//        if(book.getId() == 0){
//            this.bookService.addBook(book);
//        }else {
//            this.bookService.updateBook(book);
//        }
//
//        return "redirect:/books";
//    }

//    @RequestMapping(value = "/remove/{id}")
//    public String removeBook(@PathVariable("id") int id){
//        this.bookService.removeBook(id);
//
//        return "redirect:/books";
//    }
//
//    @RequestMapping(value = "edit/{id}")
//    public String editBook(@PathVariable("id") int id, Model model){
//        model.addAttribute("book", this.bookService.getBookById(id));
//        model.addAttribute("listBooks", this.bookService.listBooks());
//
//        return "books";
//    }

//    @RequestMapping(value = "book-info/{id}")
//    public String bookData(@PathVariable("id") int id, Model model){
//        model.addAttribute("book", this.bookService.getBookById(id));
//
//        return "create-book";
//    }
}
