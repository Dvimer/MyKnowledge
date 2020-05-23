package ru.dvimer.spring5learn.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@EqualsAndHashCode(exclude = "books")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adressLine1;
    private String city;
    private String state;
    private String zip;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books;

    public Publisher(String name, String adressLine1, String city, String state, String zip) {
        this.name = name;
        this.adressLine1 = adressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
