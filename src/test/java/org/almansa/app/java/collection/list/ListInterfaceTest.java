package org.almansa.app.java.collection.list;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.Vector;

import org.junit.Test;

/**
 * 참고한 자료
 * https://www.programcreek.com/2013/03/arraylist-vs-linkedlist-vs-vector/
 */
public class ListInterfaceTest {
    @Test
    public void List인터페이스의_구현체종류() {
        // 요소들의 순서를 저장하여 색인(Index)를 사용하여 특정 위치에 요소를 삽입하거나 접근할 수 있으며 중복 요소 허용

        List<String> linkedList = new LinkedList<>();
        List<String> stack = new Stack<>();
        List<String> vector = new Vector<>();
        List<String> arrayList = new ArrayList<>();

        assertEquals(true, linkedList instanceof List);
        assertEquals(true, stack instanceof List);
        assertEquals(true, vector instanceof List);
        assertEquals(true, arrayList instanceof List);
    }

    @Test
    public void List인터페이스의_메소드() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");

        // List의 get 메소드, 인덱스로 접근한다.
        String getValue = arrayList.get(0);

        assertEquals("Hello", getValue);
    }

    @Test
    public void List는_중복을_허용한다() {
        // 자바 Collection API에 중복을 허용하지 않는 List 구현체는 따로 제공해주지 않는것 같다.
        String value = new String("Hi");

        List<String> arrayList = new ArrayList<>();
        arrayList.add(value);
        arrayList.add(value);

        assertEquals(2, arrayList.size());
    }

    @Test
    public void ArrayList의_ensureCapacity() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.trimToSize();
        assertEquals(2, arrayList.size());

        // ArrayList 의 인스턴스의 사이즈를 확대한다.
        // 내부 버퍼의 사이즈를 증가시킬뿐, 리스트의 논리적 크기를 증가시키지는 않는다.
        arrayList.ensureCapacity(5);

        assertEquals(2, arrayList.size());
    }

    @Test
    public void Vector의_trimToSize() {
        Vector<String> vector = new Vector<>();
        vector.add("111");
        vector.add("222");
        vector.add("222");

        // 생성자로 기본 크기를 지정해주지 않으면 10의 수용량을 가지는 것을 알 수 있다.        
        assertEquals(10, vector.capacity());

        vector.trimToSize();

        // trimToSize로 수용량과 실제 크기를 동일하게 맞춰준다.
        assertEquals(3, vector.capacity());
        
        // # Vector는 매번 배열 크기를 2배로 늘리는데 반해 
        // ArrayList는 50%만 늘린다. 
        // 둘은 거의 동일하지만 Vector는 동기화 된다는 차이가 있다.
        // 일반적으로 대부분의 자바 프로그래머는 명시 적으로 자체적으로 동기화 할 수 있기 때문에 Vector대신 ArrayList를 사용한다.
    }

    @Test
    public void ArrayList의_슈퍼타입() {
        ArrayList<String> arrayList = new ArrayList<>();

        assertEquals(true, arrayList instanceof AbstractList);
        assertEquals(true, arrayList instanceof RandomAccess); 
        assertEquals(true, arrayList instanceof List); 
        assertEquals(true, arrayList instanceof AbstractCollection); 
        assertEquals(true, arrayList instanceof Collection);
        assertEquals(true, arrayList instanceof Iterable);
    }

    @Test
    public void ArrayList의_슈퍼타입_RandomAccess() {
        // RandomAccess 마커인터페이스, Random Access를 지원한다는 의미이다
        // 모든 개별의 엘리먼트에 접근하는데 동일한 시간이 걸림을 의미한다.
        // ArrayList는 요소들이 순차적으로 저장되어 있어도 순차적으로 액세스할 필요가 없다.
        RandomAccess arrayList = new ArrayList<>();
    }

    @Test
    public void 동기화_리스트() {
        // ArrayList는 동기화되지 않는다.
        // 구조적 변경에 대해서는 외부에서 동기화될 필요가 있다.
        // 구조적 변경은 요소 에 값 추가, 삭제하는 작업이다. 요소의 변경은 해당되지 않는다.
        List<String> arrayList = new ArrayList<>();

        List<String> synchronizedList = Collections.synchronizedList(arrayList);
        
        //TODO 동기화 테스트 작성 
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator의_동시변경_방어() {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");

        Iterator<String> a = arrayList.iterator();
        // 문제 코드 
        // iterator가 생성된 이후 리스트가 구조적으로 변경되면 바로 예외를 던저버린다.  
        arrayList.add("B"); 

        // ConcurrentModificationException 발생 
        String value = a.next();              
    }
    
    @Test()
    public void iterator의_동시변경_구조적_변경에_대해() {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");

        Iterator<String> a = arrayList.iterator();
        // 이작업은  구조적 변경이 아니기 때문에 ConcurrentModificationException 예외가 던져지지 않는다.
        arrayList.set(0, "B"); 
        
        String value = a.next();
        a.remove();
        
        assertEquals("B", value);
        assertEquals(0, arrayList.size());
    }

    @Test
    public void 잘못된_특정요소_제거() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        
        // 원소가 삭제될 때, list의 사이즈가 줄어들면서 다른 원소들의 index도 바뀌어 버린다.
        for (int i = 0; i < list.size(); i++) {
            list.remove(i); 
        }
        
        // 0이 아닌 2가 리턴되는것을 볼 수 있다. 
        assertEquals(2, list.size()); 
    }
    
    @Test(expected = ConcurrentModificationException.class)
    public void 잘못된_특정요소_제거2() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));        
        
        // 기본적으로 foreach 구문은 Iterator를 활용한다.
        for (String s : list) {
            if (s.equals("a")) {
                list.remove(s);
            }                
        }
    }
        
    @Test
    public void 올바르게_특정요소를_제거하는_방법() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iter = list.iterator();
        
        while (iter.hasNext()) {
            String str = iter.next();
         
            if (str.equals("a")) {
                iter.remove();
            }
        }
        
        assertEquals(3, list.size());
        assertEquals(false, list.contains("a"));
    }   
    
    @Test
    public void list의_동등성() {
		String str1 = new String("1234");
		String str2 = new String("1234");

		List<String> arrayList1 = new ArrayList<>();
		arrayList1.add(str1);
		
		List<String> arrayList2 = new ArrayList<>();
		arrayList2.add(str2);
		
		// 두 요소들이 가지고 있는 아이템의 순서와 요소가 equals()를 만족한다면 같다고 보는듯하다.
		assertEquals(arrayList1, arrayList2);
				
		arrayList2.remove(0);		
		assertNotEquals(arrayList1, arrayList2);
		
		List<String> linkedList1 = new LinkedList<>();
		linkedList1.add(str1);
		
		List<String> linkedList2 = new LinkedList<>();
		linkedList2.add(str2);
		
		assertEquals(linkedList1, linkedList2);		
    }
}
