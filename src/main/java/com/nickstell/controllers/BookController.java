package com.nickstell.controllers;

import com.nickstell.model.Book;
import com.nickstell.services.BookService;
import com.nickstell.validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookValidator bookValidator;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "/books";
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.GET)
    public String createBook(Model model){
        model.addAttribute("bookForm", new Book());

        return "/create-book";
    }

    @RequestMapping(value = "/create-book", method = RequestMethod.POST)
    public String createBook(@ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, Model model) {

        //bookValidator.validate(bookForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/create-book";
        }

        this.bookService.addBook(bookForm);

        return "redirect:/books";
    }

    @RequestMapping(value = "//books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){

        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "/books/edit-book/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model){

        Book bookEditForm = this.bookService.getBookById(id);
        model.addAttribute("bookEditForm", bookEditForm);

        return "/edit-book";
    }

    @RequestMapping(value = "/books/edit-book/{id}", method = RequestMethod.POST)
    public String editBook(@ModelAttribute("bookEditForm") Book bookEditForm,@PathVariable(value = "id") Long id, BindingResult bindingResult){

       // bookValidator.validate(bookEditForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/books";
        }

        this.bookService.updateBook(bookEditForm);

        return "redirect:/books";
    }
}
