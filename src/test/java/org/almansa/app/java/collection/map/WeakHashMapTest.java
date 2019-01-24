package org.almansa.app.java.collection.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import org.junit.Test;

public class WeakHashMapTest {

	@Test
	public void weakHashMap() {
		WeakHashMap<WeakReference<String>, String> weakHashMap = new WeakHashMap<>();
		
		String key1S = new String("key1");
		WeakReference<String> key1 = new WeakReference<String>(key1S);
		
		weakHashMap.put(key1, "entry1");
		
		key1 = null;
		
		assertEquals(false, weakHashMap.containsKey(key1));
	}
}
