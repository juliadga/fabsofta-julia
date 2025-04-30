package br.univille.projetofabsoftebooksjulia.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projetofabsoftebooksjulia.entity.Book;
import br.univille.projetofabsoftebooksjulia.entity.User;
import br.univille.projetofabsoftebooksjulia.repository.BookRepository;
import br.univille.projetofabsoftebooksjulia.service.BookService;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;
    @Override
    public User save(User user) {
        // Implement the logic to save a User object
        // For now, return null or throw an UnsupportedOperationException
        throw new UnsupportedOperationException("Method not implemented yet.");
    }
    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }
    @Override
    public Book getById(long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
    public BookRepository getRepository() {
        return repository;
    }
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }
}