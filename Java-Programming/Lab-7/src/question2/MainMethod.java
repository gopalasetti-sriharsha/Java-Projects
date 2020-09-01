package question2;

import java.util.Scanner;

class InvalidNumberOfDigitsException extends Exception{

}
class InvalidDataFormatException extends Exception{

}
class MobileNumberParser{
    public static void parseMobileNumber(String mobileNumber) throws InvalidNumberOfDigitsException, InvalidDataFormatException{
        for (int i = 0; i < mobileNumber.length(); i++){
            if (!((int)mobileNumber.charAt(i) >= 48) || !((int)mobileNumber.charAt(i) <= 57)) {
                throw new InvalidDataFormatException();
            }
        }
        if(mobileNumber.length()!=12)
            throw new InvalidNumberOfDigitsException();
    }
}

public class MainMethod {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your mobile number :\t");
        String mobileNumber = sc.next();
        try{
           MobileNumberParser.parseMobileNumber(mobileNumber);
           System.out.println("Valid Mobile Number");

        }
        catch (InvalidNumberOfDigitsException e11){
            System.out.println("Invalid no. of digits. \nEnter a Valid Mobile Number!!");
            System.out.print("Re-enter your mobile Number :\t");
            mobileNumber = sc.next();
            try{
                MobileNumberParser.parseMobileNumber(mobileNumber);
                System.out.println("Valid Mobile Number");
            }
            catch (InvalidNumberOfDigitsException e21){
                System.out.println("Invalid no. of digits. \nYou have entered two consecutive invalid mobile numbers. The program is terminated");
            }
            catch (InvalidDataFormatException e22){
                System.out.println("Invalid data format. \nYou have entered two consecutive invalid mobile numbers. The program is terminated");
            }
        }
        catch (InvalidDataFormatException e12){
            System.out.println("Invalid data format. \nEnter a Valid Mobile Number!!");
            System.out.print("Re-enter your mobile Number :\t");
            mobileNumber = sc.next();
            try{
                MobileNumberParser.parseMobileNumber(mobileNumber);
                System.out.println("Valid Mobile Number");
            }
            catch (InvalidNumberOfDigitsException e21){
                System.out.println("Invalid no. of digits. \nYou have entered two consecutive invalid mobile numbers. The program is terminated");
            }
            catch (InvalidDataFormatException e22){
                System.out.println("Invalid data format. \nYou have entered two consecutive invalid mobile numbers. The program is terminated");
            }
        }
    }
}
