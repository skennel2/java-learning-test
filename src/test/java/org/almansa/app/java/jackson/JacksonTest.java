package org.almansa.app.java.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

/**
 * https://www.lesstif.com/pages/viewpage.action?pageId=24445183
 * @author skennel
 *
 */
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
    
    @Test
    public void test() {
        //Person person = new Person("Na yun su", 31);
        String json = "{\"name\":\"Bob\", \"age\":13}";
        
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader();
        reader.forType(Person.class);
        
        Person person = null;
        try {
            person = reader.readValue(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        assertEquals("bob", person.getName());
    }
}
