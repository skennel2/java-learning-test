package org.almansa.app.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * StringBuffer는 Thread Safe StringBuilder는 Thread Unsafe
 *
 */
public class StringBufferAndBuilderTest {
	@Test
	public void appendBoolean() {
		StringBuffer appendBoolean = new StringBuffer();
		appendBoolean.append(true);
				
		assertEquals("true", String.valueOf(true));
		assertEquals("true", appendBoolean.toString());
	}
	
	@Test
	public void capacity변경테스트() {
		StringBuffer buffer = new StringBuffer();
		
		// 초기 수용량 16
		assertEquals(16, buffer.capacity());
		
		
		String data = "aaaaaaaaaaaaaaaaaaaa";
		assertEquals(20, data.length());
		
		// 수용량 초과데이터 append
		buffer.append(data);
		
		// capcity가 18이 늘었다.
		assertEquals(34, buffer.capacity());
				
		// capacity가 36이 늘었다.
		buffer.append(data);
		assertEquals(70, buffer.capacity());		
	}
}
