package org.almansa.app.java.collection.iterable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class IterableInterfaceTest {
	@Test
	public void 요소를_차례대로_반환하는_Iterable() {
		List<String> list = Arrays.asList("apple", "banana", "grape", "pair", "cherry");

		// Iterable은 자바의 컬렉션들의 root 인터페이스이다.
		Iterable<String> iterable = list;

		// Iterator를 반환하는 iterator()메소드를 노출한다.
		Iterator<String> iterator = iterable.iterator();
		String item1 = iterator.next();
		String item2 = iterator.next();

		assertEquals("apple", item1);
		assertEquals("banana", item2);
	}
}
