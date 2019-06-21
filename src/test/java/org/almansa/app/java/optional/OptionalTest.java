package org.almansa.app.java.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void optional생성하기_ofNullable() {
		Optional<String> opt = Optional.ofNullable("abc");

		assertEquals("abc", opt.get());
	}

	@Test(expected = NoSuchElementException.class)
	public void optional생성하기_ofNullable_null_값을_주었을때() {
		Optional<String> opt = Optional.ofNullable(null); // ok

		String value = opt.get(); // NoSuchElementException
	}

	@Test(expected = NullPointerException.class)
	public void optional생성하기_of_null_값을_주었을때() {
		Optional<String> opt = Optional.of(null); // NullPointerException

		String value = opt.get();
	}

	@Test
	public void orElse() {
		Optional<String> value = Optional.ofNullable(null);
		String returned = value.orElse("null");

		assertEquals("null", returned);
	}

	@Test(expected = NullPointerException.class)
	public void orElseThrow() {
		Optional<String> value = Optional.ofNullable(null);
		value.orElseThrow(() -> new NullPointerException());
	}
}