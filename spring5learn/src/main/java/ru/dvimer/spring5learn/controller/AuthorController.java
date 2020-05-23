package ru.dvimer.spring5learn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dvimer.spring5learn.service.AuthorService;
import ru.dvimer.spring5learn.service.BookService;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @RequestMapping("/authors")
    private String getAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors/list";
    }
}
