package factories.abstractf.factory;

import factories.abstractf.drink.HotDrink;

public interface HotDrinkFactory {
    HotDrink prepare(int amount);
}
