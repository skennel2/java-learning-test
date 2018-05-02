package org.almansa.app.JavaPractice.stream;

import java.util.ArrayList;
import java.util.List;

import org.almansa.app.JavaPractice.vo.Person;
import org.junit.Test;

public class StreamApiTest {
    @Test
    public void test() {
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
        boolean result = persons.stream().allMatch((p)->p.getAge() > 30);
        
        persons.stream().filter((p)->p.getAge() > 30 ).findAny().ifPresent((p)->{
            System.out.println(p.getName()); 
        });

    }
}
