package org.almansa.app.java.collection.map;

import static org.junit.Assert.assertEquals;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import org.junit.Test;

public class WeakHashMapTest {

	/**
	 * 약한 레퍼런스를 키값으로 가지는 해시맵
	 * Entry가 WeakReference<Object>를 상속한 형태이다. 	 
	 */
	@Test
	public void weakHashMap() {
		WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
		
		String key1 = new String("key1");

		weakHashMap.put(key1, "value1");
		
		// WeakHashMap에 넘긴 키값 인스턴스를 가비지컬렉터 대상으로 만든다.
		key1 = new String("key2");
				
		// 외부에서 가비지컬렉터 대상이 된 키값의 Entry가 자동으로 제거 되었다. 
		assertEquals(false, weakHashMap.containsKey(key1));
	}
}
