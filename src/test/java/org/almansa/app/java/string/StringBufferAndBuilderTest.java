package org.almansa.app.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * StringBuffer는 Thread Safe, StringBuilder는 Thread Unsafe
 * 동기화를 하냐 안하냐의 차이인데 대부분 지역변수로 사용될 거라 StringBuffer를 쓸 이유가 있을까 싶다.
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
	
	@Test
	public void StringBuilder멀티스레드테스트() throws InterruptedException {
		StringBuilder buffer = new StringBuilder();
		Thread t1 = new Thread(new StringBuilderAppender("☆", buffer));
		Thread t2 = new Thread(new StringBuilderAppender("★", buffer));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		// 간헐적으로 java.lang.ArrayIndexOutOfBoundsException 발생 
		System.out.println(buffer);
	}
	
	@Test
	public void StringBuffer멀티스레드테스트() throws InterruptedException {
		StringBuffer buffer = new StringBuffer();
		Thread t1 = new Thread(new StringBufferAppender("☆", buffer));
		Thread t2 = new Thread(new StringBufferAppender("★", buffer));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(buffer);
	}

	class StringBuilderAppender implements Runnable {

		private String name;
		private StringBuilder builder;

		private StringBuilderAppender(String name, StringBuilder builder) {
			super();
			this.name = name;
			this.builder = builder;
		}

		@Override
		public void run() {
			for (int i = 0; i < 3000; i++) {
				builder.append(name);
			}
		}
	}
	
	class StringBufferAppender implements Runnable {		
		
		private String name;
		private StringBuffer buffer;

		private StringBufferAppender(String name, StringBuffer buffer) {
			super();
			this.name = name;
			this.buffer = buffer;
		}

		@Override
		public void run() {
			for (int i = 0; i < 3000; i++) {
				buffer.append(name);
			}
		}
	}
}
