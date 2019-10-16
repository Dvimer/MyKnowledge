package entities;

import enums.Days;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity()
public class Student {

    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Days days;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date date;
    @EmbeddedId
    private Adress adress;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", days=" + days +
                ", date=" + date +
                ", adress=" + adress +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                days == student.days &&
                Objects.equals(date, student.date) &&
                Objects.equals(adress, student.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, days, date, adress);
    }
}
