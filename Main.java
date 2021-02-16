import java.text.NumberFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double principal = getInput(scanner, "Principal: ", 1_000, 1_000_000);
        double annualInterestRate = getInput(scanner, "Annual Interest Rate: ", 0, 30);
        int period = (int)getInput(scanner, "Duration(years): ", 0, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, period);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage payment: " + formattedMortgage + "\n");
        scanner.close();
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

    public static double calculateMortgage(double principal, double annualInterestRate, int period){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        double numberPayments = period * 12;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        double mortgage = principal
                            * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberPayments)  
                            / (Math.pow(1 + monthlyInterestRate, numberPayments) - 1));

        return mortgage;
    }
}