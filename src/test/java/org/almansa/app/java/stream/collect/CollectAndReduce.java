package org.almansa.app.java.stream.collect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import testobject.Dish;
import testobject.TestObjectFactory;

public class CollectAndReduce {
    @Test
    public void test() {
        List<Dish> list = TestObjectFactory.getDishList();
        
        // Collectors.reducing으로 합계 구현
        int calorieSumUsingCollect = list.stream()
                .collect(Collectors.reducing(
                        0, // 초기값
                        Dish::getCalories, // 매핑함수
                        Integer::sum)); // 집계함수
        
        int calorieSumUsingReduce = list.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        
        assertEquals(calorieSumUsingCollect, calorieSumUsingReduce);
    }
}
