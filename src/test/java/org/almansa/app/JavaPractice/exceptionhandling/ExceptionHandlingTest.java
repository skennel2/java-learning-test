package org.almansa.app.JavaPractice.exceptionhandling;

import org.junit.Test;

public class ExceptionHandlingTest {

    private ExceptionService service = new ExceptionService();

    @Test
    public void test() {
        service.raiseExceptionAndDoAnything();
    }

    @Test
    public void test2() {
        service.raiseExceptionAndThrow();
    }

    @Test
    public void test3() {
        service.raiseUnExpectedException();
    }
}
