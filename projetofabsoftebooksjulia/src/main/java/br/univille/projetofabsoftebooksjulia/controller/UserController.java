package br.univille.projetofabsoftebooksjulia.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}