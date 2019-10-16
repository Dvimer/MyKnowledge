import entities.*;
import enums.Days;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session currentSession = factory.openSession();
            currentSession.beginTransaction();
            Person person = new Person();
            person.setName("Alex");
            HomeAddress homeAddress = new HomeAddress();
            homeAddress.setStreet("Porf");
            person.setHomeAddress(homeAddress);
            homeAddress.setPerson(person);
//            Student max = new Student("Max", 19);
//            max.setDays(Days.FOUR);
//            max.setAdress(new Adress("Proff", 121));
//            currentSession.save(max);
            Book book = new Book("Garri","Roaling");
            book.setPerson(person);
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(1);
            marks.add(5);
            marks.add(4);
            marks.add(3);
            person.setMarks(marks);
            currentSession.persist(book);
            currentSession.persist(homeAddress);
            currentSession.persist(person);
            currentSession.getTransaction().commit();
        }
    }
}
