package org.almansa.app.JavaPractice.exceptionhandling;

import org.junit.Test;

public class ExceptionHandlingTest {

    private ExceptionClient service = new ExceptionClient();

    @Test
    public void test() {
        service.test();
    }

    @Test
    public void test2() {
        service.test2();
    }

    @Test
    public void test3() {
        service.test3();
    }
}
