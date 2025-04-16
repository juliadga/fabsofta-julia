package br.univille.projetofabsoftebooksjulia.service;
import java.util.List;
import br.univille.projetofabsoftebooksjulia.entity.User;
public interface UserService {
    User save(User user);
    List<User> getAll();
    User getById(long id);
    User delete(long id);
}
