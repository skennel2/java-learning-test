package org.almansa.app.java.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

import org.junit.Test;

public class UsingOuterVariableTest {

    @Test
    public void 람다본체에서_사용하는_외부변수는_final이거나_final처럼쓰여야한다() {
        String fruit = "banana";
        Predicate<String> isIgnoreCaseEquals = (a) -> a.equalsIgnoreCase(fruit);

        // 아래 구문의 주석을 풀면 컴파일에러
        // 람다의 바디에서 사용되는 외부 변수는 변경될 수 없다.

        // fruit = "apple";

        boolean isEqual = isIgnoreCaseEquals.test("banana");
        assertEquals(true, isEqual);
    }
    
    @Test
    public void 익명_인스턴스의_경우에도_마찬가지() {
        String fruit = "banana";
        Predicate<String> isIgnoreCaseEquals = new Predicate<String>() {
            
            @Override
            public boolean test(String t) {
                return t.equals(fruit);
            }
        };

        // 아래 구문의 주석을 풀면 컴파일에러
        // 람다의 바디에서 사용되는 외부 변수는 변경될 수 없다.

        //fruit = "apple";

        boolean isEqual = isIgnoreCaseEquals.test("banana");
        assertEquals(true, isEqual);
    }
}
