import java.util.List;
import java.util.ArrayList;

class Borrower{
	private String name;
	private String memberId;
	private List<Book> borrowBooks;
	
	public Borrower(String name, String memberId){
		this.name = name;
		this.memberId = memberId;
		this.borrowBooks = new ArrayList<>();
	}
	
	public void borrowBook(Book book){
		if(book.isAvailable()){
		borrowBooks.add(book);
		book.setAvailable(false);
		System.out.println("Book borrowed successfully by " + name);
		}else{
		System.out.println("Book is not Available");
		}
	}
	
	public void returnBook(Book book){
		if(borrowBooks.contains(book)){
			borrowBooks.remove(book);
			book.setAvailable(true);
			System.out.println("This book has been returned by " + name);
			
		}else{
			System.out.println("Book not found");
		}		
	}
	public String getMemberId(){
		return memberId;
	}
	
	
	public String getName(){
		return name; 
	}
	@Override
	public String toString(){
		return name + " " + memberId;
	}
}
