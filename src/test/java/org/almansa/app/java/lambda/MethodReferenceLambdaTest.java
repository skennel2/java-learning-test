package org.almansa.app.java.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

import org.junit.Test;

public class MethodReferenceLambdaTest {

    @Test
    public void Predicate타입_메소드레퍼런스() {
        Predicate<Fruit> isOrganic = Fruit::getIsOrganic;

        Fruit banana = new Fruit("Banana", new Long(2000));
        banana.setIsOrganic(true);

        assertEquals(true, isOrganic.test(banana));
    }

}
