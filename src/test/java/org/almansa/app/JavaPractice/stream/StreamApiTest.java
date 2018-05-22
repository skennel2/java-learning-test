package org.almansa.app.JavaPractice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.almansa.app.JavaPractice.vo.Person;
import org.junit.Test;

public class StreamApiTest {
    @Test
    public void handleStream() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("nys", 30));
        persons.add(new Person("adf", 12));
        persons.add(new Person("vrf", 32));
        persons.add(new Person("vvf", 32));
        persons.add(new Person("wdf", 43));
        persons.add(new Person("nys", 11));

        String searchName = "nys2";

        persons.stream().distinct().filter((p) -> p.getName().equals(searchName)).findFirst().ifPresent((p) -> {
            System.out.println(p.getName());
        });

        // age의 타입을 int -> Integer로 바꾸니 잘된다.
        // 스트림의 모든 요소가 다음조건을 만족하는가 ?
        boolean result = persons.stream().allMatch((p) -> p.getAge() > 30);

        persons.stream().filter((p) -> p.getAge() > 30).findAny().ifPresent((p) -> {
            System.out.println(p.getName());
        });

        // Map 연산
        persons.stream().map((p) -> p.getAge()).forEach((a) -> System.out.print(a.toString() + ", "));
    }

    @Test
    public void emptyStream() {
        Stream<String> stringStream = Stream.empty();
    }

    @Test
    public void StreamOfArray() {
        Stream<String> stream = Stream.of("asdf", "sadf", "sadf");
    }

    @Test
    public void StreamOfCollection() {
        Collection<String> collection = Arrays.asList("11", "22", "33", "44");
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
        Stream<Integer> stream = Stream.iterate(10, n -> n + 1).limit(10);

        stream.forEach((n) -> {
            System.out.println(n);
        });
    }

    @Test
    public void streamForPrimitive() {
        IntStream intStream = IntStream.range(0, 100);

    }

    @Test
    public void streamOfString() {
        Stream<String> stream = Pattern.compile(",").splitAsStream("a,b,c");
    }

    @Test(expected = IllegalStateException.class)
    public void streamReferenceReUseProblem() {
        Stream<String> stream = Stream.of("acb", "bcd", "cde").filter((str) -> str.contains("b"));
        Optional<String> optional = stream.findAny();

        // IllegalStateException 발생 , 같은 스트림의 재사용은 주의해야한다.
        // TODO 근데 왜일까..?
        Optional<String> optional2 = stream.findAny();
    }

    @Test
    public void streamReferenceReUseProblemSolve() {
        List<String> list = Stream.of("acb", "bcd", "cde").filter((str) -> str.contains("b"))
                .collect(Collectors.toList());

        Optional<String> optional = list.stream().findAny();
        Optional<String> optional2 = list.stream().findAny();
    }

    @Test
    public void streamReduceOperation() {

    }
}
