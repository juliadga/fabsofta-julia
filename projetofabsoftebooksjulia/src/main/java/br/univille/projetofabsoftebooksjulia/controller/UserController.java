package br.univille.projetofabsoftebooksjulia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.projetofabsoftebooksjulia.entity.User;
import br.univille.projetofabsoftebooksjulia.service.UserService;
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        var listaUsers = service.getAll();
        return new ResponseEntity<List<User>>(listaUsers, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        if(user == null){
            return ResponseEntity.badRequest().build();
        }
        if(user.getId() == 0){
            service.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(@PathVariable long id, @RequestBody User user){
        if(id <= 0 || user == null){
            return ResponseEntity.badRequest().build();
        }
        var userAntigo = service.getById(id);
        if(userAntigo == null){
            return ResponseEntity.notFound().build();
        }
        userAntigo.setName(user.getName());
        userAntigo.setEmail(user.getEmail());
        userAntigo.setAge(user.getAge());
        userAntigo.setPassword(user.getPassword());
        service.save(userAntigo);
        return new ResponseEntity<User>(userAntigo, HttpStatus.OK);
    }
}