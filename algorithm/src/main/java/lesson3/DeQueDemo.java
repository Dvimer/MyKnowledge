package lesson3;

public class DeQueDemo {
    public static void main(String[] args) {
        DeQue deQue = new DeQue(10);

        deQue.insertRight(1);
        deQue.insertRight(2);
        deQue.insertRight(3);
        deQue.insertRight(4);

        while (!deQue.isEmpty()){
            System.out.println(deQue.removeLeft());
        }
    }
}
