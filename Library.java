package library.estela.ba;

import java.util.ArrayList;
import java.util.Date;

public class Library {

	private ArrayList<Customer> customers=new ArrayList<Customer>();
	private ArrayList<Book> books= new ArrayList<Book>();
	private ArrayList<Log> records=new ArrayList<Log>();
	
	

	public Library() {
		
		this.customers.clear();
		this.books.clear();
	}

	/**
	 * @return the customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @return the books
	 */
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	/**
	 * @return the records
	 */
	public ArrayList<Log> getRecords() {
		return records;
	}
	
	public Customer memberOfCustomerList(int accID, ArrayList<Customer> list){
		
		Customer acc=new Customer();
		for(Customer a : list){
			
			if (a.getID()==accID){
				return a;
			};
		}
		return acc;
	}
	public Book memberOfBookList(int accID, ArrayList<Book> list){
		
		Book acc=new Book();
		for(Book a : list){
			
			if (a.getID()==accID){
				return a;
			};
		}
		return acc;
	}
	
	public boolean addCustomer(Customer newUser){
	
		Customer acc = new Customer();
		int accID =newUser.getID();
		acc=memberOfCustomerList(accID,customers);

		if (acc.getID()==-1){
		
			if (newUser.getID()>0){
				customers.add(newUser);
				System.out.println("*************************************************");
				System.out.println("New account is added.");
				System.out.println("*************************************************");
				return true;
			} else{
				System.out.println("*************************************************");
				System.out.println("Cannot make account with negative ID.");
				System.out.println("*************************************************");
				return false;
			}
		}else {
			System.out.println("*************************************************");
			System.out.println("Customer with that ID already exist.");
			System.out.println("*************************************************");
			return false;
		}
	}
	
	public boolean addBook(Book newBook){
		
		Book acc = new Book();
		int accID =newBook.getID();
		acc=memberOfBookList(accID,books);

		if (acc.getID()==-1){
		
			if (newBook.getID()>0){
				books.add(newBook);
				System.out.println("*************************************************");
				System.out.println("New book is added.");
				System.out.println("*************************************************");
				return true;
			} else{
				System.out.println("*************************************************");
				System.out.println("Cannot make book account with negative ID.");
				System.out.println("*************************************************");
				return false;
			}
		}else {
			System.out.println("*************************************************");
			System.out.println("Book with that ID already exist.");
			System.out.println("*************************************************");
			return false;
		}
	}
	
//	public boolean addRecord(Log newRecord){
//		records.add(newRecord);
//	}
	
	public boolean addRecord(int userID, int bookID, Date date){
		Customer accS = new Customer();
		int indexS;
		accS=this.memberOfCustomerList(userID,customers);
		indexS=customers.indexOf(accS);
		
		Book accT = new Book();
		int indexT;
		accT=this.memberOfBookList(bookID, books);
		indexT=books.indexOf(accT);
		
		if (accS.getID()==-1){
			System.out.println("*************************************************");
			System.out.println("User account with that ID does not exist.");
			System.out.println("*************************************************");
			return false;
		} else if(accS.getBorrowedBooks()==3){
			System.out.println("*************************************************");
			System.out.println("User already has 3 borrowed books.");
			System.out.println("*************************************************");
			return false;
		} else if (accT.isBorrowed()==true){
			System.out.println("*************************************************");
			System.out.println("Book is already borrowed.");
			System.out.println("*************************************************");
			return false;
		} else{
			accS.addBorrowedBooks();
			customers.set(indexS, accS);
			accT.setBorrowed(true);
			books.set(indexT, accT);
			
			Log record=new Log(accS.getID(),accT.getID(),date);
			records.add(record);
			
			System.out.println("*************************************************");
			System.out.println("We made a record of borrowing book to log, succesfully.");
			System.out.println("*************************************************");
			return true;
		}
	}
	
	public void ispis() {
		System.out.println("Ispis svih zapisa:");
		System.out.println("--------------------------");
		
		for (Log rec : records) {
			System.out.println(rec);
		}

		System.out.println("--------------------------");

	}
}
