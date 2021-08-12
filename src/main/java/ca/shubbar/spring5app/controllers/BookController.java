package ca.shubbar.spring5app.controllers;

import ca.shubbar.spring5app.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-12
 */
// Declare it as a Spring MVC Controller
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());


        return "books/list";
    }

}
