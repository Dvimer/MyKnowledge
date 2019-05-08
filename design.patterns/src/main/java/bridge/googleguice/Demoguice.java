package bridge.googleguice;

import bridge.simplebridge.Circle;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Demoguice {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle circle = injector.getInstance(Circle.class);
        circle.setRadius(3);
        circle.draw();
        circle.resize(0.2f);
        circle.draw();
    }
}
