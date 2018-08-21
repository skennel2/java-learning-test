package org.almansa.app.java.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.Vector;

import org.junit.Test;

public class ListTest {
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
    public void ArrayList의_슈퍼타입() {
        ArrayList<String> arrayList = new ArrayList<>();
        
        assertEquals(true, arrayList instanceof AbstractList);
        assertEquals(true, arrayList instanceof RandomAccess); // AbstractList 에서 구현
        assertEquals(true, arrayList instanceof List); // AbstractList에서 구현
        assertEquals(true, arrayList instanceof AbstractCollection); // AbstractList에서 상속
        assertEquals(true, arrayList instanceof Collection); // AbstractCollection에서 구현
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
    public void LinkedList_속도확인() {
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(new Integer(i).toString());
        }

        linkedList.get(50000);
    }

    @Test
    public void ArrayList_속도확인() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(new Integer(i).toString());
        }

        arrayList.get(50000);
    }
}
