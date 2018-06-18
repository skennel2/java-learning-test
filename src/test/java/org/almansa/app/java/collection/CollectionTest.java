package org.almansa.app.java.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.junit.Test;

public class CollectionTest {
    @Test
    public void 컬렉션의박싱과언박싱() {
        Vector vector = new Vector();
        // 벡터에 기본 타입을 아이템으로 추가한다.
        // 원칙적으로 자바의 모든 컬렉션은 Object만을 item으로 가진다.
        // 기본타입은 Object형이 아니다.
        // 자바 1.5 이하에서는 기본형을 아이템으로 추가하려면 Wrapper 클래스로 박싱해서 사용해야했다. ex) new Long(1)
        // 1.5 이후부터는 기본타입을 인자로 사용해는 것을 허용하며 원리는 자동박싱이다.

        vector.add(1); // 자동 박싱

        int i = (int) vector.get(0); // 언박싱
        assertEquals(1, i);
    }

    @Test
    public void Collection인터페이스의_같은_String_instance처리() {
        String item = "item";
        Collection<String> collection = new ArrayList<>();
        assertEquals(true, collection.isEmpty());

        collection.add(item);
        collection.add(item);

        assertEquals(true, collection.contains("item"));
        assertEquals(2, collection.size());
        
        String next1 = collection.iterator().next();
        String next2 = collection.iterator().next();
        
        assertEquals(true, next1 == next2);
    }

    @Test
    public void Collection인터페이스의_참조타입_참조무결성_확인() {
        Foo item = new Foo(1);
        Collection<Foo> collection = new ArrayList<>();
        assertEquals(true, collection.isEmpty());

        // 아래 둘은 정확히 같은 주소값을 가지고 있을 것이다.
        collection.add(item); 
        collection.add(item);

        assertEquals(true, collection.contains(item));
        assertEquals(2, collection.size());

        item.setValue(3);   
        
        // 당연하지만 참조무결하지 않다.
        for (Iterator<Foo> iterator = collection.iterator(); iterator.hasNext();) {
            Foo foo = (Foo) iterator.next();                        
            
            assertEquals(true, item == foo);
            assertEquals(3, foo.getValue()); 
        }
    }

    @Test
    public void Collection인터페이스_반복자로_접근해서_데이터_변경() {
        Foo item = new Foo(1);
        Collection<Foo> collection = new ArrayList<>();
        assertEquals(true, collection.isEmpty());

        collection.add(item);
        collection.add(item);

        for (Iterator<Foo> iterator = collection.iterator(); iterator.hasNext();) {
            Foo foo = (Foo) iterator.next();
            foo.setValue(3);
        }
        
        for (Iterator<Foo> iterator = collection.iterator(); iterator.hasNext();) {
            Foo foo = (Foo) iterator.next();
            assertEquals(3, foo.getValue());
        }
    }
}
