package com.nickstell.controllers;

import com.nickstell.model.Book;
import com.nickstell.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){

        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "/create-book/edit-book", method = RequestMethod.GET)
    public String editBook(Model model){
        model.addAttribute("bookEditForm", new Book());

        return "edit-book";
    }

    @RequestMapping(value = "/create-book/edit-book", method = RequestMethod.POST)
    public String editBook(@ModelAttribute("bookEditForm") Book book){

        if(book != null){
            Book bookEdit = this.bookService.getBookById(book.getId());
            this.bookService.updateBook(bookEdit);
        }

        return "redirect:/books";
    }
}
