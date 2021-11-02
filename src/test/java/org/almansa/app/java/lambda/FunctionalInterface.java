package org.almansa.app.java.lambda;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class FunctionalInterface {
    @Test
    public void Predicate타입_함수형인터페이스() {
        // 하나의 제네릭을 받아 boolean을 리턴하는 함수
        Predicate<String> isLengthFour = (String str) -> {
            return str.length() == 4;
        };

        assertEquals(true, isLengthFour.test("abcd"));
        assertEquals(false, isLengthFour.test("abcde"));
    }

    @Test
    public void Consumer타입_함수형인터페이스() {
        // 하나의 제네릭을 받아 void 리턴인 함수
        Consumer<String> stringPrinter = (String str) -> {
            System.out.println(str);
        };

        stringPrinter.accept("abcd");
        stringPrinter.accept("abcde");
    }

    @Test
    public void Supplier타입_함수형인터페이스() {
        // 하나의 제네릭을 받아 받은 제네릭타입 리턴인 함수
        Supplier<String> bananaMaker = () -> {
            return "Banana";
        };

        String get = bananaMaker.get();

        assertEquals("Banana", get);
    }

    @Test
    public void Functional타입_함수형인터페이스() {
        // 두개의 제네릭을 받아 첫번째 타입을 인수로 받고, 두번째타입을 리턴하는 함수
        Function<String, Integer> lengthGetter = (String value) -> {
            return value.length();
        };

        assertEquals(new Integer(4), lengthGetter.apply("abcd"));
        assertEquals(new Integer(5), lengthGetter.apply("abcde"));
    }
}
