package builder.faceted;

import builder.Person;

public class DemoFacetedBuilder {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder
                .lives().at("Russian street")
                .in("Moskow")
                .withPostcode("121212")
                .work().asA("current")
                .at("sberko")
                .earning(12222).build();
        System.out.println(person);
    }
}
