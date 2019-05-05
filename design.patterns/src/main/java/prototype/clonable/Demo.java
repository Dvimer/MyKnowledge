package prototype.clonable;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person john = new Person(new String[]{"John", "Smith"}, new Adress("London Road", 123));
        Person jane = john.clone();
        jane.getAdress().setHouseNumber(111);
        jane.getNames()[0] = "Jane";
        jane.getAdress().setStreetName("Road middle");

        System.out.println(john);
        System.out.println(jane);
    }
}
