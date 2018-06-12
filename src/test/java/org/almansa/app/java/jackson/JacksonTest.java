package org.almansa.app.java.jackson;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
    @Test
    public void simpleJsonSerializeAndDeserialize() throws IOException {
        Person person = new Person("e40", 43);

        // Object를 Json String으로 직렬화
        String personJson = new ObjectMapper()
                .writeValueAsString(person);
        
        // Json String을 자바 Object로 역직렬화
        Person personByJson = new ObjectMapper()
                .readerFor(Person.class)
                .readValue(personJson);

        System.out.println(personJson);
        System.out.println(personByJson.toString());
    }
}
