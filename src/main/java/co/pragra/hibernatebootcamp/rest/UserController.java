package co.pragra.hibernatebootcamp.rest;

import co.pragra.hibernatebootcamp.entity.User;
import co.pragra.hibernatebootcamp.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepo repo;

    public UserController(UserRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(@RequestParam(name = "lastName", required = false) String lastName){
        if (lastName != null) {
            return repo.findAllByLastNameLikeIgnoreCase(lastName);
        }
        return repo.findAll();
    }

    @PostMapping("/user")
    private User createUser( @RequestBody User user){
        System.out.println("user = " + user);
        return repo.save(user);
    }
    @GetMapping("/user/{id}")
    public Optional<User> getAllUsersByName(@PathVariable Long id){
        return repo.findById(id);
    }

    @PostMapping("/users")
    private List<User> createUsers( @RequestBody List<User> users){
        System.out.println("user = " + users);
        return repo.saveAll(users);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user){
        return repo.save(user);
    }


}
