package ru.dvimer.spring5learn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dvimer.spring5learn.service.BookService;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping("/books")
    private String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }
}
