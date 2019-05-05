package factories.abstractf.factory;

import factories.abstractf.drink.HotDrink;
import factories.abstractf.drink.HotWater;

public class WaterDrinkFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("This amount: " + amount +" hot water");
        return new HotWater();
    }
}
