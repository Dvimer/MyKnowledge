package prototype.serialization;

import java.io.Serializable;

public class Foo implements Serializable {
    private String first,second;

    public Foo(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
