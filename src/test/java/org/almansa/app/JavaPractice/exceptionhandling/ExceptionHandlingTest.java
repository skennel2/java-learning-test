package org.almansa.app.JavaPractice.exceptionhandling;

import org.junit.Test;

public class ExceptionHandlingTest {

    private ExceptionService service = new ExceptionService();

    @Test
    public void testRaiseExceptionAndDoAnything() {
        service.raiseExceptionAndDoAnything();
    }

    @Test
    public void testRaiseExceptionAndThrow() {
        service.raiseExceptionAndThrow();
    }

    @Test
    public void testRaiseUnExpectedException() {
        service.raiseUnExpectedException();
    }
}
