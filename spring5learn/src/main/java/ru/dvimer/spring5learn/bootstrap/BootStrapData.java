package ru.dvimer.spring5learn.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.dvimer.spring5learn.domain.Author;
import ru.dvimer.spring5learn.domain.Book;
import ru.dvimer.spring5learn.domain.Publisher;
import ru.dvimer.spring5learn.repository.AuthorRepository;
import ru.dvimer.spring5learn.repository.BookRepository;
import ru.dvimer.spring5learn.repository.PublisherRepository;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("ne Line", "Moskow", "Bdd", "50", "43543");
        publisherRepository.save(publisher);

        Book book = new Book("1241", "Name");
        Book book2 = new Book("124411", "Na421me");
        Author author = new Author("name", "Famaly");
        Set<Author> authors = new HashSet<>();
        authors.add(author);
        book.setAuthors(authors);
        book2.setAuthors(authors);
        Set<Book> books = new HashSet<>();
        books.add(book);
        books.add(book2);
        author.setBooks(books);

        book.setPublisher(publisher);
        book2.setPublisher(publisher);
        publisher.setBooks(books);

        authorRepository.save(author);
        bookRepository.save(book);
        bookRepository.save(book2);


        System.out.println("Count  publisher = " + publisherRepository.count());
        System.out.println("Count book = " + bookRepository.count());
        System.out.println("Count author = " + authorRepository.count());

    }
}
