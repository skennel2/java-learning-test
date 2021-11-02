package org.almansa.app.java.collection.list;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class CopyOnWriteArrayListTest {

	@Test
	public void copyOnWriteArrayListTest() {
		// CopyOnWriteArrayList는 기본 목록이 수정 된 경우에도 요소를 안전하게 반복 할 수 있도록하기 위해 만들어졌다.
		// add, remove 같은 수정 메소드를 사용하는 경우 CopyOnWriteArrayList의 전체 내용이 새 내부 사본에 복사된다.
		// 때문에 동시 수정이 발생하는 경우에도 안전한 방법으로 목록을 반복 할 수 있다.
		// iterator () 메서드를 호출하면 CopyOnWriteArrayList 내용의 불변 스냅 샷으로 백업 된 반복자가 반환된다.
		// 데이터를 자주 수정해야하는 작업에서는 사용하지 않는것이 좋다.
		List<Integer> list = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });
		Iterator<Integer> iter = list.iterator();

		// ArrayList와는 다르게 ConcurrentModificationException을 던지지 않는다.
		list.add(10);

		// 하지만 iterator에서는 10이 존재하지 않는다.
		while (iter.hasNext()) {
			assertEquals(false, iter.next().equals(10));
		}
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void whenIterateOverItAndTryToRemoveElement_thenShouldThrowException() {
	     
	    CopyOnWriteArrayList<Integer> numbers
	      = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
	 
	    Iterator<Integer> iterator = numbers.iterator();
	    while (iterator.hasNext()) {
	        iterator.remove();
	    }
	}
}
