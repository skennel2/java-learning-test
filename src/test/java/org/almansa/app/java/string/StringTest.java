package org.almansa.app.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTest {
    /**
     * 스트링 리터럴과 인스턴스의 비교
     */
    @Test
    public void String리터럴과_인스턴스() {
        // "" 로 생성한 문자열과 생성자로 생성된 문자열은 존재하는 메모리 공간이 다르다 .
        // "" 로 생성한 문자열은 JVM내의 Method Area라는 곳에 존재하며, 공유된다.
        // 생성자로 생성한 문자열은 힙에서 관리된다.
        String strInstance = new String("1234");
        String strLiteral1 = "1234";
        String strLiteral2 = "1234";
        
        assertEquals(false, strInstance == strLiteral1);
        assertEquals(true, strInstance.equals(strLiteral1));
        
        assertEquals(true, strLiteral2.equals(strLiteral1));
        assertEquals(true, strLiteral2 == strLiteral1);
    }

    @Test
    public void String의_immutable성() {
        String strLiteral1 = "1234";
        String concat = strLiteral1.concat("5678");

        // String의 concat은 실제 인스턴스를 변경하는 것이 아닌 새로운 인스턴스를 반환한다.
        // 이것은 String의 모든 메소드들이 공유하는 메커니즘으로 이러한 특성을 Immutable이라고한다.
        assertEquals(true, "12345678".equals(concat));

        String strLiteral2 = "12345";
        String concat2 = strLiteral2.concat("67890");

        // concat으로 리턴되는 스트링은 리터럴이 아니다. 그냥 새로운 인스턴스를 생성해서 리턴하는 것이다.
        assertEquals(false, concat2 == "1234567890");
    }
    
    @Test
    public void String_Intern() {
        String c = new String("abcd").intern();
        String d = new String("abcd").intern();
        assertEquals(true, c == d);  // 성공한다. 
        assertEquals(true, c.equals(d));   
    }
}
