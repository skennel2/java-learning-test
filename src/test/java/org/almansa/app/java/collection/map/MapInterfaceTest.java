package org.almansa.app.java.collection.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.junit.Test;

public class MapInterfaceTest {

	@Test
	public void Map인터페이스_특성() {
		// 키를 값에 매핑하는 객체. 
		// 중복 키가 포함될 수 없다. 
		// 각 키는 최대 하나의 값으로만 매핑할 수 있다. 
		Map<String, String> map = new HashMap<>();		
		map.put("key", "value");
		
		String value = map.get("key");
		
		assertEquals("value", value);
	}
	
	@Test
	public void Map인터페이스_계층() {
		Map<String, String> map = new HashMap<>();		
		
		// Map은 Iterable, Collection의 하위 타입이 아니다. 
		//Collection collection = map;	
	}
	
	@Test
	public void Map인터페이스_키값가져오기() {
		Map<String, String> map = new HashMap<>();		
		map.put("key1", "value");
		map.put("key2", "value2");
		
		Set<String> keySet = map.keySet();
		Iterator<String> ketSetIterator = keySet.iterator();
		
		String key1 = ketSetIterator.next();
		assertEquals("key1", key1);
		
		String key2 = ketSetIterator.next();
		assertEquals("key2", key2);
	}
	
	@Test
	public void Map인터페이스_만약에_중복키가_입력된다면() {
		Map<String, String> map = new HashMap<>();		
		map.put("key", "value");				
		String beforeValue = map.put("key", "value2"); // 특별한 Exception이 발생하지는 않는다. 						
		
		assertEquals("value", beforeValue); // 덮어씌워지기 전 값을 리턴한다. 
		
		String value = map.get("key"); 			
		assertEquals("value2", value); // 키에 대한 값이 덮어씌워졌다.
	}
	
	@Test
	public void Map인터페이스_getOrDefault() {
		Map<String, String> map = new HashMap<>();		
		map.put("key", "value");				
		map.put("key2", "value2"); 				
				
		// key값을 찾아서 존재하면 그 값을 리턴
		String value = map.getOrDefault("key", "value3");		
		assertEquals("value", value); 
		
		// 없으면 두번째 매개변수값을 리턴
		String value2 = map.getOrDefault("key3", "value3");		
		assertEquals("value3", value2); 
	}
	
	@Test
	public void Map인터페이스_putIfAbsent() {
		Map<String, String> map = new HashMap<>();		
		map.put("key", "value");				
		map.put("key2", "value2"); 				

		String putIfAbsent = map.putIfAbsent("key2", "value3");
		
		assertEquals("value2", putIfAbsent);		
		
		// put과 다르게 값을 덮어쓰지 않았다. 
		assertEquals("value2", map.get("key2"));
	}
	

}
