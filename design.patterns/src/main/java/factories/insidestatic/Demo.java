package factories.insidestatic;

public class Demo {

    public static void main(String[] args) {
        Point cartesian = Point.Factory.newCartesianPoint(10, 10);
        Point polar = Point.Factory.newPolarPoint(10, 10);
    }
}
