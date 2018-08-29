package testobject;

import java.util.Arrays;
import java.util.List;

public abstract class TestObjectFactory {
    static public List<Dish> getDishList(){
        List<Dish> list = Arrays.asList(
                new Dish("salad", 100, true), 
                new Dish("cherry cup", 50, true),
                new Dish("fied chicken", 1200, false),
                new Dish("cheese pizza", 1450, false),
                new Dish("ramen", 350, false),
                new Dish("seafood noodle", 650, false),
                new Dish("t born steak", 1350, false),
                new Dish("bean meal steak", 400, true),
                new Dish("rice noodle", 200, true));
        
        return list;
    }
}
