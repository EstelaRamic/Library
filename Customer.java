package library.estela.ba;

public class Customer extends Member{

	private int borrowedBooks;
	
	public Customer() {
		super();
		borrowedBooks=0;
	}

	public Customer(int ID, String name) {
		super(ID, name, USER);
		borrowedBooks=0;
	}
	
	public int getBorrowedBooks() {
		return borrowedBooks;
	}

	public void addBorrowedBooks(){
		this.borrowedBooks++;
	}
	
	public void removeBorrowedBooks(){
		this.borrowedBooks--;
	}
	
    
	
	// Override the toString method defined in the superclass
	public String toString() {
		return super.toString() + "\nNumber of borrowed books: " + this.borrowedBooks+"\n";
	}
	
}
