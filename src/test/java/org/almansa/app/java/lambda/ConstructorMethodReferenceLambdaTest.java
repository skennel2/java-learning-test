package org.almansa.app.java.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import testobject.Fruit;

public class ConstructorMethodReferenceLambdaTest {
	@Test
	public void 생성자_메소드레퍼런스_람다() {
		Supplier<Fruit> fruitMaker = Fruit::new;
		Fruit emptyFruit = fruitMaker.get();

		assertEquals(null, emptyFruit.getName());
	}

	@Test
	public void 테스트_1개의_파라미터를_가지는_생성자_메소드_레퍼런스_람다() {
		Function<String, Fruit> fruitMakerWithName = Fruit::new;

		Fruit apple = fruitMakerWithName.apply("Apple");

		assertEquals("Apple", apple.getName());
	}

	@Test
	public void 테스트_2개의_파라미터를_가지는_생성자_메소드_레퍼런스_람다() {
		BiFunction<String, Long, Fruit> fruitMakerWithName = Fruit::new;

		Fruit apple = fruitMakerWithName.apply("Banana", new Long(2000));

		assertEquals("Banana", apple.getName());
		assertEquals(new Long(2000), apple.getPrice());
	}
}
