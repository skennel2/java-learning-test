package org.almansa.app.java.exceptionhandling;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            exceptionThrow();
        } catch (Exception e) {
            System.out.println("exceptionThrow Exception catch");
        }
        
        System.out.println("next");
        
        try {
            trycatchExceptionThrowWrap();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("next");
    }
    
    public static void exceptionThrow() throws Exception {
        throw new Exception();
    }
    
    public static void trycatchExceptionThrow() {
        new Long("123e");
    }
    
    
    public static void trycatchExceptionThrowWrap() {
        trycatchExceptionThrow();
    }
    
    public static void runtimeExceptionThrow() throws RuntimeException {
        throw new RuntimeException();
    }
}
