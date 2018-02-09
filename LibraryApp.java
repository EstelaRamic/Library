package library.estela.ba;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		call(input);
		input.close();
	}
	
	public static void call(Scanner input) {

		Library library = new Library();
		int accNumber=-1;
		int choice=0;
		boolean added;
		String accName="";
		
		do{
			
			choice=showMenu(input);

		switch (choice){
		case 1:
			added = false;
			do {
				Customer acc = new Customer();
				System.out.println("Enter the account number(ID): ");
				accNumber=input.nextInt();
				acc.setID(accNumber);
				
				System.out.println("Enter the account owner name: ");
				accName=input.next();
				acc.setName(accName);

							
				added=library.addCustomer(acc);
			} while (!added);
			break;
		
		case 2:
			added = false;
			do {
				Book accB = new Book();
				System.out.println("Enter the book number(ID): ");
				accNumber=input.nextInt();
				accB.setID(accNumber);
				
				System.out.println("Enter the book name: ");
				accName=input.next();
				accB.setName(accName);

							
				added=library.addBook(accB);
			} while (!added);
			break;
		
		case 3:
			
			added = false;
			int sourceID=0, targetID=0;
			
			do{
				System.out.println("Enter the user account number (ID):");
				sourceID=input.nextInt();
				
				System.out.println("Enter the book number (ID): ");
				targetID=input.nextInt();
				
				Date date=new Date();							
				added = library.addRecord(sourceID, targetID, date);
			}while (!added);
			break;
			
		case 4:
			Customer acc = new Customer();
			int accNum=-1;

			System.out.println("For which user acoount number (ID) do you want information:");
			accNum = input.nextInt();
			acc = library.memberOfCustomerList(accNum, library.getCustomers());
			
			if (acc.getID()==-1){
				System.out.println("*************************************************");
				System.out.println("This user account doesn't exist.");
				System.out.println("*************************************************");
			} else{
				System.out.println("*************************************************");
				System.out.println(acc.toString());
				System.out.println("*************************************************");
			}
			break;
			
		case 5:
			library.ispis();
			
			break;
	
		case 6:
			System.out.println("*************************************************");
			System.out.println("You choose to exit App. You are Welcome some other time.");
			System.out.println("*************************************************");
			break;
		}
		}while (choice!=6);
		

	}

	public static int showMenu(Scanner input){
		
		char choice='1';
		ArrayList<Character> validInputs = new ArrayList<>();
		
		validInputs.add('1');
		validInputs.add('2');
		validInputs.add('3');
		validInputs.add('4');
		validInputs.add('5');
		validInputs.add('6');
		
		do{
			if (!validInputs.contains(choice)) {
				System.out.println( "\nWrong input. Choose again.\n");
			}
			System.out.println("\nChoose an option:\n");
			System.out.println("*************************************************");
			System.out.print("1. Create new user account \n");
			System.out.print("2. Create new book account \n");
			System.out.print("3. Make a book borrowing \n");
			System.out.print("4. Get account information \n");
			System.out.print("5. ispis svih posudjivanja\n");
			System.out.print("6. Exit application \n");
			System.out.println("*************************************************");
			choice = input.next().charAt(0);

		}while (!validInputs.contains(choice));
		
		//ch.close();
		
		return ((int) choice-48);
	}
}
