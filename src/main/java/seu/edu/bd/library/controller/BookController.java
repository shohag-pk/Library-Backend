package seu.edu.bd.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import seu.edu.bd.library.model.Book;
import seu.edu.bd.library.service.BookService;
import seu.edu.bd.library.service.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewBook(@Valid @RequestBody Book book, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if( errorMap != null) return errorMap;
        Book book1 = bookService.createOrUpdateBook(book);
        return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Book> getAllBook(){
        return  bookService.findAllBook();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable String bookId){
        Book book = bookService.findBookById(bookId);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBookById (@PathVariable String bookId){
        bookService.deleteByBookId(bookId);
        return new ResponseEntity<String>("Book id: "+bookId+"was deleted" , HttpStatus.OK);
    }

}
