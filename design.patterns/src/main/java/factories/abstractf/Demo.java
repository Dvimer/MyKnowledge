package factories.abstractf;

public class Demo {

    public static void main(String[] args) throws Exception {
        HotDrinkMashine hotDrinkMashine = new HotDrinkMashine();
        hotDrinkMashine.makeDrink().consume();
    }
}
