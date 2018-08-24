package org.almansa.app.java.objectcompare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import testobject.Fruit;
import testobject.ShoppingCart;

public class ObjectCompareTest {
    public void Comparable구현한_클래스() {
        ShoppingCart cart1 = new ShoppingCart(Arrays.asList("coffee", "tooth brush", "heats"));
        ShoppingCart cart2 = new ShoppingCart(Arrays.asList("egg", "butter"));
        
        // 쇼핑카트라는 것만 보고서는 직관적으로 물품 갯수로 비교한다는 걸 알 수 없을 것이다.
        // 그런 의미에서 크기, 질량, 수량등을 나타내는 유형이 아니면  Compareble 구현에는 한계가 있어보인다.  
        int compareResult = cart1.compareTo(cart2);
        
        assertEquals(1, compareResult);
    }
    
    @Test
    public void Comparator로_비교하기() {
        Fruit banana = new Fruit("banana", new Long(5200));
        Fruit apple  = new Fruit("apple", new Long(3000));
        
        // Comparator 클래스의 이름으로 가격으로 비교한다는 것을 명시적으로 표현할 수 있다.
        assertEquals(1, new FruitPriceComparator().compare(banana, apple));
    }
}
