package org.almansa.app.java.stream.collect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamCollectTest {

	@Test
	public void 내장_Collector_toList() {
		List<String> list = Arrays.asList("apple", "banana", "grape", "pair", "cherry");

		List<String> fiveCharacterFruit = list.stream()
				                              .filter(f -> f.length() == 5)
				                              .collect(Collectors.toList());
		assertEquals(2, fiveCharacterFruit.size());
	}

	@Test
	public void 내장_Collector_averagingInt() {
		List<String> list = Arrays.asList("apple", "banana", "grape", "pair");

		Double fiveCharacterFruit = list.stream()
				                        .collect(Collectors.averagingInt(f -> f.length()));
		assertEquals(new Double(5), fiveCharacterFruit);
	}
}
