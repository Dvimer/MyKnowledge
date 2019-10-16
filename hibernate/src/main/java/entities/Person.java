package entities;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private HomeAddress homeAddress;
    @OneToMany(mappedBy = "person")
    private List<Book> books;
    @ElementCollection
//    @OrderColumn
//    @OrderBy
//    @SortComparator(new MyComporator)
    @org.hibernate.annotations.OrderBy(clause = "marks DESC")
    private List<Integer> marks;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}

