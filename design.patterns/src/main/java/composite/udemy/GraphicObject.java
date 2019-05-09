package composite.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicObject {
    protected String name = "Group";
    protected String color;
    public List<GraphicObject> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        print(stringBuilder, 1);
        return stringBuilder.toString();
    }

    private void print(StringBuilder stringBuilder, int dept) {
        stringBuilder.append(String.join("", Collections.nCopies(dept, " *")))
                .append(dept > 0 ? " " : "")
                .append((color == null || color.isEmpty()) ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());
        for (GraphicObject child : children) {
            child.print(stringBuilder, dept + 1);
        }
    }
}
