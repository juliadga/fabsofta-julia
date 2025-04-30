package br.univille.projetofabsoftebooksjulia.service;
import java.util.List;

import br.univille.projetofabsoftebooksjulia.entity.Book;
import br.univille.projetofabsoftebooksjulia.entity.User;
public interface BookService {
    User save(User user);
    Book save(Book book);
    List<Book> getAll();
    Book getById(long id);
    void delete(long id);
}