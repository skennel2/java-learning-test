package org.almansa.app.java.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * flatMap은 스트림의 각값을 다른 스트림으로 부꾼후 모든 스트름을 하나로 합친다. 
 * @author skenn
 *
 */
public class FlatMapTest {

    @Test
    public void flatMap() {
        Stream<String> fruits = Stream.of("banana", "apple");
        
        List<String> unique = fruits.map(s->s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        
        unique.stream().forEach(c->System.out.print(c));
    }
    
    @Test
    public void 기본형스트림으로매핑() {
        int[] intArray = {1, 2, 3, 4, 5, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

        intStream.forEach(x -> System.out.println(x));
    }
}


