package com.nickstell.validator;

import com.nickstell.model.Book;
import com.nickstell.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {

    @Autowired
    private BookService bookService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookTitle", "Required");
        if (book.getBookTitle().length() < 8 || book.getBookTitle().length() > 32) {
            errors.rejectValue("bookTitle", "Size.bookForm.bookTitle");
        }

        if (bookService.findByBookTitle(book.getBookTitle()) != null) {
            errors.rejectValue("bookTitle", "Duplicate.bookForm.bookTitle");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookAuthor", "Required");
        if (book.getBookAuthor().length() < 8 || book.getBookAuthor().length() > 32) {
            errors.rejectValue("bookAuthor", "Size.bookForm.bookAuthor");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        if (book.getPrice() == 0 || book.getPrice() < 0) {
            errors.rejectValue("price", "Size.bookForm.price");
        }
    }
}
