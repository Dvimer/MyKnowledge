package game;

public class Field {
    private String[][] fields;

    public Field(int x) {
        this(x, x);
    }

    public Field(int x, int y) {
        this.fields = new String[x][y];
        initFields();
    }

    public String[][] getFields() {
        return fields;
    }

    public void initFields() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = "*";
            }
        }
    }

    public void printField() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                System.out.print(fields[i][j]);
            }
            System.out.println();
        }
    }

}
