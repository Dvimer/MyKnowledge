package prototype.serialization;

import org.apache.commons.lang3.SerializationUtils;

public class DemoFoo {
    public static void main(String[] args) {
        Foo foo1 = new Foo("first","second");
        Foo foo2 = SerializationUtils.roundtrip(foo1);
        foo2.setFirst("four");
        System.out.println(foo1);
        System.out.println(foo2);
    }
}
