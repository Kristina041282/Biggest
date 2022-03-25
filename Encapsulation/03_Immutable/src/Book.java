public class Book {
    private final String bookName;
    private final String bookAuthor;
    private final  int numberOfPages;
    private final int  ISBN;

    public Book(String bookName, String bookAuthor, int numberOfPages, int ISBN) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.bookAuthor = bookAuthor;
        this.numberOfPages = numberOfPages;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getISBN() {
        return ISBN;
    }
    public void print(String tittle) {
        System.out.println(tittle);
        System.out.println(bookName + " автор книги: " + bookAuthor + "\n" + numberOfPages + "страниц" +
                " номер: " + ISBN );
    }
}
