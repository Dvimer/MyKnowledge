package prototype.clonable;

import java.util.Arrays;

public class Person implements Cloneable {
    private String[] names;
    private Adress adress;

    public Person(String[] names, Adress adress) {
        this.names = names;
        this.adress = adress;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return new Person(names.clone(), adress.clone());
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", adress=" + adress +
                '}';
    }
}
