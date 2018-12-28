package org.almansa.app.java.collection.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import testobject.Dish;

public class SortedMapInterfaceTest {
	@Test
	public void SortedMap인터페이스_특성() {
		SortedMap<Integer, String> map = new TreeMap<>();
		map.put(new Integer(100), "putted 1");
		map.put(new Integer(1), "putted 2");
		map.put(new Integer(1000), "putted 3");

		Iterator<Integer> keySet = map.keySet().iterator();

		Integer firstKey = keySet.next();
		assertEquals(new Integer(1), firstKey);

		Integer nextKey = keySet.next();
		assertEquals(new Integer(100), nextKey);
	}

	@Test
	public void SortedMap인터페이스_subMap() {
		SortedMap<Integer, String> map = new TreeMap<>();
		map.put(new Integer(1), "1");
		map.put(new Integer(2), "2");
		map.put(new Integer(3), "3");
		map.put(new Integer(4), "4");
		map.put(new Integer(5), "5");
		map.put(new Integer(6), "6");

		// 2 ~ 5번까지의 키값에 대한 SortMap을 리턴한다.
		SortedMap<Integer, String> subMap = map.subMap(new Integer(2), new Integer(5));

		Iterator<Integer> keyset = subMap.keySet().iterator();

		Integer firstKey = keyset.next();
		assertEquals(new Integer(2), firstKey);

		Integer nextKey = keyset.next();
		assertEquals(new Integer(3), nextKey);

		Integer lastKey = keyset.next();
		assertEquals(new Integer(4), lastKey);
	}

	@Test
	public void SortedMap인터페이스_subMap_카피여부_확인() {
		SortedMap<Integer, String> mainMap = new TreeMap<>();
		mainMap.put(new Integer(1), "1");
		mainMap.put(new Integer(2), "2");
		mainMap.put(new Integer(3), "3");
		mainMap.put(new Integer(4), "4");
		mainMap.put(new Integer(5), "5");
		mainMap.put(new Integer(6), "6");

		// 2 ~ 5번까지의 키값에 대한 SortMap을 리턴한다.
		SortedMap<Integer, String> subMap = mainMap.subMap(new Integer(2), new Integer(5));

		// 서브맵의 데이터를 변경하면, 본 맵의 데이터도 변경되는가?
		subMap.put(new Integer(2), "Two");
		String value = mainMap.get(new Integer(2));

		// 변경된다. subMap은 일종의 마스킹 맵을 리턴하는 것이다.
		assertEquals("Two", value);
	}

	@Test
	public void SortedMap인터페이스_tailMap() {
		SortedMap<Integer, String> map = new TreeMap<>();
		map.put(new Integer(1), "1");
		map.put(new Integer(2), "2");
		map.put(new Integer(3), "3");
		map.put(new Integer(4), "4");
		map.put(new Integer(5), "5");
		map.put(new Integer(6), "6");

		// 4번부터 마지막 키값까지의 SortMap을 리턴한다.
		// 나머지 특성은 subMap과 같다.
		SortedMap<Integer, String> subMap = map.tailMap(new Integer(4));

		Iterator<Integer> keyset = subMap.keySet().iterator();

		Integer firstKey = keyset.next();
		assertEquals(new Integer(4), firstKey);

		Integer nextKey = keyset.next();
		assertEquals(new Integer(5), nextKey);

		Integer lastKey = keyset.next();
		assertEquals(new Integer(6), lastKey);
	}

	@Test
	public void SortedMap인터페이스_생성자() {
		// 일반적인 목적의 SortedMap의 구현체는4가지의 생성자를 구현해야한다.(파라미터없는 생성자 포함)
		// 다음은 그 중 하나로 Comparator를 인자로 받는 것으로 key에 대한 정렬의 기준이 된다.
		// 다음 맵은 Dish메소드의 Calorie로 크기를 비교하게 된다.
		SortedMap<Dish, String> map = new TreeMap<>(new Comparator<Dish>() {
			@Override
			public int compare(Dish dish1, Dish dish2) {
				return new Integer(dish1.getCalories()).compareTo(new Integer(dish2.getCalories()));
			}
		});
	}

	@Test(expected = ClassCastException.class)
	public void SortedMap인터페이스_비교불가능한_키() {
		// Dish는 Compareble을 구현하지도 않았고, 생성자로 Comparator를 알려주지도 않았다.
		// 이럴경우 Item을 Put하는 시점에 ClassCastException을 뱉는다.
		SortedMap<Dish, String> map = new TreeMap<>();
		map.put(new Dish("dish1", 200, true), "123");
		map.put(new Dish("dish2", 200, true), "abc");
		map.put(new Dish("dish3", 200, true), "!!!");
	}
}
