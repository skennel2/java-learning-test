package org.almansa.app.java.collection.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

public class SortedMapInterface {
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
		SortedMap<Integer, String> subMap = map.subMap(new Integer(2), new Integer(5));
		
		Iterator<Integer> keyset = subMap.keySet().iterator();
		
		Integer firstKey = keyset.next();
		assertEquals(new Integer(2), firstKey);
		
		Integer nextKey = keyset.next();
		assertEquals(new Integer(3), nextKey);	
		
		Integer lastKey = keyset.next();
		assertEquals(new Integer(4), lastKey);	
	}
}
