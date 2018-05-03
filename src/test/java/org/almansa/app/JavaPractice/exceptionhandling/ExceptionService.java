package org.almansa.app.JavaPractice.exceptionhandling;

public class ExceptionService {
    
    public void raiseUnExpectedException() {
        new Long("abc");
    }
    
    public void raiseExceptionAndThrow() {
        try {
            new Long("abc");
        }catch(RuntimeException ex) {
            throw ex;
        }
    }  
    
    public void raiseExceptionAndDoAnything() {
        try {
            new Long("abc");
        }catch(Exception ex) {
            // 아무것도 하지 않는다. 
        } 
    }
}
