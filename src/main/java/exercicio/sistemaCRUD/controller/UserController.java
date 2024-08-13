package exercicio.sistemaCRUD.controller;

import exercicio.sistemaCRUD.model.User;
import exercicio.sistemaCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        if (!userService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User>  update (@PathVariable Long id, @RequestBody User user){
        if(!userService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

}
