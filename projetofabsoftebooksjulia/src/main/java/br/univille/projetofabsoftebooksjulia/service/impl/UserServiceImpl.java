package br.univille.projetofabsoftebooksjulia.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projetofabsoftebooksjulia.entity.User;
import br.univille.projetofabsoftebooksjulia.repository.UserRepository;
import br.univille.projetofabsoftebooksjulia.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;
    @Override
    public User save(User user) {
        return repository.save(user);
    }
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
    @Override
    public User getById(long id) {
       var retorno = repository.findById(id);
       if(retorno.isPresent()){
        return retorno.get();
       }
        return null;
    } 
    @Override
    public User delete(long id) {
        var user = getById(id);
        if(user != null){
            repository.deleteById(id);
        }
        return user;
    }
}