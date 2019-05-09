package composite.youtube;

import java.util.ArrayList;
import java.util.List;

public class CompositApp {
    public static void main(String[] args) {
        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        Triangle triangle = new Triangle();
        Circle circle = new Circle();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        Square square = new Square();
        Square square1 = new Square();
        Square square2 = new Square();

       composite1.addComponent(triangle);
       composite1.addComponent(circle);
       composite1.addComponent(square);

       composite2.addComponent(circle1);
       composite2.addComponent(circle2);
       composite2.addComponent(square1);

       composite.addComponent(composite1);
       composite.addComponent(composite2);
       composite.addComponent(square2);

        composite.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello i " + Square.class.getSimpleName());
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello i " + Circle.class.getSimpleName());
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Hello i " + Triangle.class.getSimpleName());
    }
}

class Composite implements Shape {

    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}
