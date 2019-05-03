package builder.faceted;

import builder.Person;

public class PersonAdressBuilder extends PersonBuilder {
    public PersonAdressBuilder(Person person) {
        this.person = person;
    }

    public PersonAdressBuilder at(String streetAdress) {
        person.setStreetAdress(streetAdress);
        return this;
    }
    public PersonAdressBuilder withPostcode(String postcode) {
        person.setPostcode(postcode);
        return this;
    }
    public PersonAdressBuilder in(String city) {
        person.setCity(city);
        return this;
    }
}
