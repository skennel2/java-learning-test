package org.almansa.app.java.exceptionhandling;

public class App {

    public static void main(String[] args) {
        ExceptionService service = new ExceptionService();
        service.raiseExceptionAndThrow();
    }

}
