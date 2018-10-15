package org.almansa.app.java.lambda;

import org.junit.Test;

public class StreamAndAnonymousClass {

	@Test
	public void 익명클래스와_람다의_쉐도우변수() {
		int a = 10;
		
		Runnable runnable1 = () -> {
			// 아래 라인의 주석을 풀면 컴파일 에러 
			// 컨테이너 메소드의 변수 a를 가리는것이 허용되지 않는다.
			// int a = 10; 
		};
		
		Runnable runnable2 =  new Runnable() {
			
			@Override
			public void run() {
				// 반면 익명클래스는 쉐도우변수를 허용한다. 
				int a = 20;
			}
		};
	}
	
	@Test
	public void dd() {
		// 람다의 타입에 대한 형지정을 해주어야한다. 
		doSomething((Runnable)()-> System.out.println("어떤 오버로딩 메소드가 실행되는 가?"));
	}
	
	public static void doSomething(Runnable r){
		r.run();
	}
	
	public static void doSomething(Task t) {
		t.run();
	}
	
	interface Task{
		void run();
	}
	
}
