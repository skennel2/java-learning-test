package org.almansa.app.java.stream.reduce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.junit.Test;

import testobject.Dish;

public class ReduceTest {
    @Test
    public void reduce로_합산하기_초기값부여() {
        List<String> list = Arrays.asList("apple", "banana", "grape", "pair", "cherry");

        Integer lengthFiveSum = list.stream().filter(f -> f.length() == 5)
                                             .map((p) -> p.length()).reduce(0, (a, b) -> a + b); // 0으로 초기값 부여

        assertEquals(new Integer(10), lengthFiveSum);
    }

    @Test
    public void reduce로_초기값없이_합산하기() {
        List<String> list = Arrays.asList("apple", "banana", "grape", "pair", "cherry");

        Optional<Integer> lengthFiveSum = list.stream().filter(f -> f.length() == 5)
                                                       .map((p) -> p.length())
                                                       .reduce((a, b) -> a + b); // 초기값을 부여하지 않으면, 요소가 아예 없을수도 있으니 Optional로 리턴한다.

        assertEquals(new Integer(10), lengthFiveSum.get());
    }
    
    @Test
    public void reduce로_합산하기_함수레퍼런스이용() {
        List<Dish> list = Arrays.asList(
                new Dish("salad", 100, true), 
                new Dish("cherry", 50, true),
                new Dish("chicken", 1200, false),
                new Dish("tomato pasta", 450, false));

        int vegetarianMenuCalories = list.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getCalories)
                .reduce(0, Integer::sum); // Integer 클래스에 다양한 함수형 정적 메소드를 제공한다.

        assertEquals(150, vegetarianMenuCalories);
    }
    
}
