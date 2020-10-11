package seu.edu.bd.library.repository;

import org.springframework.data.repository.CrudRepository;
import seu.edu.bd.library.model.Book;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {


   Optional<Book> findByBookId(String bookId);
}
