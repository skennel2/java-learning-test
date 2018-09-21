package org.almansa.app.java.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamCreate {
    
    @Test
    public void IntStream의_범위로_스트림생성() {
        int sum = IntStream.range(0, 10).sum();
        
        assertEquals(45, sum);
    }
    
    @Test
    public void of키워드() {
        Stream<String> strings = Stream.of("keyboard", "mouse", "moniter");
        strings.map((s) -> s.toUpperCase())
        	.forEach((s) -> {
        		System.out.println(s);
        	});
    }

    @Test
    public void 배열을스트림으로만들기() {
        String[] strings = { "keyboard", "mouse", "moniter" };
        String reducing = Arrays.stream(strings)
        		.reduce("", (a, b)->{
        			return a.concat(", ").concat(b);
        		});
        
        System.out.println(reducing);
    }
    
    @Test
    public void 무한스트림만들기_iterate() {
        Integer sum = Stream.iterate(0, n -> n + 1) // 이렇게 생성된 스트림은 언바운드 스트림이라고 한다. 
            .limit(10)
            .reduce(0, Integer::sum);
        
        assertEquals(45, sum.intValue());
    }
    
    @Test
    public void 무한스트림만들기_generate() {
        Integer sum = Stream.generate(()-> 1)
            .limit(10)
            .reduce(0, Integer::sum);
        
        assertEquals(10, sum.intValue());
    }
    
    
}
