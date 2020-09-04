package question3;

import java.util.InputMismatchException;
import java.util.Random;

class InsufficientFundsException extends Exception{

}
class Bank{
    private static final int MIN_BALANCE = 200;
    private static void reduceBalance(Customer sender, int amount)throws InsufficientFundsException{
        if(sender.getBalance()-amount < MIN_BALANCE)
            throw new InputMismatchException();
        sender.setBalance(sender.getBalance() - amount);
    }
    private static void addBalance(Customer receiver, int amount){
        receiver.setBalance(receiver.getBalance() + amount);
    }
    public static void amountTransfer(Customer sender, Customer receiver, int amount){
        try {
            reduceBalance(sender, amount);
            Random random = new Random();
            int 
            addBalance(receiver,amount);
        }
        catch (InsufficientFundsException ie){

        }
    }
}
class Customer{
    private String accountNumber;
    private int balance;
    private String customerName;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

public class MainClass {
}
