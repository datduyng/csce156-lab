package unl.cse.library;

import org.joda.time.DateTime;

public class Book {

    public String title;
    public String isbn;
    public  Author author;
    public  DateTime publishDate;

	// constructor
	public Book(String title, Author author, String isbn, String publishDate ) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		setPublishDate(publishDate);
	}
    	
    /**
     * Getter method for author
     * @return
     */
    public Author getAuthor() {
    	//String result = this.author.getAuthor();
        return author;
    }

    /**
     * Setter method for authors
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Getter method for call number.
     * @return
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Setter method for call number.
     * @param callNumber
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter method for title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
    	return this.publishDate.toString("YYYY");
    }
    
    public void setPublishDate(String date) {
    	this.publishDate = DateTime.parse(date);
    }
    
}
