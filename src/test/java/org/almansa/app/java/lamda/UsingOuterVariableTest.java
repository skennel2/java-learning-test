package org.almansa.app.java.lamda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

import org.junit.Test;

public class UsingOuterVariableTest {

    @Test
    public void 람다본체에서_사용하는_외부변수는_final이거나_final처럼쓰여야한다() {
        String fruit = "banana";
        Predicate<String> isIgnoreCaseEquals = (a)-> a.equalsIgnoreCase(fruit);
        
        // 아래 구문의 주석을 풀면 컴파일에러 
        // fruit = "apple";
        boolean isEqual = isIgnoreCaseEquals.test("banana");
        assertEquals(true, isEqual); 
    }
}
