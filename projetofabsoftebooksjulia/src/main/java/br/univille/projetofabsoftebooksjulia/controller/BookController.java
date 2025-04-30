package br.univille.projetofabsoftebooksjulia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.univille.projetofabsoftebooksjulia.entity.Book;
import br.univille.projetofabsoftebooksjulia.repository.BookRepository;
@RestController
@RequestMapping("/api/v1/users")
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        var books = repository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book) {
        if (book == null) {
            return ResponseEntity.badRequest().build();
        }
        var savedBook = repository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> putBook(@PathVariable long id, @RequestBody Book book) {
        if (id <= 0 || book == null) {
            return ResponseEntity.badRequest().build();
        }
        var existingBook = repository.findById(id);
        if (existingBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var bookToUpdate = existingBook.get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setCategory(book.getCategory());
        bookToUpdate.setFree(book.isFree());
        bookToUpdate.setYear(book.getYear());
        bookToUpdate.setStatus(book.getStatus());
        bookToUpdate.setRating(book.getRating());
        bookToUpdate.setComment(book.getComment());
        var updatedBook = repository.save(bookToUpdate);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var bookToDelete = repository.findById(id);
        if (bookToDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return new ResponseEntity<>(bookToDelete.get(), HttpStatus.OK);
    }
}