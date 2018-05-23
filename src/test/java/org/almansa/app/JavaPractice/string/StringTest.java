package org.almansa.app.JavaPractice.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTest {
    /**
     * 스트링 리터럴과 인스턴스의 비교 
     */
    @Test
    public void testStringliteralAndInstance() {
        String strInstance = new String("1234");
        String strLiteral1 = "1234";
        String strLiteral2 = "1234";
        
        assertEquals(false, strInstance == strLiteral1);
        assertEquals(true, strInstance.equals(strLiteral1));
        // 스프링 리터럴은 JVM 내의 스트링 리터럴 테이블 내의 인스턴스를 공유한다. 
        // 그러므로 아래 테스트는 통과한다. 
        assertEquals(true, strLiteral2.equals(strLiteral1)); 
    }
    
    @Test
    public void testStringIsImmutable() {
        String string = "1234";
        String concat = string.concat("5678");
        
        // String의 concat은 실제 인스턴스를 변경하는 것이 아닌 새로운 인스턴스를 반환한다.
        // 이것은 String의 모든 메소드들이 공유하는 메커니즘으로 이러한 특성을 Immutable이라고한다.
        assertEquals(concat, "12345678");
        
        String string2 = "12345";
        String concat2 = string2.concat("67890");
        
        // concat으로 리턴되는 스트링은 리터럴이 아니다. 그냥 새로운 인스턴스를 생성해서 리턴하는 것이다. 
        assertEquals(false, concat2 == "1234567890");
    }
}
