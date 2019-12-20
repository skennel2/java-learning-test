package org.almansa.app.java.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

import testobject.Foo;

public class CollectionInterfaceTest {
	@Test
	public void 컬렉션의박싱과_언박싱() {
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
	public void Collection의_슈퍼타입() {
		Collection<String> collection = new ArrayList<>();
		collection.add("Hello"); // 요소추가
		collection.add("World"); // 요소추가

		// Iterable -> Collection
		Iterable<String> iterable = collection;

		Iterator<String> iterator = iterable.iterator();
		String next1 = iterator.next();
		String next2 = iterator.next();
		
		assertEquals("Hello", next1);
		assertEquals("Hello", next2);
	}

	@Test
	public void Collection의_메소드() {
		Collection<String> collection = new ArrayList<>();
		collection.add("Hello"); // 요소추가
		collection.add("World"); // 요소추가
		collection.remove("Hello"); // 요소제거
		assertEquals(1, collection.size());
	}

	@Test
	public void Collection의_메소드_removeIf() {
		Collection<String> collection = new ArrayList<>();
		collection.add("Hello");
		collection.add("World");
		collection.add("Hello~!");
		collection.add("World~!");

		collection.removeIf((String value) -> value.length() > 5);

		assertEquals(2, collection.size());
	}

	@Test
	public void Collection_인터페이스의_같은_String_instance처리() {
		String item = "item";

		// Collection은 기본적으로 중복을 허용한다.
		Collection<String> collection = new ArrayList<>();
		collection.add(item);
		collection.add(item);

		assertEquals(true, collection.contains("item"));
		assertEquals(2, collection.size());

		String next1 = collection.iterator().next();
		String next2 = collection.iterator().next();

		// 콜렉션에 같은 참조값을 여러개 담고 있다.
		assertEquals(true, next1 == next2);
		
		// remove시 해당하는 모든 엘리먼트를 제거하지 않는다. 
		// 검색되는 첫번째것만 제거하는듯 하다.
		collection.remove(item);
		
		assertEquals(1, collection.size());
	}

	@Test
	public void Collection인터페이스의_참조타입_참조무결성_확인() {
		Collection<Foo> collection = new ArrayList<>();

		Foo item = new Foo(1);
		// 아래 둘은 정확히 같은 주소값을 가지고 있을 것이다.
		collection.add(item);
		collection.add(item);

		assertEquals(true, collection.contains(item));
		assertEquals(2, collection.size());

		// 값 변경
		item.setValue(3);

		// 당연하지만 참조무결하지 않다.
		for (Iterator<Foo> iterator = collection.iterator(); iterator.hasNext();) {
			Foo foo = (Foo) iterator.next();

			assertEquals(true, item == foo);
			assertEquals(3, foo.getValue());
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void 수정불가_리스트만들기() {
		Collection<String> collection = new ArrayList<>();
		collection.add("black");
		collection.add("green");

		Collection<String> readOnlyCollection = Collections.unmodifiableCollection(collection);

		// 수정은 지원하지 않는다.
		readOnlyCollection.add("pink");
	}
}
