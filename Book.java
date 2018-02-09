package library.estela.ba;

public class Book extends Member{

	private boolean borrowed;
	
	public Book() {
		super();
		borrowed = false;
	}

	/**
	 * @param ID
	 * @param name
	 */
	public Book(int ID, String name) {
		super(ID, name, BOOK);
		borrowed = false;
	}

	/**
	 * @return the borrowed
	 */
	public boolean isBorrowed() {
		return borrowed;
	}

	/**
	 * @param borrowed the borrowed to set
	 */
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	// Override the toString method defined in the superclass
	public String toString() {
		return super.toString() + (this.borrowed ? "\nBook is borrowed\n":"Book is NOT borrowed\n");
	}
	
	

	
}
