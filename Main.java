import java.text.NumberFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal loan amount: $");
        double principal = scanner.nextDouble();

        System.out.print("Annual interest rate: ");
        float annualInterestRate = scanner.nextFloat();
        System.out.print("Payment period(years): ");
        int period = scanner.nextInt();
        scanner.close();

        double numberPayments = period * 12;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberPayments) / 
                            (Math.pow(1 + monthlyInterestRate, numberPayments) - 1));
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage payment: " + formattedMortgage + "\n");

    }
}