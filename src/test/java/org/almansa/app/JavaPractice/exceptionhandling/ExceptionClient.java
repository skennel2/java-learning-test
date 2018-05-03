package org.almansa.app.JavaPractice.exceptionhandling;

public class ExceptionClient {
    private ExceptionService service = new ExceptionService();
    
    public void test() {
        service.raiseUnExpectedException();
    }
    
    public void test2() {
        service.raiseExceptionAndThrow();
    }
    
    public void test3() {
        service.raiseExceptionAndDoAnything();
    }
}
