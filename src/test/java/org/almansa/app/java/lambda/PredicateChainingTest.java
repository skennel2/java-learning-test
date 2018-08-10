package org.almansa.app.java.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

import org.junit.Test;

public class PredicateChainingTest {
	@Test
	public void Predicate_연결하기() {
		Predicate<Fruit> isExpensive = (f) -> f.getPrice().longValue() >= 5000;
		Predicate<Fruit> chaing = isExpensive.and((f) -> f.getName().length() >= 20)
				                             .or((f) -> f.getPrice() <= 1000);

		Fruit fruit = new Fruit("Banana", new Long(1000));

		boolean result = chaing.test(fruit);

		assertEquals(true, result);
	}
}
