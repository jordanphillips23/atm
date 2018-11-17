package atm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ATM {

	private Account current;
	Scanner scan = new Scanner(System.in);
	DecimalFormat format = new DecimalFormat( "###,##0.00" );
	
	public void menu () {
		User currentUser = new User("first last", "1 not real lane", "100000001", "5555555555");
		BigDecimal zero = new BigDecimal(0);
		current = new Account(zero, 100000001, "1234", currentUser);
		
		System.out.println("Welcome to the Bank ATM. Please enter your account number.");
		System.out.println();
		System.out.println();
		System.out.print("Account Number #: ");
		int accountNumber = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
		
		System.out.print("Pin #: ");
		String pin = scan.nextLine();
		
		System.out.println();
		
		if (!(accountNumber == current.getAccountNumber() && pin.equals(current.getPin()))) {
			System.out.println("invalid input");
			System.out.println();
			return;
		}
		
		
		int input = 0;
		boolean end = true;
		do {
			System.out.println("Hello " + current.getAccountHolder().getName() + "!");
			System.out.println();
			System.out.println("0 : Exit");
			System.out.println("1 : Deposit");
			System.out.println("2 : Withdraw");
			System.out.println("3 : Balance");
			System.out.println();
			System.out.print("Enter in your choice: ");
			input = scan.nextInt();
			scan.nextLine();
		
			System.out.println();
			switch (input) {
				case 0:
					end = false;
					break;
				case 1:
					deposit();
					break;
				case 2:
					if (current.getBalance().compareTo(zero) >= 0) {
						withdraw();
					}
					else {
						System.out.println("You have no funds to withdrawl. Please deposit money first.");
						System.out.println("");
					}
					
					break;
				case 3:
					showBalance();
					break;
				default:
					
					System.out.println("Invalid Response.");
				
					break;
			}
			
		} while(end);
	}
	
	public void deposit() {
		BigDecimal zero = new BigDecimal(0);

		System.out.println("You Current Balance is $" + format.format(current.getBalance()) + " How much would you like to Deposit?");
		System.out.println();
		System.out.print("Amount: ");
	
		String amount = scan.nextLine();
		BigDecimal bigAmount = new BigDecimal(amount);
		
		if(bigAmount.compareTo(zero) <= 0) {
			System.out.print("Invalid Input. Amount must be greater than 0");
			System.out.println(); 
			return;
		}
		
		System.out.println();
		
		current.deposit(bigAmount);
		
		System.out.println("Your new balance is: $" + format.format(current.getBalance()));
		System.out.println();
	}
	
	public void withdraw() {
		BigDecimal zero = new BigDecimal(0);
		System.out.println("You Current Balance is $" + format.format(current.getBalance()) + " How much would you like to withdraw?");
		System.out.println();
		System.out.print("Amount: ");
		
		String amount = scan.nextLine();
		
		BigDecimal bigAmount = new BigDecimal(amount);
		
		System.out.println();
		
		if (bigAmount.compareTo(current.getBalance()) > 0 ) {
			System.out.println("Invalid Input. Insufficient Funds.");
			System.out.println(); 
			return;
		}
		if(bigAmount.compareTo(zero) <= 0) {
			System.out.print("Invalid Input. Amount must be greater than 0");
			System.out.println(); 
			return;
		}
		current.withdraw(bigAmount);
		
		
		System.out.println("Your new balance is: $" + format.format(current.getBalance()));
		System.out.println();
		
	}
	
	public void showBalance() {
		System.out.println("You currently have " + format.format(current.getBalance()) + " dollars in your account.");
		System.out.println(); 

	}
	
	public static void main(String[] args) {
		ATM thisATM = new ATM();
		thisATM.menu();
		thisATM.scan.close();
	}
	
}