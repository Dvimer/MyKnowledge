package builder.faceted;

import builder.Person;

public class PersonBuilder {
    protected Person person = new Person();

    public PersonAdressBuilder lives(){
        return new PersonAdressBuilder(person);
    }
    public PersonJobBuilder work(){
        return new PersonJobBuilder(person);
    }
    public Person build() {
        return person;
    }
}
