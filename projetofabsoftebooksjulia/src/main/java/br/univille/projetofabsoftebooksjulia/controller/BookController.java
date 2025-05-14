package br.univille.projetofabsoftebooksjulia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.projetofabsoftebooksjulia.entity.Book;
import br.univille.projetofabsoftebooksjulia.service.BookService;
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        var listaBooks = service.getAll();
        return new ResponseEntity<List<Book>>(listaBooks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book) {
        if (book == null) {
            return ResponseEntity.badRequest().build();
        }
        if(book.getId() == 0){
            service.save(book);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> putBook(@PathVariable long id, @RequestBody Book book) {
        if (id <= 0 || book == null) {
            return ResponseEntity.badRequest().build();
        }
        var bookAntigo = service.getById(id);
        if (bookAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        bookAntigo.setTitle(book.getTitle());
        bookAntigo.setAuthor(book.getAuthor());
        bookAntigo.setCategory(book.getCategory());
        bookAntigo.setFree(book.isFree());
        bookAntigo.setYear(book.getYear());
        bookAntigo.setStatus(book.getStatus());
        bookAntigo.setRating(book.getRating());
        bookAntigo.setComment(book.getComment());
        service.save(bookAntigo);
        return new ResponseEntity<Book>(bookAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var bookExcluir = service.getById(id);
        if(bookExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Book>(bookExcluir, HttpStatus.OK);
    }
}