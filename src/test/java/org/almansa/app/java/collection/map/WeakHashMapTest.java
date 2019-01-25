package org.almansa.app.java.collection.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import org.junit.Test;

public class WeakHashMapTest {

	@Test
	public void weakHashMap() {
		WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
		
		String key1 = new String("key1");

		weakHashMap.put(key1, "entry1");
		
		// WeakHashMap에 넘긴 키값 인스턴스를 가비지컬렉터 대상으로 만든다.
		key1 = new String("key2");
				
		// 가비지컬렉터 대상이 된 키값의 KeyValuePair가 제거 되었다. 
		assertEquals(false, weakHashMap.containsKey(key1));
	}
}
