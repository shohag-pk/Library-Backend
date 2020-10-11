package seu.edu.bd.library.exception;

public class BookIdExceptionResponse {

    private String book_id;

    public BookIdExceptionResponse(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
}
