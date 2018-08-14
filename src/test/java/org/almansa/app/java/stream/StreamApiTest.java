package org.almansa.app.java.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.almansa.app.java.jackson.Person;
import org.junit.Test;

public class StreamApiTest {
	
	private List<Person> getPersonList(){
        List<Person> persons 
        = Arrays.asList(new Person("nys", 30), new Person("adf", 12), new Person("vrf", 32), new Person("vvf", 32), new Person("wdf", 43), new Person("nys", 11));

        return persons;
	}
	
	/**
	 * List<Person> 타입에 대해 스트림 다뤄보기
	 */
    @Test
    public void handleStream() {
        List<Person> persons = getPersonList();
        
        //Consumer 매개변수 값을 소비할 뿐 리턴하지 않는다. C#으로 치면 Action
        Consumer<Person> printPerson = (p) -> 
        {
        	System.out.println(p.getName());     	
        };
        
        persons.stream()
               .distinct()
               .filter((p) -> p.getName().equals("nys2"))
               .findFirst()
               .ifPresent(printPerson);

        // age의 타입을 int -> Integer로 바꾸니 잘된다.
        // 스트림의 모든 요소가 다음조건을 만족하는가 ?
        boolean isAllAgeOver30 = persons.stream().allMatch((p) -> p.getAge() > 30);
        
        assertEquals(false, isAllAgeOver30);

        persons.stream()
        .filter((p) -> p.getAge() > 30)
        .findAny()
        .ifPresent((p) -> {
            System.out.println(p.getName());
        });

        // Map 연산 순회하며 본 타입을 특정타입으로 바꾼다. 
        persons.stream()
        .map((p) -> p.getAge())
        .forEach((a) -> System.out.print(a.toString() + ", "));
    }

    /**
     * 빈 스트림만들기
     */
    @Test
    public void emptyStream() {
        Stream<String> stringStream = Stream.empty();
        
        long count = stringStream.count();
        assertEquals(0, count);
    }

    /**
     * Stream.of 메소드로 스트림 만들기
     */
    @Test
    public void StreamOfArray() {
        Stream<String> stream = Stream.of("asdf", "sadf", "sadf");
        long count = stream.count();
        
        assertEquals(3, count);
    }

    /**
     * asList로  Collection 객체 만들기
     */
    @Test
    public void StreamOfCollection() {
        Collection<String> collectionForString = Arrays.asList("11", "22", "33", "44");
        long stringCollectionSize = collectionForString.size();
        assertEquals(4, stringCollectionSize);
        
        Collection<Person> collectionsForPerson = Arrays.asList(new Person());
        long personCollectionSize = collectionsForPerson.size();
        assertEquals(1, personCollectionSize);        
    }

    @Test
    public void StreamBuilder() {
        Stream<String> stream = Stream.<String>builder().add("a").add("b").add("c").build();
    }

    @Test
    public void streamGenegater() {
        // The generate() method accepts a Supplier<T> for element generation.
        // As the resulting stream is infinite, developer should specify the desired
        // size
        // or the generate() method will work until it reaches the memory limit:

        Stream<String> stream = Stream.generate(() -> "123456789");
    }

    @Test
    public void streamIterate() {
        // iterate는 무한 스트림을 생성한다.
        Stream<Integer> stream = Stream.iterate(10, n -> n + 1);

        assertEquals(10, stream.count());
    }

    /**
     * 기본자료형에 대한 스트림생성 
     */
    @Test
    public void streamForPrimitive() {
        IntStream intStream = IntStream.range(0, 10); // 0 ~ 9
        
        assertEquals(45, intStream.sum());

    }

    /**
     * String 타입에 대한 스트림 생성
     */
    @Test
    public void streamOfString() {
        Stream<String> stream = Pattern.compile(",").splitAsStream("a,b,c");
    }

    /**
     * 하나의 스트림에 대해 여러번의 집계 작업을 수행하면 IllegalStateException예외를 던진다.
     */
    @Test(expected = IllegalStateException.class)
    public void streamReferenceReUseProblem() {
        Stream<String> stream = Stream.of("acb", "bcd", "cde").filter((str) -> str.contains("b"));
        
        Optional<String> optional = stream.findAny();
        Optional<String> optional2 = stream.findAny();
        // IllegalStateException 발생 , 같은 스트림의 재사용은 주의해야한다.
        // TODO 근데 왜일까..?        
    }

    @Test
    public void streamReferenceReUseProblemSolve() {
        List<String> list = Stream.of("acb", "bcd", "cde")
        		                  .filter((str) -> str.contains("b"))
                                  .collect(Collectors.toList());

        Optional<String> optional = list.stream().findAny();
        Optional<String> optional2 = list.stream().findAny();
         

    }
}
