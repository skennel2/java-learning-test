package org.almansa.app.java.ref;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.ref.WeakReference;

import org.junit.Test;

import testobject.Dish;

public class WeakReferenceTest {

	@Test
	public void weakReferenceTest() {
		Dish dish = new Dish("salad", 100, true);
		
		WeakReference<Dish> weakDish = new WeakReference<Dish>(dish);
		
		dish = null;
		
		System.gc();
		
		assertEquals(null, weakDish.get());
	}
}
