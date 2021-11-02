package org.almansa.app.java.stream.primitive;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.junit.Test;

import testobject.Dish;

public class PrimitiveStream {
    
    @Test
    public void 기본형_특화_스트림생성() {
        int intStream = IntStream.range(1, 100).filter((i) -> i % 2 == 0).sum();
        assertEquals(intStream, 2450);
    }
    
    @Test
    public void 기본형_특화_스트림으로_매핑() {
        List<Dish> list = Arrays.asList(
                new Dish("salad", 100, true), 
                new Dish("cherry", 50, true),
                new Dish("chicken", 1200, false),
                new Dish("tomato pasta", 450, false));
        
        // 기본 특화형 스트림을 사용하지 않았을때. 
        int vegetarianMenuCalories = list.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        
        // 기본 특화형 스트림을 사용했을 때.
        int vegetarianMenuCaloriesUsingPrimitiveStream = list.stream()
                .filter(Dish::isVegetarian)
                .mapToInt(Dish::getCalories) // IntStream 이라는 기본형 특화 스트림을 리턴한다.
                .sum(); // sum, average등의 함수를 제공한다.

        assertEquals(150, vegetarianMenuCalories);
        assertEquals(150, vegetarianMenuCaloriesUsingPrimitiveStream);
    }
    
    @Test
    public void 기본형_Optional() {
        List<Dish> list = new ArrayList<>();
        
        OptionalInt vegetarianMenuCalories = list.stream()
                .filter(Dish::isVegetarian)
                .mapToInt(Dish::getCalories)
                .max(); // OptionalInt를 리턴한다.
        
        // 요소가 비어있는 기본형스트림에 대해  max() 함수가 기본값 0을 리턴했다면
        // 결과값에 대해 오해할 여지가 있다. 그렇기에 기본형 Optional을 제공한다.
        assertEquals(false, vegetarianMenuCalories.isPresent());
    }
}
