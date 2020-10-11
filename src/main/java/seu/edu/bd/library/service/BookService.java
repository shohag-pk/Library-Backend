package seu.edu.bd.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.edu.bd.library.exception.BookIdException;
import seu.edu.bd.library.model.Book;
import seu.edu.bd.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createOrUpdateBook (Book book ){

        try{
            book.setBookId(book.getBookId().toUpperCase());
            return bookRepository.save(book);

        }catch (Exception e){
            throw new BookIdException("Book ID "+ book.getBookId().toUpperCase() + "already exist");
        }

    }

    public Iterable<Book> findAllBook(){
        return bookRepository.findAll();
    }

    public Book findBookById(String bookId){
        Book book = bookRepository.findByBookId(bookId.toUpperCase()).orElse(null);
        if(book == null){
            throw new BookIdException("Book ID " + bookId+"does not exit");
        }

        return  book;
    }

    public void deleteByBookId(String bookId){
        Book book = bookRepository.findByBookId(bookId.toUpperCase()).orElse(null);
        if(book == null){
            throw new BookIdException("Book ID " + bookId+"does not exit");
        }
        else bookRepository.delete(book);

    }


}
