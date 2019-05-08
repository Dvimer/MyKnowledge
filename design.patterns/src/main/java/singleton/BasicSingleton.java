package singleton;

public class BasicSingleton {
    private String value;
    public static final BasicSingleton INSTANCE = new BasicSingleton();

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
