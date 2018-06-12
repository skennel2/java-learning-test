package org.almansa.app.java.collection;

import java.util.Vector;

import org.junit.Test;

public class CollectionBasicTest {
    @Test
    public void 컬렉션의박싱과언박싱() {
        Vector vector = new Vector();
        // 벡터에 기본 타입을 아이템으로 추가한다. 
        // 원칙적으로 자바의 모든 컬렉션은 Object만을 item으로 가진다.
        // 기본타입은 Object형이 아니다. 
        // 자바 1.5 이하에서는 기본형을 아이템으로 추가하려면 Wrapper 클래스로 박싱해서 사용해야했다.
        // 1.5 이후부터는 기본타입을  인자로 사용해는 것을 허용하며 원리는 자동박싱이다. 
        vector.add(1); // 자동 박싱
        
        int i = (int) vector.get(0); // 자동 언박싱 
    }
}
