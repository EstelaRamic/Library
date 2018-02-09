package library.estela.ba;

public class Member {

	final static int USER = 1;
	final static int BOOK = 2;
		
	private int ID;
	private String name;
	private int memberType;
	
	public Member(){
		ID=-1;
		name="---";
		memberType=BOOK;
	}
	public Member(int ID, String name, int type){
		this.ID = ID;
		this.name = name;
		this.memberType = type;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};
		
	/**
	 * @return the memberType
	 */
	public int getMemberType() {
		return memberType;
	}
	/**
	 * @param memberType the memberType to set
	 */
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	
	
	
	@Override
	public String toString(){
		return "Type: "+this.memberType+ "\nID : "+this.ID+"\nName: "+this.name+"\n";
	}
}
