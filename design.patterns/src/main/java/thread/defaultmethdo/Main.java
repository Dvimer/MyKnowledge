package thread.defaultmethdo;

public class Main {
    public static void main(String[] args) {
        ClassDefault classDefault = new ClassDefault() {};
        ClassDefault classDefault2 = new ClassDefault() {
            @Override
            public void metdhod() {
                System.out.println("Class");
            }
        };

        ExtendDefaultClass extendDefaultClass = new ExtendDefaultClass();
        classDefault.metdhod();
        classDefault2.metdhod();
        extendDefaultClass.metdhod();

    }
}
