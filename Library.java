import java.util.*;
import java.util.Scanner;
class Library{
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<Borrower> borrowers = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	
	public void start(){
		
		
		boolean exit = false;
	
		while(true){
			System.out.println();
		System.out.println("Welcome to the Library Management System!");
		System.out.println("----------------------------------------------");
		System.out.println("1. Add a new book");
		System.out.println("2. Remove a book");
		System.out.println("3. Search for a book");
		System.out.println("4. Register a new borrower");
		System.out.println("5. Issue a book to a borrower");
		System.out.println("6. Return a book from a borrower");
		System.out.println("7. Display all books");
		System.out.println("8. Display all borrowers");
		System.out.println("9. Exit");
		System.out.println("----------------------------------------------");
		System.out.println("Enter your choice: " );
		System.out.println();
		
		
		if(sc.hasNextInt()){
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case 1: addBook();
			break;
			
			case 2: removeBook();
			
			break;
			case 3: searchBook();
			break;
			
			case 4: registerBorrower();
			break;
			
			case 5: issueBook();
			break;
			
			case 6: returnBook();
			break;
			
			case 7: displayAllBooks();
			break;
			
			case 8: displayAllBorrowers();
			break;
			
			case 9: System.out.println("Exiting the application"); 
			return;
			default: System.out.println("invalid choice");
			
			}
		}else{
			System.out.println("Please enter an integer value 1-9! ");
			return;
			}
		
		}// end of loop
	}// end of method
	
	private void addBook(){
		System.out.println("Enter book title: ");
		String title = sc.nextLine();
		System.out.println("Enter book author: ");
		String author = sc.nextLine();
		System.out.println("Enter the ISBN: ");
		String ISBN = sc.nextLine();
		books.add(new Book(title, author, ISBN));
		System.out.println("Book added successfully!");
		System.out.println();
	}
	
	private void removeBook(){
		System.out.println("Enter the title of the book to remove: ");
		String title = sc.nextLine();
		for(Book book: books){
			if(book.getTitle().equalsIgnoreCase(title)){
				books.remove(book);
				System.out.println("Book removed successfully");
				return;
			}
		}// end of loop
		System.out.println("Book not found");
	}
	
	private void searchBook(){
		System.out.println("Enter the title of the book to search for: ");
		String title = sc.nextLine();
		System.out.println("The title of the book to search for is: " + title);
		for(Book book: books){
			
			System.out.println("You are searching for: " + book.getTitle());
			
			System.out.println();
			if(book.getTitle().contains(title)){
				System.out.println("Book found: " + book);
				return;
			}
		}
		System.out.println("Book not found, please try again! ");
	}
	
	private void registerBorrower(){
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();
		System.out.println("Please enter your ID number: ");
		String memberId = sc.nextLine();
		borrowers.add(new Borrower(name, memberId));
		System.out.println(name + " Registered successfully");
	}
	
	private Borrower findBorrower(String memberId){
		for(Borrower borrower : borrowers){
			if(borrower.getMemberId().equals(memberId)){
				return borrower;
			}
		}
		return null;
	}
	
	private Book findBook(String ISBN){
		for(Book book : books){
			if(book.getISBN().equals(ISBN)){
				return book;
			}
		}
		return null;
	}
	
	
	public void issueBook(){
		System.out.println("Enter book ISBN to issue: ");
		String ISBN = sc.nextLine();
		System.out.println("Enter borrower ID: ");
		String memberId = sc.nextLine();
		Borrower borrower = findBorrower(memberId);
		Book book = findBook(ISBN);
		
		if(borrower != null && book != null){
		borrower.borrowedBook(book);
		}else{
			System.out.println("Either the book or the borrower is invalid");
		}
	}// End of Method
	
	private void returnBook(){
		System.out.println("Enter book title to return: ");
		String title = sc.nextLine();
		
		for(Book book : books){
			if(book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()){
				book.setAvailable(true);
				System.out.println("Book returned successfully. ");
				return;
			}
		}
	}// End of Method
	
	private void displayAllBooks(){
		System.out.println("Books in the library: ");
		for(Book book : books){
			System.out.println(book);
		}
	}
	
	private void displayAllBorrowers(){
		
	System.out.println("Registered borrowers: ");
	for (Borrower borrower : borrowers){
		System.out.println(borrower);
		}
	}
		
}// end of class 