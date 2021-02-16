import java.text.NumberFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);

        double principal = getInput(scanner, "Principal: ", 1_000, 1_000_000);
        double annualInterestRate = getInput(scanner, "Annual Interest Rate: ", 0, 30);
        int period = (int)getInput(scanner, "Duration(years): ", 0, 30);

        int numberPayments = period * 12;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        printMortgageDetails(principal, monthlyInterestRate, numberPayments);
        
        scanner.close();
    }

    public static double getBalance(double principal, double monthlyInterestRate, int totalPayments, byte paymentsMade){
        double balance = principal
                        * (Math.pow(1 + monthlyInterestRate, totalPayments) - Math.pow(1 + monthlyInterestRate, paymentsMade))
                        / (Math.pow(1 + monthlyInterestRate, totalPayments) - 1);

        return balance;
    }

    public static void printMortgageDetails(double principal, double monthlyInterestRate, int numberPayments){
        double mortgage = calculateMortgage(principal, monthlyInterestRate, numberPayments);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMORTGAGE\n-------");
        System.out.println("Monthly payment: " + formattedMortgage + "\n");
        System.out.println("Balance by month:\n----------------");
        double balance; 
        byte paymentsMade = 0;
        for(int i = 0; i <= numberPayments; i++){
            balance = getBalance(principal, monthlyInterestRate, numberPayments, paymentsMade);
            String formattedBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(formattedBalance);
            paymentsMade++;
        }

    }

    public static double getInput(Scanner scanner, String prompt, int min, int  max){ 
        double input;
        
        while(true){
            System.out.print(prompt);
            input = scanner.nextDouble();
            if(input > min && input < max){
                break;
            }
            System.out.println("Value must be between " + min + "and " + max);
        }

        return input;
    }

    public static double calculateMortgage(double principal, double monthlyInterestRate, int numberPayments){

        double mortgage = principal
                            * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberPayments)  
                            / (Math.pow(1 + monthlyInterestRate, numberPayments) - 1));

        return mortgage;
    }
}