package builder;

public class DemoPersonBuilder {

    public static void main(String[] args) {
        EmployeeBuilder personBuilder = new EmployeeBuilder();
        Person person = personBuilder
                .withName("Aleksey")
                .worksAt("Moskow")
                .buildPerson();
    }
}
