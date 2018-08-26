package org.almansa.app.java.stream.map;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class FlatMapTest {

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


