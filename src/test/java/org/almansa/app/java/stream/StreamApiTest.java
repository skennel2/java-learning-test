package org.almansa.app.java.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import testobject.Person;

public class StreamApiTest {

    private List<Person> getPersonList() {
        List<Person> persons = Arrays.asList(new Person("nys", 30), new Person("adf", 12), new Person("vrf", 32),
                new Person("vvf", 32), new Person("wdf", 43), new Person("nys", 11));

        return persons;
    }

    @Test
    public void 스트림_다루기() {
        List<Person> persons = getPersonList();

        // Consumer 매개변수 값을 소비할 뿐 리턴하지 않는다. C#으로 치면 Action
        Consumer<Person> printPerson = (p) -> {
            System.out.println(p.getName());
        };

        persons.stream()
               .distinct() 
               .filter((p) -> p.getName().equals("nys2"))
               .findFirst()
               .ifPresent(printPerson);

        // age의 타입을 int -> Integer로 바꾸니 잘된다.
        // 스트림의 모든 요소가 다음조건을 만족하는가 ?
        boolean isAllAgeOver30 = persons.stream()
                                        .allMatch((p) -> p.getAge() > 30);

        assertEquals(false, isAllAgeOver30);

        persons.stream().filter((p) -> p.getAge() > 30).findAny().ifPresent((p) -> {
            System.out.println(p.getName());
        });

        // Map 연산 순회하며 본 타입을 특정타입으로 바꾼다.
        persons.stream().map((p) -> p.getAge()).forEach((a) -> System.out.print(a.toString() + ", "));
    }

    @Test
    public void 빈스트림생성() {
        Stream<String> stringStream = Stream.empty();

        long count = stringStream.count();
        assertEquals(0, count);
    }

    @Test
    public void of메소드로_스트림생성() {
        Stream<String> stream = Stream.of("asdf", "sadf", "sadf");
        long count = stream.count();

        assertEquals(3, count);
    }

    @Test
    public void asList로_콜렉션객체생성() {
        Collection<String> collectionForString = Arrays.asList("11", "22", "33", "44");
        long stringCollectionSize = collectionForString.size();
        assertEquals(4, stringCollectionSize);

        Collection<Person> collectionsForPerson = Arrays.asList(new Person());
        long personCollectionSize = collectionsForPerson.size();
        assertEquals(1, personCollectionSize);
    }

    @Test
    public void 스트림빌더() {
        Stream<String> stream = Stream.<String>builder().add("a").add("b").add("c").build();

        assertEquals(3, stream.count());
    }

    @Test
    public void generate로_무한스트림생성() {
        Stream<String> stream = Stream.generate(() -> "123456789").limit(5);

        assertEquals(5, stream.count());
    }

    @Test
    public void iterate로_스트림생성() {
        // iterate는 무한 스트림을 생성한다.
        Stream<Integer> stream = Stream.iterate(10, n -> n + 1);

        assertEquals(10, stream.count());
    }

    @Test
    public void 기본자료형스트림생성() {
        IntStream intStream = IntStream.range(0, 10); // 0 ~ 9

        assertEquals(45, intStream.sum());

    }

    @Test
    public void 패턴으로_String에서_스트림생성() {
        Stream<String> stream = Pattern.compile(",").splitAsStream("a,b,c");

        assertEquals(3, stream.count());
    }

    /**
     * 하나의 스트림에 대해 여러번의 집계 작업을 수행하면 IllegalStateException예외를 던진다.
     */
    @Test(expected = IllegalStateException.class)
    public void 스트림_재사용의_문제() {
        Stream<String> stream = Stream.of("acb", "bcd", "cde").filter((str) -> str.contains("b"));

        Optional<String> optional = stream.findAny();

        // IllegalStateException 발생 , 같은 스트림의 재사용은 주의해야한다.
        // TODO 근데 왜일까..?
        Optional<String> optional2 = stream.findAny();
    }

    @Test
    public void 스트림_재사용의_문제의_해결() {
        List<String> list = Stream.of("acb", "bcd", "cde").filter((str) -> str.contains("b"))
                .collect(Collectors.toList());

        Optional<String> optional = list.stream().findAny();
        Optional<String> optional2 = list.stream().findAny();
    }
}
