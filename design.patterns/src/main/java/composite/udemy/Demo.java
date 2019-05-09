package composite.udemy;

public class Demo {
    public static void main(String[] args) {
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Square("Yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);

        GraphicObject group2 = new GraphicObject();
        group2.children.add(new Circle("Blue"));
        group2.children.add(new Square("Blue"));
        group.children.get(0).children.add(group2);

        System.out.println(drawing);

    }
}
