package factories.abstractf.factory;

import factories.abstractf.drink.Coffee;
import factories.abstractf.drink.HotDrink;

public class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pour, " + amount + "ml, add cream and sugar, enjoy!");
        return new Coffee();
    }
}
