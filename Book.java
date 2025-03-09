
import java.util.*;

class Book{
	
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;
	
	
	
	public Book(String title, String author, String ISBN){
		this.title = title;
		this.author = author;
		this.isAvailable = true;
		this.ISBN = ISBN;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	
	public String getISBN(){
		return ISBN;
	}
		
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public boolean isAvailable(){
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString(){
		return"Title: " + title + " " + "|Author: " + author + " "+ "|ISBN: " +  ISBN + " "+ "|Available?: " + isAvailable;
	}
}