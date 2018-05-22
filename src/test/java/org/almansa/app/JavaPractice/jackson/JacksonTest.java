package org.almansa.app.JavaPractice.jackson;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
    @Test
    public void simpleJsonSerializeAndDeserialize() throws IOException {
        Person person = new Person("e40", 43);

        String personJson = new ObjectMapper().writeValueAsString(person);
        Person personByJson = new ObjectMapper().readerFor(Person.class).readValue(personJson);

        System.out.println(personJson);
        System.out.println(personByJson.toString());
    }
}
