package org.almansa.app.java.stream.collect;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import testobject.Dish;
import testobject.TestObjectFactory;

public class StreamCollectTest {
    
    @Test
    public void 내장_Collector_toList() {
        List<String> list = Arrays.asList("apple", "banana", "grape", "pair", "cherry");

        List<String> fiveCharacterFruit = list.stream()
                .filter(f -> f.length() == 5)
                .collect(Collectors.toList());
        assertEquals(2, fiveCharacterFruit.size());
    }

    @Test
    public void 내장_Collector_averagingInt() {
        List<String> list = Arrays.asList("apple", "banana", "grape", "pair");

        Double fiveCharacterFruit = list.stream()
                .collect(Collectors.averagingInt(f -> f.length()));
        assertEquals(new Double(5), fiveCharacterFruit);
    }
    
    @Test
    public void 내장_Collector_grouping() {
        List<Dish> list = TestObjectFactory.getDishList();
        Map<Boolean, List<Dish>> groupByCalorieOver1000 = list.stream()
                .collect(Collectors.groupingBy((d)->{
                    Dish dish = (Dish)d;
                    return dish.getCalories() >= 1000;
                }));

        for (Dish item : groupByCalorieOver1000.get(true)) {
            assertEquals(true, item.getCalories() >= 1000);
        }

        for (Dish item : groupByCalorieOver1000.get(false)) {
            assertEquals(true, item.getCalories() < 1000);
        }    
    }
    
    @Test
    public void 내장_Collector_grouping_and_summing() {
        List<Dish> list = TestObjectFactory.getDishList();
        Map<Boolean, Integer> map = list.stream().collect(Collectors.groupingBy(
                Dish::isVegetarian,
                Collectors.summingInt(Dish::getCalories)));
        
        map.keySet().forEach((isVegetarian)->{
            if(isVegetarian) {
                System.out.println("Vegetarian");
            }else {
                System.out.println("Not Vegetarian");
            }
            System.out.println(map.get(isVegetarian));
        });
    }
    
    @Test
    public void 내장_Collector_toMap() {
        List<Dish> list = TestObjectFactory.getDishList();
        Map<String, Integer> dishCaloriesByName =
                list.stream()
                .collect(Collectors.toMap(Dish::getName, (dish)->dish.getCalories()));
        
        dishCaloriesByName.keySet()
            .stream()
            .forEach((dishName)->{
                Integer calrories = dishCaloriesByName.get(dishName);
                System.out.println(calrories);
            });
    }
    
    @Test
    public void 내장_Collector_joining() {
        List<Dish> list = TestObjectFactory.getDishList();
        String nameJoining = list.stream().map(Dish::getName)
                .collect(Collectors.joining(", "));

        System.out.println(nameJoining); 
    }
    
    @Test
    public void 내장_Collector_maxBy() {
        List<Dish> list = TestObjectFactory.getDishList();
        list.stream().collect(Collectors.maxBy((Dish a, Dish b)->{
            return a.getCalories() - b.getCalories();
        })).ifPresent((a)->{
            System.out.println(a.getName());
        });       
    }
    
}
