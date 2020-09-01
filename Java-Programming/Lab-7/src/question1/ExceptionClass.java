package question1;

import java.util.InputMismatchException;

public class ExceptionClass {
    public static void someMethod(){
        try {
            someMethod2();
        }
        catch (InputMismatchException e){
            throw e;
        }
        finally {
            System.out.println("Finally from Method 1");
        }
    }
    public static void someMethod2(){
        InputMismatchException inputMismatchException = new InputMismatchException();
        try {
            throw inputMismatchException;
        }
        catch (InputMismatchException e){
            throw e;
        }
        finally {
            System.out.println("Finally from Method 2");
        }
    }
    public static void main(String args[]){
        try {
            someMethod();
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Finally from main");
        }
    }
}
