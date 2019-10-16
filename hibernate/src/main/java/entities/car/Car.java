package entities.car;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String number;
}
