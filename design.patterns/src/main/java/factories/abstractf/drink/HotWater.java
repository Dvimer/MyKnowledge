package factories.abstractf.drink;

public class HotWater implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This is hot water");
    }
}
