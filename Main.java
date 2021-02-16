import java.text.NumberFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        double principal = getPrincipal(scanner, 0);
        float annualInterestRate = getAnnual(scanner, 0);
        byte period = getPeriod(scanner);
        scanner.close();

        double numberPayments = period * 12;
        double monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        double mortgage = principal
                            * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberPayments)  
                            / (Math.pow(1 + monthlyInterestRate, numberPayments) - 1));

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage payment: " + formattedMortgage + "\n");

    }

    public static double getPrincipal(Scanner scanner, double principal){
        do{
            System.out.print("Principal loan amount(1k-1mil): $");
            principal = scanner.nextDouble();
        } while(principal > 1000000 && principal < 1000);
        
        return principal;
    }

    public static float getAnnual(Scanner scanner, float annual){
        do{
            System.out.print("Annual interest rate(0-30%): ");
            annual = scanner.nextFloat();
        } while(annual > 30 && annual < 10);
        
        return annual;
    }

    public static byte getPeriod(Scanner scanner){
        byte period;
        do{
            System.out.print("Payment period(years, 0-30): ");
            period = scanner.nextByte();
        } while(period > 30 && period < 0);
        
        return period;
    }
}