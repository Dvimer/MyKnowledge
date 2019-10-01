package thread.defaultmethdo;

public interface ClassDefault {
    default void metdhod(){
        System.out.println(getClass().getName());
    }
}
