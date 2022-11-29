// Console Version
package currency_converter;

import java.util.Scanner;

public class Currency_Converter {

	public static void main(String[] args) {
		System.out.println("Dollar : 1");
		System.out.println("Rupee : 2");
		System.out.println("Euro : 3");
		
		Scanner keyboard =new Scanner(System.in);
		System.out.println("Choose the currency");
		int choice = keyboard.nextInt();
		System.out.println("Enter the amount");
        double amount = keyboard.nextDouble();
        
        if (choice == 1) {
        	double rupeeAmount = amount * 79.37;
        	double euroAmount = amount * 0.98;
        	System.out.printf("$%.2f", amount);
        	System.out.println();
        	System.out.printf("₹%.2f", rupeeAmount);
        	System.out.println(" in Rupees");
        	System.out.printf("€%.2f", euroAmount);
        	System.out.println(" in Euros");
        } else if (choice == 2) {
        	double euroAmount = amount * 0.012;
        	double dollarAmount = amount * 0.013;
        	System.out.printf("₹%.2f", amount);
        	System.out.println();
        	System.out.printf("$%.2f", dollarAmount);
        	System.out.println(" in dollars");
        	System.out.printf("€%.2f", euroAmount);
        	System.out.println(" in Euros");
        } else {
        	double rupeeAmount = amount * 80.85;
        	double dollarAmount = amount * 1.02;
        	System.out.printf("€%.2f", amount);
        	System.out.println();
        	System.out.printf("₹%.2f", rupeeAmount);
        	System.out.println(" in Rupees");
        	System.out.printf("$%.2f", dollarAmount);
        	System.out.println(" in dollars");
        }
	}

}
