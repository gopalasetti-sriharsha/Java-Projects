package question3;

import java.util.Random;

class InsufficientFundsException extends Exception{

}
class PowerFailureException extends Exception{

}
class NetworkFailureException extends Exception{

}
class Bank{
    private static final int MIN_BALANCE = 200;
    private static void reduceBalance(Customer sender, int amount)throws InsufficientFundsException{
        if(sender.getBalance()-amount < MIN_BALANCE)
            throw new InsufficientFundsException();
        sender.setBalance(sender.getBalance() - amount);
        System.out.println("Rs. " + amount+" debited from " + sender.getCustomerName()+ "'s account");
    }
    private static void addBalance(Customer receiver, int amount){
        receiver.setBalance(receiver.getBalance() + amount);
        System.out.println("Rs. " + amount+" credited to " + receiver.getCustomerName()+ "'s account");
    }
    public static void amountTransfer(Customer sender, Customer receiver, int amount){
        try {
            reduceBalance(sender, amount);
            Random random = new Random();
            int randomNumber = Math.abs(random.nextInt());
            if (randomNumber%2 == 0){//Exception block
                int secondRandomNumber = Math.abs(random.nextInt())%2;
                if(secondRandomNumber == 0){//Power Failure
                    throw new PowerFailureException();
                }
                else{//Network Failure
                    throw new NetworkFailureException();
                }
            }
            addBalance(receiver,amount);
            System.out.println("Transaction Successful");
        }
        catch (InsufficientFundsException ie){
            System.out.println("Amount cannot be transferred due to insufficient funds in your account");
            System.out.println("Your Current Balance :\t" + sender.getBalance());
            System.out.println("Min balance required to make this transaction is :\t" + Bank.MIN_BALANCE);
        }
        catch (PowerFailureException pe){
            System.out.println("Power Failure");
        }
        catch (NetworkFailureException ne){
            System.out.println("Network Failure");
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
    public static void main(String args[]){
        //Sender details
        Customer customer1 = new Customer();
        customer1.setAccountNumber("100023450");
        customer1.setBalance(450);
        customer1.setCustomerName("Henry");
        //Receiver details
        Customer customer2 = new Customer();
        customer2.setAccountNumber("100087652");
        customer2.setBalance(700);
        customer2.setCustomerName("Blake");
        Bank.amountTransfer(customer1,customer2,200);
    }
}
