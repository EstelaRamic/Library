package library.estela.ba;

import java.util.Date; 

public class Log {
	
	private int customerID;
	private int bookID;
	private Date borrowingDate;
	
	public Log(){
		
	}

	/**
	 * @param customerID
	 * @param bookID
	 * @param borrowingDate
	 */
	public Log(int customerID, int bookID, Date borrowingDate) {
		super();
		this.customerID = customerID;
		this.bookID = bookID;
		this.borrowingDate = borrowingDate;
	};
	
	public String toString(){
		return "customer ID : "+this.customerID + "\nbook ID: "+this.bookID+"\ndate: "+this.borrowingDate+"\n";
	}
}
