package ca.shubbar.spring5app.controllers;

import ca.shubbar.spring5app.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-12
 */
@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }

    @RequestMapping("/authors/demo")
    public String getDemo() {
        return "authors/demo";
    }
}
